package de.fraunhofer.fokus.oefit.particity.service.persistence;

public interface AHCatEntriesFinder {
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription> getSubscriptionMailsByCategoryitems(
        de.fraunhofer.fokus.oefit.adhoc.custom.E_SubscriptionStatus status,
        java.lang.String categoryItems)
        throws com.liferay.portal.kernel.exception.SystemException;

    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription> getUsersBySubscriptions()
        throws com.liferay.portal.kernel.exception.SystemException;

    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription> getSubscriptionsByCategoryitems(
        de.fraunhofer.fokus.oefit.adhoc.custom.E_SubscriptionStatus status,
        java.lang.String[] categoryItems, int from, int to)
        throws com.liferay.portal.kernel.exception.SystemException;

    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription> getSubscriptionMailsByCategoryitems(
        de.fraunhofer.fokus.oefit.adhoc.custom.E_SubscriptionStatus status,
        java.lang.Long[] categories)
        throws com.liferay.portal.kernel.exception.SystemException;

    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHCatEntries> getCategoriesByOffer(
        long offerId, de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType type)
        throws com.liferay.portal.kernel.exception.SystemException;

    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHCatEntries> getCategoriesBySubscription(
        long subId) throws com.liferay.portal.kernel.exception.SystemException;
}
