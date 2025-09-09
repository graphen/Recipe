package com.szamraj.spring_guru_9_spring_webapp3.converter;

import com.szamraj.spring_guru_9_spring_webapp3.command.UnitOfMeasureCommand;
import com.szamraj.spring_guru_9_spring_webapp3.model.UnitOfMeasure;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommand, UnitOfMeasure> {

	@Override
	public UnitOfMeasure convert(UnitOfMeasureCommand unitOfMeasureCommand) {
		if (unitOfMeasureCommand == null) {
			return null;
		}
		
		UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
		
		unitOfMeasure.setId(unitOfMeasureCommand.getId());
		unitOfMeasure.setDescription(unitOfMeasureCommand.getDescription());
		
		return unitOfMeasure;
	}
}
