package de.particity.model.map;

import javax.enterprise.context.ApplicationScoped;

import org.apache.deltaspike.data.api.mapping.SimpleQueryInOutMapperBase;

import de.particity.model.I_OfferModel;
import de.particity.model.impl.Offer;

@ApplicationScoped
public class OfferMapper extends SimpleQueryInOutMapperBase<Offer, I_OfferModel> {

	@Override
	protected Object getPrimaryKey(I_OfferModel dto) {
		return dto.getId();
	}

	@Override
	protected I_OfferModel toDto(Offer entity) {
		return entity;
	}

	@Override
	protected Offer toEntity(Offer entity, I_OfferModel dto) {
		return (Offer) dto;
	}

}
