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
package de.fraunhofer.fokus.oefit.adhoc.service.base;

import de.fraunhofer.fokus.oefit.adhoc.service.AHCategoriesLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AHCategoriesLocalServiceClpInvoker {
    private String _methodName0;
    private String[] _methodParameterTypes0;
    private String _methodName1;
    private String[] _methodParameterTypes1;
    private String _methodName2;
    private String[] _methodParameterTypes2;
    private String _methodName3;
    private String[] _methodParameterTypes3;
    private String _methodName4;
    private String[] _methodParameterTypes4;
    private String _methodName5;
    private String[] _methodParameterTypes5;
    private String _methodName6;
    private String[] _methodParameterTypes6;
    private String _methodName7;
    private String[] _methodParameterTypes7;
    private String _methodName8;
    private String[] _methodParameterTypes8;
    private String _methodName9;
    private String[] _methodParameterTypes9;
    private String _methodName10;
    private String[] _methodParameterTypes10;
    private String _methodName11;
    private String[] _methodParameterTypes11;
    private String _methodName12;
    private String[] _methodParameterTypes12;
    private String _methodName13;
    private String[] _methodParameterTypes13;
    private String _methodName14;
    private String[] _methodParameterTypes14;
    private String _methodName15;
    private String[] _methodParameterTypes15;
    private String _methodName72;
    private String[] _methodParameterTypes72;
    private String _methodName73;
    private String[] _methodParameterTypes73;
    private String _methodName78;
    private String[] _methodParameterTypes78;
    private String _methodName79;
    private String[] _methodParameterTypes79;
    private String _methodName80;
    private String[] _methodParameterTypes80;
    private String _methodName81;
    private String[] _methodParameterTypes81;
    private String _methodName82;
    private String[] _methodParameterTypes82;
    private String _methodName83;
    private String[] _methodParameterTypes83;
    private String _methodName84;
    private String[] _methodParameterTypes84;
    private String _methodName85;
    private String[] _methodParameterTypes85;

    public AHCategoriesLocalServiceClpInvoker() {
        _methodName0 = "addAHCategories";

        _methodParameterTypes0 = new String[] {
                "de.fraunhofer.fokus.oefit.adhoc.model.AHCategories"
            };

        _methodName1 = "createAHCategories";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteAHCategories";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteAHCategories";

        _methodParameterTypes3 = new String[] {
                "de.fraunhofer.fokus.oefit.adhoc.model.AHCategories"
            };

        _methodName4 = "dynamicQuery";

        _methodParameterTypes4 = new String[] {  };

        _methodName5 = "dynamicQuery";

        _methodParameterTypes5 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName6 = "dynamicQuery";

        _methodParameterTypes6 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
            };

        _methodName7 = "dynamicQuery";

        _methodParameterTypes7 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };

        _methodName8 = "dynamicQueryCount";

        _methodParameterTypes8 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName9 = "dynamicQueryCount";

        _methodParameterTypes9 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery",
                "com.liferay.portal.kernel.dao.orm.Projection"
            };

        _methodName10 = "fetchAHCategories";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getAHCategories";

        _methodParameterTypes11 = new String[] { "long" };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getAHCategorieses";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getAHCategoriesesCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateAHCategories";

        _methodParameterTypes15 = new String[] {
                "de.fraunhofer.fokus.oefit.adhoc.model.AHCategories"
            };

        _methodName72 = "getBeanIdentifier";

        _methodParameterTypes72 = new String[] {  };

        _methodName73 = "setBeanIdentifier";

        _methodParameterTypes73 = new String[] { "java.lang.String" };

        _methodName78 = "getCategories";

        _methodParameterTypes78 = new String[] {
                "de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType"
            };

        _methodName79 = "getCategoryMap";

        _methodParameterTypes79 = new String[] {
                "de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType",
                "boolean"
            };

        _methodName80 = "getCategory";

        _methodParameterTypes80 = new String[] {
                "java.lang.String",
                "de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType"
            };

        _methodName81 = "getCategory";

        _methodParameterTypes81 = new String[] { "long" };

        _methodName82 = "getCategoriesByIdStr";

        _methodParameterTypes82 = new String[] { "java.lang.String" };

        _methodName83 = "getCategoriesByInverseIdStr";

        _methodParameterTypes83 = new String[] { "java.lang.String" };

        _methodName84 = "deleteCategoryById";

        _methodParameterTypes84 = new String[] { "long" };

        _methodName85 = "addCategory";

        _methodParameterTypes85 = new String[] {
                "java.lang.String", "java.lang.String",
                "de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return AHCategoriesLocalServiceUtil.addAHCategories((de.fraunhofer.fokus.oefit.adhoc.model.AHCategories) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return AHCategoriesLocalServiceUtil.createAHCategories(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return AHCategoriesLocalServiceUtil.deleteAHCategories(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return AHCategoriesLocalServiceUtil.deleteAHCategories((de.fraunhofer.fokus.oefit.adhoc.model.AHCategories) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return AHCategoriesLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return AHCategoriesLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return AHCategoriesLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return AHCategoriesLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return AHCategoriesLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return AHCategoriesLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return AHCategoriesLocalServiceUtil.fetchAHCategories(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return AHCategoriesLocalServiceUtil.getAHCategories(((Long) arguments[0]).longValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return AHCategoriesLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return AHCategoriesLocalServiceUtil.getAHCategorieses(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return AHCategoriesLocalServiceUtil.getAHCategoriesesCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return AHCategoriesLocalServiceUtil.updateAHCategories((de.fraunhofer.fokus.oefit.adhoc.model.AHCategories) arguments[0]);
        }

        if (_methodName72.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
            return AHCategoriesLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName73.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
            AHCategoriesLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName78.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes78, parameterTypes)) {
            return AHCategoriesLocalServiceUtil.getCategories((de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType) arguments[0]);
        }

        if (_methodName79.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes79, parameterTypes)) {
            return AHCategoriesLocalServiceUtil.getCategoryMap((de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType) arguments[0],
                ((Boolean) arguments[1]).booleanValue());
        }

        if (_methodName80.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
            return AHCategoriesLocalServiceUtil.getCategory((java.lang.String) arguments[0],
                (de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType) arguments[1]);
        }

        if (_methodName81.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
            return AHCategoriesLocalServiceUtil.getCategory(((Long) arguments[0]).longValue());
        }

        if (_methodName82.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
            return AHCategoriesLocalServiceUtil.getCategoriesByIdStr((java.lang.String) arguments[0]);
        }

        if (_methodName83.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes83, parameterTypes)) {
            return AHCategoriesLocalServiceUtil.getCategoriesByInverseIdStr((java.lang.String) arguments[0]);
        }

        if (_methodName84.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes84, parameterTypes)) {
            return AHCategoriesLocalServiceUtil.deleteCategoryById(((Long) arguments[0]).longValue());
        }

        if (_methodName85.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes85, parameterTypes)) {
            return AHCategoriesLocalServiceUtil.addCategory((java.lang.String) arguments[0],
                (java.lang.String) arguments[1],
                (de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType) arguments[2]);
        }

        throw new UnsupportedOperationException();
    }
}
