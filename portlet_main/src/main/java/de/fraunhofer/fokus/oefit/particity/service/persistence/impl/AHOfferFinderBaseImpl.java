/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package de.fraunhofer.fokus.oefit.particity.service.persistence.impl;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

import de.fraunhofer.fokus.oefit.particity.model.AHOffer;
import de.fraunhofer.fokus.oefit.particity.service.persistence.AHOfferPersistence;

import java.util.Set;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AHOfferFinderBaseImpl extends BasePersistenceImpl<AHOffer> {
	@Override
	public Set<String> getBadColumnNames() {
		return getAHOfferPersistence().getBadColumnNames();
	}

	/**
	 * Returns the a h offer persistence.
	 *
	 * @return the a h offer persistence
	 */
	public AHOfferPersistence getAHOfferPersistence() {
		return ahOfferPersistence;
	}

	/**
	 * Sets the a h offer persistence.
	 *
	 * @param ahOfferPersistence the a h offer persistence
	 */
	public void setAHOfferPersistence(AHOfferPersistence ahOfferPersistence) {
		this.ahOfferPersistence = ahOfferPersistence;
	}

	@BeanReference(type = AHOfferPersistence.class)
	protected AHOfferPersistence ahOfferPersistence;
}