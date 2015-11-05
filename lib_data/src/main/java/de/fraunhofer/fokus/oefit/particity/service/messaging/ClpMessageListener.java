package de.fraunhofer.fokus.oefit.particity.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import de.fraunhofer.fokus.oefit.particity.service.AHAddrLocalServiceUtil;
import de.fraunhofer.fokus.oefit.particity.service.AHCatEntriesLocalServiceUtil;
import de.fraunhofer.fokus.oefit.particity.service.AHCategoriesLocalServiceUtil;
import de.fraunhofer.fokus.oefit.particity.service.AHConfigLocalServiceUtil;
import de.fraunhofer.fokus.oefit.particity.service.AHContactLocalServiceUtil;
import de.fraunhofer.fokus.oefit.particity.service.AHOfferLocalServiceUtil;
import de.fraunhofer.fokus.oefit.particity.service.AHOrgLocalServiceUtil;
import de.fraunhofer.fokus.oefit.particity.service.AHRegionLocalServiceUtil;
import de.fraunhofer.fokus.oefit.particity.service.AHSubscriptionLocalServiceUtil;
import de.fraunhofer.fokus.oefit.particity.service.ClpSerializer;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            AHAddrLocalServiceUtil.clearService();

            AHCategoriesLocalServiceUtil.clearService();

            AHCatEntriesLocalServiceUtil.clearService();

            AHConfigLocalServiceUtil.clearService();

            AHContactLocalServiceUtil.clearService();

            AHOfferLocalServiceUtil.clearService();

            AHOrgLocalServiceUtil.clearService();

            AHRegionLocalServiceUtil.clearService();

            AHSubscriptionLocalServiceUtil.clearService();
        }
    }
}
