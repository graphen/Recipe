package com.szamraj.recipe_app.service;

import java.util.Set;

import com.szamraj.recipe_app.command.UnitOfMeasureCommand;

public interface UnitOfMeasureService {
	public Set<UnitOfMeasureCommand> getAllUnitsOfMeasure();
	public UnitOfMeasureCommand findUnitOfMeasureById(Long id);
	public UnitOfMeasureCommand findUnitOfMeasureByDescription(String description);
	public UnitOfMeasureCommand saveUnitOfMeasure(UnitOfMeasureCommand unitOfMeasureCommand);
	public void deleteUnitOfMeasureById(Long id);
	public boolean isUnitOfMeasureUsedInRecipes(Long id);
	public long getRecipeIngredientCountForUnitOfMeasure(Long id);
}
