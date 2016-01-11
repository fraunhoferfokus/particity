// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3)
// Source File Name: SecureURLFilter.java

package org.particity.liferay.filter;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.LiferayFilter;
import com.liferay.portal.kernel.servlet.LiferayFilterTracker;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.User;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

public class SecureURLFilter
        implements LiferayFilter
{

	private static final int	 PERM_ALL	             = 0;
	private static final int	 PERM_HTTPS_ONLY	     = 1;
	private static final int	 PERM_INTERNAL_ONLY	     = 2;
	private static final int	 PERM_INTERNALHTTPS_ONLY	= 3;

	private File	             m_objFile	             = null;

	private static Log	         log	                 = LogFactoryUtil
	                                                             .getLog(SecureURLFilter.class);
	private Map<String, Integer>	m_objUrls;
	private Set<String>	         m_objBlockedUrls;
	private Set<String>	         m_objInternalHosts;
	private String	             DEFAULT_REDIRECT_URL;
	private long	             ADMIN_ROLE_ID = -1;
	private long	             m_numLastModified	     = -1;
	private boolean 			 m_bIsEnabled = GetterUtil.getBoolean(PropsUtil.get(getClass().getName()), true);
	
	public SecureURLFilter()
	{

		try {
			log.debug("SecureURLFilter:ctor:start");

			if (m_bIsEnabled) {
				Timer timer = new Timer(true);
				timer.schedule(new TimerTask() {
	
					@Override
					public void run() {
						// log.info("SecureURLFilter:schedule:run" );
						if (m_objFile != null) {
							long lm = m_objFile.lastModified();
							if (lm > m_numLastModified) {
								reloadProperties();
								m_numLastModified = m_objFile.lastModified();
							}
						}
	
					}
				}, 10000, 10000);
	
				/*
				 * Destination dest =
				 * MessageBusUtil.getMessageBus().getDestination("SecureURLFilter"
				 * ); if(dest == null) { dest = new
				 * ParallelDestination("SecureURLFilter");
				 * MessageBusUtil.addDestination(dest); } dest.register(this);
				 * CronTrigger trigger = new CronTrigger("SecureURLFilter",
				 * "SecureURLFilter", " 0/10 1/1 * 1/1 * ? *");
				 * SchedulerEngineUtil.schedule(trigger, StorageType.MEMORY,
				 * "SecureURLFilter", "SecureURLFilter", "", 0);
				 */
	
				m_objUrls = new HashMap<String, Integer>();
				m_objInternalHosts = new HashSet<String>();
				m_objBlockedUrls = new HashSet<String>();
				DEFAULT_REDIRECT_URL = "";
			}
		} catch (Throwable t) {
			t.printStackTrace();
		}

		log.debug("SecureURLFilter:ctor:end");
	}

	private void getProperties(String propertiesFile, ServletContext ctx)
	{
		log.debug("SecureURLFilter:getProperties:start");
		try
		{
			//URL url = SecureURLFilter.class.getResource(propertiesFile);
			
			String pth = ctx.getRealPath("/")+propertiesFile;
			//log.info("Trying to load properties from "+pth);
			
			File fcfg = null;
			if (pth != null) {
				fcfg = new File(pth);
			}

			if (fcfg == null || !fcfg.exists())
			{
				log.warn((new StringBuilder("Properties file: "))
				        .append(ctx.getRealPath("/")).append(propertiesFile)
				        .append(" not found. Loading default properties ...")
				        .toString());
				URL url = SecureURLFilter.class
				        .getResource("/secureUrlFilter.properties");
				if (url != null) {
					fcfg = new File(url.toURI());
				} else {
					log.error((new StringBuilder("Properties file: "))
					        .append(propertiesFile)
					        .append(" not found at all!")
					        .toString());	
				}
			} else
			{
				log.info((new StringBuilder("Loaded properties from: ")).append(
				        propertiesFile).toString());
			}

			if (fcfg != null) {
				m_objFile = fcfg;
				m_numLastModified = fcfg.lastModified();
				reloadProperties();
			}

		} catch (Throwable e)
		{
			log.error((new StringBuilder(
			        "Exception in SecureURLFilter.getProperties(): \n"))
			        .append(e.getMessage()).toString(),e);
		}
		log.debug("SecureURLFilter:getProperties:end");
	}

	private void reloadProperties() {
		log.info("SecureURLFilter:reloadProperties:start");
		try {
			InputStream in = m_objFile.toURL().openStream();
			Properties props = new Properties();
			props.load(in);
			in.close();
			DEFAULT_REDIRECT_URL = props.getProperty("defaultUrl");
			if (DEFAULT_REDIRECT_URL == null || DEFAULT_REDIRECT_URL.trim().length() == 0) {
				Company defCompany = CompanyLocalServiceUtil
				        .getCompany(PortalUtil
				                .getDefaultCompanyId());
				DEFAULT_REDIRECT_URL = PortalUtil.getPortalURL(
						defCompany.getVirtualHostname(),
				        PortalUtil.getPortalPort(), false);
				// FIX: #5 - somethimes portal port is -1 for unknown reasons
				if (DEFAULT_REDIRECT_URL.contains(":-1"))
					DEFAULT_REDIRECT_URL = DEFAULT_REDIRECT_URL.replace(":-1", "");
			}
			
			DEFAULT_REDIRECT_URL = DEFAULT_REDIRECT_URL
			        .substring(DEFAULT_REDIRECT_URL.indexOf("://"));
			String strAdminRoleId = props.getProperty("adminRoleId");
			if (strAdminRoleId != null && strAdminRoleId.trim().length() > 0) {
				try {
					ADMIN_ROLE_ID = Long.parseLong(strAdminRoleId);	
				} catch (Throwable t) {
					ADMIN_ROLE_ID = -1;
				}
			}
			String strInternalHosts = props.getProperty("internalHosts");

			
			log.info("Base portal URL: http(s)" + DEFAULT_REDIRECT_URL);
			log.info("Admin role ID: " + ADMIN_ROLE_ID);
			log.info("Internal hosts: "+strInternalHosts);
			log.info("Filter enabled: "+m_bIsEnabled);
			
			m_objInternalHosts.clear();
			if (strInternalHosts != null
			        && strInternalHosts.trim().length() > 0) {
				String[] hosts = strInternalHosts.split(",");
				for (String host : hosts)
					m_objInternalHosts.add(host);
			}

			// reread
			m_objUrls.clear();
			m_objBlockedUrls.clear();
			in = m_objFile.toURL().openStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String line = null;
			while ((line = br.readLine()) != null) {
				line = line.trim();
				// ignore comments and properties
				if (line.startsWith("#") || line.contains("=")
				        || line.length() == 0)
					continue;
				else {
					if (line.startsWith("/")) {
						m_objUrls.put(line, PERM_ALL);
						log.info("Adding external URL: " + line);
					}
					else {
						int idx = line.indexOf("/");
						if (idx >= 0) {
							String markers = line.substring(0, idx);
							line = line.substring(idx);
							int perm = PERM_ALL;
							if (markers.contains("I"))
							    perm += PERM_INTERNAL_ONLY;
							if (markers.contains("S"))
							    perm += PERM_HTTPS_ONLY;
							if (markers.contains("B")) {
								m_objBlockedUrls.add(line);
								log.info("Adding blocked URL: " + line);
								continue;
							}
							m_objUrls.put(line, perm);
							log.info("Adding restricted (" + perm + ") URL: "
							        + line);
						}
					}
				}
			}

			log.info((new StringBuilder("Number of URLs in SecureURLFilter: "))
			        .append(String.valueOf(m_objUrls.size()+m_objBlockedUrls.size())).append(" admin role id is ").append(ADMIN_ROLE_ID).toString());
		} catch (Throwable e) {
			e.printStackTrace();
			log.error((new StringBuilder(
			        "Exception in SecureURLFilter.reloadProperties(): \n"))
			        .append(e.getMessage()).toString());

		}
		log.info("SecureURLFilter:reloadProperties:end");
	}

	public void doFilter(ServletRequest req, ServletResponse res,
	        FilterChain chain)
	        throws IOException, ServletException
	{
		// filter only, if filter set enabled
		if (m_bIsEnabled) {
			HttpServletRequest request = (HttpServletRequest) req;
			try
			{
				User user = PortalUtil.getUser(request);
				if (user != null)
				{
					long userId = user.getUserId();
					if ((ADMIN_ROLE_ID < 0)
					        || UserLocalServiceUtil.hasRoleUser(ADMIN_ROLE_ID,
					                userId))
					{

						chain.doFilter(req, res);
						return;
					} else
					{
						userNotFound(req, res, chain);
						return;
					}
				} else
				{
					userNotFound(req, res, chain);
					return;
				}
			} catch (Exception e)
			{
				log.error((new StringBuilder(
				        "Error in SecureURLFilter.doFilter(): \n")).append(
				        e.getMessage()).toString());
				userNotFound(req, res, chain);
				return;
			}
		} else {
			chain.doFilter(req, res);
			return;
		}
	}

	private void isUrlAllowed(ServletRequest req, ServletResponse res,
	        FilterChain chain, String targetUrl, boolean isHttps)
	        throws IOException, ServletException {

		int urlPerm = 0;
		boolean urlMatch = false;
		// check for blocked patterns
		for (String url : m_objBlockedUrls) {
			urlMatch = url.endsWith("*")
			        && targetUrl.startsWith(url.substring(0, url.length() - 1));
			urlMatch |= url.equals(targetUrl);
		}
		// if blocked, reset match and ignore further check
		if (urlMatch) {
			urlMatch = false;
		}
		// if NOT blocked, check further
		else {
			for (String url : m_objUrls.keySet())
			{
				urlPerm = m_objUrls.get(url);
				urlMatch = false;

				urlMatch = url.endsWith("*")
				        && targetUrl.startsWith(url.substring(0,
				                url.length() - 1));
				urlMatch |= url.equals(targetUrl);

				if (urlMatch) {
					// external or https required and available
					if (urlPerm == PERM_ALL
					        || (urlPerm == PERM_HTTPS_ONLY && isHttps)) {
						chain.doFilter(req, res);
						return;
					}
					// request for restricted page
					else {
						// simply no HTTPS -> redirect to HTTPS version
						if (urlPerm == PERM_HTTPS_ONLY && !isHttps) {
							log.warn("Denied non-HTTPS access to: " + targetUrl);
							redirect(res, true, targetUrl);
							return;
						}
						// request for internal (with or without HTTPS)
						else {
							String addr = req.getRemoteAddr();
							for (String intHost : m_objInternalHosts) {
								if (addr.startsWith(intHost)) {
									if (urlPerm == PERM_INTERNALHTTPS_ONLY
									        && !isHttps) {
										// simply no HTTPS -> redirect to HTTPS
										// version
										log.warn("Denied non-HTTPS access to internal: "
										        + targetUrl);
										redirect(res, true, targetUrl);
										return;
									} else {
										log.info("Not internal, nor HTTPS -> allow");
										chain.doFilter(req, res);
										return;
									}
								}
							}
						}
						// not allowed!
						redirect(res, isHttps, null);
						return;
					}
				}
			}
		}
		// not allowed!
		log.warn("Denied access to: " + targetUrl);
		redirect(res, isHttps, null);
		return;
	}

	private void redirect(ServletResponse res, boolean https, String url) {
		try
		{
			String scheme = https ? "https" : "http";
			if (url != null)
				url = scheme + DEFAULT_REDIRECT_URL + url;
			else
				url = scheme + DEFAULT_REDIRECT_URL;
			HttpServletResponse httpServletResponse = (HttpServletResponse) res;
			httpServletResponse.sendRedirect(url);
		} catch (IOException e)
		{
			log.error((new StringBuilder("IOException in SecureURLFilter: \n"))
			        .append(e.getMessage()).toString());
		}
	}

	public void init(FilterConfig config)
	        throws ServletException
	{
		log.debug("SecureURLFilter:init:start");
		
		
		if (m_bIsEnabled) {
			try {
				String propertiesFile = config.getInitParameter("propertiesFile");
				if (propertiesFile == null)
				    propertiesFile = "";
				getProperties(propertiesFile, config.getServletContext());
				if (m_numLastModified > 0) {
					LiferayFilterTracker.addLiferayFilter(this);
				}
			} catch (Throwable t) {
				log.error("Could not start SecureURLFilter due to: "
				        + t.getMessage());
				t.printStackTrace();
			}
		}
		log.debug("SecureURLFilter:init:end");
	}

	public void destroy()
	{
		LiferayFilterTracker.removeLiferayFilter(this);
		log.debug("SecureURLFilter:destroy:startend");
	}

	private void userNotFound(ServletRequest req, ServletResponse res,
	        FilterChain chain)
	{
		HttpServletRequest request = (HttpServletRequest) req;
		String currUrl = request.getRequestURL().toString();
		String currParameters = request.getQueryString();
		if (currUrl == null)
		    currUrl = "";
		if (currParameters != null)
		    currUrl = (new StringBuilder(String.valueOf(currUrl))).append("?")
		            .append(currParameters).toString();
		// cut off http(s)
		String scheme = request.getScheme();
		currUrl = currUrl.substring(currUrl.indexOf("://") + 3);
		String currUrlSave = currUrl;
		if (currUrl.contains("p_p_auth="))
		    currUrlSave = currUrl.replaceAll("p_p_auth=.*&p_p_id", "p_p_id");

		String currUrlRel = currUrlSave.substring(currUrl.indexOf("/"));

		try {
			isUrlAllowed(req, res, chain, currUrlRel, scheme.trim()
			        .toLowerCase().equals("https"));
		} catch (Throwable e) {
			log.debug("Got exception on access check: " + e.getMessage());
			e.printStackTrace();
		}

	}

	@Override
    public boolean isFilterEnabled() {
	    return m_bIsEnabled;
    }

	@Override
    public boolean isFilterEnabled(HttpServletRequest request,
            HttpServletResponse response) {
	    return m_bIsEnabled;
    }

	@Override
    public void setFilterEnabled(boolean filterEnabled) {
		log.debug("setFilterEnabled::start("+filterEnabled+")");
	    m_bIsEnabled = filterEnabled;
	    log.debug("setFilterEnabled::end()");
    }

}
