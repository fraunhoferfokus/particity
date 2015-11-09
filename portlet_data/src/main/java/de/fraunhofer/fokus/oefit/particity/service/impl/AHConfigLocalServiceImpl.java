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

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.fraunhofer.fokus.oefit.adhoc.custom.E_ConfigKey;
import de.fraunhofer.fokus.oefit.particity.model.AHConfig;
import de.fraunhofer.fokus.oefit.particity.service.base.AHConfigLocalServiceBaseImpl;

// TODO: Auto-generated Javadoc
/**
 * The implementation of the a h config local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link de.fraunhofer.fokus.oefit.particity.service.AHConfigLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see de.fraunhofer.fokus.oefit.adhoc.service.base.AHConfigLocalServiceBaseImpl
 * @see de.fraunhofer.fokus.oefit.particity.service.AHConfigLocalServiceUtil
 */
public class AHConfigLocalServiceImpl extends AHConfigLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link de.fraunhofer.fokus.oefit.adhoc.service.AHConfigLocalServiceUtil}
	 * to access the a h config local service.
	 */

	private static final Log	m_objLog	= LogFactoryUtil
	                                             .getLog(AHConfigLocalServiceImpl.class);


	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHConfigLocalService#getConfig(java.lang.String, java.lang.String)
	 */
	@Override
	public String getConfig(final String key, final String defaultValue) {
		AHConfig cfg = null;
		try {
			cfg = this.getAHConfig(key);
		} catch (final Throwable e) {
		}
		return cfg == null ? defaultValue : cfg.getValue();
	}

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHConfigLocalService#setConfig(java.lang.String, java.lang.String)
	 */
	@Override
	public void setConfig(final String key, final String value) {
		AHConfig cfg = null;
		try {
			try {
				cfg = this.getAHConfig(key);
			} catch (final Throwable t) {
			}
			if (cfg == null) {
				cfg = this.createAHConfig(key);
			}
			cfg.setValue(value);
			m_objLog.debug("Setting " + key + "=" + value);
			this.updateAHConfig(cfg);
		} catch (final Throwable e) {
			m_objLog.error(e);
		}
	}

}
