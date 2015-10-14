package de.fraunhofer.fokus.oefit.particity.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import de.fraunhofer.fokus.oefit.particity.model.AHCategories;
import de.fraunhofer.fokus.oefit.particity.service.AHCategoriesLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class AHCategoriesActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public AHCategoriesActionableDynamicQuery() throws SystemException {
        setBaseLocalService(AHCategoriesLocalServiceUtil.getService());
        setClass(AHCategories.class);

        setClassLoader(de.fraunhofer.fokus.oefit.particity.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("catId");
    }
}
