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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.LockLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;

/**
 * Custom utility methods for locking mechanism
 * Acts as a wrapper for Liferays locking mechanism.
 * 
 */
public class CustomLockServiceHandler {

	/**
	 * The inner object to synchronize utility calls
	 */
	private static final Object	m_objLock	= new Object();

	private static final Log	m_objLog	= LogFactoryUtil
	                                              .getLog(CustomLockServiceHandler.class);

	private static String getLockOwner(final String className,
	        final long offerId) {
		String result = null;
		try {
			if (LockLocalServiceUtil.isLocked(className,
			        Long.toString(offerId))) {
				result = LockLocalServiceUtil.getLock(className,
				        Long.toString(offerId)).getOwner();
			}

		} catch (final SystemException e) {
			m_objLog.error(e);
		} catch (final PortalException e) {
			m_objLog.error(e);
		}

		return result;
	}

	/**
	 * Check if a specific class with a given primary key is locked for the current user
	 *
	 * @param className the class name
	 * @param id the primary key
	 * @param display the current user's theme display
	 * @return true, if the object is locked
	 */
	public static boolean isLocked(final String className, final long id,
	        final ThemeDisplay display) {
		final String usermail = display.getUser().getEmailAddress();
		final String owner = getLockOwner(className, id);
		return owner != null && !owner.equals(usermail);
	}

	private static String lock(final String className, final long offerId,
	        final String owner) {
		String result = null;
		synchronized (m_objLock) {
			try {
				result = getLockOwner(className, offerId);
				if (result == null) {
					LockLocalServiceUtil.lock(className,
					        Long.toString(offerId), owner);
					result = owner;
				}
			} catch (final SystemException e) {
				m_objLog.error(e);
			}
		}
		return result;
	}

	/**
	 * Lock a specific class with a given primary key for the current user
	 *
	 * @param className the class name
	 * @param id the primary key
	 * @param display the current user's theme display
	 * @return true, if the object was locked successfully, false otherwise (e.g. locked by someone else)
	 */
	public static boolean lock(final String className, final long id,
	        final ThemeDisplay display) {
		final String usermail = display.getUser().getEmailAddress();
		final String newOwner = lock(className, id, usermail);
		final boolean result = newOwner != null && newOwner.equals(usermail);
		m_objLog.debug("Locking " + className + ":" + id + " = " + result
		        + "(user: " + usermail + ", owner: " + newOwner + ")");
		return result;
	}

	private static String unlock(final String className, final long offerId,
	        final String owner) {
		String result = null;
		synchronized (m_objLock) {
			try {
				result = getLockOwner(className, offerId);

				if (result != null && result.equals(owner)) {
					LockLocalServiceUtil.unlock(className,
					        Long.toString(offerId));
				}
			} catch (final SystemException e) {
				m_objLog.error(e);
			}
		}
		return result;
	}

	/**
	 * Unlock a specific class with a given primary key for the current user
	 *
	 * @param className the class name
	 * @param id the primary key
	 * @param display the current user's theme display
	 * @return true, if the object was unlocked successfully, false otherwise (e.g. locked by someone else)
	 */
	public static boolean unlock(final String className, final long id,
	        final ThemeDisplay display) {
		final String usermail = display.getUser().getEmailAddress();
		final String owner = unlock(className, id, usermail);
		final boolean result = owner == null || owner.equals(usermail);
		m_objLog.debug("Unlocking " + className + ":" + id + " = " + result
		        + "(user: " + usermail + ", owner: " + owner + ")");
		return result;
	}
}
