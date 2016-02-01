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

import java.util.Enumeration;
import java.util.List;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.PortletPreferences;

import org.springframework.validation.BindingResult;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.model.PortalPreferences;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.PortalPreferencesLocalServiceUtil;
import com.liferay.portal.service.ResourcePermissionServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;

import de.fraunhofer.fokus.oefit.adhoc.forms.ProfileForm;
import de.fraunhofer.fokus.oefit.adhoc.socialize.SocialMediaFactory;
import de.fraunhofer.fokus.oefit.particity.model.custom.MessageComposer;
import de.fraunhofer.fokus.oefit.particity.service.AHConfigLocalServiceUtil;
import de.fraunhofer.fokus.oefit.particity.service.AHOrgLocalServiceUtil;

/**
 * Custom utility methods for tasks related to portal datastructures 
 */
public class CustomPortalServiceHandler {

	private static final Log	m_objLog	= LogFactoryUtil
	                                                .getLog(CustomPortalServiceHandler.class);

	private static Boolean	 m_bInitialized	= null;

	/**
	 * Validates a given form object and changes user settings accordingly
	 *
	 * @param oldUser the old Liferay user model
	 * @param newProfile the profile containing new values
	 * @param result the message handler to bind validation errors to
	 */
	public static void changeUserProfile(User oldUser,
	        final ProfileForm newProfile, final BindingResult result) {
		final String oldMail = oldUser.getEmailAddress();
		final String newMail = newProfile.getMail();
		if (!oldMail.toLowerCase().trim().equals(newMail.toLowerCase().trim())) {
			m_objLog.debug("User mail changed!");
			try {
				oldUser = UserLocalServiceUtil.updateEmailAddress(
				        oldUser.getUserId(), oldUser.getPassword(),
				        newMail.trim(), newMail.trim());
			} catch (final Throwable e) {
				result.rejectValue("mail", "notExistentErrorCode",
				        "common.form.profile.field.mail.unknown");
				e.printStackTrace();
			}
			if (oldUser != null) {
				AHOrgLocalServiceUtil.updateOwner(oldMail, newMail.trim());
			}
		} else {
			m_objLog.debug("User mail not changed!");
		}
		if (newProfile.getPass1().equals(newProfile.getPass2())) {
			if (newProfile.getPass1().replaceAll("\\*", "").length() > 0) {
				m_objLog.debug("User password changed!");
				try {
					UserLocalServiceUtil.updatePassword(oldUser.getUserId(),
					        newProfile.getPass1(),
					        newProfile.getPass1(), false);
				} catch (final Throwable e) {
					result.rejectValue("mail", "notExistentErrorCode",
					        "common.form.profile.field.pass1.unknown");
					m_objLog.error(e);
				}

			} else {
				m_objLog.debug("User password not changed!");
			}
		}
	}

	/**
	 * Provides an entry point to initialize basic settings and data-structures.
	 * Due to use of Liferay's document library and permission settings, this
	 * should be run only on login by an administrator. 
	 *
	 * @param themeDisplay the theme display of the administrator
	 */
	public static synchronized void checkInit(long groupId, long userId) {
		if (!isSystemInitialized()) {

			try {

				createOrganisationLogoFolder(groupId, userId);

				setConfig(E_ConfigKey.INITFLAG, "true");
				m_bInitialized = true;

			} catch (final Throwable t) {
				m_objLog.error(t);
			}

		}
	}
	
	public static void createOrganisationLogoFolder(long groupId, long userId) throws PortalException, SystemException {
		final ServiceContext ctx = new ServiceContext();
		ctx.setUserId(userId);
		ctx.setScopeGroupId(groupId);
		ctx.setAddGroupPermissions(true);
		ctx.setAddGuestPermissions(true);
		// ctx.setWorkflowAction(WorkflowConstants.ACTION_PUBLISH);

		String orgFolder = getConfigValue(E_ConfigKey.ORGANISATION_LOGO_FOLDER);
		
		Folder parent = null;
		try {
			parent = DLAppServiceUtil.getFolder(groupId, 0,
			        orgFolder);
		} catch (final Throwable t) {
		}

		if (parent == null) {
			parent = DLAppServiceUtil.addFolder(groupId, 0,
			        orgFolder, "", ctx);
			m_objLog.info("Folder "
			        + orgFolder
			        + " created ....");
		} else {
			m_objLog.info("Folder "
			        + orgFolder
			        + " already existing ....");
		}

		final String[] actionids = new String[2];
		final Role guestRole = RoleLocalServiceUtil.getRole(
		        PortalUtil.getDefaultCompanyId(), RoleConstants.GUEST);
		actionids[0] = ActionKeys.VIEW;
		actionids[1] = ActionKeys.ACCESS;
		// actionids[2] = ActionKeys.ADD_FILE;

		ResourcePermissionServiceUtil.setIndividualResourcePermissions(
		        parent.getGroupId(), parent.getCompanyId(),
		        DLFolder.class.getName(), parent.getFolderId() + "",
		        guestRole.getRoleId(), actionids);
		
	}
	
	/**
	 * Check whether a Liferay-Role matches any role defined by this enum
	 *
	 * @param cmpRole the Liferay role
	 * @return the supported enum or null, if not supported
	 */
	public static E_Role matchesRole(final Role cmpRole) {
		E_Role result = null;

		if (cmpRole != null) {
			for (final E_Role role : E_Role.values()) {
				if (getRoleName(role).equals(cmpRole.getName())
				        && role.getType() == cmpRole.getType()) {
					result = role;
					// System.out.println(role.getName()+" ("+role.getType()+") == "+cmpRole.getName()+" ("+cmpRole.getType()+")");
					break;
				} else {
					// System.out.println(role.getName()+" ("+role.getType()+") != "+cmpRole.getName()+" ("+cmpRole.getType()+")");
				}
			}
		}

		return result;
	}
	
	/**
	 * Get actual/dynamic role name of a role containing a configuration reference
	 * 
	 * @param role The role
	 * @return The role name
	 */
	public static String getRoleName(E_Role role) {
		String name = role.getDefaultName();
		
		//m_objLog.info("Got role "+role.name()+" with rolename "+name+", and key "+role.getKey());
		if (name == null && role.getKey() != null) {
			name = CustomPortalServiceHandler.getConfigValue(role.getKey());
		}
		
		return name;
	}
	
	/**
	 * Check for a specific role name and create a regular role if not existent
	 *
	 * @param companyId the company Id of the given role
	 * @param role the role enum
	 * @return the role
	 */
	public static Role checkRole(final long userId, final long companyId, final E_Role role) {
		return checkRole(userId, companyId, getRoleName(role), role.getType());
	}
	
	/**
	 * Check for a specific role name and create a regular role if not existent
	 *
	 * @param companyId the company Id of the given role
	 * @param roleName the role name
	 * @return the role
	 */
	public static Role checkRole(final long userId, final long companyId, final String roleName, int roleType) {
		Role result = null;

		Role role = null;
		try {
			role = RoleLocalServiceUtil.fetchRole(companyId,
			        roleName);
			if (role != null && role.getType() == roleType)
				result = role;
		} catch (final SystemException e) {
		}
		if (role == null) {
			try {
				/*role = RoleLocalServiceUtil.createRole(CounterLocalServiceUtil
				        .increment(Role.class.getName()));
				role.setName(roleName);
				role.setCompanyId(companyId);
				role.setDescription(roleName);
				role.setTitle(roleName);
				role.setType(RoleConstants.TYPE_REGULAR);
				result = RoleLocalServiceUtil.updateRole(role);*/
				result = RoleLocalServiceUtil.addRole(userId, Role.class.getName(), CounterLocalServiceUtil
				        .increment(Role.class.getName()), roleName, null, null, roleType, null, null);
			} catch (final Throwable t) {
				m_objLog.error(t);
			}
		}

		return result;
	}

	/**
	 * Creates a new portal user
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param mail the email address
	 * @param companyId the company id
	 * @param locale the user's locale
	 * @return the user object
	 */
	public static User createPortalUser(final String firstName,
	        final String lastName, final String mail, final long companyId, final long groupId,
	        final Locale locale, boolean sendMail) {
		return createPortalUser(firstName, lastName, mail, companyId, groupId, locale, sendMail, null, false, null);
	}
	
	public static User createPortalUser(final String firstName,
	        final String lastName, final String mail, final long companyId, final long groupId,
	        final Locale locale, boolean sendMail, String password, boolean isAdmin) {
		return createPortalUser(firstName, lastName, mail, companyId, groupId, locale, sendMail, password, isAdmin, null);
	}
	
	/**
	 * Creates a new portal user
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param mail the email address
	 * @param companyId the company id
	 * @param locale the user's locale
	 * @return the user object
	 */
	public static User createPortalUser(final String firstName,
	        final String lastName, final String mail, final long companyId, final long groupId,
	        final Locale locale, boolean sendMail, String password, boolean isAdmin, E_Role defaultRole) {

		User user = null;
		try {
			if (defaultRole == null)
				defaultRole = E_Role.ORG;
			final Role defRole = checkRole(0, companyId, defaultRole);

			try {
				user = UserLocalServiceUtil.getUserByEmailAddress(companyId,
				        mail);
			} catch (final Throwable t) {
			}
			

			if (user == null) {
				long[] userGroups = new long[1];
				Group guestSite = GroupLocalServiceUtil.getGroup(companyId, GroupConstants.GUEST);
				if (guestSite != null) {
					userGroups = new long[2];
					userGroups[1] = guestSite.getGroupId();
				}
				userGroups[0] = groupId;
				//long[] userGroups = new long[]{groupId, guestSite.getGroupId()};
				
				long[] roles = new long[2];
				roles[0] = defRole.getRoleId();
				
				if (isAdmin) {
					final Role adminRole = checkRole(0, companyId,
					        RoleConstants.ADMINISTRATOR, RoleConstants.TYPE_REGULAR);
					roles[0] = adminRole.getRoleId();
				}
				
				final Role memberRole = checkRole(0, companyId,
				        RoleConstants.SITE_MEMBER, RoleConstants.TYPE_SITE);
				roles[1] = memberRole.getRoleId();
				
				user = UserLocalServiceUtil.addUser(0, companyId, password == null, password,
				        password,
				        true, null, mail, 0L, "", locale, firstName, "",
				        lastName,
				        0, 0, false, 0, 1, 1970, "", userGroups, null,
				        roles, null, sendMail,
				        new ServiceContext());
			}

		} catch (final Exception e) {
			m_objLog.error(e);
		}
		return user;
	}

	/**
	 * Gets the value for a given configuration key (or the default setting if not found)
	 * This method may either access the portlet data-source for local settings or the portal properties for global configuration settings
	 *
	 * @param key the configuration key
	 * @return the configuration value
	 */
	public static String getConfigValue(final E_ConfigKey key) {
		String value = null;
		if (key.isSystemProperty()) {
			try {
				value = PrefsPropsUtil.getString(
				        PortalUtil.getDefaultCompanyId(),
				        key.getSystemProperty());
				// m_objLog.debug("Got portal property "+key.getSystemProperty()+" = "+value);
			} catch (final SystemException e) {
				value = key.getDefaultValue();
				m_objLog.error(e);
			}
		} else {
			value = AHConfigLocalServiceUtil.getConfig(key.toString(),
			        key.getDefaultValue());
			m_objLog.info("Got portlet property "+key.toString()+" = "+value);
		}
		return value;
	}
	
	/**
	 * Checks if a configuration key that holds a boolean setting is set to true
	 * 
	 * @param key the configuration key
	 *
	 * @return true, if the configuration key is a string representation of Boolean.TRUE
	 */
	public static boolean isConfigEnabled(E_ConfigKey key) {
		final String cfgVal = getConfigValue(key);
		return cfgVal != null && cfgVal.equals("true");
	}

	/**
	 * Check whether a given user exists
	 *
	 * @param companyId the company id
	 * @param mail the email address of the user in question
	 * @return true, if the user exists, false otherwise
	 */
	public static boolean hasUser(final long companyId, final String mail) {
		boolean result = false;

		try {
			final User user = UserLocalServiceUtil.getUserByEmailAddress(
			        companyId,
			        mail);
			result = user != null;
		} catch (final NoSuchUserException e) {
			// IGNORE
		} catch (final PortalException e) {
			m_objLog.error(e);
		} catch (final SystemException e) {
			m_objLog.error(e);
		}

		return result;
	}

	/**
	 * Checks if is system initialized. Uses a portlet configuration setting to determine, if {@link #checkInit()) checkInit} was called before.
	 *
	 * @return true, if {@link #checkInit()) checkInit} was successfully called before
	 */
	public static boolean isSystemInitialized() {
		if (m_bInitialized == null) {
			final String cfgVal = getConfigValue(E_ConfigKey.INITFLAG);
			m_bInitialized = cfgVal != null && cfgVal.equals("true");
		}
		return m_bInitialized;
	}

	/**
	 * Save a set of configuration changes right from the portlet request
	 * 
	 * The request is parsed for configuration values with names out of <code>E_ConfigKey</code>
	 * 
	 * As a result, social media plugins and messagec composers will be reinitialized to address the changes
	 *
	 * @param request the portlet request
	 */
	public static void saveConfig(final ActionRequest request) {
		
		final Enumeration<String> paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			final String keyName = paramNames.nextElement();
			E_ConfigKey key = null;
			try {
				key = E_ConfigKey.valueOf(keyName);
			} catch (final Throwable t) {
			}
			if (key != null) {

				final String value = request.getParameter(keyName);
				if (value != null) {
					m_objLog.info("Accepting save parameter: "+keyName+" with value: "+value);
					final String oldVal = getConfigValue(key);
					if (!oldVal.equals(value)) {
						m_objLog.debug("Setting changed parameter: " + keyName);
						setConfig(key, value);
					}

				} /*
				 * else { m_objLog.debug("Accepting save parameter: "+keyName+
				 * " with empty value"); }
				 */
			} /*
			 * else { m_objLog.debug("Ignoring save parameter: "+keyName); }
			 */
		}
		/*
		 * refresh modules that depend on fresh configuration settings
		 */
		MessageComposer.getInstance().refreshCfg();
		SocialMediaFactory.refreshCfg();
	}

	/**
	 * Set a given configuration value
	 *
	 * @param key the configuration key
	 * @param value the configuration value
	 */
	public static void setConfig(final E_ConfigKey key, final String value) {
		if (key.isSystemProperty()) {
			updatePortalPreferences(key.getSystemProperty(), value);
		} else {
			AHConfigLocalServiceUtil.setConfig(key.toString(), value);
		}

	}

	/**
	 * Update portal preferences.
	 *
	 * @param key the property name
	 * @param value the value
	 */
	private static void updatePortalPreferences(final String key,
	        final String value) {
		try {
			final List<PortalPreferences> prefs = PortalPreferencesLocalServiceUtil
			        .getPortalPreferenceses(QueryUtil.ALL_POS,
			                QueryUtil.ALL_POS);

			for (final PortalPreferences pref : prefs) {
				final long ownerId = pref.getOwnerId();
				final int ownerType = pref.getOwnerType();
				// m_objLog.debug("Pref is "+ownerId+","+ownerType+","+pref.getPortalPreferencesId());
				final PortletPreferences pps = PortalPreferencesLocalServiceUtil
				        .getPreferences(ownerId, ownerType);
				final Enumeration<String> names = pps.getNames();
				while (names.hasMoreElements()) {
					final String pkey = names.nextElement();
					if (pkey.equals(key)) {
						// m_objLog.debug("Found property "+key+" with former value "+pps.getValue(key,"N/A"));
						pps.setValue(pkey, value);
						pps.store();
						break;
					}
				}
			}
		} catch (final Throwable e) {
			m_objLog.error(e);
		}
	}
}
