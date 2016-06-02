package de.particity.model.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply=true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Date> {

	@Override
	public Date convertToDatabaseColumn(LocalDateTime attribute) {
		return Date.from(attribute.atZone(ZoneId.systemDefault()).toInstant());
	}

	@Override
	public LocalDateTime convertToEntityAttribute(Date dbData) {
		return dbData.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

	
	
}
