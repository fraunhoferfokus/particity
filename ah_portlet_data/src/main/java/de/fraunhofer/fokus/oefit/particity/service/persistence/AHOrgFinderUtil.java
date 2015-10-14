package de.fraunhofer.fokus.oefit.particity.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;


public class AHOrgFinderUtil {
    private static AHOrgFinder _finder;

    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOrg> getOrganisationsByUserlistEntry(
        java.lang.String userMailAddr)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder().getOrganisationsByUserlistEntry(userMailAddr);
    }

    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHOrg> getOrganisationsWithCustomOrder(
        java.lang.String column,
        de.fraunhofer.fokus.oefit.adhoc.custom.E_OrderType order, int from,
        int to) throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder()
                   .getOrganisationsWithCustomOrder(column, order, from, to);
    }

    public static AHOrgFinder getFinder() {
        if (_finder == null) {
            _finder = (AHOrgFinder) PortletBeanLocatorUtil.locate(de.fraunhofer.fokus.oefit.particity.service.ClpSerializer.getServletContextName(),
                    AHOrgFinder.class.getName());

            ReferenceRegistry.registerReference(AHOrgFinderUtil.class, "_finder");
        }

        return _finder;
    }

    public void setFinder(AHOrgFinder finder) {
        _finder = finder;

        ReferenceRegistry.registerReference(AHOrgFinderUtil.class, "_finder");
    }
}
