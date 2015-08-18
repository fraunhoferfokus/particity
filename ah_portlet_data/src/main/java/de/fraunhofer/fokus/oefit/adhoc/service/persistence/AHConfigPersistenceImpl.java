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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import de.fraunhofer.fokus.oefit.adhoc.NoSuchAHConfigException;
import de.fraunhofer.fokus.oefit.adhoc.model.AHConfig;
import de.fraunhofer.fokus.oefit.adhoc.model.impl.AHConfigImpl;
import de.fraunhofer.fokus.oefit.adhoc.model.impl.AHConfigModelImpl;
import de.fraunhofer.fokus.oefit.adhoc.service.persistence.AHConfigPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the a h config service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AHConfigPersistence
 * @see AHConfigUtil
 * @generated
 */
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
    private static final String _SQL_SELECT_AHCONFIG = "SELECT ahConfig FROM AHConfig ahConfig";
    private static final String _SQL_COUNT_AHCONFIG = "SELECT COUNT(ahConfig) FROM AHConfig ahConfig";
    private static final String _ORDER_BY_ENTITY_ALIAS = "ahConfig.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AHConfig exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(AHConfigPersistenceImpl.class);
    private static AHConfig _nullAHConfig = new AHConfigImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<AHConfig> toCacheModel() {
                return _nullAHConfigCacheModel;
            }
        };

    private static CacheModel<AHConfig> _nullAHConfigCacheModel = new CacheModel<AHConfig>() {
            @Override
            public AHConfig toEntityModel() {
                return _nullAHConfig;
            }
        };

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
        EntityCacheUtil.putResult(AHConfigModelImpl.ENTITY_CACHE_ENABLED,
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
            if (EntityCacheUtil.getResult(
                        AHConfigModelImpl.ENTITY_CACHE_ENABLED,
                        AHConfigImpl.class, ahConfig.getPrimaryKey()) == null) {
                cacheResult(ahConfig);
            } else {
                ahConfig.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all a h configs.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(AHConfigImpl.class.getName());
        }

        EntityCacheUtil.clearCache(AHConfigImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the a h config.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(AHConfig ahConfig) {
        EntityCacheUtil.removeResult(AHConfigModelImpl.ENTITY_CACHE_ENABLED,
            AHConfigImpl.class, ahConfig.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<AHConfig> ahConfigs) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (AHConfig ahConfig : ahConfigs) {
            EntityCacheUtil.removeResult(AHConfigModelImpl.ENTITY_CACHE_ENABLED,
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
     * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHConfigException if a a h config with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHConfig remove(String name)
        throws NoSuchAHConfigException, SystemException {
        return remove((Serializable) name);
    }

    /**
     * Removes the a h config with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the a h config
     * @return the a h config that was removed
     * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHConfigException if a a h config with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHConfig remove(Serializable primaryKey)
        throws NoSuchAHConfigException, SystemException {
        Session session = null;

        try {
            session = openSession();

            AHConfig ahConfig = (AHConfig) session.get(AHConfigImpl.class,
                    primaryKey);

            if (ahConfig == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchAHConfigException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(ahConfig);
        } catch (NoSuchAHConfigException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected AHConfig removeImpl(AHConfig ahConfig) throws SystemException {
        ahConfig = toUnwrappedModel(ahConfig);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(ahConfig)) {
                ahConfig = (AHConfig) session.get(AHConfigImpl.class,
                        ahConfig.getPrimaryKeyObj());
            }

            if (ahConfig != null) {
                session.delete(ahConfig);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (ahConfig != null) {
            clearCache(ahConfig);
        }

        return ahConfig;
    }

    @Override
    public AHConfig updateImpl(
        de.fraunhofer.fokus.oefit.adhoc.model.AHConfig ahConfig)
        throws SystemException {
        ahConfig = toUnwrappedModel(ahConfig);

        boolean isNew = ahConfig.isNew();

        Session session = null;

        try {
            session = openSession();

            if (ahConfig.isNew()) {
                session.save(ahConfig);

                ahConfig.setNew(false);
            } else {
                session.merge(ahConfig);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(AHConfigModelImpl.ENTITY_CACHE_ENABLED,
            AHConfigImpl.class, ahConfig.getPrimaryKey(), ahConfig);

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
     * Returns the a h config with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the a h config
     * @return the a h config
     * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHConfigException if a a h config with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHConfig findByPrimaryKey(Serializable primaryKey)
        throws NoSuchAHConfigException, SystemException {
        AHConfig ahConfig = fetchByPrimaryKey(primaryKey);

        if (ahConfig == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchAHConfigException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return ahConfig;
    }

    /**
     * Returns the a h config with the primary key or throws a {@link de.fraunhofer.fokus.oefit.adhoc.NoSuchAHConfigException} if it could not be found.
     *
     * @param name the primary key of the a h config
     * @return the a h config
     * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHConfigException if a a h config with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHConfig findByPrimaryKey(String name)
        throws NoSuchAHConfigException, SystemException {
        return findByPrimaryKey((Serializable) name);
    }

    /**
     * Returns the a h config with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the a h config
     * @return the a h config, or <code>null</code> if a a h config with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHConfig fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        AHConfig ahConfig = (AHConfig) EntityCacheUtil.getResult(AHConfigModelImpl.ENTITY_CACHE_ENABLED,
                AHConfigImpl.class, primaryKey);

        if (ahConfig == _nullAHConfig) {
            return null;
        }

        if (ahConfig == null) {
            Session session = null;

            try {
                session = openSession();

                ahConfig = (AHConfig) session.get(AHConfigImpl.class, primaryKey);

                if (ahConfig != null) {
                    cacheResult(ahConfig);
                } else {
                    EntityCacheUtil.putResult(AHConfigModelImpl.ENTITY_CACHE_ENABLED,
                        AHConfigImpl.class, primaryKey, _nullAHConfig);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(AHConfigModelImpl.ENTITY_CACHE_ENABLED,
                    AHConfigImpl.class, primaryKey);

                throw processException(e);
            } finally {
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
     * @throws SystemException if a system exception occurred
     */
    @Override
    public AHConfig fetchByPrimaryKey(String name) throws SystemException {
        return fetchByPrimaryKey((Serializable) name);
    }

    /**
     * Returns all the a h configs.
     *
     * @return the a h configs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHConfig> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the a h configs.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of a h configs
     * @param end the upper bound of the range of a h configs (not inclusive)
     * @return the range of a h configs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHConfig> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the a h configs.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.fraunhofer.fokus.oefit.adhoc.model.impl.AHConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of a h configs
     * @param end the upper bound of the range of a h configs (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of a h configs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<AHConfig> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<AHConfig> list = (List<AHConfig>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_AHCONFIG);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
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
                    list = (List<AHConfig>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<AHConfig>(list);
                } else {
                    list = (List<AHConfig>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the a h configs from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (AHConfig ahConfig : findAll()) {
            remove(ahConfig);
        }
    }

    /**
     * Returns the number of a h configs.
     *
     * @return the number of a h configs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_AHCONFIG);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Initializes the a h config persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.de.fraunhofer.fokus.oefit.adhoc.model.AHConfig")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<AHConfig>> listenersList = new ArrayList<ModelListener<AHConfig>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<AHConfig>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(AHConfigImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
