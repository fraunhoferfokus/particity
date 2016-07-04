package de.particity.model.map;

import javax.enterprise.context.ApplicationScoped;

import org.apache.deltaspike.data.api.mapping.SimpleQueryInOutMapperBase;

import de.particity.model.I_SubscriptionModel;
import de.particity.model.impl.Subscription;

@ApplicationScoped
public class SubscriptionMapper extends SimpleQueryInOutMapperBase<Subscription, I_SubscriptionModel> {

	@Override
	protected Object getPrimaryKey(I_SubscriptionModel dto) {
		return dto.getUuid();
	}

	@Override
	protected I_SubscriptionModel toDto(Subscription entity) {
		return entity;
	}

	@Override
	protected Subscription toEntity(Subscription entity, I_SubscriptionModel dto) {
		return (Subscription) dto;
	}

}
