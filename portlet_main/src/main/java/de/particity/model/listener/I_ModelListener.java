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

import java.util.List;

import de.particity.model.impl.Offer;
import de.particity.model.impl.Organization;
import de.particity.model.impl.Subscription;

/**
 * The listener interface for receiving any model events.
 * The class that is interested in processing model
 * events implements this interface. When a model event occurs, 
 * that object's appropriate method is invoked.
 *
 */
public interface I_ModelListener {

	/** Static classname of AHOffer implementation . */
	public static final String	OFFER_CLASS	 = Offer.class.getName();
	
	/** Static classname of AHOrg implementation . */
	public static final String	ORG_CLASS	 = Organization.class.getName();
	
	/** Static classname of AHSubscription implementation . */
	public static final String	SUBSCR_CLASS	= Subscription.class
	                                                 .getName();

	/**
	 * Called when a new object is created
	 *
	 * @param className the class name
	 * @param clazz the clazz
	 */
	public void notifyCreate(String className, Object clazz);

	/**
	 * Called when an existing object is deleted
	 *
	 * @param className the class name
	 * @param clazz the clazz
	 */
	public void notifyDelete(String className, Object clazz);

	/**
	 * Called when several existing objects are outdated (according to portlet logic)
	 *
	 * @param className the class name
	 * @param clazz the clazz
	 * @param time the time
	 */
	public void notifyOutdated(String className, List<Object> clazz, long time);

	/**
	 * Called when an existing object is outdated (according to portlet logic)
	 *
	 * @param className the class name
	 * @param clazz the clazz
	 * @param time the time
	 */
	public void notifyOutdated(String className, Object clazz, long time);

	/**
	 * Called when an existing object is updated
	 *
	 * @param className the class name
	 * @param clazz the clazz
	 */
	public void notifyUpdate(String className, Object clazz);

}
