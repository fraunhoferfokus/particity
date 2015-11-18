package de.fraunhofer.fokus.oefit.particity.service.persistence;

public interface AHOfferFinder {
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getOffersByDistance(
        long lon, long lat, int distInKm, int from, int to)
        throws com.liferay.portal.kernel.exception.SystemException;

    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getOffersWithCustomOrder(
        java.lang.String column, java.lang.String order, int from, int to)
        throws com.liferay.portal.kernel.exception.SystemException;

    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getOffersByOrgWithCustomOrder(
        long orgId, java.lang.String column, java.lang.String order, int from,
        int to) throws com.liferay.portal.kernel.exception.SystemException;

    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getNewlyPublishedOffers(
        long publishStartTime)
        throws com.liferay.portal.kernel.exception.SystemException;

    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getExpiredOffersByOrg(
        long orgId, long starTime, long endTime)
        throws com.liferay.portal.kernel.exception.SystemException;

    public java.lang.Integer countOfferByCategoryitems(int status,
        java.lang.String[] categoryItems)
        throws com.liferay.portal.kernel.exception.SystemException;

    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getOfferByCategoryitems(
        int status, java.lang.String[] categoryItems, int from, int to)
        throws com.liferay.portal.kernel.exception.SystemException;

    public java.lang.Integer countOfferByOfferTypes(int status,
        java.lang.String types)
        throws com.liferay.portal.kernel.exception.SystemException;

    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getOfferByTypesAndItemsAndOrg(
        int status, java.lang.String types, java.lang.String categories,
        long orgId, int from, int to, java.lang.Float lat, java.lang.Float lon,
        java.lang.Integer dist)
        throws com.liferay.portal.kernel.exception.SystemException;

    public java.lang.Integer countOfferByTypesAndItemsAndOrg(int status,
        java.lang.String types, java.lang.String categories, long orgId,
        java.lang.Float lat, java.lang.Float lon, java.lang.Integer dist)
        throws com.liferay.portal.kernel.exception.SystemException;

    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getOfferByOfferTypes(
        int status, java.lang.String types, int from, int to)
        throws com.liferay.portal.kernel.exception.SystemException;

    public java.lang.Integer countOfferByCategories(int status,
        java.lang.String categories)
        throws com.liferay.portal.kernel.exception.SystemException;

    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getOfferByCategories(
        int status, java.lang.String categories, int from, int to)
        throws com.liferay.portal.kernel.exception.SystemException;

    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getOfferByCategories(
        int status, java.lang.String[] categories, int from, int to)
        throws com.liferay.portal.kernel.exception.SystemException;

    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getOfferByCategories(
        int status, java.lang.Long[] categories, int from, int to)
        throws com.liferay.portal.kernel.exception.SystemException;

    public java.lang.Integer countOfferByCategories(int status,
        java.lang.Long[] categories)
        throws com.liferay.portal.kernel.exception.SystemException;

    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOffer> getOfferByOfferTypes(
        int status, int[] types, int from, int to)
        throws com.liferay.portal.kernel.exception.SystemException;

    public java.lang.Integer countOfferByOfferTypes(int status, int[] types)
        throws com.liferay.portal.kernel.exception.SystemException;
}
