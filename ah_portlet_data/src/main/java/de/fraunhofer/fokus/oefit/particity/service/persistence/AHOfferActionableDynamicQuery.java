package de.fraunhofer.fokus.oefit.particity.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import de.fraunhofer.fokus.oefit.particity.model.AHOffer;
import de.fraunhofer.fokus.oefit.particity.service.AHOfferLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class AHOfferActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public AHOfferActionableDynamicQuery() throws SystemException {
        setBaseLocalService(AHOfferLocalServiceUtil.getService());
        setClass(AHOffer.class);

        setClassLoader(de.fraunhofer.fokus.oefit.particity.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("offerId");
    }
}
