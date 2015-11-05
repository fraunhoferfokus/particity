package de.fraunhofer.fokus.oefit.particity.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import de.fraunhofer.fokus.oefit.particity.model.AHAddr;
import de.fraunhofer.fokus.oefit.particity.service.AHAddrLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class AHAddrActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public AHAddrActionableDynamicQuery() throws SystemException {
        setBaseLocalService(AHAddrLocalServiceUtil.getService());
        setClass(AHAddr.class);

        setClassLoader(de.fraunhofer.fokus.oefit.particity.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("addrId");
    }
}
