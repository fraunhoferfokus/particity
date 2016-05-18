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
package de.fraunhofer.fokus.oefit.particity.service.impl;

import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.fraunhofer.fokus.oefit.particity.model.AHRegion;
import de.fraunhofer.fokus.oefit.particity.service.base.AHRegionLocalServiceBaseImpl;
import de.fraunhofer.fokus.oefit.particity.service.persistence.AHRegionPK;

// TODO: Auto-generated Javadoc
/**
 * The implementation of the a h region local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link de.fraunhofer.fokus.oefit.particity.service.AHRegionLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see de.fraunhofer.fokus.oefit.adhoc.service.base.AHRegionLocalServiceBaseImpl
 * @see de.fraunhofer.fokus.oefit.particity.service.AHRegionLocalServiceUtil
 */
public class AHRegionLocalServiceImpl extends AHRegionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link de.fraunhofer.fokus.oefit.adhoc.service.AHRegionLocalServiceUtil}
	 * to access the a h region local service.
	 */

	private static final Log	m_objLog	= LogFactoryUtil
	                                             .getLog(AHRegionLocalServiceImpl.class);

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHRegionLocalService#addRegion(java.lang.String, java.lang.String, int)
	 */
	@Override
	public AHRegion addRegion(final String city, final String country,
	        final String zip) {
		AHRegion result = null;

		result = this.getRegion(city, country, zip);
		if (result == null) {
			try {
				result = this.createAHRegion(new AHRegionPK(
				        CounterLocalServiceUtil.increment(AHRegion.class
				                .getName()), zip, city, country));
				result = this.updateAHRegion(result);
			} catch (final SystemException e) {
				m_objLog.error(e);
			}
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHRegionLocalService#getRegion(long)
	 */
	@Override
	public AHRegion getRegion(final long regionId) {
		AHRegion result = null;

		try {
			final List<AHRegion> regions = this.getAHRegionPersistence()
			        .findByregionId(
			                regionId);
			if (regions.size() > 0) {
				result = regions.get(0);

			}
		} catch (final Throwable t) {
			m_objLog.error(t);
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHRegionLocalService#getRegion(java.lang.String, java.lang.String, int)
	 */
	@Override
	public AHRegion getRegion(final String city, final String country,
	        final String zip) {
		AHRegion result = null;

		try {
			final DynamicQuery dyQuery = DynamicQueryFactoryUtil
			        .forClass(AHRegion.class);

			final Criterion term1 = RestrictionsFactoryUtil.ilike(
			        "primaryKey.city", city);
			final Criterion term2 = RestrictionsFactoryUtil.ilike(
			        "primaryKey.country", country);
			final Criterion term3 = RestrictionsFactoryUtil.eq(
			        "primaryKey.zip", zip);
			final Criterion allTerms = RestrictionsFactoryUtil.and(term3,
			        RestrictionsFactoryUtil.and(term1, term2));

			dyQuery.add(allTerms);
			final List regions = this.dynamicQuery(dyQuery);

			if (regions.size() > 0) {
				for (final Object region : regions) {
					if (region instanceof AHRegion) {
						result = (AHRegion) region;
						break;
					}
				}
			}
		} catch (final SystemException e) {
			m_objLog.error(e);
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHRegionLocalService#removeRegion(long)
	 */
	@Override
	public AHRegion removeRegion(final long regionId) {
		AHRegion result = this.getRegion(regionId);
		if (result != null) {
			try {
				result = this.deleteAHRegion(result);
			} catch (final SystemException e) {
				m_objLog.error(e);
			}
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHRegionLocalService#removeRegion(java.lang.String, java.lang.String, int)
	 */
	@Override
	public AHRegion removeRegion(final String city, final String country,
	        final String zip) {
		AHRegion result = null;

		final AHRegion region = this.getRegion(city, country, zip);
		if (region != null) {
			try {
				result = this.deleteAHRegion(region);
			} catch (final SystemException e) {
				m_objLog.error(e);
			}
		}

		return result;
	}

}
