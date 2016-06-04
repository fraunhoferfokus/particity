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


// TODO: Auto-generated Javadoc
/**
 * The implementation of the a h org local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link de.fraunhofer.fokus.oefit.particity.service.AHOrgLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see de.fraunhofer.fokus.oefit.adhoc.service.base.AHOrgLocalServiceBaseImpl
 * @see de.fraunhofer.fokus.oefit.particity.service.AHOrgLocalServiceUtil
 */
public class AHOrgLocalServiceImpl {

	/*
	@Override
	public AHOrg addOrganisation(final String owner, final String name,
	        final String holder, final String descr, final String legalStatus,
	        final long addressId, final long contactId) {
		m_objLog.trace("addOrganisation::start("+owner+")");
		AHOrg result = null;

		try {
			AHOrg tmp = this.getOrganisationByOwnerMail(owner);
			if (tmp == null) {
				m_objLog.info("Found no organisation for " + owner
				        + ". Creating new one!");
				tmp = this.createAHOrg(CounterLocalServiceUtil
				        .increment(AHOrg.class.getName()));
				tmp.setCreated(System.currentTimeMillis());
				tmp.setOwner(owner.toLowerCase());
				tmp.setStatus(E_OrgStatus.NEW.getIntValue());
			} else {
				m_objLog.info("Found existing organisation for " + owner + "!");
				tmp.setStatus(E_OrgStatus.CHANGED.getIntValue());
			}
			tmp.setAddressId(addressId);
			tmp.setContactId(contactId);
			tmp.setName(name);
			tmp.setDescription(descr);
			tmp.setUpdated(System.currentTimeMillis());
			tmp.setHolder(holder);
			tmp.setLegalStatus(legalStatus);
			// set valid, if it does not require additional input or check by mgmt and moderation is disabled
			if (!CustomPortalServiceHandler.isConfigEnabled(E_ConfigKey.MODERATE_ORGS)) {
				tmp.setStatus(E_OrgStatus.VALIDATED.getIntValue());
			}
			result = this.updateAHOrg(tmp);
		} catch (final SystemException e) {
			m_objLog.error(e);
		}
		m_objLog.trace("addOrganisation::end("+owner+")");
		return result;
	}

	
	@Override
	public void addOrganisationUser(final long orgId, final String userMail) {
		try {
			final AHOrg org = this.getAHOrg(orgId);
			String users = org.getUserlist();
			if (users.length() > 0) {
				users += ",";
			}
			users += userMail.toLowerCase();
			org.setUserlist(users);
			this.updateAHOrg(org);
		} catch (final Throwable t) {
			m_objLog.error(t);
		}
	}

	
	@Override
	public int countNewOrg() {
		int result = 0;
		try {
			result += this.getAHOrgPersistence().countBystatus(
			        E_OfferStatus.CHANGED.getIntValue());
			result += this.getAHOrgPersistence().countBystatus(
			        E_OfferStatus.NEW.getIntValue());
		} catch (final SystemException e) {
			m_objLog.error(e);
		}

		return result;
	}

	
	@Override
	public void deleteOrganisation(final long orgId) {
		try {
			this.deleteAHOrg(orgId);
			AHOfferLocalServiceUtil.deleteOffersByOrg(orgId);
		} catch (final PortalException e) {
			m_objLog.error(e);
		} catch (final SystemException e) {
			m_objLog.error(e);
		}
	}

	
	@Override
	public AHOrg getOrganisationByOwnerMail(final String owner) {
		m_objLog.trace("getOrganisationByOwnerMail::start("+owner+")");
		AHOrg result = null;

		List<AHOrg> orgs;
		try {
			orgs = this.getAHOrgPersistence().findByowner(owner.toLowerCase());
			if (orgs != null && orgs.size() > 0) {
				result = orgs.get(0);
			}
		} catch (final SystemException e) {
			m_objLog.error(e);
		}
		m_objLog.trace("getOrganisationByOwnerMail::end("+owner+","+(result != null)+")");
		return result;
	}

	
	@Override
	public AHOrg getOrganisationByUserMail(final String userMail) {
		m_objLog.trace("getOrganisationByUserMail::start("+userMail+")");
		AHOrg result = null;

		List<AHOrg> orgs;
		try {
			orgs = AHOrgFinderUtil.getOrganisationsByUserlistEntry(userMail.toLowerCase());
			if (orgs != null && orgs.size() > 0) {
				result = orgs.get(0);
			}
		} catch (final SystemException e) {
			m_objLog.error(e);
		}
		m_objLog.trace("getOrganisationByUserMail::end("+userMail+","+(result != null)+")");
		return result;
	}

	
	@Override
	public List<AHOrg> getOrganisations(final int start, final int end,
	        final String column, final String order) {
		List<AHOrg> result = null;
		try {
			m_objLog.info("Looking up organisations sorted by "+column+" in order "+order.toString()+" from "+start+", to "+end);
			result = AHOrgFinderUtil.getOrganisationsWithCustomOrder(column,
			        order, start, end);
		} catch (final SystemException e) {
			m_objLog.error(e);
		}
		return result;
	}

	
	@Override
	public List<AHOrg> listOrganisations() {
		List<AHOrg> result = null;

		try {
			result = this.getAHOrgs(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (final SystemException e) {
			m_objLog.error(e);
		}

		return result;
	}

	
	@Override
	public void setOrganisationStatus(final long orgId, final int status) {
		try {
			final AHOrg org = this.getAHOrg(orgId);
			if (org != null) {
				org.setStatus(status);
				this.updateAHOrg(org);
			}
		} catch (final PortalException e) {
			m_objLog.error(e);
		} catch (final SystemException e) {
			m_objLog.error(e);
		}
	}

	
	@Override
	public void updateLogoLocation(final long orgId, final String logoLocation) {
		AHOrg org = null;
		try {
			org = this.getAHOrg(orgId);
		} catch (final Throwable t) {
		}
		if (org != null) {
			org.setLogoLocation(logoLocation);
			try {
				this.updateAHOrg(org);
			} catch (final SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	@Override
	public void updateOwner(final String oldOwner, final String newOwner) {
		List<AHOrg> orgs;
		try {
			orgs = this.getAHOrgPersistence().findByowner(oldOwner);
			if (orgs != null && orgs.size() > 0) {
				for (final AHOrg org : orgs) {
					org.setOwner(newOwner.toLowerCase());
					this.updateAHOrg(org);
				}
			}
		} catch (final SystemException e) {
			m_objLog.error(e);
		}
	}
	 */
}
