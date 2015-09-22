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


public class AHCatEntriesFinderUtil {
    private static AHCatEntriesFinder _finder;

    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription> getSubscriptionMailsByCategoryitems(
        de.fraunhofer.fokus.oefit.adhoc.custom.E_SubscriptionStatus status,
        java.lang.String categoryItems)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder()
                   .getSubscriptionMailsByCategoryitems(status, categoryItems);
    }

    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription> getUsersBySubscriptions()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder().getUsersBySubscriptions();
    }

    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription> getSubscriptionsByCategoryitems(
        de.fraunhofer.fokus.oefit.adhoc.custom.E_SubscriptionStatus status,
        java.lang.String[] categoryItems, int from, int to)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder()
                   .getSubscriptionsByCategoryitems(status, categoryItems,
            from, to);
    }

    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHSubscription> getSubscriptionMailsByCategoryitems(
        de.fraunhofer.fokus.oefit.adhoc.custom.E_SubscriptionStatus status,
        java.lang.Long[] categories)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder()
                   .getSubscriptionMailsByCategoryitems(status, categories);
    }

    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> getCategoriesByOffer(
        long offerId, de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType type)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder().getCategoriesByOffer(offerId, type);
    }

    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries> getCategoriesBySubscription(
        long subId) throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder().getCategoriesBySubscription(subId);
    }

    public static AHCatEntriesFinder getFinder() {
        if (_finder == null) {
            _finder = (AHCatEntriesFinder) PortletBeanLocatorUtil.locate(de.fraunhofer.fokus.oefit.adhoc.service.ClpSerializer.getServletContextName(),
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
