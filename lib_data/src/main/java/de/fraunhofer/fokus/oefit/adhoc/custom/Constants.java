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

/**
 * Basic constants used all-over the platform
 * TODO: should actually be made configurable in the settings later on
 */
public class Constants {

	/** The default TimeZone-ID of the server (used for time conversions). */
	public static final String	DEFAULT_TIMEZONE_ID	         = "Europe/Berlin";
	
	/** The default JODA format used to display date strings . */
	public static final String	DEFAULT_JODA_DATE_FORMAT	 = "dd.MM.yyyy";
	
	/** The default JODA format used to display time strings . */
	public static final String	DEFAULT_JODA_TIME_FORMAT	 = "HH:mm";
	
	/** The default JODA format used to display date and time strings . */
	public static final String	DEFAULT_JODA_DATETIME_FORMAT	= DEFAULT_JODA_DATE_FORMAT
	                                                                 + " "
	                                                                 + DEFAULT_JODA_TIME_FORMAT;
	
	/** Portal mode for demonstration purposes (e.g. restricted) */
	public static final int PORTAL_MODE_DEMO = -1;
	/** Portal mode for development (e.g. full functionality with debugging) */
	public static final int PORTAL_MODE_DEV = 0;
	/** Portal mode for production (e.g. full functionality, no debugging)) */
	public static final int PORTAL_MODE_PRODUCTION = 1;
	/** Portal mode for showcases (e.g. full functionality, no online map-services)) */
	public static final int PORTAL_MODE_OFFLINE = -2;
	
	/** Currently active portal mode */
	public static int PORTAL_MODE = PORTAL_MODE_DEV;
	
	/** For demonstration purposes, the platform is restricted in various ways to prevent SPAM, tampering with liferay, etc */
	public static final boolean RESTRICT_TO_DEMO = PORTAL_MODE == PORTAL_MODE_DEMO;

}
