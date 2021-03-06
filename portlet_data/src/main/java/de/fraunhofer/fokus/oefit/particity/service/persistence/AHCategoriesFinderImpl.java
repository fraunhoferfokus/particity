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
package de.fraunhofer.fokus.oefit.particity.service.persistence;

import java.util.List;

import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import de.fraunhofer.fokus.oefit.particity.model.AHCategories;
import de.fraunhofer.fokus.oefit.particity.model.impl.AHCategoriesImpl;

public class AHCategoriesFinderImpl extends BasePersistenceImpl<AHCategories>
	implements AHCategoriesFinder	 {
	
	private static final Log m_objLog = LogFactoryUtil
			.getLog(AHCategoriesFinderImpl.class);

		
	public static String getCategoriesByIdList = "select entry.* from AHCATS entry "
			+ "WHERE entry.catId IN ([$ITEM_IDS$])";
	public static String getInverseCategoriesByIdList = "select entry.* from AHCATS entry "
			+ "WHERE entry.catId NOT IN ([$ITEM_IDS$])";
	
	
	@Override
	public List<AHCategories> getCategoriesByListStr(String categoryIds)
			throws SystemException {
		List<AHCategories> result = null;

		Session session = null;

		try {
			session = openSession();

			String sql = StringUtil.replace(getCategoriesByIdList, "[$ITEM_IDS$]", categoryIds);

			SQLQuery query = session.createSQLQuery(sql);

			query.addEntity("AHCategories", AHCategoriesImpl.class);
			

			result = (List<AHCategories>) query.list();

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
		return result;
	}
	
	@Override
	public List<AHCategories> getCategoriesByInverseListStr(String categoryIds)
			throws SystemException {
		List<AHCategories> result = null;

		Session session = null;

		try {
			session = openSession();

			String sql = StringUtil.replace(getInverseCategoriesByIdList, "[$ITEM_IDS$]", categoryIds);

			SQLQuery query = session.createSQLQuery(sql);

			query.addEntity("AHCategories", AHCategoriesImpl.class);
			

			result = (List<AHCategories>) query.list();

		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
		return result;
	}

}
