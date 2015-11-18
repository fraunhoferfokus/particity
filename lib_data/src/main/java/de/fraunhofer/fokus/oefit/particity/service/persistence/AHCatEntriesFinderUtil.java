package de.fraunhofer.fokus.oefit.particity.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;


public class AHCatEntriesFinderUtil {
    private static AHCatEntriesFinder _finder;

    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription> getSubscriptionMailsByCategoryitems(
        int status, java.lang.String categoryItems)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder()
                   .getSubscriptionMailsByCategoryitems(status, categoryItems);
    }

    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription> getUsersBySubscriptions()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder().getUsersBySubscriptions();
    }

    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription> getSubscriptionsByCategoryitems(
        int status, java.lang.String[] categoryItems, int from, int to)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder()
                   .getSubscriptionsByCategoryitems(status, categoryItems,
            from, to);
    }

    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription> getSubscriptionMailsByCategoryitems(
        int status, java.lang.Long[] categories)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder()
                   .getSubscriptionMailsByCategoryitems(status, categories);
    }

    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHCatEntries> getCategoriesByOffer(
        long offerId, java.lang.Integer type)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder().getCategoriesByOffer(offerId, type);
    }

    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHCatEntries> getCategoriesBySubscription(
        long subId) throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder().getCategoriesBySubscription(subId);
    }

    public static AHCatEntriesFinder getFinder() {
        if (_finder == null) {
            _finder = (AHCatEntriesFinder) PortletBeanLocatorUtil.locate(de.fraunhofer.fokus.oefit.particity.service.ClpSerializer.getServletContextName(),
                    AHCatEntriesFinder.class.getName());

            ReferenceRegistry.registerReference(AHCatEntriesFinderUtil.class,
                "_finder");
        }

        return _finder;
    }

    public void setFinder(AHCatEntriesFinder finder) {
        _finder = finder;

        ReferenceRegistry.registerReference(AHCatEntriesFinderUtil.class,
            "_finder");
    }
}
