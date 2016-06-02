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
package de.particity.model.listener;

import java.util.LinkedList;
import java.util.List;

/**
 * A repository for listeners of type <code>I_ModelListener</code> that require
 * notification on model changes
 */
public class ModelNotificationRepository {

	private static ModelNotificationRepository	m_objSelf	= null;

	/**
	 * Gets the single instance of ModelNotificationRepository.
	 *
	 * @return single instance of ModelNotificationRepository
	 */
	public static final synchronized ModelNotificationRepository getInstance() {
		if (m_objSelf == null) {
			m_objSelf = new ModelNotificationRepository();
		}

		return m_objSelf;
	}

	private final List<I_ModelListener>	m_objListeners;

	private ModelNotificationRepository() {
		this.m_objListeners = new LinkedList<I_ModelListener>();
		this.m_objListeners.add(MailListener.getInstance());
	}

	/**
	 * Adds the listener.
	 *
	 * @param listener the listener
	 */
	public void addListener(final I_ModelListener listener) {
		synchronized (this.m_objListeners) {
			if (this.m_objListeners.contains(listener)) {
				this.m_objListeners.add(listener);
			}
		}
	}

	/**
	 * Notify create.
	 *
	 * @param o the o
	 */
	public void notifyCreate(final Object o) {
		synchronized (this.m_objListeners) {
			if (o != null && this.m_objListeners.size() > 0) {
				final String className = o.getClass().getName();
				for (final I_ModelListener listener : this.m_objListeners) {
					listener.notifyCreate(className, o);
				}
			}
		}
	}

	/**
	 * Notify delete.
	 *
	 * @param o the o
	 */
	public void notifyDelete(final Object o) {
		synchronized (this.m_objListeners) {
			if (o != null && this.m_objListeners.size() > 0) {
				final String className = o.getClass().getName();
				for (final I_ModelListener listener : this.m_objListeners) {
					listener.notifyDelete(className, o);
				}
			}
		}
	}

	/**
	 * Notify outdated.
	 *
	 * @param o the o
	 * @param time the time
	 */
	public void notifyOutdated(final List<Object> o, final long time) {
		synchronized (this.m_objListeners) {
			if (o != null && this.m_objListeners.size() > 0) {
				final List lst = o;
				if (lst.size() > 0) {
					final String className = lst.get(0).getClass().getName();
					for (final I_ModelListener listener : this.m_objListeners) {
						listener.notifyOutdated(className, o, time);
					}
				}

			}
		}
	}

	/**
	 * Notify outdated.
	 *
	 * @param o the o
	 * @param time the time
	 */
	public void notifyOutdated(final Object o, final long time) {
		synchronized (this.m_objListeners) {
			if (o != null && this.m_objListeners.size() > 0) {
				final String className = o.getClass().getName();
				for (final I_ModelListener listener : this.m_objListeners) {
					listener.notifyOutdated(className, o, time);
				}
			}
		}
	}

	/**
	 * Notify update.
	 *
	 * @param o the o
	 */
	public void notifyUpdate(final Object o) {
		synchronized (this.m_objListeners) {
			if (o != null && this.m_objListeners.size() > 0) {
				final String className = o.getClass().getName();
				for (final I_ModelListener listener : this.m_objListeners) {
					listener.notifyUpdate(className, o);
				}
			}
		}
	}

}
