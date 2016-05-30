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

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.fraunhofer.fokus.oefit.particity.exception.NoSuchAHCatEntriesException;
import de.fraunhofer.fokus.oefit.particity.model.AHCatEntries;
import de.fraunhofer.fokus.oefit.particity.service.base.AHCatEntriesLocalServiceBaseImpl;

// TODO: Auto-generated Javadoc
/**
 * The implementation of the a h cat entries local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link de.fraunhofer.fokus.oefit.particity.service.AHCatEntriesLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see de.fraunhofer.fokus.oefit.adhoc.service.base.AHCatEntriesLocalServiceBaseImpl
 * @see de.fraunhofer.fokus.oefit.particity.service.AHCatEntriesLocalServiceUtil
 */
public class AHCatEntriesLocalServiceImpl
        extends AHCatEntriesLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link
	 * de.fraunhofer.fokus.oefit.adhoc.service.AHCatEntriesLocalServiceUtil} to
	 * access the a h cat entries local service.
	 */
	private static final Log	m_objLog	= LogFactoryUtil
	                                             .getLog(AHCatEntriesLocalServiceImpl.class);

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHCatEntriesLocalService#addCategoryEntry(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public AHCatEntries addCategoryEntry(long catId, final String name,
	        final String description, long parentId) {
		AHCatEntries result = null;

		
		if (name != null && catId >= 0) {
			try {
				result = this.createAHCatEntries(CounterLocalServiceUtil
				        .increment(AHCatEntries.class.getName()));
				result.setName(name);
				result.setDescr(description);
				result.setCatId(catId);
				result.setParentId(parentId);
				result = this.updateAHCatEntries(result);

				m_objLog.info("Added category item " + result.getName()
				        + " in category " + catId + " with parent "
				        + parentId);
			} catch (final SystemException e) {
				m_objLog.error(e);
			}
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHCatEntriesLocalService#getCategoryEntries(long)
	 */
	@Override
	public List<AHCatEntries> getCategoryEntries(final long catId) {
		List<AHCatEntries> result = null;
		try {
			result = this.getAHCatEntriesPersistence().findBycat(catId);
		} catch (final SystemException e) {
			m_objLog.error(e);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHCatEntriesLocalService#getCategoryEntriesChildsSorted(long)
	 */
	@Override
	public List<AHCatEntries> getCategoryEntriesChildsSorted(final long catId) {
		List<AHCatEntries> result = null;
		try {
			final List<AHCatEntries> entries = this
			        .getAHCatEntriesPersistence().findBycat(catId);
			if (entries.size() > 0) {
				result = new LinkedList<AHCatEntries>();
				// add entries without childs first
				for (final AHCatEntries entry : entries) {
					if (entry.getParentId() < 0) {
						final List<AHCatEntries> childs = this
						        .getChildEntriesById(entry.getItemId());
						if (childs == null || childs.size() == 0) {
							result.add(entry);
						}
					}
				}
				// then add rest
				if (result.size() != entries.size()) {
					for (final AHCatEntries entry : entries) {
						if (entry.getParentId() < 0 && !result.contains(entry)) {
							result.add(entry);
						}
					}
				}

			}
		} catch (final SystemException e) {
			m_objLog.error(e);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHCatEntriesLocalService#getCategoryEntryById(long)
	 */
	@Override
	public AHCatEntries getCategoryEntryById(final long entryId) {
		AHCatEntries result = null;

		try {
			result = this.getAHCatEntriesPersistence()
			        .findByPrimaryKey(entryId);
		} catch (final SystemException e) {
			m_objLog.error(e);
		} catch (final NoSuchAHCatEntriesException e) {
			m_objLog.error(e);
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHCatEntriesLocalService#getChildEntriesById(long)
	 */
	@Override
	public List<AHCatEntries> getChildEntriesById(final long entryId) {
		List<AHCatEntries> result = new LinkedList<AHCatEntries>();

		try {
			result = this.getAHCatEntriesPersistence().findByparent(entryId);
		} catch (final SystemException e) {
			m_objLog.error(e);
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHCatEntriesLocalService#getEntriesForCatId(long)
	 */
	@Override
	public List<AHCatEntries> getEntriesForCatId(final long catId) {
		List<AHCatEntries> result = new LinkedList<AHCatEntries>();

		try {
			result = this.getAHCatEntriesPersistence().findBycat(catId);
		} catch (final SystemException e) {
			m_objLog.error(e);
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see de.fraunhofer.fokus.oefit.adhoc.service.AHCatEntriesLocalService#getEntryMapForCatId(long)
	 */
	@Override
	public Map<Long, String> getEntryMapForCatId(final long catId) {
		final Map<Long, String> result = new HashMap<Long, String>();

		final List<AHCatEntries> entries = this.getEntriesForCatId(catId);
		if (entries != null) {
			for (final AHCatEntries entry : entries) {
				// restrict entries to depth 2
				if (entry.getParentId() < 0) {
					result.put(entry.getItemId(), entry.getName());
				}
			}
		}

		return result;
	}
}
