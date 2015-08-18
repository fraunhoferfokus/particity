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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import de.fraunhofer.fokus.oefit.adhoc.model.AHCategories;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing AHCategories in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see AHCategories
 * @generated
 */
public class AHCategoriesCacheModel implements CacheModel<AHCategories>,
    Externalizable {
    public long catId;
    public String name;
    public String descr;
    public int type;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{catId=");
        sb.append(catId);
        sb.append(", name=");
        sb.append(name);
        sb.append(", descr=");
        sb.append(descr);
        sb.append(", type=");
        sb.append(type);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public AHCategories toEntityModel() {
        AHCategoriesImpl ahCategoriesImpl = new AHCategoriesImpl();

        ahCategoriesImpl.setCatId(catId);

        if (name == null) {
            ahCategoriesImpl.setName(StringPool.BLANK);
        } else {
            ahCategoriesImpl.setName(name);
        }

        if (descr == null) {
            ahCategoriesImpl.setDescr(StringPool.BLANK);
        } else {
            ahCategoriesImpl.setDescr(descr);
        }

        ahCategoriesImpl.setType(type);

        ahCategoriesImpl.resetOriginalValues();

        return ahCategoriesImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        catId = objectInput.readLong();
        name = objectInput.readUTF();
        descr = objectInput.readUTF();
        type = objectInput.readInt();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(catId);

        if (name == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(name);
        }

        if (descr == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(descr);
        }

        objectOutput.writeInt(type);
    }
}
