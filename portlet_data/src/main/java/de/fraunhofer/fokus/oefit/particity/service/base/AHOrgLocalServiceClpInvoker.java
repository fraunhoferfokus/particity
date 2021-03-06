package de.fraunhofer.fokus.oefit.particity.service.base;

import de.fraunhofer.fokus.oefit.particity.service.AHOrgLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AHOrgLocalServiceClpInvoker {
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
    private String _methodName86;
    private String[] _methodParameterTypes86;
    private String _methodName87;
    private String[] _methodParameterTypes87;
    private String _methodName88;
    private String[] _methodParameterTypes88;

    public AHOrgLocalServiceClpInvoker() {
        _methodName0 = "addAHOrg";

        _methodParameterTypes0 = new String[] {
                "de.fraunhofer.fokus.oefit.particity.model.AHOrg"
            };

        _methodName1 = "createAHOrg";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteAHOrg";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteAHOrg";

        _methodParameterTypes3 = new String[] {
                "de.fraunhofer.fokus.oefit.particity.model.AHOrg"
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

        _methodName10 = "fetchAHOrg";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getAHOrg";

        _methodParameterTypes11 = new String[] { "long" };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getAHOrgs";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getAHOrgsCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateAHOrg";

        _methodParameterTypes15 = new String[] {
                "de.fraunhofer.fokus.oefit.particity.model.AHOrg"
            };

        _methodName72 = "getBeanIdentifier";

        _methodParameterTypes72 = new String[] {  };

        _methodName73 = "setBeanIdentifier";

        _methodParameterTypes73 = new String[] { "java.lang.String" };

        _methodName78 = "addOrganisation";

        _methodParameterTypes78 = new String[] {
                "java.lang.String", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.String", "long", "long"
            };

        _methodName79 = "addOrganisationUser";

        _methodParameterTypes79 = new String[] { "long", "java.lang.String" };

        _methodName80 = "countNewOrg";

        _methodParameterTypes80 = new String[] {  };

        _methodName81 = "deleteOrganisation";

        _methodParameterTypes81 = new String[] { "long" };

        _methodName82 = "getOrganisationByOwnerMail";

        _methodParameterTypes82 = new String[] { "java.lang.String" };

        _methodName83 = "getOrganisationByUserMail";

        _methodParameterTypes83 = new String[] { "java.lang.String" };

        _methodName84 = "getOrganisations";

        _methodParameterTypes84 = new String[] {
                "int", "int", "java.lang.String", "java.lang.String"
            };

        _methodName85 = "listOrganisations";

        _methodParameterTypes85 = new String[] {  };

        _methodName86 = "setOrganisationStatus";

        _methodParameterTypes86 = new String[] { "long", "int" };

        _methodName87 = "updateLogoLocation";

        _methodParameterTypes87 = new String[] { "long", "java.lang.String" };

        _methodName88 = "updateOwner";

        _methodParameterTypes88 = new String[] {
                "java.lang.String", "java.lang.String"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return AHOrgLocalServiceUtil.addAHOrg((de.fraunhofer.fokus.oefit.particity.model.AHOrg) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return AHOrgLocalServiceUtil.createAHOrg(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return AHOrgLocalServiceUtil.deleteAHOrg(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return AHOrgLocalServiceUtil.deleteAHOrg((de.fraunhofer.fokus.oefit.particity.model.AHOrg) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return AHOrgLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return AHOrgLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return AHOrgLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return AHOrgLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return AHOrgLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return AHOrgLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return AHOrgLocalServiceUtil.fetchAHOrg(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return AHOrgLocalServiceUtil.getAHOrg(((Long) arguments[0]).longValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return AHOrgLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return AHOrgLocalServiceUtil.getAHOrgs(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return AHOrgLocalServiceUtil.getAHOrgsCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return AHOrgLocalServiceUtil.updateAHOrg((de.fraunhofer.fokus.oefit.particity.model.AHOrg) arguments[0]);
        }

        if (_methodName72.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
            return AHOrgLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName73.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
            AHOrgLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName78.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes78, parameterTypes)) {
            return AHOrgLocalServiceUtil.addOrganisation((java.lang.String) arguments[0],
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                (java.lang.String) arguments[3],
                (java.lang.String) arguments[4],
                ((Long) arguments[5]).longValue(),
                ((Long) arguments[6]).longValue());
        }

        if (_methodName79.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes79, parameterTypes)) {
            AHOrgLocalServiceUtil.addOrganisationUser(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1]);

            return null;
        }

        if (_methodName80.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
            return AHOrgLocalServiceUtil.countNewOrg();
        }

        if (_methodName81.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
            AHOrgLocalServiceUtil.deleteOrganisation(((Long) arguments[0]).longValue());

            return null;
        }

        if (_methodName82.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
            return AHOrgLocalServiceUtil.getOrganisationByOwnerMail((java.lang.String) arguments[0]);
        }

        if (_methodName83.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes83, parameterTypes)) {
            return AHOrgLocalServiceUtil.getOrganisationByUserMail((java.lang.String) arguments[0]);
        }

        if (_methodName84.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes84, parameterTypes)) {
            return AHOrgLocalServiceUtil.getOrganisations(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue(),
                (java.lang.String) arguments[2], (java.lang.String) arguments[3]);
        }

        if (_methodName85.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes85, parameterTypes)) {
            return AHOrgLocalServiceUtil.listOrganisations();
        }

        if (_methodName86.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes86, parameterTypes)) {
            AHOrgLocalServiceUtil.setOrganisationStatus(((Long) arguments[0]).longValue(),
                ((Integer) arguments[1]).intValue());

            return null;
        }

        if (_methodName87.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes87, parameterTypes)) {
            AHOrgLocalServiceUtil.updateLogoLocation(((Long) arguments[0]).longValue(),
                (java.lang.String) arguments[1]);

            return null;
        }

        if (_methodName88.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes88, parameterTypes)) {
            AHOrgLocalServiceUtil.updateOwner((java.lang.String) arguments[0],
                (java.lang.String) arguments[1]);

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
