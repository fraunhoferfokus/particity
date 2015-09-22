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
package de.fraunhofer.fokus.oefit.adhoc.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import de.fraunhofer.fokus.oefit.adhoc.model.AHCategories;
import de.fraunhofer.fokus.oefit.adhoc.model.AHCategoriesModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the AHCategories service. Represents a row in the &quot;AHCATS&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link de.fraunhofer.fokus.oefit.adhoc.model.AHCategoriesModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AHCategoriesImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AHCategoriesImpl
 * @see de.fraunhofer.fokus.oefit.adhoc.model.AHCategories
 * @see de.fraunhofer.fokus.oefit.adhoc.model.AHCategoriesModel
 * @generated
 */
public class AHCategoriesModelImpl extends BaseModelImpl<AHCategories>
    implements AHCategoriesModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a a h categories model instance should use the {@link de.fraunhofer.fokus.oefit.adhoc.model.AHCategories} interface instead.
     */
    public static final String TABLE_NAME = "AHCATS";
    public static final Object[][] TABLE_COLUMNS = {
            { "catId", Types.BIGINT },
            { "name", Types.VARCHAR },
            { "descr", Types.VARCHAR },
            { "type_", Types.INTEGER }
        };
    public static final String TABLE_SQL_CREATE = "create table AHCATS (catId LONG not null primary key,name VARCHAR(80) null,descr STRING null,type_ INTEGER)";
    public static final String TABLE_SQL_DROP = "drop table AHCATS";
    public static final String ORDER_BY_JPQL = " ORDER BY ahCategories.catId ASC";
    public static final String ORDER_BY_SQL = " ORDER BY AHCATS.catId ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.de.fraunhofer.fokus.oefit.adhoc.model.AHCategories"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.de.fraunhofer.fokus.oefit.adhoc.model.AHCategories"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.de.fraunhofer.fokus.oefit.adhoc.model.AHCategories"),
            true);
    public static long NAME_COLUMN_BITMASK = 1L;
    public static long TYPE_COLUMN_BITMASK = 2L;
    public static long CATID_COLUMN_BITMASK = 4L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.de.fraunhofer.fokus.oefit.adhoc.model.AHCategories"));
    private static ClassLoader _classLoader = AHCategories.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            AHCategories.class
        };
    private long _catId;
    private String _name;
    private String _originalName;
    private String _descr;
    private int _type;
    private int _originalType;
    private boolean _setOriginalType;
    private long _columnBitmask;
    private AHCategories _escapedModel;

    public AHCategoriesModelImpl() {
    }

    @Override
    public long getPrimaryKey() {
        return _catId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setCatId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _catId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Class<?> getModelClass() {
        return AHCategories.class;
    }

    @Override
    public String getModelClassName() {
        return AHCategories.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("catId", getCatId());
        attributes.put("name", getName());
        attributes.put("descr", getDescr());
        attributes.put("type", getType());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long catId = (Long) attributes.get("catId");

        if (catId != null) {
            setCatId(catId);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String descr = (String) attributes.get("descr");

        if (descr != null) {
            setDescr(descr);
        }

        Integer type = (Integer) attributes.get("type");

        if (type != null) {
            setType(type);
        }
    }

    @Override
    public long getCatId() {
        return _catId;
    }

    @Override
    public void setCatId(long catId) {
        _catId = catId;
    }

    @Override
    public String getName() {
        if (_name == null) {
            return StringPool.BLANK;
        } else {
            return _name;
        }
    }

    @Override
    public void setName(String name) {
        _columnBitmask |= NAME_COLUMN_BITMASK;

        if (_originalName == null) {
            _originalName = _name;
        }

        _name = name;
    }

    public String getOriginalName() {
        return GetterUtil.getString(_originalName);
    }

    @Override
    public String getDescr() {
        if (_descr == null) {
            return StringPool.BLANK;
        } else {
            return _descr;
        }
    }

    @Override
    public void setDescr(String descr) {
        _descr = descr;
    }

    @Override
    public int getType() {
        return _type;
    }

    @Override
    public void setType(int type) {
        _columnBitmask |= TYPE_COLUMN_BITMASK;

        if (!_setOriginalType) {
            _setOriginalType = true;

            _originalType = _type;
        }

        _type = type;
    }

    public int getOriginalType() {
        return _originalType;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
            AHCategories.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public AHCategories toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (AHCategories) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        AHCategoriesImpl ahCategoriesImpl = new AHCategoriesImpl();

        ahCategoriesImpl.setCatId(getCatId());
        ahCategoriesImpl.setName(getName());
        ahCategoriesImpl.setDescr(getDescr());
        ahCategoriesImpl.setType(getType());

        ahCategoriesImpl.resetOriginalValues();

        return ahCategoriesImpl;
    }

    @Override
    public int compareTo(AHCategories ahCategories) {
        long primaryKey = ahCategories.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof AHCategories)) {
            return false;
        }

        AHCategories ahCategories = (AHCategories) obj;

        long primaryKey = ahCategories.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public void resetOriginalValues() {
        AHCategoriesModelImpl ahCategoriesModelImpl = this;

        ahCategoriesModelImpl._originalName = ahCategoriesModelImpl._name;

        ahCategoriesModelImpl._originalType = ahCategoriesModelImpl._type;

        ahCategoriesModelImpl._setOriginalType = false;

        ahCategoriesModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<AHCategories> toCacheModel() {
        AHCategoriesCacheModel ahCategoriesCacheModel = new AHCategoriesCacheModel();

        ahCategoriesCacheModel.catId = getCatId();

        ahCategoriesCacheModel.name = getName();

        String name = ahCategoriesCacheModel.name;

        if ((name != null) && (name.length() == 0)) {
            ahCategoriesCacheModel.name = null;
        }

        ahCategoriesCacheModel.descr = getDescr();

        String descr = ahCategoriesCacheModel.descr;

        if ((descr != null) && (descr.length() == 0)) {
            ahCategoriesCacheModel.descr = null;
        }

        ahCategoriesCacheModel.type = getType();

        return ahCategoriesCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{catId=");
        sb.append(getCatId());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", descr=");
        sb.append(getDescr());
        sb.append(", type=");
        sb.append(getType());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(16);

        sb.append("<model><model-name>");
        sb.append("de.fraunhofer.fokus.oefit.adhoc.model.AHCategories");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>catId</column-name><column-value><![CDATA[");
        sb.append(getCatId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>descr</column-name><column-value><![CDATA[");
        sb.append(getDescr());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>type</column-name><column-value><![CDATA[");
        sb.append(getType());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}