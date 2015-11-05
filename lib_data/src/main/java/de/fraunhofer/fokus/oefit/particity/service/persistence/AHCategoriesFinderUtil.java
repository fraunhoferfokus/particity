package de.fraunhofer.fokus.oefit.particity.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;


public class AHCategoriesFinderUtil {
    private static AHCategoriesFinder _finder;

    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHCategories> getCategoriesByListStr(
        java.lang.String categoryIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder().getCategoriesByListStr(categoryIds);
    }

    public static java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHCategories> getCategoriesByInverseListStr(
        java.lang.String categoryIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder().getCategoriesByInverseListStr(categoryIds);
    }

    public static AHCategoriesFinder getFinder() {
        if (_finder == null) {
            _finder = (AHCategoriesFinder) PortletBeanLocatorUtil.locate(de.fraunhofer.fokus.oefit.particity.service.ClpSerializer.getServletContextName(),
                    AHCategoriesFinder.class.getName());

            ReferenceRegistry.registerReference(AHCategoriesFinderUtil.class,
                "_finder");
        }

        return _finder;
    }

    public void setFinder(AHCategoriesFinder finder) {
        _finder = finder;

        ReferenceRegistry.registerReference(AHCategoriesFinderUtil.class,
            "_finder");
    }
}
