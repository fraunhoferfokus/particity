package de.fraunhofer.fokus.oefit.particity.service.persistence;

public interface AHOrgFinder {
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOrg> getOrganisationsByUserlistEntry(
        java.lang.String userMailAddr)
        throws com.liferay.portal.kernel.exception.SystemException;

    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOrg> getOrganisationsWithCustomOrder(
        java.lang.String column, java.lang.String order, int from, int to)
        throws com.liferay.portal.kernel.exception.SystemException;
}
