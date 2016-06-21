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

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * Custom utility methods used by services and JSPs
 */
public class CustomServiceUtils {

	private static final Log	m_objLog	= LogFactoryUtil
	                                             .getLog(CustomServiceUtils.class);

	private static ZoneId	m_objTZ	 = null;

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
	
	public static String arrToStr(String[] categoryItems) {
		StringBuffer result = new StringBuffer();
		
		if (categoryItems != null && categoryItems.length > 0) {
			int i = 0;
			String item;
			for (;i<categoryItems.length;i++) {
				item = categoryItems[i];
				
				if (item != null && item.trim().length() > 0) {
					//m_objLog.info("Adding first category item "+i+": "+item);
					result.append(item);
					break;
				}
			}
			
			for (;i<categoryItems.length; i++) {
				item = categoryItems[i];
				if (item != null && item.trim().length() > 0) {
					//m_objLog.info("Adding category item "+i+": "+item);
					result.append(",").append(item);
				}
			}
				
		}
		return result.toString();
	}
	
	public static String arrToStr(Long[] ids) {
		StringBuffer result = new StringBuffer();
		
		if (ids != null && ids.length > 0) {
			result.append(ids[0]);
			for (int i=1; i<ids.length; i++)
				result.append(",").append(ids[i]);
		}
		
		return result.toString();
	}
	
	public static String arrToStr(int[] ids) {
		StringBuffer result = new StringBuffer();
		
		if (ids != null && ids.length > 0) {
			result.append(ids[0]);
			for (int i=1; i<ids.length; i++)
				result.append(",").append(ids[i]);
		}
		
		return result.toString();
	}
	
	public static String arrToStr(Enum[] enums) {
		StringBuffer result = new StringBuffer();
		
		if (enums != null && enums.length > 0) {
			result.append(enums[0].name());
			for (int i=1; i<enums.length; i++)
				result.append(",").append(enums[i].name());
		}
		
		return result.toString();
	}

	/**
	 * Format a numeric Date representation to a readable string, according to the default Date-format specified in Constants
	 * Note: uses {@link #getTimeZone()) getTimeZone} as default timezone 
	 *
	 * @param date the date in numeric form
	 * @return the string representation
	 */
	public static String formatZoneDate(final long date) {
		return formatZoneDate(toLocalDateTime(date));
	}
	
	public static String formatZoneDate(final LocalDateTime date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.DEFAULT_JODA_DATE_FORMAT);
		return formatter.format(date);
	}

	/**
	 * Format a numeric date+time representation to a readable string, according to the default Date+Time-format specified in Constants
	 * Note: uses {@link #getTimeZone()) getTimeZone} as default timezone
	 *  
	 * @param date the date+time in numeric form
	 * @return the string representation
	 */
	public static String formatZoneDateTime(final long date) {
		return formatZoneDateTime(toLocalDateTime(date));
	}
	
	public static String formatZoneDateTime(LocalDateTime date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.DEFAULT_JODA_DATETIME_FORMAT);
		return formatter.format(date);
	}

	/**
	 * Format a numeric time representation to a readable string, according to the default Time-format specified in Constants
	 * Note: uses {@link #getTimeZone()) getTimeZone} as default timezone 
	 * 
	 * @param date the time in numeric form
	 * @return the string representation
	 */
	public static String formatZoneTime(final long date) {
		return formatZoneTime(toLocalDateTime(date));
	}

	public static String formatZoneTime(final LocalDateTime date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.DEFAULT_JODA_TIME_FORMAT);
		return formatter.format(date);
	}
	
	/**
	 * Gets the time zone, as configured in Constants 
	 *
	 * @return the default time zone object
	 */
	public static ZoneId getTimeZone() {
		
		ZoneId result = m_objTZ;
		if (result == null) {
			try {
				result = ZoneId.of(Constants.DEFAULT_TIMEZONE_ID);
			} catch (final Throwable t) {
				result = ZoneId.systemDefault();
				m_objLog.warn("Could not get timezone for "
				        + Constants.DEFAULT_TIMEZONE_ID
				        + ". Using system default " + result.getId());
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
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.DEFAULT_JODA_DATETIME_FORMAT);
		LocalDateTime dateTime = LocalDateTime.parse(date+" "+time, formatter);
		return dateTime.atZone(getTimeZone()).toInstant().toEpochMilli();
	}
	
	public static long localDateTimeToMillis(LocalDateTime date) {
		return date.atZone(getTimeZone()).toInstant().toEpochMilli();
	}
	
	public static LocalDateTime toLocalDateTime(long date) {
		return LocalDateTime.ofInstant(Instant.ofEpochMilli(date), getTimeZone());
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
	public static LocalDateTime time() {
		return LocalDateTime.now();
	}
	
	public static long timeMillis() {
		return LocalDateTime.now(getTimeZone()).atZone(getTimeZone()).toInstant().toEpochMilli();
	}

	

}
