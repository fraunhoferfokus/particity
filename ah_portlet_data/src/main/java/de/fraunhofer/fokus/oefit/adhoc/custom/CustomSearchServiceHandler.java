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
package de.fraunhofer.fokus.oefit.adhoc.custom;

import java.util.List;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.fraunhofer.fokus.oefit.particity.model.AHOffer;
import de.fraunhofer.fokus.oefit.particity.service.AHOfferLocalServiceUtil;

/**
 * Custom utility methods that handle search requests
 */
public class CustomSearchServiceHandler {

	private static final Log	m_objLog	= LogFactoryUtil
	                                             .getLog(CustomSearchServiceHandler.class);

	/*
	 * public static Integer countSearch(SearchForm data) { Integer result = new
	 * Integer(0); if (data.getOrgId() != null) { result =
	 * AHOfferLocalServiceUtil
	 * .countPublishedOffers(Long.parseLong(data.getOrgId())); } else if
	 * (data.getCategories() != null && data.getCategories().length > 0) {
	 * result =
	 * AHOfferLocalServiceUtil.countOfferByCategoryItems(data.getCategories());
	 * } else if (data.getTypes() != null && data.getTypes().length > 0) {
	 * E_OfferType[] types = new E_OfferType[data.getTypes().length]; for (int
	 * i=0; i<data.getTypes().length;i++) types[i] =
	 * E_OfferType.valueOf(data.getTypes()[i]); result =
	 * countByOfferTypes(types); } else if (data.getRootCategoriesStr() != null
	 * && data.getRootCategoriesStr().trim().length() > 0) { result =
	 * countByCategoriyId(strToLongArr(data.getRootCategoriesStr())); } else {
	 * result = countAllPublished(); } return result; } public static
	 * List<AHOffer> search(SearchForm data,int from, int to) { List <AHOffer>
	 * result = new LinkedList<AHOffer>(); List<AHOffer> offers = null; if
	 * (data.getOrgId() != null) { result =
	 * AHOfferLocalServiceUtil.getPublishedOffers(from, to,
	 * Long.parseLong(data.getOrgId())); } else if (data.getCategories() != null
	 * && data.getCategories().length > 0) { offers =
	 * AHOfferLocalServiceUtil.getOfferByCategoryItems
	 * (data.getCategories(),from,to); if (offers != null)
	 * result.addAll(offers); } else if (data.getTypes() != null &&
	 * data.getTypes().length > 0) { E_OfferType[] types = new
	 * E_OfferType[data.getTypes().length]; for (int i=0;
	 * i<data.getTypes().length;i++) types[i] =
	 * E_OfferType.valueOf(data.getTypes()[i]); offers =
	 * searchByOfferTypes(types,from,to); if (offers != null)
	 * result.addAll(offers); } else if (data.getRootCategoriesStr() != null &&
	 * data.getRootCategoriesStr().trim().length() > 0) { result =
	 * searchByCategoriyId(strToLongArr(data.getRootCategoriesStr()), from, to);
	 * } else { result = searchAllPublished(from, to); } return result; }
	 */

	/**
	 * Count all published offers for all organisations
	 *
	 * @return the number of published offers
	 */
	public static Integer countAllPublished() {
		return countAllPublished(-1L);
	}

	/**
	 * Count all published offers for a given organisations
	 *
	 * @param orgId the organisation ID
	 * @return the number of published offers for the given organisation
	 */
	public static Integer countAllPublished(final long orgId) {
		return AHOfferLocalServiceUtil.countPublishedOffers(orgId);
	}

	/**
	 * Count all published offers that match a list of categories
	 *
	 * @param catId a list of categoriy IDs
	 * @return the number of published offers for the specified categories
	 */
	public static int countByCategoriyId(final Long[] catId) {
		return AHOfferLocalServiceUtil.countOfferByCategoryId(catId);
	}

	/**
	 * Count all published offers that match a list of item IDs (subcategories)
	 *
	 * @param itemIds a list of item IDs
	 * @return the number of published offers for the specified item IDs
	 */
	public static int countByItemId(final String[] itemIds) {
		return AHOfferLocalServiceUtil.countOfferByCategoryItems(itemIds);
	}

	/**
	 * Count all published offers that match a list of E_OfferType
	 *
	 * @param types a list of types (E_OfferType)
	 * @return the number of published offers for the given type array
	 */
	public static Integer countByOfferTypes(final E_OfferType[] types) {
		final int[] itypes = new int[types.length];
		for (int i = 0; i < types.length; i++) {
			itypes[i] = types[i].getIntValue();
		}
		return AHOfferLocalServiceUtil.countOfferByOfferTypes(itypes);
	}

	/**
	 * Count all published offers that match a list of types, items and a specified organisation ID
	 *
	 * @param types a list of E_OfferType as comma-separated string (or <code>null</code>)
	 * @param items a list of items as comma-separated string (or <code>null</code>)
	 * @param orgId an organisation ID (or <code>-1</code>)
	 * @return the number of published offers for the given parameters
	 */
	public static Integer countByTypesAndItemsAndOrg(final String types,
	        final String items, final long orgId, Float lat, Float lon, Integer dist) {
		return AHOfferLocalServiceUtil.countOfferByTypesAndCItemsAndOrg(items,
		        types, orgId, lat, lon, dist);
	}

	/**
	 * Search all published offers for the given indices
	 *
	 * @param from start index
	 * @param to end index
	 * @return a list of published offers with size() <= to-from
	 */
	public static List<AHOffer> searchAllPublished(final int from, final int to) {
		return searchAllPublished(from, to, -1L);
	}

	/**
	 * Search all published offers for the given indices and organisation ID
	 *
	 * @param from start index
	 * @param to end index
	 * @param orgId the organisation ID
	 * @return a list of published offers with size() <= to-from for the given organisation
	 */
	public static List<AHOffer> searchAllPublished(final int from,
	        final int to, final long orgId) {
		return AHOfferLocalServiceUtil.getPublishedOffers(from, to, orgId);
	}

	/**
	 * Search all published offers for the given indices and category IDs
	 *
	 * @param catId a list of category IDs
	 * @param from start index
	 * @param to end index
	 * @return a list of published offers with size() <= to-from for the given category IDs
	 */
	public static List<AHOffer> searchByCategoriyId(final Long[] catId,
	        final int from, final int to) {
		return AHOfferLocalServiceUtil.getOfferByCategoryId(catId, from, to);
	}

	/**
	 * Search all published offers for the given indices and item IDs
	 *
	 * @param itemIds a list of item IDs as strings
	 * @param from start index
	 * @param to end index
	 * @return a list of published offers with size() <= to-from for the specified item IDs
	 */
	public static List<AHOffer> searchByItemId(final String[] itemIds,
	        final int from, final int to) {
		return AHOfferLocalServiceUtil.getOfferByCategoryItems(itemIds, from,
		        to);
	}

	/**
	 * Search all published offers for the given indices and offer types
	 *
	 * @param types an array of types to search for
	 * @param from start index
	 * @param to end index
	 * @return a list of published offers with site() <= to-from for the given types
	 */
	public static List<AHOffer> searchByOfferTypes(final E_OfferType[] types,
	        final int from, final int to) {
		final int[] itypes = new int[types.length];
		for (int i = 0; i < types.length; i++) {
			itypes[i] = types[i].getIntValue();
		}
		return AHOfferLocalServiceUtil.getOfferByOfferTypes(itypes, from, to);
	}

	/**
	 * Search all published offers for the given indices, a list of types, a list of items and the given organisation ID
	 *
	 * @param types string representation of a list of E_OfferType separated by comma, or <code>null</code> if not required
	 * @param items string representation of a list of item IDs separated by comma, or <code>null</code> if not required
	 * @param orgId an organisation ID or -1, if not required
	 * @param from start index
	 * @param to end index
	 * @return a list of published offers with site() <= to-from for the given parameters
	 */
	public static List<AHOffer> searchByTypesAndItemsAndOrg(final String types,
	        final String items, final long orgId, final int from, final int to, Float lat, Float lon, Integer dist) {
		return AHOfferLocalServiceUtil.getOfferByTypesAndCItemsAndOrg(items,
		        types, orgId, from, to, lat, lon, dist);
	}
	
	public static List<AHOffer> getLatestPublishedOffers(int size) {
		return AHOfferLocalServiceUtil.getPublishedOffers(0, size, -1);
	}

	/**
	 * Converts a comma-separated string-representation of a list of numbers to an array
	 *
	 * @param str comma-separated list of <code>Long</code>
	 * @return the parsed array, may contain <code>null</code> values, where parsing failed
	 */
	public static Long[] strToLongArr(final String str) {
		Long[] result = null;
		if (str != null) {
			final String split[] = str.replaceAll("\"", "").split(",");
			if (split != null && split.length > 0) {
				result = new Long[split.length];
				for (int i = 0; i < split.length; i++) {
					try {
						result[i] = Long.parseLong(split[i]);
					} catch (final Throwable t) {
					}
				}
			}

		}
		return result;
	}
}
