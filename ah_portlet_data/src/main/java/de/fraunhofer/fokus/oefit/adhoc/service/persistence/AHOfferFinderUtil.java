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


public class AHOfferFinderUtil {
    private static AHOfferFinder _finder;

    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> getOffersWithCustomOrder(
        java.lang.String column,
        de.fraunhofer.fokus.oefit.adhoc.custom.E_OrderType order, int from,
        int to) throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder().getOffersWithCustomOrder(column, order, from, to);
    }

    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> getOffersByOrgWithCustomOrder(
        long orgId, java.lang.String column,
        de.fraunhofer.fokus.oefit.adhoc.custom.E_OrderType order, int from,
        int to) throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder()
                   .getOffersByOrgWithCustomOrder(orgId, column, order, from, to);
    }

    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> getNewlyPublishedOffers(
        long publishStartTime)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder().getNewlyPublishedOffers(publishStartTime);
    }

    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> getExpiredOffersByOrg(
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

    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> getOfferByCategoryitems(
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

    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> getOfferByTypesAndItemsAndOrg(
        de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferStatus status,
        java.lang.String types, java.lang.String categories, long orgId,
        int from, int to)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder()
                   .getOfferByTypesAndItemsAndOrg(status, types, categories,
            orgId, from, to);
    }

    public static java.lang.Integer countOfferByTypesAndItemsAndOrg(
        de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferStatus status,
        java.lang.String types, java.lang.String categories, long orgId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder()
                   .countOfferByTypesAndItemsAndOrg(status, types, categories,
            orgId);
    }

    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> getOfferByOfferTypes(
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

    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> getOfferByCategories(
        de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferStatus status,
        java.lang.String categories, int from, int to)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder().getOfferByCategories(status, categories, from, to);
    }

    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> getOfferByCategories(
        de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferStatus status,
        java.lang.String[] categories, int from, int to)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder().getOfferByCategories(status, categories, from, to);
    }

    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> getOfferByCategories(
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

    public static java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHOffer> getOfferByOfferTypes(
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
            _finder = (AHOfferFinder) PortletBeanLocatorUtil.locate(de.fraunhofer.fokus.oefit.adhoc.service.ClpSerializer.getServletContextName(),
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
