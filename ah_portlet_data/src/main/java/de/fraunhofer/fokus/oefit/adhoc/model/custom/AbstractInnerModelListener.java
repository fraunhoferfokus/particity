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
package de.fraunhofer.fokus.oefit.adhoc.model.custom;

import com.liferay.portal.ModelListenerException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.BaseModelListener;

/**
 * The listener interface for receiving model events.
 * The class that is interested in processing a model
 * event implements this interface. When the generic model 
 * event occurs, that object's appropriate method is invoked.
 *
 * @param <T> the generic type
 */
public abstract class AbstractInnerModelListener<T extends BaseModel<T>> extends
        BaseModelListener<T> {

	private static final Log	              m_objLog	  = LogFactoryUtil
	                                                              .getLog(AbstractInnerModelListener.class);
	private final ModelNotificationRepository	m_objRepo	= ModelNotificationRepository
	                                                              .getInstance();

	/* (non-Javadoc)
	 * @see com.liferay.portal.model.BaseModelListener#onAfterCreate(com.liferay.portal.model.BaseModel)
	 */
	@Override
	public void onAfterCreate(final T model) throws ModelListenerException {
		m_objLog.trace("onAfterCreate::start");
		this.m_objRepo.notifyCreate(model);
		super.onAfterCreate(model);
		m_objLog.trace("onAfterCreate::end");
	}

	/* (non-Javadoc)
	 * @see com.liferay.portal.model.BaseModelListener#onAfterRemove(com.liferay.portal.model.BaseModel)
	 */
	@Override
	public void onAfterRemove(final T model) throws ModelListenerException {
		m_objLog.trace("onAfterRemove::start");
		this.m_objRepo.notifyDelete(model);
		super.onAfterUpdate(model);
		m_objLog.trace("onAfterRemove::end");
	}

	/* (non-Javadoc)
	 * @see com.liferay.portal.model.BaseModelListener#onAfterUpdate(com.liferay.portal.model.BaseModel)
	 */
	@Override
	public void onAfterUpdate(final T model) throws ModelListenerException {
		m_objLog.trace("onAfterUpdate::start");
		this.m_objRepo.notifyUpdate(model);
		super.onAfterUpdate(model);
		m_objLog.trace("onAfterUpdate::end");
	}

}
