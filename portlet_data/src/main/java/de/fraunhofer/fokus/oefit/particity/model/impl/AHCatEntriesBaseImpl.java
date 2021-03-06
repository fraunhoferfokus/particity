package de.fraunhofer.fokus.oefit.particity.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import de.fraunhofer.fokus.oefit.particity.model.AHCatEntries;
import de.fraunhofer.fokus.oefit.particity.service.AHCatEntriesLocalServiceUtil;

/**
 * The extended model base implementation for the AHCatEntries service. Represents a row in the &quot;AHCITEM&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AHCatEntriesImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AHCatEntriesImpl
 * @see de.fraunhofer.fokus.oefit.particity.model.AHCatEntries
 * @generated
 */
public abstract class AHCatEntriesBaseImpl extends AHCatEntriesModelImpl
    implements AHCatEntries {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a a h cat entries model instance should use the {@link AHCatEntries} interface instead.
     */
    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            AHCatEntriesLocalServiceUtil.addAHCatEntries(this);
        } else {
            AHCatEntriesLocalServiceUtil.updateAHCatEntries(this);
        }
    }
}
