package de.fraunhofer.fokus.oefit.particity.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import de.fraunhofer.fokus.oefit.particity.model.AHCatEntries;
import de.fraunhofer.fokus.oefit.particity.service.AHCatEntriesLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class AHCatEntriesActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public AHCatEntriesActionableDynamicQuery() throws SystemException {
        setBaseLocalService(AHCatEntriesLocalServiceUtil.getService());
        setClass(AHCatEntries.class);

        setClassLoader(de.fraunhofer.fokus.oefit.particity.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("itemId");
    }
}
