package de.fraunhofer.fokus.oefit.particity.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import de.fraunhofer.fokus.oefit.particity.model.AHAddrClp;
import de.fraunhofer.fokus.oefit.particity.model.AHCatEntriesClp;
import de.fraunhofer.fokus.oefit.particity.model.AHCategoriesClp;
import de.fraunhofer.fokus.oefit.particity.model.AHConfigClp;
import de.fraunhofer.fokus.oefit.particity.model.AHContactClp;
import de.fraunhofer.fokus.oefit.particity.model.AHOfferClp;
import de.fraunhofer.fokus.oefit.particity.model.AHOrgClp;
import de.fraunhofer.fokus.oefit.particity.model.AHRegionClp;
import de.fraunhofer.fokus.oefit.particity.model.AHSubscriptionClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;


public class ClpSerializer {
    private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
    private static String _servletContextName;
    private static boolean _useReflectionToTranslateThrowable = true;

    public static String getServletContextName() {
        if (Validator.isNotNull(_servletContextName)) {
            return _servletContextName;
        }

        synchronized (ClpSerializer.class) {
            if (Validator.isNotNull(_servletContextName)) {
                return _servletContextName;
            }

            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Class<?> portletPropsClass = classLoader.loadClass(
                        "com.liferay.util.portlet.PortletProps");

                Method getMethod = portletPropsClass.getMethod("get",
                        new Class<?>[] { String.class });

                String portletPropsServletContextName = (String) getMethod.invoke(null,
                        "padata-portlet-deployment-context");

                if (Validator.isNotNull(portletPropsServletContextName)) {
                    _servletContextName = portletPropsServletContextName;
                }
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info(
                        "Unable to locate deployment context from portlet properties");
                }
            }

            if (Validator.isNull(_servletContextName)) {
                try {
                    String propsUtilServletContextName = PropsUtil.get(
                            "padata-portlet-deployment-context");

                    if (Validator.isNotNull(propsUtilServletContextName)) {
                        _servletContextName = propsUtilServletContextName;
                    }
                } catch (Throwable t) {
                    if (_log.isInfoEnabled()) {
                        _log.info(
                            "Unable to locate deployment context from portal properties");
                    }
                }
            }

            if (Validator.isNull(_servletContextName)) {
                _servletContextName = "padata-portlet";
            }

            return _servletContextName;
        }
    }

    public static Object translateInput(BaseModel<?> oldModel) {
        Class<?> oldModelClass = oldModel.getClass();

        String oldModelClassName = oldModelClass.getName();

        if (oldModelClassName.equals(AHAddrClp.class.getName())) {
            return translateInputAHAddr(oldModel);
        }

        if (oldModelClassName.equals(AHCategoriesClp.class.getName())) {
            return translateInputAHCategories(oldModel);
        }

        if (oldModelClassName.equals(AHCatEntriesClp.class.getName())) {
            return translateInputAHCatEntries(oldModel);
        }

        if (oldModelClassName.equals(AHConfigClp.class.getName())) {
            return translateInputAHConfig(oldModel);
        }

        if (oldModelClassName.equals(AHContactClp.class.getName())) {
            return translateInputAHContact(oldModel);
        }

        if (oldModelClassName.equals(AHOfferClp.class.getName())) {
            return translateInputAHOffer(oldModel);
        }

        if (oldModelClassName.equals(AHOrgClp.class.getName())) {
            return translateInputAHOrg(oldModel);
        }

        if (oldModelClassName.equals(AHRegionClp.class.getName())) {
            return translateInputAHRegion(oldModel);
        }

        if (oldModelClassName.equals(AHSubscriptionClp.class.getName())) {
            return translateInputAHSubscription(oldModel);
        }

        return oldModel;
    }

    public static Object translateInput(List<Object> oldList) {
        List<Object> newList = new ArrayList<Object>(oldList.size());

        for (int i = 0; i < oldList.size(); i++) {
            Object curObj = oldList.get(i);

            newList.add(translateInput(curObj));
        }

        return newList;
    }

    public static Object translateInputAHAddr(BaseModel<?> oldModel) {
        AHAddrClp oldClpModel = (AHAddrClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getAHAddrRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputAHCategories(BaseModel<?> oldModel) {
        AHCategoriesClp oldClpModel = (AHCategoriesClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getAHCategoriesRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputAHCatEntries(BaseModel<?> oldModel) {
        AHCatEntriesClp oldClpModel = (AHCatEntriesClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getAHCatEntriesRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputAHConfig(BaseModel<?> oldModel) {
        AHConfigClp oldClpModel = (AHConfigClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getAHConfigRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputAHContact(BaseModel<?> oldModel) {
        AHContactClp oldClpModel = (AHContactClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getAHContactRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputAHOffer(BaseModel<?> oldModel) {
        AHOfferClp oldClpModel = (AHOfferClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getAHOfferRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputAHOrg(BaseModel<?> oldModel) {
        AHOrgClp oldClpModel = (AHOrgClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getAHOrgRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputAHRegion(BaseModel<?> oldModel) {
        AHRegionClp oldClpModel = (AHRegionClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getAHRegionRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputAHSubscription(BaseModel<?> oldModel) {
        AHSubscriptionClp oldClpModel = (AHSubscriptionClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getAHSubscriptionRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInput(Object obj) {
        if (obj instanceof BaseModel<?>) {
            return translateInput((BaseModel<?>) obj);
        } else if (obj instanceof List<?>) {
            return translateInput((List<Object>) obj);
        } else {
            return obj;
        }
    }

    public static Object translateOutput(BaseModel<?> oldModel) {
        Class<?> oldModelClass = oldModel.getClass();

        String oldModelClassName = oldModelClass.getName();

        if (oldModelClassName.equals(
                    "de.fraunhofer.fokus.oefit.particity.model.impl.AHAddrImpl")) {
            return translateOutputAHAddr(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals(
                    "de.fraunhofer.fokus.oefit.particity.model.impl.AHCategoriesImpl")) {
            return translateOutputAHCategories(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals(
                    "de.fraunhofer.fokus.oefit.particity.model.impl.AHCatEntriesImpl")) {
            return translateOutputAHCatEntries(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals(
                    "de.fraunhofer.fokus.oefit.particity.model.impl.AHConfigImpl")) {
            return translateOutputAHConfig(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals(
                    "de.fraunhofer.fokus.oefit.particity.model.impl.AHContactImpl")) {
            return translateOutputAHContact(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals(
                    "de.fraunhofer.fokus.oefit.particity.model.impl.AHOfferImpl")) {
            return translateOutputAHOffer(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals(
                    "de.fraunhofer.fokus.oefit.particity.model.impl.AHOrgImpl")) {
            return translateOutputAHOrg(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals(
                    "de.fraunhofer.fokus.oefit.particity.model.impl.AHRegionImpl")) {
            return translateOutputAHRegion(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals(
                    "de.fraunhofer.fokus.oefit.particity.model.impl.AHSubscriptionImpl")) {
            return translateOutputAHSubscription(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        return oldModel;
    }

    public static Object translateOutput(List<Object> oldList) {
        List<Object> newList = new ArrayList<Object>(oldList.size());

        for (int i = 0; i < oldList.size(); i++) {
            Object curObj = oldList.get(i);

            newList.add(translateOutput(curObj));
        }

        return newList;
    }

    public static Object translateOutput(Object obj) {
        if (obj instanceof BaseModel<?>) {
            return translateOutput((BaseModel<?>) obj);
        } else if (obj instanceof List<?>) {
            return translateOutput((List<Object>) obj);
        } else {
            return obj;
        }
    }

    public static Throwable translateThrowable(Throwable throwable) {
        if (_useReflectionToTranslateThrowable) {
            try {
                UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

                objectOutputStream.writeObject(throwable);

                objectOutputStream.flush();
                objectOutputStream.close();

                UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
                        0, unsyncByteArrayOutputStream.size());

                Thread currentThread = Thread.currentThread();

                ClassLoader contextClassLoader = currentThread.getContextClassLoader();

                ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
                        contextClassLoader);

                throwable = (Throwable) objectInputStream.readObject();

                objectInputStream.close();

                return throwable;
            } catch (SecurityException se) {
                if (_log.isInfoEnabled()) {
                    _log.info("Do not use reflection to translate throwable");
                }

                _useReflectionToTranslateThrowable = false;
            } catch (Throwable throwable2) {
                _log.error(throwable2, throwable2);

                return throwable2;
            }
        }

        Class<?> clazz = throwable.getClass();

        String className = clazz.getName();

        if (className.equals(PortalException.class.getName())) {
            return new PortalException();
        }

        if (className.equals(SystemException.class.getName())) {
            return new SystemException();
        }

        if (className.equals(
                    "de.fraunhofer.fokus.oefit.particity.NoSuchAHAddrException")) {
            return new de.fraunhofer.fokus.oefit.particity.NoSuchAHAddrException();
        }

        if (className.equals(
                    "de.fraunhofer.fokus.oefit.particity.NoSuchAHCategoriesException")) {
            return new de.fraunhofer.fokus.oefit.particity.NoSuchAHCategoriesException();
        }

        if (className.equals(
                    "de.fraunhofer.fokus.oefit.particity.NoSuchAHCatEntriesException")) {
            return new de.fraunhofer.fokus.oefit.particity.NoSuchAHCatEntriesException();
        }

        if (className.equals(
                    "de.fraunhofer.fokus.oefit.particity.NoSuchAHConfigException")) {
            return new de.fraunhofer.fokus.oefit.particity.NoSuchAHConfigException();
        }

        if (className.equals(
                    "de.fraunhofer.fokus.oefit.particity.NoSuchAHContactException")) {
            return new de.fraunhofer.fokus.oefit.particity.NoSuchAHContactException();
        }

        if (className.equals(
                    "de.fraunhofer.fokus.oefit.particity.NoSuchAHOfferException")) {
            return new de.fraunhofer.fokus.oefit.particity.NoSuchAHOfferException();
        }

        if (className.equals(
                    "de.fraunhofer.fokus.oefit.particity.NoSuchAHOrgException")) {
            return new de.fraunhofer.fokus.oefit.particity.NoSuchAHOrgException();
        }

        if (className.equals(
                    "de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException")) {
            return new de.fraunhofer.fokus.oefit.particity.NoSuchAHRegionException();
        }

        if (className.equals(
                    "de.fraunhofer.fokus.oefit.particity.NoSuchAHSubscriptionException")) {
            return new de.fraunhofer.fokus.oefit.particity.NoSuchAHSubscriptionException();
        }

        return throwable;
    }

    public static Object translateOutputAHAddr(BaseModel<?> oldModel) {
        AHAddrClp newModel = new AHAddrClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setAHAddrRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputAHCategories(BaseModel<?> oldModel) {
        AHCategoriesClp newModel = new AHCategoriesClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setAHCategoriesRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputAHCatEntries(BaseModel<?> oldModel) {
        AHCatEntriesClp newModel = new AHCatEntriesClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setAHCatEntriesRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputAHConfig(BaseModel<?> oldModel) {
        AHConfigClp newModel = new AHConfigClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setAHConfigRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputAHContact(BaseModel<?> oldModel) {
        AHContactClp newModel = new AHContactClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setAHContactRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputAHOffer(BaseModel<?> oldModel) {
        AHOfferClp newModel = new AHOfferClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setAHOfferRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputAHOrg(BaseModel<?> oldModel) {
        AHOrgClp newModel = new AHOrgClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setAHOrgRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputAHRegion(BaseModel<?> oldModel) {
        AHRegionClp newModel = new AHRegionClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setAHRegionRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputAHSubscription(BaseModel<?> oldModel) {
        AHSubscriptionClp newModel = new AHSubscriptionClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setAHSubscriptionRemoteModel(oldModel);

        return newModel;
    }
}
