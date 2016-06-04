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
package de.fraunhofer.fokus.oefit.particity.service.persistence.impl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class AHOrgFinderImpl  {
	
	private static final Log m_objLog = LogFactoryUtil
			.getLog(AHOrgFinderImpl.class);

	public static String getOrgByUserListEntry = "select * from AHORG org WHERE org.userlist LIKE '%USERMAIL%'";
	
	public static String getOrgCustomOrder = "select * from AHORG ORDER BY _COL_ _DIR_";
	
		
	/*
	@Override
	public List<AHOrg> getOrganisationsByUserlistEntry(String userMailAddr)  throws SystemException {
		List<AHOrg> result = null;

		Session session = null;

		try {
	
			session = openSession();
			
			SQLQuery query = session.createSQLQuery(getOrgByUserListEntry.replaceAll("USERMAIL", userMailAddr));
			
			query.addEntity("AHOrg", AHOrgImpl.class);
			

			result = (List<AHOrg>) query.list();
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
		return result;
	}
	
	@Override
	public List<AHOrg> getOrganisationsWithCustomOrder(String column, String order, int from, int to)
			throws SystemException {
		List<AHOrg> result = null;

		Session session = null;

		try {
			session = openSession();

			String sql = getOrgCustomOrder.replaceAll("_COL_", column).replaceAll("_DIR_", order);
			SQLQuery query = session.createSQLQuery(sql);

			query.addEntity("AHOrg", AHOrgImpl.class);
			query.setFirstResult(from);
			query.setMaxResults(to-from);

			
			result = (List<AHOrg>) query.list();
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
		return result;
	}
	 */
}
