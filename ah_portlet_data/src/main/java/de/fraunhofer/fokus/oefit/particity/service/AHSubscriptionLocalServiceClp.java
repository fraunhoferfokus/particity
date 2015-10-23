package de.fraunhofer.fokus.oefit.particity.service;

import com.liferay.portal.service.InvokableLocalService;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AHSubscriptionLocalServiceClp implements AHSubscriptionLocalService {
    private InvokableLocalService _invokableLocalService;
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
    private String _methodName16;
    private String[] _methodParameterTypes16;
    private String _methodName17;
    private String[] _methodParameterTypes17;
    private String _methodName18;
    private String[] _methodParameterTypes18;
    private String _methodName19;
    private String[] _methodParameterTypes19;
    private String _methodName20;
    private String[] _methodParameterTypes20;
    private String _methodName21;
    private String[] _methodParameterTypes21;
    private String _methodName22;
    private String[] _methodParameterTypes22;
    private String _methodName23;
    private String[] _methodParameterTypes23;
    private String _methodName24;
    private String[] _methodParameterTypes24;
    private String _methodName25;
    private String[] _methodParameterTypes25;
    private String _methodName26;
    private String[] _methodParameterTypes26;
    private String _methodName27;
    private String[] _methodParameterTypes27;
    private String _methodName28;
    private String[] _methodParameterTypes28;
    private String _methodName29;
    private String[] _methodParameterTypes29;
    private String _methodName30;
    private String[] _methodParameterTypes30;
    private String _methodName31;
    private String[] _methodParameterTypes31;
    private String _methodName32;
    private String[] _methodParameterTypes32;
    private String _methodName33;
    private String[] _methodParameterTypes33;
    private String _methodName35;
    private String[] _methodParameterTypes35;
    private String _methodName36;
    private String[] _methodParameterTypes36;
    private String _methodName37;
    private String[] _methodParameterTypes37;
    private String _methodName38;
    private String[] _methodParameterTypes38;
    private String _methodName39;
    private String[] _methodParameterTypes39;
    private String _methodName40;
    private String[] _methodParameterTypes40;
    private String _methodName41;
    private String[] _methodParameterTypes41;
    private String _methodName42;
    private String[] _methodParameterTypes42;
    private String _methodName43;
    private String[] _methodParameterTypes43;
    private String _methodName44;
    private String[] _methodParameterTypes44;

    public AHSubscriptionLocalServiceClp(
        InvokableLocalService invokableLocalService) {
        _invokableLocalService = invokableLocalService;

        _methodName0 = "addAHSubscription";

        _methodParameterTypes0 = new String[] {
                "de.fraunhofer.fokus.oefit.particity.model.AHSubscription"
            };

        _methodName1 = "createAHSubscription";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteAHSubscription";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteAHSubscription";

        _methodParameterTypes3 = new String[] {
                "de.fraunhofer.fokus.oefit.particity.model.AHSubscription"
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

        _methodName10 = "fetchAHSubscription";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getAHSubscription";

        _methodParameterTypes11 = new String[] { "long" };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getAHSubscriptions";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getAHSubscriptionsCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateAHSubscription";

        _methodParameterTypes15 = new String[] {
                "de.fraunhofer.fokus.oefit.particity.model.AHSubscription"
            };

        _methodName16 = "addAHCatEntriesAHSubscription";

        _methodParameterTypes16 = new String[] { "long", "long" };

        _methodName17 = "addAHCatEntriesAHSubscription";

        _methodParameterTypes17 = new String[] {
                "long",
                "de.fraunhofer.fokus.oefit.particity.model.AHSubscription"
            };

        _methodName18 = "addAHCatEntriesAHSubscriptions";

        _methodParameterTypes18 = new String[] { "long", "long[][]" };

        _methodName19 = "addAHCatEntriesAHSubscriptions";

        _methodParameterTypes19 = new String[] { "long", "java.util.List" };

        _methodName20 = "clearAHCatEntriesAHSubscriptions";

        _methodParameterTypes20 = new String[] { "long" };

        _methodName21 = "deleteAHCatEntriesAHSubscription";

        _methodParameterTypes21 = new String[] { "long", "long" };

        _methodName22 = "deleteAHCatEntriesAHSubscription";

        _methodParameterTypes22 = new String[] {
                "long",
                "de.fraunhofer.fokus.oefit.particity.model.AHSubscription"
            };

        _methodName23 = "deleteAHCatEntriesAHSubscriptions";

        _methodParameterTypes23 = new String[] { "long", "long[][]" };

        _methodName24 = "deleteAHCatEntriesAHSubscriptions";

        _methodParameterTypes24 = new String[] { "long", "java.util.List" };

        _methodName25 = "getAHCatEntriesAHSubscriptions";

        _methodParameterTypes25 = new String[] { "long" };

        _methodName26 = "getAHCatEntriesAHSubscriptions";

        _methodParameterTypes26 = new String[] { "long", "int", "int" };

        _methodName27 = "getAHCatEntriesAHSubscriptions";

        _methodParameterTypes27 = new String[] {
                "long", "int", "int",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };

        _methodName28 = "getAHCatEntriesAHSubscriptionsCount";

        _methodParameterTypes28 = new String[] { "long" };

        _methodName29 = "hasAHCatEntriesAHSubscription";

        _methodParameterTypes29 = new String[] { "long", "long" };

        _methodName30 = "hasAHCatEntriesAHSubscriptions";

        _methodParameterTypes30 = new String[] { "long" };

        _methodName31 = "setAHCatEntriesAHSubscriptions";

        _methodParameterTypes31 = new String[] { "long", "long[][]" };

        _methodName32 = "getBeanIdentifier";

        _methodParameterTypes32 = new String[] {  };

        _methodName33 = "setBeanIdentifier";

        _methodParameterTypes33 = new String[] { "java.lang.String" };

        _methodName35 = "addSubscription";

        _methodParameterTypes35 = new String[] { "java.lang.String", "long[][]" };

        _methodName36 = "addSubscription";

        _methodParameterTypes36 = new String[] {
                "java.lang.String", "long[][]", "java.lang.String",
                "de.fraunhofer.fokus.oefit.adhoc.custom.E_SubscriptionStatus"
            };

        _methodName37 = "getCategoriesBySubscription";

        _methodParameterTypes37 = new String[] { "long" };

        _methodName38 = "getCategoriesBySubscriptionAsString";

        _methodParameterTypes38 = new String[] { "long" };

        _methodName39 = "getSubscriptionsByMail";

        _methodParameterTypes39 = new String[] { "java.lang.String" };

        _methodName40 = "getSubscriptionsByUuid";

        _methodParameterTypes40 = new String[] { "java.lang.String" };

        _methodName41 = "getUserAddresses";

        _methodParameterTypes41 = new String[] {  };

        _methodName42 = "getUserAddressesByCatItems";

        _methodParameterTypes42 = new String[] { "java.lang.Long[][]" };

        _methodName43 = "removeSubscription";

        _methodParameterTypes43 = new String[] { "long" };

        _methodName44 = "setSubscriptionStatus";

        _methodParameterTypes44 = new String[] {
                "long",
                "de.fraunhofer.fokus.oefit.adhoc.custom.E_SubscriptionStatus"
            };
    }

    @Override
    public de.fraunhofer.fokus.oefit.particity.model.AHSubscription addAHSubscription(
        de.fraunhofer.fokus.oefit.particity.model.AHSubscription ahSubscription)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName0,
                    _methodParameterTypes0,
                    new Object[] { ClpSerializer.translateInput(ahSubscription) });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (de.fraunhofer.fokus.oefit.particity.model.AHSubscription) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public de.fraunhofer.fokus.oefit.particity.model.AHSubscription createAHSubscription(
        long subId) {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName1,
                    _methodParameterTypes1, new Object[] { subId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (de.fraunhofer.fokus.oefit.particity.model.AHSubscription) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public de.fraunhofer.fokus.oefit.particity.model.AHSubscription deleteAHSubscription(
        long subId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName2,
                    _methodParameterTypes2, new Object[] { subId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (de.fraunhofer.fokus.oefit.particity.model.AHSubscription) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public de.fraunhofer.fokus.oefit.particity.model.AHSubscription deleteAHSubscription(
        de.fraunhofer.fokus.oefit.particity.model.AHSubscription ahSubscription)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName3,
                    _methodParameterTypes3,
                    new Object[] { ClpSerializer.translateInput(ahSubscription) });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (de.fraunhofer.fokus.oefit.particity.model.AHSubscription) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName4,
                    _methodParameterTypes4, new Object[] {  });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.liferay.portal.kernel.dao.orm.DynamicQuery) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName5,
                    _methodParameterTypes5,
                    new Object[] { ClpSerializer.translateInput(dynamicQuery) });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName6,
                    _methodParameterTypes6,
                    new Object[] {
                        ClpSerializer.translateInput(dynamicQuery),
                        
                    start,
                        
                    end
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName7,
                    _methodParameterTypes7,
                    new Object[] {
                        ClpSerializer.translateInput(dynamicQuery),
                        
                    start,
                        
                    end,
                        
                    ClpSerializer.translateInput(orderByComparator)
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName8,
                    _methodParameterTypes8,
                    new Object[] { ClpSerializer.translateInput(dynamicQuery) });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return ((Long) returnObj).longValue();
    }

    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName9,
                    _methodParameterTypes9,
                    new Object[] {
                        ClpSerializer.translateInput(dynamicQuery),
                        
                    ClpSerializer.translateInput(projection)
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return ((Long) returnObj).longValue();
    }

    @Override
    public de.fraunhofer.fokus.oefit.particity.model.AHSubscription fetchAHSubscription(
        long subId) throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName10,
                    _methodParameterTypes10, new Object[] { subId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (de.fraunhofer.fokus.oefit.particity.model.AHSubscription) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public de.fraunhofer.fokus.oefit.particity.model.AHSubscription getAHSubscription(
        long subId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName11,
                    _methodParameterTypes11, new Object[] { subId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (de.fraunhofer.fokus.oefit.particity.model.AHSubscription) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName12,
                    _methodParameterTypes12,
                    new Object[] { ClpSerializer.translateInput(primaryKeyObj) });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.liferay.portal.model.PersistedModel) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription> getAHSubscriptions(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName13,
                    _methodParameterTypes13, new Object[] { start, end });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription>) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public int getAHSubscriptionsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName14,
                    _methodParameterTypes14, new Object[] {  });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return ((Integer) returnObj).intValue();
    }

    @Override
    public de.fraunhofer.fokus.oefit.particity.model.AHSubscription updateAHSubscription(
        de.fraunhofer.fokus.oefit.particity.model.AHSubscription ahSubscription)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName15,
                    _methodParameterTypes15,
                    new Object[] { ClpSerializer.translateInput(ahSubscription) });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (de.fraunhofer.fokus.oefit.particity.model.AHSubscription) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public void addAHCatEntriesAHSubscription(long itemId, long subId)
        throws com.liferay.portal.kernel.exception.SystemException {
        try {
            _invokableLocalService.invokeMethod(_methodName16,
                _methodParameterTypes16, new Object[] { itemId, subId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    @Override
    public void addAHCatEntriesAHSubscription(long itemId,
        de.fraunhofer.fokus.oefit.particity.model.AHSubscription ahSubscription)
        throws com.liferay.portal.kernel.exception.SystemException {
        try {
            _invokableLocalService.invokeMethod(_methodName17,
                _methodParameterTypes17,
                new Object[] {
                    itemId,
                    
                ClpSerializer.translateInput(ahSubscription)
                });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    @Override
    public void addAHCatEntriesAHSubscriptions(long itemId, long[] subIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        try {
            _invokableLocalService.invokeMethod(_methodName18,
                _methodParameterTypes18,
                new Object[] { itemId, ClpSerializer.translateInput(subIds) });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    @Override
    public void addAHCatEntriesAHSubscriptions(long itemId,
        java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription> AHSubscriptions)
        throws com.liferay.portal.kernel.exception.SystemException {
        try {
            _invokableLocalService.invokeMethod(_methodName19,
                _methodParameterTypes19,
                new Object[] {
                    itemId,
                    
                ClpSerializer.translateInput(AHSubscriptions)
                });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    @Override
    public void clearAHCatEntriesAHSubscriptions(long itemId)
        throws com.liferay.portal.kernel.exception.SystemException {
        try {
            _invokableLocalService.invokeMethod(_methodName20,
                _methodParameterTypes20, new Object[] { itemId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    @Override
    public void deleteAHCatEntriesAHSubscription(long itemId, long subId)
        throws com.liferay.portal.kernel.exception.SystemException {
        try {
            _invokableLocalService.invokeMethod(_methodName21,
                _methodParameterTypes21, new Object[] { itemId, subId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    @Override
    public void deleteAHCatEntriesAHSubscription(long itemId,
        de.fraunhofer.fokus.oefit.particity.model.AHSubscription ahSubscription)
        throws com.liferay.portal.kernel.exception.SystemException {
        try {
            _invokableLocalService.invokeMethod(_methodName22,
                _methodParameterTypes22,
                new Object[] {
                    itemId,
                    
                ClpSerializer.translateInput(ahSubscription)
                });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    @Override
    public void deleteAHCatEntriesAHSubscriptions(long itemId, long[] subIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        try {
            _invokableLocalService.invokeMethod(_methodName23,
                _methodParameterTypes23,
                new Object[] { itemId, ClpSerializer.translateInput(subIds) });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    @Override
    public void deleteAHCatEntriesAHSubscriptions(long itemId,
        java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription> AHSubscriptions)
        throws com.liferay.portal.kernel.exception.SystemException {
        try {
            _invokableLocalService.invokeMethod(_methodName24,
                _methodParameterTypes24,
                new Object[] {
                    itemId,
                    
                ClpSerializer.translateInput(AHSubscriptions)
                });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription> getAHCatEntriesAHSubscriptions(
        long itemId) throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName25,
                    _methodParameterTypes25, new Object[] { itemId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription>) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription> getAHCatEntriesAHSubscriptions(
        long itemId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName26,
                    _methodParameterTypes26, new Object[] { itemId, start, end });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription>) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription> getAHCatEntriesAHSubscriptions(
        long itemId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName27,
                    _methodParameterTypes27,
                    new Object[] {
                        itemId,
                        
                    start,
                        
                    end,
                        
                    ClpSerializer.translateInput(orderByComparator)
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription>) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public int getAHCatEntriesAHSubscriptionsCount(long itemId)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName28,
                    _methodParameterTypes28, new Object[] { itemId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return ((Integer) returnObj).intValue();
    }

    @Override
    public boolean hasAHCatEntriesAHSubscription(long itemId, long subId)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName29,
                    _methodParameterTypes29, new Object[] { itemId, subId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return ((Boolean) returnObj).booleanValue();
    }

    @Override
    public boolean hasAHCatEntriesAHSubscriptions(long itemId)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName30,
                    _methodParameterTypes30, new Object[] { itemId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return ((Boolean) returnObj).booleanValue();
    }

    @Override
    public void setAHCatEntriesAHSubscriptions(long itemId, long[] subIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        try {
            _invokableLocalService.invokeMethod(_methodName31,
                _methodParameterTypes31,
                new Object[] { itemId, ClpSerializer.translateInput(subIds) });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    @Override
    public java.lang.String getBeanIdentifier() {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName32,
                    _methodParameterTypes32, new Object[] {  });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.lang.String) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        try {
            _invokableLocalService.invokeMethod(_methodName33,
                _methodParameterTypes33,
                new Object[] { ClpSerializer.translateInput(beanIdentifier) });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        throw new UnsupportedOperationException();
    }

    @Override
    public de.fraunhofer.fokus.oefit.particity.model.AHSubscription addSubscription(
        java.lang.String email, long[] categories) {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName35,
                    _methodParameterTypes35,
                    new Object[] {
                        ClpSerializer.translateInput(email),
                        
                    ClpSerializer.translateInput(categories)
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (de.fraunhofer.fokus.oefit.particity.model.AHSubscription) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public de.fraunhofer.fokus.oefit.particity.model.AHSubscription addSubscription(
        java.lang.String email, long[] categories, java.lang.String uuid,
        de.fraunhofer.fokus.oefit.adhoc.custom.E_SubscriptionStatus status) {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName36,
                    _methodParameterTypes36,
                    new Object[] {
                        ClpSerializer.translateInput(email),
                        
                    ClpSerializer.translateInput(categories),
                        
                    ClpSerializer.translateInput(uuid),
                        
                    ClpSerializer.translateInput(status)
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (de.fraunhofer.fokus.oefit.particity.model.AHSubscription) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHCatEntries> getCategoriesBySubscription(
        long subId) {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName37,
                    _methodParameterTypes37, new Object[] { subId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHCatEntries>) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public java.lang.String getCategoriesBySubscriptionAsString(long subId) {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName38,
                    _methodParameterTypes38, new Object[] { subId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.lang.String) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription> getSubscriptionsByMail(
        java.lang.String email) {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName39,
                    _methodParameterTypes39,
                    new Object[] { ClpSerializer.translateInput(email) });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription>) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription> getSubscriptionsByUuid(
        java.lang.String uuid) {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName40,
                    _methodParameterTypes40,
                    new Object[] { ClpSerializer.translateInput(uuid) });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription>) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public java.util.List<java.lang.String> getUserAddresses() {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName41,
                    _methodParameterTypes41, new Object[] {  });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<java.lang.String>) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription> getUserAddressesByCatItems(
        java.lang.Long[] catItems) {
        Object returnObj = null;

        try {
            returnObj = _invokableLocalService.invokeMethod(_methodName42,
                    _methodParameterTypes42,
                    new Object[] { ClpSerializer.translateInput(catItems) });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<de.fraunhofer.fokus.oefit.particity.model.AHSubscription>) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public void removeSubscription(long id) {
        try {
            _invokableLocalService.invokeMethod(_methodName43,
                _methodParameterTypes43, new Object[] { id });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    @Override
    public void setSubscriptionStatus(long subId,
        de.fraunhofer.fokus.oefit.adhoc.custom.E_SubscriptionStatus status) {
        try {
            _invokableLocalService.invokeMethod(_methodName44,
                _methodParameterTypes44,
                new Object[] { subId, ClpSerializer.translateInput(status) });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }
}
