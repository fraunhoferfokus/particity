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

import de.fraunhofer.fokus.oefit.particity.model.AHCatEntries;
import de.fraunhofer.fokus.oefit.particity.service.persistence.AHCatEntriesPersistence;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AHCatEntriesFinderBaseImpl extends BasePersistenceImpl<AHCatEntries> {
	/**
	 * Returns the a h cat entries persistence.
	 *
	 * @return the a h cat entries persistence
	 */
	public AHCatEntriesPersistence getAHCatEntriesPersistence() {
		return ahCatEntriesPersistence;
	}

	/**
	 * Sets the a h cat entries persistence.
	 *
	 * @param ahCatEntriesPersistence the a h cat entries persistence
	 */
	public void setAHCatEntriesPersistence(
		AHCatEntriesPersistence ahCatEntriesPersistence) {
		this.ahCatEntriesPersistence = ahCatEntriesPersistence;
	}

	@BeanReference(type = AHCatEntriesPersistence.class)
	protected AHCatEntriesPersistence ahCatEntriesPersistence;
}