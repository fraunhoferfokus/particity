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

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * Custom utility methods used by services and JSPs
 */
public class CustomServiceUtils {

	private static final Log	m_objLog	= LogFactoryUtil
	                                             .getLog(CustomServiceUtils.class);

	private static DateTimeZone	m_objTZ	 = null;

	/**
	 * Parse a list of Long values from their String representation
	 *
	 * @param categories The Long values as array with string representations
	 * @return the actual Long values as array
	 */
	public static long[] categoryStrToLong(final String[] categories) {
		long[] l_cats = null;
		if (categories != null && categories.length > 0) {
			l_cats = new long[categories.length];
			for (int i = 0; i < categories.length; i++) {
				l_cats[i] = Long.parseLong(categories[i]);
			}
		}
		return l_cats;
	}

	/**
	 * Format a numeric Date representation to a readable string, according to the default Date-format specified in Constants
	 * Note: uses {@link #getTimeZone()) getTimeZone} as default timezone 
	 *
	 * @param date the date in numeric form
	 * @return the string representation
	 */
	public static String formatZoneDate(final long date) {
		String result = null;
		DateTimeFormatter fmt = DateTimeFormat
		        .forPattern(Constants.DEFAULT_JODA_DATE_FORMAT);
		fmt = fmt.withZone(getTimeZone());
		result = fmt.print(date);
		return result;
	}

	/**
	 * Format a numeric date+time representation to a readable string, according to the default Date+Time-format specified in Constants
	 * Note: uses {@link #getTimeZone()) getTimeZone} as default timezone
	 *  
	 * @param date the date+time in numeric form
	 * @return the string representation
	 */
	public static String formatZoneDateTime(final long date) {
		String result = null;
		DateTimeFormatter fmt = DateTimeFormat
		        .forPattern(Constants.DEFAULT_JODA_DATETIME_FORMAT);
		fmt = fmt.withZone(getTimeZone());
		result = fmt.print(date);
		return result;
	}

	/**
	 * Format a numeric time representation to a readable string, according to the default Time-format specified in Constants
	 * Note: uses {@link #getTimeZone()) getTimeZone} as default timezone 
	 * 
	 * @param date the time in numeric form
	 * @return the string representation
	 */
	public static String formatZoneTime(final long date) {
		String result = null;
		DateTimeFormatter fmt = DateTimeFormat
		        .forPattern(Constants.DEFAULT_JODA_TIME_FORMAT);
		fmt = fmt.withZone(getTimeZone());
		result = fmt.print(date);
		return result;
	}

	/**
	 * Gets the time zone, as configured in Constants 
	 *
	 * @return the default time zone object
	 */
	public static DateTimeZone getTimeZone() {
		DateTimeZone result = m_objTZ;
		if (result == null) {
			try {
				result = DateTimeZone.forID(Constants.DEFAULT_TIMEZONE_ID);
			} catch (final Throwable t) {
				result = DateTimeZone.getDefault();
				m_objLog.warn("Could not get timezone for "
				        + Constants.DEFAULT_TIMEZONE_ID
				        + ". Using system default " + result.getID());
			}
			m_objTZ = result;
		}
		return result;
	}

	/**
	 * Parses the given date and time from string-representation to its numeric value
	 * Note: uses {@link #getTimeZone()) getTimeZone} as default timezone 
	 * 
	 * @param date the date
	 * @param time the time
	 * @return the numeric representation
	 */
	public static long parseZoneDateTime(final String date, final String time) {
		long result = -1;
		DateTimeFormatter fmt = DateTimeFormat
		        .forPattern(Constants.DEFAULT_JODA_DATETIME_FORMAT);
		fmt = fmt.withZone(getTimeZone());
		result = fmt.parseDateTime(date + " " + time).getMillis();
		return result;
	}

	/**
	 * Parse a list of Long values from an imploded String representation (using , as delimiter)
	 *
	 * @param str The string representing a list of long, separated by comma
	 * @return the actual Long values as array
	 */
	public static Long[] strToLongArr(final String str) {
		Long[] result = null;
		if (str != null) {
			final String split[] = str.replaceAll("\"", "").split(",");
			if (split != null && split.length > 0) {
				result = new Long[split.length];
				for (int i = 0; i < split.length; i++) {
					try {
						result[i] = Long.parseLong(split[i]);
					} catch (final Throwable t) {
					}
				}
			}

		}
		return result;
	}

	/**
	 * Get the current time as number
	 *
	 * @return the current time in milliseconds
	 */
	public static long time() {
		return DateTime.now(getTimeZone()).getMillis();
	}

}
