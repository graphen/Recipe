package com.szamraj.spring_guru_9_spring_webapp3.service;

import java.util.Set;

import com.szamraj.spring_guru_9_spring_webapp3.command.UnitOfMeasureCommand;

public interface UnitOfMeasureService {
	public Set<UnitOfMeasureCommand> getAllUnitsOfMeasure();
	public UnitOfMeasureCommand findUnitOfMeasureById(Long id);
	public UnitOfMeasureCommand findUnitOfMeasureByDescription(String description);
	public UnitOfMeasureCommand saveUnitOfMeasure(UnitOfMeasureCommand unitOfMeasureCommand);
	public void deleteUnitOfMeasureById(Long id);
	public boolean isUnitOfMeasureUsedInRecipes(Long id);
	public long getRecipeIngredientCountForUnitOfMeasure(Long id);
}
