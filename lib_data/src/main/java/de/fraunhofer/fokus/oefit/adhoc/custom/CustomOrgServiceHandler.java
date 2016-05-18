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
package de.fraunhofer.fokus.oefit.adhoc.custom;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.portal.security.auth.PrincipalThreadLocal;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.storage.Fields;

import de.fraunhofer.fokus.oefit.adhoc.forms.RegistrationForm;
import de.fraunhofer.fokus.oefit.particity.model.AHAddr;
import de.fraunhofer.fokus.oefit.particity.model.AHCategories;
import de.fraunhofer.fokus.oefit.particity.model.AHContact;
import de.fraunhofer.fokus.oefit.particity.model.AHOrg;
import de.fraunhofer.fokus.oefit.particity.model.AHRegion;
import de.fraunhofer.fokus.oefit.particity.service.AHAddrLocalServiceUtil;
import de.fraunhofer.fokus.oefit.particity.service.AHCategoriesLocalServiceUtil;
import de.fraunhofer.fokus.oefit.particity.service.AHContactLocalServiceUtil;
import de.fraunhofer.fokus.oefit.particity.service.AHOrgLocalServiceUtil;
import de.fraunhofer.fokus.oefit.particity.service.AHRegionLocalServiceUtil;

/**
 * Custom utility methods for all tasks regarding organisations
 */
public class CustomOrgServiceHandler {

	private static final Log	m_objLog	= LogFactoryUtil
	                                             .getLog(CustomOrgServiceHandler.class);

	/**
	 * Add (or update) an organisation
	 *
	 * @param companyId the company id
	 * @param userId the user id
	 * @param groupId the group id
	 * @param form the form object
	 * @return the organisation added or changed
	 */
	public static AHOrg addOrganisation(final long companyId,
	        final long userId, final long groupId, final RegistrationForm form) {
		return addOrganisation(companyId, userId, groupId, form.getMail(),
		        form.getName(),
		        form.getHolder(), form.getDescr(), form.getLegalState(),
		        form.getAddrStreet(),
		        form.getAddrNum(), form.getRegionCity(),
		        form.getRegionCountry(), form.getRegionZip(),
		        form.getContactPhone(), form.getContactFax(),
		        form.getContactMail(), form.getContactWeb(), form.getLogoFile(), 0, 0);
	}

	/**
	 * Add (or update) an organisation)
	 *
	 * @param companyId the company id
	 * @param userId the user id
	 * @param groupId the group id
	 * @param owner the owner of the organisation
	 * @param name the organisation name
	 * @param holder the holder of the organisation
	 * @param descr the description of the organisation
	 * @param legalStatus the legal status  of the organisation
	 * @param street the street address of the organisation's contact
	 * @param streetNumber the street number of the organisation's contact
	 * @param city the city of the organisation's contact
	 * @param country the country of the organisation's contact
	 * @param zip the zip of the organisation's contact
	 * @param tel the telephone number of the organisation's contact
	 * @param fax the fax of the organisation's contact
	 * @param mail the email address of the organisation's contact
	 * @param web the URL of the organisation's contact
	 * @param logo the logo of the organisation (or null)
	 * @return the organisation added or changed
	 */
	public static AHOrg addOrganisation(final long companyId,
	        final long userId, final long groupId, final String owner,
	        final String name,
	        final String holder, final String descr, final String legalStatus,
	        final String street,
	        final String streetNumber, final String city, final String country,
	        final String zip,
	        final String tel, final String fax, final String mail,
	        final String web, final CommonsMultipartFile logo, float coordsLat, float coordsLon) {
		AHOrg result = null;

		String countryName = country;

		try {
			final Long countryId = Long.parseLong(country);
			final AHCategories countryCat = AHCategoriesLocalServiceUtil
			        .getCategory(countryId);
			if (countryCat != null) {
				countryName = countryCat.getName();
			}
		} catch (final Throwable t) {
			//m_objLog.warn(t);
		}

		final AHRegion region = AHRegionLocalServiceUtil.addRegion(city,
		        countryName,
		        zip);
		final AHAddr address = AHAddrLocalServiceUtil.addAddress(street,
		        streetNumber, null, null, region.getRegionId());
		final AHContact contact = AHContactLocalServiceUtil.addContact(null,
		        null,
		        tel, fax, mail, web);
		// m_objLog.info("Trying to add/update an org for "+owner+" with name "+name);
		result = AHOrgLocalServiceUtil.addOrganisation(owner, name, holder,
		        descr,
		        legalStatus, address.getAddrId(), contact.getContactId());

		if (userId > 0 && result != null && logo != null && logo.getSize() > 0) {
			final String logoLocation = updateLogo(companyId, userId, groupId,
			        result.getOrgId(), logo);
			if (logoLocation != null) {
				AHOrgLocalServiceUtil.updateLogoLocation(result.getOrgId(),
				        logoLocation);
			}
		}
		return result;
	}

	/**
	 * Delete an organisation by its ID
	 *
	 * @param orgId the organisation's ID
	 */
	public static void deleteOrganisation(final Long orgId) {
		AHOrgLocalServiceUtil.deleteOrganisation(orgId);
	}

	/**
	 * Get the form object for a given organisation
	 *
	 * @param org the organisation model
	 * @return the organisation's form
	 */
	public static RegistrationForm getOrganisation(final AHOrg org) {
		RegistrationForm result = null;

		// AHOrg org = AHOrgLocalServiceUtil.getOrganisationByOwner(owner);
		if (org != null) {
			AHContact contact = null;
			AHAddr address = null;
			AHRegion region = null;
			try {
				contact = AHContactLocalServiceUtil.getAHContact(org
				        .getContactId());
				address = AHAddrLocalServiceUtil.getAHAddr(org.getAddressId());
				if (address != null) {
					region = AHRegionLocalServiceUtil.getRegion(address
					        .getRegionId());
				}
			} catch (final PortalException e) {
				m_objLog.error(e);
			} catch (final SystemException e) {
				m_objLog.error(e);
			}

			result = new RegistrationForm();
			result.setDescr(org.getDescription());
			result.setName(org.getName());
			result.setHolder(org.getHolder());
			result.setMail(org.getOwner());
			result.setLegalState(org.getLegalStatus());
			if (address != null) {
				result.setAddrNum(address.getNumber());
				result.setAddrStreet(address.getStreet());
			}
			if (region != null) {
				result.setRegionCity(region.getCity());
				result.setRegionCountry(region.getCountry());
				result.setRegionZip(region.getZip());
			}
			if (contact != null) {
				result.setContactFax(contact.getFax());
				result.setContactForename(contact.getForename());
				result.setContactMail(contact.getEmail());
				result.setContactPhone(contact.getTel());
				result.setContactWeb(contact.getWww());
				result.setContactSurname(contact.getSurname());
			}
			result.setOrgId(org.getOrgId());
			result.setLogoFilename(org.getLogoLocation());
		}

		return result;
	}

	/**
	 * Get an organisation's form object by its ID
	 *
	 * @param orgId the organisation's ID
	 * @return the form object
	 */
	public static RegistrationForm getOrganisation(final long orgId) {
		RegistrationForm result = null;
		try {
			final AHOrg org = AHOrgLocalServiceUtil.getAHOrg(orgId);
			result = getOrganisation(org);
		} catch (final PortalException e) {
			m_objLog.error(e);
		} catch (final SystemException e) {
			m_objLog.error(e);
		}
		return result;
	}

	/**
	 * Get an organisation's form object by its ID for editing purpose
	 *
	 * This method should be used only for editing form-data in the view, as it
	 * replaces some human-readable fields (i.e. data-lists) with their numeric
	 * values. This workaround is necessary to allow cleartext data-list fields
	 * to be stored in the database instead of numeric values that might point
	 * to wrong references in case the data-lists are modified without updating
	 * the references.
	 *
	 * @param orgId the organisation's ID
	 * @return the form object
	 */
	public static RegistrationForm getOrganisationForEdit(final long orgId) {
		final RegistrationForm result = getOrganisation(orgId);

		final String countryName = result.getRegionCountry();
		AHCategories countryCat = null;
		try {
			countryCat = AHCategoriesLocalServiceUtil.getCategory(countryName,
			        E_CategoryType.COUNTRIES.getIntValue());
			if (countryCat != null) {
				result.setRegionCountry(Long.toString(countryCat.getCatId()));
			}
		} catch (final Throwable t) {
		}

		return result;
	}

	/**
	 * Get a list of organisations as CSV (UTF-8). Provides owner, name and contact details.
	 *
	 * @return the organisations as CSV
	 */
	public static byte[] getOrganisationsAsCsv() {
		byte[] result = null;
		final StringBuffer csv = new StringBuffer();
		try {
			final int size = AHOrgLocalServiceUtil.getAHOrgsCount();
			List<AHOrg> orgs = null;
			for (int i = 0; i < size; i += 5) {
				orgs = AHOrgLocalServiceUtil.getAHOrgs(i, i += 5);
				for (final AHOrg org : orgs) {
					final AHAddr addr = AHAddrLocalServiceUtil.getAHAddr(org
					        .getAddressId());
					final AHRegion reg = AHRegionLocalServiceUtil
					        .getRegion(addr.getRegionId());
					csv.append(org.getOwner()).append("\t")
					        .append(org.getName()).append("\t")
					        .append(addr.getStreet() + " " + addr.getNumber())
					        .append("\t").append(reg.getZip()).append("\t")
					        .append(reg.getCity()).append("\n");
				}
			}

			result = csv.toString().getBytes("utf-8");
		} catch (final Throwable e) {
			m_objLog.error(e);
		}

		return result;
	}

	/**
	 * Get the organisation that is bound to the current Liferay user
	 *
	 * @param tDisplay the theme display of the current session
	 * @return the organisation bound to the user, or null if none
	 */
	public static AHOrg getOrgByLiferayUser(final ThemeDisplay tDisplay) {
		AHOrg result = null;
		try {
			final String ownerEmail = tDisplay.getUser().getEmailAddress();
			result = AHOrgLocalServiceUtil
			        .getOrganisationByOwnerMail(ownerEmail);
			if (result == null) {
				result = AHOrgLocalServiceUtil
				        .getOrganisationByUserMail(ownerEmail);
			}
		} catch (final Throwable t) {
			m_objLog.error(t);
		}
		return result;
	}

	/**
	 * Get the ID of the organisation bound to the current Liferay user
	 *
	 * @param tDisplay the theme display of the current session
	 * @return the organisation bound to the user, or null if none
	 */
	public static long getOrgIdByLiferayUser(final ThemeDisplay tDisplay) {
		long result = -1L;
		try {
			final String ownerEmail = tDisplay.getUser().getEmailAddress();
			AHOrg org = AHOrgLocalServiceUtil
			        .getOrganisationByOwnerMail(ownerEmail);
			if (org == null) {
				org = AHOrgLocalServiceUtil
				        .getOrganisationByUserMail(ownerEmail);
			}
			if (org != null) {
				result = org.getOrgId();
			}
		} catch (final Throwable t) {
			m_objLog.error(t);
		}
		return result;
	}

	/**
	 * Check if the provided email-address is an owner of the given organisation
	 *
	 * @param orgId ID of the organisation
	 * @param userMail email address of the user
	 * @return true, if the email address is registered as organisation owner
	 */
	public static boolean isOrgOwner(final long orgId, final String userMail) {
		boolean result = true;
		try {
			final AHOrg org = AHOrgLocalServiceUtil
			        .getOrganisationByOwnerMail(userMail);
			if (org != null && org.getOrgId() == orgId) {
				result = true;
			}
		} catch (final Throwable t) {
			m_objLog.error(t);
		}
		return result;
	}

	public static String updateLogo(final long companyId, final long userId,
	        final long groupId, final long orgId,
	        final CommonsMultipartFile logo) {
		return updateLogo(companyId, userId, groupId, orgId, logo.getBytes(), logo.getOriginalFilename());
	}
	
	public static String updateLogo(final long companyId, final long userId,
	        final long groupId, final long orgId, byte[] logoData, String logoName) {

		String fileName = Long.toString(orgId) + ".img";

		try {

			PrincipalThreadLocal.setName(userId);
			final PermissionChecker pchecker = PermissionCheckerFactoryUtil
			        .create(UserLocalServiceUtil.getUser(userId));
			PermissionThreadLocal.setPermissionChecker(pchecker);

			long parentId = -1;
			try {
				String orgFolder = CustomPortalServiceHandler.getConfigValue(E_ConfigKey.ORGANISATION_LOGO_FOLDER);
				
				final DLFolder parent = DLFolderLocalServiceUtil.getFolder(
				        groupId, 0, orgFolder);
				if (parent != null)
				{
					parentId = parent.getFolderId();
					// parent = DLAppServiceUtil.getFolder(groupId, 0,
					// Constants.ORGANISATION_LOGO_FOLDER);
				}
			} catch (final Throwable t) {
				t.printStackTrace();
			}

			if (parentId >= 0) {

				final ServiceContext ctx = new ServiceContext();
				ctx.setScopeGroupId(groupId);
				ctx.setUserId(userId);
				ctx.setAddGroupPermissions(true);
				ctx.setAddGuestPermissions(true);
				ctx.setWorkflowAction(WorkflowConstants.ACTION_PUBLISH);

				DLFileEntry file = null;
				try {
					file = DLFileEntryLocalServiceUtil.getFileEntry(groupId,
					        parentId, fileName);
					// file = DLAppServiceUtil.getFileEntry(groupId, parentId,
					// fileName);
				} catch (final Throwable t) {
				}
				if (file == null) {

					file = DLFileEntryLocalServiceUtil.addFileEntry(userId,
					        groupId, groupId, parentId, fileName,
					        MimeTypesUtil.getContentType(fileName), fileName, "", "",
					        -1L, new HashMap<String, Fields>(), null, new ByteArrayInputStream(logoData), logoData.length, ctx);

					m_objLog.debug("File " + fileName + " added!");
				} else {
					file = DLFileEntryLocalServiceUtil.updateFileEntry(userId,
					        file.getFileEntryId(), fileName,
					        MimeTypesUtil.getContentType(fileName), fileName, "", "",
					        false, file.getFileEntryTypeId(),
					        new HashMap<String, Fields>(), null, new ByteArrayInputStream(logoData), logoData.length, ctx);
					m_objLog.debug("File " + fileName + " updated!");
				}
				if (file != null) {

					Role guestRole = null;
					Role userRole = null;
					try {
						guestRole = RoleLocalServiceUtil.fetchRole(
						        CompanyThreadLocal.getCompanyId(),
						        RoleConstants.GUEST);
						userRole = RoleLocalServiceUtil.fetchRole(
						        CompanyThreadLocal.getCompanyId(),
						        RoleConstants.USER);
						final Map<Long, String[]> perms = new HashMap<Long, String[]>();
						perms.put(guestRole.getRoleId(),
						        new String[] { ActionKeys.VIEW });
						perms.put(userRole.getRoleId(),
						        new String[] { ActionKeys.VIEW });
						ResourcePermissionLocalServiceUtil
						        .setResourcePermissions(
						                CompanyThreadLocal.getCompanyId(),
						                DLFileEntry.class.getName(),
						                ResourceConstants.SCOPE_INDIVIDUAL,
						                String.valueOf(file.getFileEntryId()),
						                perms);
					} catch (final Throwable t) {
						m_objLog.warn(t);
					}

					file = file.toEscapedModel();

					file.getFileEntryId();
					final long folderId = file.getFolderId();
					file.getName();
					file.getExtension();
					final String title = file.getTitle();
					fileName = "/documents/" + groupId + "//" + folderId + "//"
					        + HttpUtil.encodeURL(HtmlUtil.unescape(title));
				}

			}

			/*
			 * if (DLStoreUtil.hasFile(companyId, CompanyConstants.SYSTEM,
			 * fileName)) { DLStoreUtil.updateFile(companyId,
			 * CompanyConstants.SYSTEM, fileName, ".img", false, "1.0",
			 * logo.getOriginalFilename(), logo.getInputStream()); } else
			 * DLStoreUtil.addFile(companyId, CompanyConstants.SYSTEM, fileName,
			 * false, logo.getInputStream());
			 */

		} catch (final Throwable t) {
			m_objLog.error(t);
			fileName = null;
		}
		return fileName;

	}

}
