package com.szamraj.spring_guru_9_spring_webapp3.converter;

import com.szamraj.spring_guru_9_spring_webapp3.command.UnitOfMeasureCommand;
import com.szamraj.spring_guru_9_spring_webapp3.model.UnitOfMeasure;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {
	
	@Override
	public UnitOfMeasureCommand convert(UnitOfMeasure unitOfMeasure) {
		if (unitOfMeasure == null) {
			return null;
		}

		UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();

		unitOfMeasureCommand.setId(unitOfMeasure.getId());
		unitOfMeasureCommand.setDescription(unitOfMeasure.getDescription());

		return unitOfMeasureCommand;
	}
}
