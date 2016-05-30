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

import java.util.LinkedList;
import java.util.List;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.fraunhofer.fokus.oefit.particity.model.AHContact;
import de.fraunhofer.fokus.oefit.particity.service.base.AHContactLocalServiceBaseImpl;

// TODO: Auto-generated Javadoc
/**
 * The implementation of the a h contact local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link de.fraunhofer.fokus.oefit.particity.service.AHContactLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see de.fraunhofer.fokus.oefit.adhoc.service.base.AHContactLocalServiceBaseImpl
 * @see de.fraunhofer.fokus.oefit.particity.service.AHContactLocalServiceUtil
 */
public class AHContactLocalServiceImpl extends AHContactLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link de.fraunhofer.fokus.oefit.adhoc.service.AHContactLocalServiceUtil}
	 * to access the a h contact local service.
	 */

	private static final Log	m_objLog	= LogFactoryUtil
	                                             .getLog(AHContactLocalServiceImpl.class);

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHContactLocalService#addContact(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public AHContact addContact(final String forename, final String surname,
	        final String phone, final String fax, final String mail,
	        final String web) {
		AHContact result = null;
		try {
			result = this.createAHContact(CounterLocalServiceUtil
			        .increment(AHContact.class.getName()));
			result.setEmail(mail);
			result.setFax(fax);
			result.setForename(forename);
			result.setSurname(surname);
			result.setMobile(phone);
			result.setTel(phone);
			result.setWww(web);
			this.updateAHContact(result);
		} catch (final SystemException e) {
			m_objLog.error(e);
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHContactLocalService#getByMail(java.lang.String)
	 */
	@Override
	public List<AHContact> getByMail(final String mail) {
		List<AHContact> result = new LinkedList<AHContact>();

		try {
			final List<AHContact> contacts = this.getAHContactPersistence()
			        .findByemail(mail);
			if (contacts != null && contacts.size() > 0) {
				result = contacts;
			}
		} catch (final SystemException e) {
			m_objLog.error(e);
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHContactLocalService#getByName(java.lang.String, java.lang.String)
	 */
	@Override
	public List<AHContact> getByName(final String forename, final String surname) {
		List<AHContact> result = new LinkedList<AHContact>();

		try {
			final List<AHContact> contacts = this.getAHContactPersistence()
			        .findByname(forename, surname);
			if (contacts != null && contacts.size() > 0) {
				result = contacts;
			}
		} catch (final SystemException e) {
			m_objLog.error(e);
		}

		return result;
	}

}
