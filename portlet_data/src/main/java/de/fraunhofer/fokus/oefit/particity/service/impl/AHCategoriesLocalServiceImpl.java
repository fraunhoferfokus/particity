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
package de.fraunhofer.fokus.oefit.particity.service.impl;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType;
import de.fraunhofer.fokus.oefit.particity.model.AHCategories;
import de.fraunhofer.fokus.oefit.particity.service.base.AHCategoriesLocalServiceBaseImpl;
import de.fraunhofer.fokus.oefit.particity.service.persistence.AHCategoriesFinderUtil;

// TODO: Auto-generated Javadoc
/**
 * The implementation of the a h categories local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link de.fraunhofer.fokus.oefit.particity.service.AHCategoriesLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see de.fraunhofer.fokus.oefit.adhoc.service.base.AHCategoriesLocalServiceBaseImpl
 * @see de.fraunhofer.fokus.oefit.particity.service.AHCategoriesLocalServiceUtil
 */
public class AHCategoriesLocalServiceImpl extends
        AHCategoriesLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link
	 * de.fraunhofer.fokus.oefit.adhoc.service.AHCategoriesLocalServiceUtil} to
	 * access the a h categories local service.
	 */
	private static final Log	m_objLog	= LogFactoryUtil
	                                             .getLog(AHCategoriesLocalServiceImpl.class);

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHCategoriesLocalService#addCategory(java.lang.String, java.lang.String, de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType)
	 */
	@Override
	public AHCategories addCategory(final String name,
	        final String description, int type)
	        throws SystemException {

		m_objLog.debug("addCategory::start("+name+")");
		AHCategories result = this.getCategory(name, type);
		if (result == null) {
			result = this.createAHCategories(CounterLocalServiceUtil
			        .increment(AHCategories.class.getName()));
			result.setName(name);
			result.setType(type);
			result.setDescr(description);
			result = this.updateAHCategories(result);
		}
		m_objLog.debug("addCategory::end("+name+")");

		return result;
	}

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHCategoriesLocalService#deleteCategoryById(long)
	 */
	@Override
	public AHCategories deleteCategoryById(final long catId) {

		AHCategories result = null;
		try {
			result = this.getCategory(catId);

			if (result != null) {
				this.deleteAHCategories(result);
			}
		} catch (final SystemException e) {
			m_objLog.error(e);
		}

		return result;
	}

	/**
	 * Get all root categories.
	 *
	 * @param type the type
	 * @return a list of root categories
	 * @throws SystemException the system exception
	 */
	@Override
	public List<AHCategories> getCategories(int type)
	        throws SystemException {
		return this.getAHCategoriesPersistence().findBytype(type);
	}

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHCategoriesLocalService#getCategoriesByIdStr(java.lang.String)
	 */
	@Override
	public List<AHCategories> getCategoriesByIdStr(final String idStr)
	        throws SystemException {
		List<AHCategories> result = null;

		try {
			result = AHCategoriesFinderUtil.getCategoriesByListStr(idStr);
		} catch (final Throwable t) {
			m_objLog.error(t);
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHCategoriesLocalService#getCategoriesByInverseIdStr(java.lang.String)
	 */
	@Override
	public List<AHCategories> getCategoriesByInverseIdStr(final String idStr)
	        throws SystemException {
		List<AHCategories> result = null;

		try {
			result = AHCategoriesFinderUtil
			        .getCategoriesByInverseListStr(idStr);
		} catch (final Throwable t) {
			m_objLog.error(t);
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHCategoriesLocalService#getCategory(long)
	 */
	@Override
	public AHCategories getCategory(final long catId) throws SystemException {
		AHCategories result = null;

		try {
			result = this.getAHCategoriesPersistence().findByPrimaryKey(catId);
		} catch (final Throwable t) {
			m_objLog.error(t);
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHCategoriesLocalService#getCategory(java.lang.String, de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType)
	 */
	@Override
	public AHCategories getCategory(final String name, int type)
	        throws SystemException {
		AHCategories result = null;

		try {
			final List<AHCategories> list = this.getAHCategoriesPersistence()
			        .findBynameAndType(
			                name, type);
			if (list.size() > 0) {
				result = list.get(0);
			}
		} catch (final Throwable t) {
			m_objLog.error(t);
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHCategoriesLocalService#getCategoryMap(de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType, boolean)
	 */
	@Override
	public Map<Long, String> getCategoryMap(int type,
	        final boolean includeEmpty) throws SystemException {
		final Map<Long, String> result = new TreeMap<Long, String>();
		final List<AHCategories> cats = this.getAHCategoriesPersistence()
		        .findBytype(type);
		if (cats != null) {
			if (includeEmpty) {
				result.put(-1L, "-");
			}
			for (final AHCategories cat : cats) {
				result.put(cat.getCatId(), cat.getName());
			}
		}
		return result;
	}
}
