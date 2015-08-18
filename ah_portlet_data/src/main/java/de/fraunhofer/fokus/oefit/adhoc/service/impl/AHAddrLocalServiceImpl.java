/*
 * Copyright (c) 2015, Fraunhofer FOKUS
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * 
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 * 
 * * Neither the name of particity nor the names of its
 *   contributors may be used to endorse or promote products derived from
 *   this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 
 * 
 * 
 * @author sma
 */
package de.fraunhofer.fokus.oefit.adhoc.service.impl;

import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.fraunhofer.fokus.oefit.adhoc.model.AHAddr;
import de.fraunhofer.fokus.oefit.adhoc.service.base.AHAddrLocalServiceBaseImpl;

// TODO: Auto-generated Javadoc
/**
 * The implementation of the a h addr local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link de.fraunhofer.fokus.oefit.adhoc.service.AHAddrLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see de.fraunhofer.fokus.oefit.adhoc.service.base.AHAddrLocalServiceBaseImpl
 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHAddrLocalServiceUtil
 */
public class AHAddrLocalServiceImpl extends AHAddrLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link de.fraunhofer.fokus.oefit.adhoc.service.AHAddrLocalServiceUtil} to
	 * access the a h addr local service.
	 */
	private static final Log	m_objLog	= LogFactoryUtil
	                                             .getLog(AHAddrLocalServiceImpl.class);

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHAddrLocalService#addAddress(java.lang.String, java.lang.String, java.lang.String, java.lang.String, long)
	 */
	@Override
	public AHAddr addAddress(final String street, final String number,
	        final String lat, final String lon, final long regionId) {
		AHAddr result = null;

		result = this.getAddress(street, number, regionId);
		if (result == null) {
			try {
				result = this.createAHAddr(CounterLocalServiceUtil
				        .increment(AHAddr.class.getName()));
				result.setStreet(street);
				result.setNumber(number);
				result.setRegionId(regionId);
			} catch (final SystemException e) {
				m_objLog.error(e);
			}
		}
		if (lat != null && lon != null && lat.trim().length() != 0
		        && lon.trim().length() != 0) {
			result.setCoordLat(lat);
			result.setCoordLon(lon);
		}
		try {
			result = this.updateAHAddr(result);
		} catch (final SystemException e) {
			m_objLog.error(e);
		}

		return result;
	}

	/*
	 * public AHAddr addAddress(String street, String number, long regionId) {
	 * AHAddr result = null; result = getAddress(street, number, regionId); if
	 * (result == null) { try { result =
	 * createAHAddr(CounterLocalServiceUtil.increment(AHAddr.class.getName()));
	 * result.setStreet(street); result.setNumber(number);
	 * result.setRegionId(regionId); result.setCoordLat(coordLat);
	 * result.setCoordLat(coordon); result = updateAHAddr(result); } catch
	 * (SystemException e) { m_objLog.error(e); } } return result; }
	 */

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHAddrLocalService#findAddressesForRegion(long)
	 */
	@Override
	public List<AHAddr> findAddressesForRegion(final long regionId) {
		List<AHAddr> result = null;
		try {
			result = this.getAHAddrPersistence().findByregion(regionId);
		} catch (final Throwable t) {
			m_objLog.warn(t);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHAddrLocalService#getAddress(java.lang.String, java.lang.String, long)
	 */
	@Override
	public AHAddr getAddress(final String street, final String number,
	        final long regionId) {
		AHAddr result = null;

		try {
			final DynamicQuery dyQuery = DynamicQueryFactoryUtil
			        .forClass(AHAddr.class);

			final Criterion term1 = RestrictionsFactoryUtil.ilike("street",
			        street);
			final Criterion term2 = RestrictionsFactoryUtil
			        .eq("number", number);
			final Criterion term3 = RestrictionsFactoryUtil.eq("regionId",
			        regionId);
			final Criterion allTerms = RestrictionsFactoryUtil.and(term3,
			        RestrictionsFactoryUtil.and(term1, term2));

			dyQuery.add(allTerms);
			final List addrs = this.dynamicQuery(dyQuery);
			if (addrs.size() > 0) {
				for (final Object addr : addrs) {
					if (addr instanceof AHAddr) {
						result = (AHAddr) addr;
						break;
					}
				}
			}
		} catch (final Throwable t) {
			m_objLog.error(t);
		}
		return result;
	}

	/*
	 * public AHAddr addAddress(String street, String number, AHRegion region) {
	 * return addAddress(street, number, region.getRegionId()); }
	 */

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHAddrLocalService#updateCoords(long, java.lang.String, java.lang.String)
	 */
	@Override
	public AHAddr updateCoords(final long addrId, final String lat,
	        final String lon) {
		AHAddr result = null;

		try {
			result = this.getAHAddr(addrId);
		} catch (final Throwable t) {
		}
		if (result != null) {
			try {
				result.setCoordLat(lat);
				result.setCoordLon(lon);
				result = this.updateAHAddr(result);
			} catch (final SystemException e) {
				m_objLog.error(e);
			}
		}

		return result;
	}
}
