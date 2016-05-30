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

import de.fraunhofer.fokus.oefit.particity.model.AHCategories;
import de.fraunhofer.fokus.oefit.particity.service.persistence.AHCategoriesPersistence;

import java.util.Set;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AHCategoriesFinderBaseImpl extends BasePersistenceImpl<AHCategories> {
	@Override
	public Set<String> getBadColumnNames() {
		return getAHCategoriesPersistence().getBadColumnNames();
	}

	/**
	 * Returns the a h categories persistence.
	 *
	 * @return the a h categories persistence
	 */
	public AHCategoriesPersistence getAHCategoriesPersistence() {
		return ahCategoriesPersistence;
	}

	/**
	 * Sets the a h categories persistence.
	 *
	 * @param ahCategoriesPersistence the a h categories persistence
	 */
	public void setAHCategoriesPersistence(
		AHCategoriesPersistence ahCategoriesPersistence) {
		this.ahCategoriesPersistence = ahCategoriesPersistence;
	}

	@BeanReference(type = AHCategoriesPersistence.class)
	protected AHCategoriesPersistence ahCategoriesPersistence;
}