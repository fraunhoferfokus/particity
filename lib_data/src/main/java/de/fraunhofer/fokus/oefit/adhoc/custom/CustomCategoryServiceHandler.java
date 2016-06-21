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
import java.util.Map;

import javax.inject.Inject;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.fraunhofer.fokus.oefit.adhoc.forms.CategoryForm;
import de.particity.model.I_CategoryEntryModel;
import de.particity.model.I_CategoryModel;
import de.particity.model.boundary.I_CategoryController;
import de.particity.model.boundary.I_CategoryEntryController;

/**
 * Custom utility methods for all tasks regarding categories and category entries
 */
public class CustomCategoryServiceHandler {

	private static final Log	m_objLog	= LogFactoryUtil
	                                             .getLog(CustomCategoryServiceHandler.class);

	@Inject
	public static I_CategoryEntryController catEntryCtrl;
	@Inject 
	public static I_CategoryController catCtrl;
	
	public static I_CategoryEntryModel addCategoryEntry(CategoryForm data) {
		
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
	
	public static I_CategoryEntryModel addCategoryEntry(long catId, String name, String descr, long parentId) {
		return catEntryCtrl.addCategoryEntry(catId, name, descr, parentId);
	}

	
	public static I_CategoryModel addMainCategory(CategoryForm data, E_CategoryType type) {
		return addMainCategory(data.getName(), data.getDescr(), type);
	}
	
	public static I_CategoryModel addMainCategory(String name, String descr, E_CategoryType type) {
		I_CategoryModel result = null;
		try {
			result = catCtrl.addCategory(name,descr, type);
		} catch (Throwable t) {
			m_objLog.error("Error adding category",t);
		}
		return result;
		        
	}

	public static void deleteMainCategory(Long l_catId) {
		catCtrl.delete(l_catId);
	}
	
	public static void deleteCategoryEntry(Long l_itemId) {
		catEntryCtrl.delete(l_itemId);
	}
	
	public static List<I_CategoryModel> getCategoryByType(E_CategoryType type) {
		return catCtrl.getByType(type);
	}
	
	public static List<I_CategoryEntryModel> getCategoryEntriesByCategoryId(long catId) {
		return catEntryCtrl.getByCategory(catId);
	}
	
	public static List<I_CategoryEntryModel> getCategoryEntriesByCategoryIdSorted(long catId) {
		return catEntryCtrl.getByCategorySorted(catId);
	}
	
	public static Map<Long, String> getEntryMapForCategoryId(long catId) {
		return catEntryCtrl.getMapByCategoryId(catId);
	}
	
	public static I_CategoryEntryModel getCategoryEntryById(long catEntryId) {
		return catEntryCtrl.get(catEntryId);
	}
	
	public static List<I_CategoryEntryModel> getChildCategoryEntriesByCategoryEntryId(long parentId) {
		return catEntryCtrl.getChildEntriesById(parentId);
	}
}
