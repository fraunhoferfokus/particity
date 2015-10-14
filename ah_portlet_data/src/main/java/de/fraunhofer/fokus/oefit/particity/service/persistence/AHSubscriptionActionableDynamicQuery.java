package de.fraunhofer.fokus.oefit.particity.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import de.fraunhofer.fokus.oefit.particity.model.AHSubscription;
import de.fraunhofer.fokus.oefit.particity.service.AHSubscriptionLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class AHSubscriptionActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public AHSubscriptionActionableDynamicQuery() throws SystemException {
        setBaseLocalService(AHSubscriptionLocalServiceUtil.getService());
        setClass(AHSubscription.class);

        setClassLoader(de.fraunhofer.fokus.oefit.particity.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("subId");
    }
}
