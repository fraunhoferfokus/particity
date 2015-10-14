package de.fraunhofer.fokus.oefit.particity.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import de.fraunhofer.fokus.oefit.particity.model.AHContact;
import de.fraunhofer.fokus.oefit.particity.service.AHContactLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class AHContactActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public AHContactActionableDynamicQuery() throws SystemException {
        setBaseLocalService(AHContactLocalServiceUtil.getService());
        setClass(AHContact.class);

        setClassLoader(de.fraunhofer.fokus.oefit.particity.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("contactId");
    }
}
