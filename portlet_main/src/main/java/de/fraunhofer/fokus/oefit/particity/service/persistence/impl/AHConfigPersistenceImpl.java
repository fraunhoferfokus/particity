/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package de.fraunhofer.fokus.oefit.particity.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import de.fraunhofer.fokus.oefit.particity.exception.NoSuchAHConfigException;
import de.fraunhofer.fokus.oefit.particity.model.AHConfig;
import de.fraunhofer.fokus.oefit.particity.model.impl.AHConfigImpl;
import de.fraunhofer.fokus.oefit.particity.model.impl.AHConfigModelImpl;
import de.fraunhofer.fokus.oefit.particity.service.persistence.AHConfigPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the a h config service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AHConfigPersistence
 * @see de.fraunhofer.fokus.oefit.particity.service.persistence.AHConfigUtil
 * @generated
 */
@ProviderType
public class AHConfigPersistenceImpl extends BasePersistenceImpl<AHConfig>
	implements AHConfigPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AHConfigUtil} to access the a h config persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AHConfigImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AHConfigModelImpl.ENTITY_CACHE_ENABLED,
			AHConfigModelImpl.FINDER_CACHE_ENABLED, AHConfigImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AHConfigModelImpl.ENTITY_CACHE_ENABLED,
			AHConfigModelImpl.FINDER_CACHE_ENABLED, AHConfigImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AHConfigModelImpl.ENTITY_CACHE_ENABLED,
			AHConfigModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public AHConfigPersistenceImpl() {
		setModelClass(AHConfig.class);
	}

	/**
	 * Caches the a h config in the entity cache if it is enabled.
	 *
	 * @param ahConfig the a h config
	 */
	@Override
	public void cacheResult(AHConfig ahConfig) {
		entityCache.putResult(AHConfigModelImpl.ENTITY_CACHE_ENABLED,
			AHConfigImpl.class, ahConfig.getPrimaryKey(), ahConfig);

		ahConfig.resetOriginalValues();
	}

	/**
	 * Caches the a h configs in the entity cache if it is enabled.
	 *
	 * @param ahConfigs the a h configs
	 */
	@Override
	public void cacheResult(List<AHConfig> ahConfigs) {
		for (AHConfig ahConfig : ahConfigs) {
			if (entityCache.getResult(AHConfigModelImpl.ENTITY_CACHE_ENABLED,
						AHConfigImpl.class, ahConfig.getPrimaryKey()) == null) {
				cacheResult(ahConfig);
			}
			else {
				ahConfig.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all a h configs.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AHConfigImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the a h config.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AHConfig ahConfig) {
		entityCache.removeResult(AHConfigModelImpl.ENTITY_CACHE_ENABLED,
			AHConfigImpl.class, ahConfig.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AHConfig> ahConfigs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AHConfig ahConfig : ahConfigs) {
			entityCache.removeResult(AHConfigModelImpl.ENTITY_CACHE_ENABLED,
				AHConfigImpl.class, ahConfig.getPrimaryKey());
		}
	}

	/**
	 * Creates a new a h config with the primary key. Does not add the a h config to the database.
	 *
	 * @param name the primary key for the new a h config
	 * @return the new a h config
	 */
	@Override
	public AHConfig create(String name) {
		AHConfig ahConfig = new AHConfigImpl();

		ahConfig.setNew(true);
		ahConfig.setPrimaryKey(name);

		return ahConfig;
	}

	/**
	 * Removes the a h config with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param name the primary key of the a h config
	 * @return the a h config that was removed
	 * @throws NoSuchAHConfigException if a a h config with the primary key could not be found
	 */
	@Override
	public AHConfig remove(String name) throws NoSuchAHConfigException {
		return remove((Serializable)name);
	}

	/**
	 * Removes the a h config with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the a h config
	 * @return the a h config that was removed
	 * @throws NoSuchAHConfigException if a a h config with the primary key could not be found
	 */
	@Override
	public AHConfig remove(Serializable primaryKey)
		throws NoSuchAHConfigException {
		Session session = null;

		try {
			session = openSession();

			AHConfig ahConfig = (AHConfig)session.get(AHConfigImpl.class,
					primaryKey);

			if (ahConfig == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAHConfigException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(ahConfig);
		}
		catch (NoSuchAHConfigException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected AHConfig removeImpl(AHConfig ahConfig) {
		ahConfig = toUnwrappedModel(ahConfig);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ahConfig)) {
				ahConfig = (AHConfig)session.get(AHConfigImpl.class,
						ahConfig.getPrimaryKeyObj());
			}

			if (ahConfig != null) {
				session.delete(ahConfig);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (ahConfig != null) {
			clearCache(ahConfig);
		}

		return ahConfig;
	}

	@Override
	public AHConfig updateImpl(AHConfig ahConfig) {
		ahConfig = toUnwrappedModel(ahConfig);

		boolean isNew = ahConfig.isNew();

		Session session = null;

		try {
			session = openSession();

			if (ahConfig.isNew()) {
				session.save(ahConfig);

				ahConfig.setNew(false);
			}
			else {
				ahConfig = (AHConfig)session.merge(ahConfig);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		entityCache.putResult(AHConfigModelImpl.ENTITY_CACHE_ENABLED,
			AHConfigImpl.class, ahConfig.getPrimaryKey(), ahConfig, false);

		ahConfig.resetOriginalValues();

		return ahConfig;
	}

	protected AHConfig toUnwrappedModel(AHConfig ahConfig) {
		if (ahConfig instanceof AHConfigImpl) {
			return ahConfig;
		}

		AHConfigImpl ahConfigImpl = new AHConfigImpl();

		ahConfigImpl.setNew(ahConfig.isNew());
		ahConfigImpl.setPrimaryKey(ahConfig.getPrimaryKey());

		ahConfigImpl.setName(ahConfig.getName());
		ahConfigImpl.setValue(ahConfig.getValue());

		return ahConfigImpl;
	}

	/**
	 * Returns the a h config with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the a h config
	 * @return the a h config
	 * @throws NoSuchAHConfigException if a a h config with the primary key could not be found
	 */
	@Override
	public AHConfig findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAHConfigException {
		AHConfig ahConfig = fetchByPrimaryKey(primaryKey);

		if (ahConfig == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAHConfigException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return ahConfig;
	}

	/**
	 * Returns the a h config with the primary key or throws a {@link NoSuchAHConfigException} if it could not be found.
	 *
	 * @param name the primary key of the a h config
	 * @return the a h config
	 * @throws NoSuchAHConfigException if a a h config with the primary key could not be found
	 */
	@Override
	public AHConfig findByPrimaryKey(String name)
		throws NoSuchAHConfigException {
		return findByPrimaryKey((Serializable)name);
	}

	/**
	 * Returns the a h config with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the a h config
	 * @return the a h config, or <code>null</code> if a a h config with the primary key could not be found
	 */
	@Override
	public AHConfig fetchByPrimaryKey(Serializable primaryKey) {
		AHConfig ahConfig = (AHConfig)entityCache.getResult(AHConfigModelImpl.ENTITY_CACHE_ENABLED,
				AHConfigImpl.class, primaryKey);

		if (ahConfig == _nullAHConfig) {
			return null;
		}

		if (ahConfig == null) {
			Session session = null;

			try {
				session = openSession();

				ahConfig = (AHConfig)session.get(AHConfigImpl.class, primaryKey);

				if (ahConfig != null) {
					cacheResult(ahConfig);
				}
				else {
					entityCache.putResult(AHConfigModelImpl.ENTITY_CACHE_ENABLED,
						AHConfigImpl.class, primaryKey, _nullAHConfig);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(AHConfigModelImpl.ENTITY_CACHE_ENABLED,
					AHConfigImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return ahConfig;
	}

	/**
	 * Returns the a h config with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param name the primary key of the a h config
	 * @return the a h config, or <code>null</code> if a a h config with the primary key could not be found
	 */
	@Override
	public AHConfig fetchByPrimaryKey(String name) {
		return fetchByPrimaryKey((Serializable)name);
	}

	@Override
	public Map<Serializable, AHConfig> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, AHConfig> map = new HashMap<Serializable, AHConfig>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			AHConfig ahConfig = fetchByPrimaryKey(primaryKey);

			if (ahConfig != null) {
				map.put(primaryKey, ahConfig);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			AHConfig ahConfig = (AHConfig)entityCache.getResult(AHConfigModelImpl.ENTITY_CACHE_ENABLED,
					AHConfigImpl.class, primaryKey);

			if (ahConfig == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, ahConfig);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 4) +
				1);

		query.append(_SQL_SELECT_AHCONFIG_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(StringPool.APOSTROPHE);
			query.append((String)primaryKey);
			query.append(StringPool.APOSTROPHE);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (AHConfig ahConfig : (List<AHConfig>)q.list()) {
				map.put(ahConfig.getPrimaryKeyObj(), ahConfig);

				cacheResult(ahConfig);

				uncachedPrimaryKeys.remove(ahConfig.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(AHConfigModelImpl.ENTITY_CACHE_ENABLED,
					AHConfigImpl.class, primaryKey, _nullAHConfig);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the a h configs.
	 *
	 * @return the a h configs
	 */
	@Override
	public List<AHConfig> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the a h configs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AHConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of a h configs
	 * @param end the upper bound of the range of a h configs (not inclusive)
	 * @return the range of a h configs
	 */
	@Override
	public List<AHConfig> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the a h configs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AHConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of a h configs
	 * @param end the upper bound of the range of a h configs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of a h configs
	 */
	@Override
	public List<AHConfig> findAll(int start, int end,
		OrderByComparator<AHConfig> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the a h configs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AHConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of a h configs
	 * @param end the upper bound of the range of a h configs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of a h configs
	 */
	@Override
	public List<AHConfig> findAll(int start, int end,
		OrderByComparator<AHConfig> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<AHConfig> list = null;

		if (retrieveFromCache) {
			list = (List<AHConfig>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_AHCONFIG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_AHCONFIG;

				if (pagination) {
					sql = sql.concat(AHConfigModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AHConfig>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AHConfig>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the a h configs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AHConfig ahConfig : findAll()) {
			remove(ahConfig);
		}
	}

	/**
	 * Returns the number of a h configs.
	 *
	 * @return the number of a h configs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_AHCONFIG);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AHConfigModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the a h config persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(AHConfigImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_AHCONFIG = "SELECT ahConfig FROM AHConfig ahConfig";
	private static final String _SQL_SELECT_AHCONFIG_WHERE_PKS_IN = "SELECT ahConfig FROM AHConfig ahConfig WHERE name IN (";
	private static final String _SQL_COUNT_AHCONFIG = "SELECT COUNT(ahConfig) FROM AHConfig ahConfig";
	private static final String _ORDER_BY_ENTITY_ALIAS = "ahConfig.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AHConfig exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(AHConfigPersistenceImpl.class);
	private static final AHConfig _nullAHConfig = new AHConfigImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AHConfig> toCacheModel() {
				return _nullAHConfigCacheModel;
			}
		};

	private static final CacheModel<AHConfig> _nullAHConfigCacheModel = new CacheModel<AHConfig>() {
			@Override
			public AHConfig toEntityModel() {
				return _nullAHConfig;
			}
		};
}