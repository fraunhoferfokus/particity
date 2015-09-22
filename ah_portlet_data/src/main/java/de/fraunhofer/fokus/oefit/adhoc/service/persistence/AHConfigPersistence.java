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

import com.liferay.portal.service.persistence.BasePersistence;

import de.fraunhofer.fokus.oefit.adhoc.model.AHConfig;

/**
 * The persistence interface for the a h config service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AHConfigPersistenceImpl
 * @see AHConfigUtil
 * @generated
 */
public interface AHConfigPersistence extends BasePersistence<AHConfig> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link AHConfigUtil} to access the a h config persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the a h config in the entity cache if it is enabled.
    *
    * @param ahConfig the a h config
    */
    public void cacheResult(
        de.fraunhofer.fokus.oefit.adhoc.model.AHConfig ahConfig);

    /**
    * Caches the a h configs in the entity cache if it is enabled.
    *
    * @param ahConfigs the a h configs
    */
    public void cacheResult(
        java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHConfig> ahConfigs);

    /**
    * Creates a new a h config with the primary key. Does not add the a h config to the database.
    *
    * @param name the primary key for the new a h config
    * @return the new a h config
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHConfig create(
        java.lang.String name);

    /**
    * Removes the a h config with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param name the primary key of the a h config
    * @return the a h config that was removed
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHConfigException if a a h config with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHConfig remove(
        java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHConfigException;

    public de.fraunhofer.fokus.oefit.adhoc.model.AHConfig updateImpl(
        de.fraunhofer.fokus.oefit.adhoc.model.AHConfig ahConfig)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the a h config with the primary key or throws a {@link de.fraunhofer.fokus.oefit.adhoc.NoSuchAHConfigException} if it could not be found.
    *
    * @param name the primary key of the a h config
    * @return the a h config
    * @throws de.fraunhofer.fokus.oefit.adhoc.NoSuchAHConfigException if a a h config with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHConfig findByPrimaryKey(
        java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.fraunhofer.fokus.oefit.adhoc.NoSuchAHConfigException;

    /**
    * Returns the a h config with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param name the primary key of the a h config
    * @return the a h config, or <code>null</code> if a a h config with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.fraunhofer.fokus.oefit.adhoc.model.AHConfig fetchByPrimaryKey(
        java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the a h configs.
    *
    * @return the a h configs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHConfig> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHConfig> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.fraunhofer.fokus.oefit.adhoc.model.AHConfig> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the a h configs from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of a h configs.
    *
    * @return the number of a h configs
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
