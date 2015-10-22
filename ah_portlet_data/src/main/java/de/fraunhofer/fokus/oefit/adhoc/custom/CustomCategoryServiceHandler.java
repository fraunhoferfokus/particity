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

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.fraunhofer.fokus.oefit.adhoc.forms.CategoryForm;
import de.fraunhofer.fokus.oefit.particity.model.AHCatEntries;
import de.fraunhofer.fokus.oefit.particity.model.AHCategories;
import de.fraunhofer.fokus.oefit.particity.service.AHCatEntriesLocalServiceUtil;
import de.fraunhofer.fokus.oefit.particity.service.AHCategoriesLocalServiceUtil;

/**
 * Custom utility methods for all tasks regarding categories and category entries
 */
public class CustomCategoryServiceHandler {

	private static final Log	m_objLog	= LogFactoryUtil
	                                             .getLog(CustomCategoryServiceHandler.class);

	public static AHCatEntries addCategoryEntry(CategoryForm data) {
		
		Long l_parentId = null;
		Long l_catId = null;
		if (data.getParent() != null && data.getParent().trim().length() > 0) {
			try {
				l_parentId = Long.parseLong(data.getParent());
			} catch (final Throwable t) {
			}
		}
		if (data.getCat() != null && data.getCat().trim().length() > 0) {
			try {
				l_catId = Long.parseLong(data.getCat());
			} catch (final Throwable t) {
			}
		}
		if (l_parentId == null) {
			l_parentId = -1L;
		}
		
		return addCategoryEntry(l_catId, data.getName(), data.getDescr(), l_parentId);
	}
	
	public static AHCatEntries addCategoryEntry(long catId, String name, String descr, long parentId) {
		return AHCatEntriesLocalServiceUtil
		        .addCategoryEntry(catId, name, descr, parentId);
	}

	
	public static AHCategories addMainCategory(CategoryForm data, E_CategoryType type) {
		return addMainCategory(data.getName(), data.getDescr(), type);
	}
	
	public static AHCategories addMainCategory(String name, String descr, E_CategoryType type) {
		AHCategories result = null;
		try {
			result = AHCategoriesLocalServiceUtil.addCategory(name,descr, type);
		} catch (Throwable t) {
			m_objLog.error("Error adding category",t);
		}
		return result;
		        
	}

	public static void deleteMainCategory(Long l_catId) {
		AHCategoriesLocalServiceUtil.deleteCategoryById(l_catId);
	}
	
	public static void deleteCategoryEntry(Long l_itemId) {
		CustomPersistanceServiceHandler.deleteCategoryEntryById(l_itemId);
	}
}
