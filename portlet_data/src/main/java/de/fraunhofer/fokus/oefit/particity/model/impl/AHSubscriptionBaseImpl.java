package de.fraunhofer.fokus.oefit.particity.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import de.fraunhofer.fokus.oefit.particity.model.AHSubscription;
import de.fraunhofer.fokus.oefit.particity.service.AHSubscriptionLocalServiceUtil;

/**
 * The extended model base implementation for the AHSubscription service. Represents a row in the &quot;AHSUBSCR&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AHSubscriptionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AHSubscriptionImpl
 * @see de.fraunhofer.fokus.oefit.particity.model.AHSubscription
 * @generated
 */
public abstract class AHSubscriptionBaseImpl extends AHSubscriptionModelImpl
    implements AHSubscription {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a a h subscription model instance should use the {@link AHSubscription} interface instead.
     */
    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            AHSubscriptionLocalServiceUtil.addAHSubscription(this);
        } else {
            AHSubscriptionLocalServiceUtil.updateAHSubscription(this);
        }
    }
}
