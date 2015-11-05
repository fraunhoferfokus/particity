package de.fraunhofer.fokus.oefit.particity.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;


public class AHOfferFinderUtil {
    private static AHOfferFinder _finder;

    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getOffersByDistance(
        long lon, long lat, int distInKm, int from, int to)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder().getOffersByDistance(lon, lat, distInKm, from, to);
    }

    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getOffersWithCustomOrder(
        java.lang.String column,
        de.fraunhofer.fokus.oefit.adhoc.custom.E_OrderType order, int from,
        int to) throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder().getOffersWithCustomOrder(column, order, from, to);
    }

    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getOffersByOrgWithCustomOrder(
        long orgId, java.lang.String column,
        de.fraunhofer.fokus.oefit.adhoc.custom.E_OrderType order, int from,
        int to) throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder()
                   .getOffersByOrgWithCustomOrder(orgId, column, order, from, to);
    }

    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getNewlyPublishedOffers(
        long publishStartTime)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder().getNewlyPublishedOffers(publishStartTime);
    }

    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getExpiredOffersByOrg(
        long orgId, long starTime, long endTime)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder().getExpiredOffersByOrg(orgId, starTime, endTime);
    }

    public static java.lang.Integer countOfferByCategoryitems(
        de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferStatus status,
        java.lang.String[] categoryItems)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder().countOfferByCategoryitems(status, categoryItems);
    }

    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getOfferByCategoryitems(
        de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferStatus status,
        java.lang.String[] categoryItems, int from, int to)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder()
                   .getOfferByCategoryitems(status, categoryItems, from, to);
    }

    public static java.lang.Integer countOfferByOfferTypes(
        de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferStatus status,
        java.lang.String types)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder().countOfferByOfferTypes(status, types);
    }

    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getOfferByTypesAndItemsAndOrg(
        de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferStatus status,
        java.lang.String types, java.lang.String categories, long orgId,
        int from, int to, java.lang.Float lat, java.lang.Float lon,
        java.lang.Integer dist)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder()
                   .getOfferByTypesAndItemsAndOrg(status, types, categories,
            orgId, from, to, lat, lon, dist);
    }

    public static java.lang.Integer countOfferByTypesAndItemsAndOrg(
        de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferStatus status,
        java.lang.String types, java.lang.String categories, long orgId,
        java.lang.Float lat, java.lang.Float lon, java.lang.Integer dist)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder()
                   .countOfferByTypesAndItemsAndOrg(status, types, categories,
            orgId, lat, lon, dist);
    }

    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getOfferByOfferTypes(
        de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferStatus status,
        java.lang.String types, int from, int to)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder().getOfferByOfferTypes(status, types, from, to);
    }

    public static java.lang.Integer countOfferByCategories(
        de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferStatus status,
        java.lang.String categories)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder().countOfferByCategories(status, categories);
    }

    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getOfferByCategories(
        de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferStatus status,
        java.lang.String categories, int from, int to)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder().getOfferByCategories(status, categories, from, to);
    }

    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getOfferByCategories(
        de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferStatus status,
        java.lang.String[] categories, int from, int to)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder().getOfferByCategories(status, categories, from, to);
    }

    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getOfferByCategories(
        de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferStatus status,
        java.lang.Long[] categories, int from, int to)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder().getOfferByCategories(status, categories, from, to);
    }

    public static java.lang.Integer countOfferByCategories(
        de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferStatus status,
        java.lang.Long[] categories)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder().countOfferByCategories(status, categories);
    }

    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getOfferByOfferTypes(
        de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferStatus status,
        int[] types, int from, int to)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder().getOfferByOfferTypes(status, types, from, to);
    }

    public static java.lang.Integer countOfferByOfferTypes(
        de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferStatus status, int[] types)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder().countOfferByOfferTypes(status, types);
    }

    public static AHOfferFinder getFinder() {
        if (_finder == null) {
            _finder = (AHOfferFinder) PortletBeanLocatorUtil.locate(de.fraunhofer.fokus.oefit.particity.service.ClpSerializer.getServletContextName(),
                    AHOfferFinder.class.getName());

            ReferenceRegistry.registerReference(AHOfferFinderUtil.class,
                "_finder");
        }

        return _finder;
    }

    public void setFinder(AHOfferFinder finder) {
        _finder = finder;

        ReferenceRegistry.registerReference(AHOfferFinderUtil.class, "_finder");
    }
}
