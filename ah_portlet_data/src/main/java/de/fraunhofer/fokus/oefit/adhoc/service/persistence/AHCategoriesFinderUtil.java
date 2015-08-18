/*
 * Copyright (c) 2015, Fraunhofer FOKUS
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * 
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 * 
 * * Neither the name of particity nor the names of its
 *   contributors may be used to endorse or promote products derived from
 *   this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 
 * 
 * 
 * @author sma
 */
package de.fraunhofer.fokus.oefit.adhoc.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;


public class AHCategoriesFinderUtil {
    private static AHCategoriesFinder _finder;

    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCategories> getCategoriesByListStr(
        java.lang.String categoryIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder().getCategoriesByListStr(categoryIds);
    }

    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCategories> getCategoriesByInverseListStr(
        java.lang.String categoryIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder().getCategoriesByInverseListStr(categoryIds);
    }

    public static AHCategoriesFinder getFinder() {
        if (_finder == null) {
            _finder = (AHCategoriesFinder) PortletBeanLocatorUtil.locate(de.fraunhofer.fokus.oefit.adhoc.service.ClpSerializer.getServletContextName(),
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
