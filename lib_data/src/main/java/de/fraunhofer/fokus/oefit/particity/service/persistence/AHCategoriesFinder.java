package de.fraunhofer.fokus.oefit.particity.service.persistence;

public interface AHCategoriesFinder {
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHCategories> getCategoriesByListStr(
        java.lang.String categoryIds)
        throws com.liferay.portal.kernel.exception.SystemException;

    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHCategories> getCategoriesByInverseListStr(
        java.lang.String categoryIds)
        throws com.liferay.portal.kernel.exception.SystemException;
}
