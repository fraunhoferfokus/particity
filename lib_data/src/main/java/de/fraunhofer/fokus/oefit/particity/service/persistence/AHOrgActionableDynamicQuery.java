package de.fraunhofer.fokus.oefit.particity.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import de.fraunhofer.fokus.oefit.particity.model.AHOrg;
import de.fraunhofer.fokus.oefit.particity.service.AHOrgLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class AHOrgActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public AHOrgActionableDynamicQuery() throws SystemException {
        setBaseLocalService(AHOrgLocalServiceUtil.getService());
        setClass(AHOrg.class);

        setClassLoader(de.fraunhofer.fokus.oefit.particity.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("orgId");
    }
}
