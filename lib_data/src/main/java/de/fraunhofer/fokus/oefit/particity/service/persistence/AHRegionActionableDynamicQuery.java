package de.fraunhofer.fokus.oefit.particity.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import de.fraunhofer.fokus.oefit.particity.model.AHRegion;
import de.fraunhofer.fokus.oefit.particity.service.AHRegionLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class AHRegionActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public AHRegionActionableDynamicQuery() throws SystemException {
        setBaseLocalService(AHRegionLocalServiceUtil.getService());
        setClass(AHRegion.class);

        setClassLoader(de.fraunhofer.fokus.oefit.particity.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("primaryKey.regionId");
    }
}
