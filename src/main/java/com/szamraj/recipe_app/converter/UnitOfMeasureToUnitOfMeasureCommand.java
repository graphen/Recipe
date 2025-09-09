package com.szamraj.recipe_app.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.szamraj.recipe_app.command.UnitOfMeasureCommand;
import com.szamraj.recipe_app.model.UnitOfMeasure;

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
