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

import java.util.LinkedList;
import java.util.List;

import com.liferay.portal.kernel.util.PropsKeys;

/**
 * An enum describing available configuration keys, their default value and (if available) their link/id to global portal settings
 */
public enum E_ConfigKey {

	/** Basic contact settings. */
	MGMT_CONTACT_NAME(
	        E_ConfigCategory.MGMTCONTACT,
	        "mgmt.cfg.key.mgmtcontact.name",
	        "",
	        PropsKeys.ADMIN_EMAIL_FROM_NAME),
	
	/** The mgmt contact mail. */
	MGMT_CONTACT_MAIL(
	        E_ConfigCategory.MGMTCONTACT,
	        "mgmt.cfg.key.mgmtcontact.mail",
	        "",
	        PropsKeys.ADMIN_EMAIL_FROM_ADDRESS),
	
	/** The mgmt contact tel. */
	MGMT_CONTACT_TEL(
	        E_ConfigCategory.MGMTCONTACT,
	        "mgmt.cfg.key.mgmtcontact.tel",
	        ""),
	
	/** The mgmt contact surname. */
	MGMT_CONTACT_SURNAME(
	        E_ConfigCategory.MGMTCONTACT,
	        "mgmt.cfg.key.mgmtcontact.surname",
	        ""),
	
	/** The mgmt contact forename. */
	MGMT_CONTACT_FORENAME(
	        E_ConfigCategory.MGMTCONTACT,
	        "mgmt.cfg.key.mgmtcontact.forename",
	        ""),
	
	/** The mgmt path offer permalink. */
	MGMT_PATH_OFFER_PERMALINK(
	        E_ConfigCategory.MGMTPATHS,
	        "mgmt.cfg.key.mgmtpath.offerperma",
	        "http://www.mitmachboerse.de/suche-form/-/search/result/"),
	
	/** The mgmt path org registration. */
	MGMT_PATH_ORG_REGISTRATION(
	        E_ConfigCategory.MGMTPATHS,
	        "mgmt.cfg.key.mgmtpath.orgregister",
	        "/organization"),

	/** The mgmt new org subj. */
	MGMT_NEW_ORG_SUBJ(
	        E_ConfigCategory.MGMTNEWORG,
	        "mgmt.cfg.key.mail.subj",
	        "[adhoc-boerse] Neue Organisation [$ORG_NAME$]"),
	
	/** The mgmt new org body. */
	MGMT_NEW_ORG_BODY(
	        E_ConfigCategory.MGMTNEWORG,
	        E_ConfigType.TEXTAREA,
	        "mgmt.cfg.key.mail.body",
	        "Die Organisation [$ORG_NAME$] hat sich auf dem Portal registriert!"),
	
	/** The mgmt new offer subj. */
	MGMT_NEW_OFFER_SUBJ(
	        E_ConfigCategory.MGMTNEWOFFER,
	        "mgmt.cfg.key.mail.subj",
	        "[adhoc-boerse] Neues Angebot von [$ORG_NAME$]"),
	
	/** The mgmt new offer body. */
	MGMT_NEW_OFFER_BODY(
	        E_ConfigCategory.MGMTNEWOFFER,
	        E_ConfigType.TEXTAREA,
	        "mgmt.cfg.key.mail.body",
	        "Die Organisation [$ORG_NAME$] hat ein neues Angebot eingestellt: [$OFFER_NAME$]"),

	/** New or changed organisations, offers. */
	ORG_REMINDER_SUBJ(
	        E_ConfigCategory.ORGREMIND,
	        "mgmt.cfg.key.mail.subj",
	        "[adhoc-boerse] Angeboteserinnerung"),
	
	/** The org reminder body. */
	ORG_REMINDER_BODY(
	        E_ConfigCategory.ORGREMIND,
	        E_ConfigType.TEXTAREA,
	        "mgmt.cfg.key.mail.body",
	        "Sehr geehrte Damen und Herren,<br/><br/>Ihre Organisation [$ORG_NAME$] hat in letzter Zeit keine neuen Angebote eingestellt.<br/><br/>Mit freundlichen Grüßen,<br/>das Team"),
	
	/** The org expired offer subj. */
	ORG_EXPIRED_OFFER_SUBJ(
	        E_ConfigCategory.ORGEXPIRED,
	        "mgmt.cfg.key.mail.subj",
	        "[adhoc-boerse] Angebote beendet"),
	
	/** The org expired offer body. */
	ORG_EXPIRED_OFFER_BODY(
	        E_ConfigCategory.ORGEXPIRED,
	        E_ConfigType.TEXTAREA,
	        "mgmt.cfg.key.mail.body",
	        "Sehr geehrte Damen und Herren,<br/><br/>folgende Angebote wurden innerhalb der letzten Stunde beendet:<br/><br/> [$OFFER_LIST$]<br/><br/>Mit freundlichen Grüßen,<br/>das Team"),

	/** The org valid org subj. */
	ORG_VALID_ORG_SUBJ(
	        E_ConfigCategory.ORGORGVALID,
	        "mgmt.cfg.key.mail.subj",
	        "[adhoc-boerse] Organisation freigegeben"),
	
	/** The org valid org body. */
	ORG_VALID_ORG_BODY(
	        E_ConfigCategory.ORGORGVALID,
	        E_ConfigType.TEXTAREA,
	        "mgmt.cfg.key.mail.body",
	        "Sehr geehrte Damen und Herren,<br/><br/>Ihre Organisation [$ORG_NAME$] wurde von der Verwaltung bestätigt.<br/> Sie können nun Angebote einstellen.<br/><br/>Mit freundlichen Grüßen,<br/>das Team"),
	
	/** The org valid offer subj. */
	ORG_VALID_OFFER_SUBJ(
	        E_ConfigCategory.ORGOFFERVALID,
	        "mgmt.cfg.key.mail.subj",
	        "[adhoc-boerse] Angebot freigegeben: [$OFFER_NAME$]"),
	
	/** The org valid offer body. */
	ORG_VALID_OFFER_BODY(
	        E_ConfigCategory.ORGOFFERVALID,
	        E_ConfigType.TEXTAREA,
	        "mgmt.cfg.key.mail.body",
	        "Sehr geehrte Damen und Herren,<br/><br/>Ihr Angebot [$OFFER_NAME$] wurde von der Verwaltung freigegeben.<br/><br/>Mit freundlichen Grüßen,<br/>das Team"),
	
	/** The org new offer subj. */
	ORG_NEW_OFFER_SUBJ(
	        E_ConfigCategory.ORGOFFERNEW,
	        "mgmt.cfg.key.mail.subj",
	        "[adhoc-boerse] Neues Angebot: [$OFFER_NAME$]"),
	
	/** The org new offer body. */
	ORG_NEW_OFFER_BODY(
	        E_ConfigCategory.ORGOFFERNEW,
	        E_ConfigType.TEXTAREA,
	        "mgmt.cfg.key.mail.body",
	        "Sehr geehrte Damen und Herren,<br/><br/>Ihr Angebot [$OFFER_NAME$] wurde der Verwaltung vorgelegt. Sie erhalten in Kürze von uns Nachricht zum aktuellen Stand.<br/><br/>Mit freundlichen Grüßen,<br/>das Team"),
	
	/** Organisation new account notification & verification. */
	ORG_REG_VER_SUBJ(
	        E_ConfigCategory.ORGVER,
	        "mgmt.cfg.key.mail.subj",
	        "",
	        PropsKeys.ADMIN_EMAIL_VERIFICATION_SUBJECT),
	
	/** The org reg ver body. */
	ORG_REG_VER_BODY(
	        E_ConfigCategory.ORGVER,
	        E_ConfigType.TEXTAREA,
	        "mgmt.cfg.key.mail.body",
	        "",
	        PropsKeys.ADMIN_EMAIL_VERIFICATION_BODY),
	
	/** The org reg newacc subj. */
	ORG_REG_NEWACC_SUBJ(
	        E_ConfigCategory.ORGREG,
	        "mgmt.cfg.key.mail.subj",
	        "",
	        PropsKeys.ADMIN_EMAIL_USER_ADDED_SUBJECT),
	
	/** The org reg newacc body. */
	ORG_REG_NEWACC_BODY(
	        E_ConfigCategory.ORGREG,
	        E_ConfigType.TEXTAREA,
	        "mgmt.cfg.key.mail.body",
	        "",
	        PropsKeys.ADMIN_EMAIL_USER_ADDED_BODY),

	/** Newsletter confirmation subject. */
	NEWS_REG_CONFIRM_SUBJ(
	        E_ConfigCategory.NEWSREG,
	        "mgmt.cfg.key.mail.subj",
	        "[adhoc-boerse] Newsletter Bestätigung erforderlich"),
	
	/** Newsletter confirmation body. */
	NEWS_REG_CONFIRM_BODY(
	        E_ConfigCategory.NEWSREG,
	        E_ConfigType.TEXTAREA,
	        "mgmt.cfg.key.mail.body",
	        "Lieber Interessent!<br/><br/>Sie haben unseren personalisierten Newsletter über diese E-Mail Adresse abboniert. Zur Bestätigung klicken Sie bitte hier:<br/>[$PORTAL_URL$]/newsletter?uuid=[$TO_UUID$]!<br/><br/> Vielen Dank für Ihr Engagement!<br/>Ihr adhoc-Team"),

	/** Newsletter update subject. */
	NEWS_UPDATE_SUBJ(
	        E_ConfigCategory.NEWSUPD,
	        "mgmt.cfg.key.mail.subj",
	        "[adhoc-boerse] [$OFFER_COUNT$] neue Angebote"),
	
	/** Newsletter update body. */
	NEWS_UPDATE_BODY(
	        E_ConfigCategory.NEWSUPD,
	        E_ConfigType.TEXTAREA,
	        "mgmt.cfg.key.mail.body",
	        "Lieber Interessent!<br/><br/>es gibt [$OFFER_COUNT$] neue Angebote, die Sie interessieren könnten:<br/><br/>[$OFFER_LIST_EXT:baseUrl=/suche-kenntnisse/$]<br/><br/>Zur Verwaltung Ihres Newsletter oder zur Abmeldung verwenden Sie bitte folgenden Link:<br/>[$PORTAL_URL$]/newsletter?uuid=[$TO_UUID$]<br/>Vielen Dank für Ihr Engagement!<br/>Ihr adhoc-Team"),

	/** Switch for Facebook-integration */
	SOCIAL_FB_ENABLED(E_ConfigCategory.SOCIALFB, E_ConfigType.YESNO, "mgmt.cfg.key.fb.enable", "true"),
	        
	/** Facebook consumer key/token Facebook access key/token. */
	SOCIAL_FB_APPID(E_ConfigCategory.SOCIALFB, "mgmt.cfg.key.fbappid.title", ""),
	
	/** The social fb appsec. */
	SOCIAL_FB_APPSEC(
	        E_ConfigCategory.SOCIALFB,
	        "mgmt.cfg.key.fbappsec.title",
	        ""),
	
	/** The social fb at. */
	SOCIAL_FB_AT(E_ConfigCategory.SOCIALFB, "mgmt.cfg.key.fbat.title", ""),
	
	/** The social fb msg. */
	SOCIAL_FB_MSG(
	        E_ConfigCategory.SOCIALFB,
	        E_ConfigType.TEXTAREA,
	        "mgmt.cfg.key.fb.body",
	        "Die Organisation [$ORG_NAME$] hat ein neues Angebot [$OFFER_NAME$] eingestellt unter: [$OFFER_URL$]"),
	
	/** Switch for Twitter-integration */
	SOCIAL_TW_ENABLED(E_ConfigCategory.SOCIALTW, E_ConfigType.YESNO, "mgmt.cfg.key.tw.enable", "true"),
	        
	/** Twitter consumer key/token Twitter access key/token. */
	SOCIAL_TW_CK(E_ConfigCategory.SOCIALTW, "mgmt.cfg.key.twck.title", ""),
	
	/** The social tw cs. */
	SOCIAL_TW_CS(E_ConfigCategory.SOCIALTW, "mgmt.cfg.key.twcs.title", ""),
	
	/** The social tw at. */
	SOCIAL_TW_AT(E_ConfigCategory.SOCIALTW, "mgmt.cfg.key.twat.title", ""),
	
	/** The social tw ats. */
	SOCIAL_TW_ATS(E_ConfigCategory.SOCIALTW, "mgmt.cfg.key.twats.title", ""),
	
	/** The social tw msg. */
	SOCIAL_TW_MSG(
	        E_ConfigCategory.SOCIALTW,
	        E_ConfigType.TEXTAREA,
	        "mgmt.cfg.key.fb.body",
	        "Die Organisation [$ORG_NAME$] hat ein neues Angebot [$OFFER_NAME$] eingestellt unter [$OFFER_URL$]"),

	OSM_URL(E_ConfigCategory.OSMMAP, "mgmt.cfg.key.osm.url", "http://{s}.tile.osm.org/{z}/{x}/{y}.png"),
	OSM_ATTRIB(E_ConfigCategory.OSMMAP, "mgmt.cfg.key.osm.attrib", "&copy; <a href=\"http://osm.org/copyright\">OpenStreetMap</a> contributors"),
	OSM_ID(E_ConfigCategory.OSMMAP, "mgmt.cfg.key.osm.id", ""),
	OSM_AT(E_ConfigCategory.OSMMAP, "mgmt.cfg.key.osm.at", ""),
	        
	/** Newsletter-Scheduler Settings. */
	SCHED_NEWS(E_ConfigCategory.NONE, "", "-1"),

	/** Initial initialization. */
	INITFLAG(E_ConfigCategory.NONE, "", "false"),
	
	/** Setup wizard already run. */
	WIZARDFLAG(E_ConfigCategory.NONE, "", "true", "setup.wizard.enabled"),
	
	/** Where to put uploads of organisation logos */
	ORGANISATION_LOGO_FOLDER(E_ConfigCategory.NONE, "","Organisation-Logos"),
	
	/** Moderate offers **/
	MODERATE_OFFERS(E_ConfigCategory.NONE, "", "true"),
	
	/** Moderate organisations **/
	MODERATE_ORGS(E_ConfigCategory.NONE, "", "true"),
	
	/** Moderate organisations **/
	ENABLE_NEWSLETTER(E_ConfigCategory.NONE, "", "true"),
	
	/** Role for organisations */
	ROLE_NAME_ORG(E_ConfigCategory.NONE, "", "Engagement Organisation"),
	
	/** Role for agency/management */
	ROLE_NAME_MGMT(E_ConfigCategory.NONE, "", "Engagement Verwaltung"),
	
	/** Role for administration */
	ROLE_NAME_ADM(E_ConfigCategory.NONE, "", "Engagement Administration"),
	
	;

	/**
	 * Gets the by category.
	 *
	 * @param cat the cat
	 * @return the by category
	 */
	public static List<E_ConfigKey> getByCategory(final E_ConfigCategory cat) {
		final List<E_ConfigKey> result = new LinkedList<E_ConfigKey>();

		for (final E_ConfigKey key : E_ConfigKey.values()) {
			if (key.getCategory().equals(cat)) {
				result.add(key);
			}
		}

		return result;
	}

	private String	         m_strDefVal;
	private String	         m_strMsgProp;
	private E_ConfigCategory	m_objCategory;
	private E_ConfigType	 m_objType;

	private String	         m_strSysProp	= null;

	private E_ConfigKey(final E_ConfigCategory category,
	        final E_ConfigType type, final String msgProperty,
	        final String defValue) {
		this.m_strDefVal = defValue;
		this.m_strMsgProp = msgProperty;
		this.m_objCategory = category;
		this.m_objType = type;
	}

	private E_ConfigKey(final E_ConfigCategory category,
	        final E_ConfigType type, final String msgProperty,
	        final String defValue, final String systemProperty) {
		this.m_strDefVal = defValue;
		this.m_strMsgProp = msgProperty;
		this.m_objCategory = category;
		this.m_objType = type;
		this.m_strSysProp = systemProperty;
	}

	private E_ConfigKey(final E_ConfigCategory category,
	        final String msgProperty, final String defValue) {
		this.m_strDefVal = defValue;
		this.m_strMsgProp = msgProperty;
		this.m_objCategory = category;
		this.m_objType = E_ConfigType.TEXT;
	}

	private E_ConfigKey(final E_ConfigCategory category,
	        final String msgProperty, final String defValue,
	        final String systemProperty) {
		this.m_strDefVal = defValue;
		this.m_strMsgProp = msgProperty;
		this.m_objCategory = category;
		this.m_objType = E_ConfigType.TEXT;
		this.m_strSysProp = systemProperty;
	}

	/**
	 * Gets the category.
	 *
	 * @return the category
	 */
	public E_ConfigCategory getCategory() {
		return this.m_objCategory;
	}

	/**
	 * Gets the default value.
	 *
	 * @return the default value
	 */
	public String getDefaultValue() {
		return this.m_strDefVal;
	}

	/**
	 * Gets the msg property.
	 *
	 * @return the msg property
	 */
	public String getMsgProperty() {
		return this.m_strMsgProp;
	}

	/**
	 * Gets the system property.
	 *
	 * @return the system property
	 */
	public String getSystemProperty() {
		return this.m_strSysProp;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public E_ConfigType getType() {
		return this.m_objType;
	}

	/**
	 * Checks if is system property.
	 *
	 * @return true, if is system property
	 */
	public boolean isSystemProperty() {
		return this.m_strSysProp != null;
	}
}
