package com.szamraj.spring_guru_9_spring_webapp3.service;

import java.util.Set;

import com.szamraj.spring_guru_9_spring_webapp3.command.IngredientCommand;

public interface IngredientService {
	public Set<IngredientCommand> getAllIngredients();
	public IngredientCommand findIngredientById(Long id);
	public IngredientCommand saveIngredient(IngredientCommand ingredientCommand);
	public void deleteIngredientById(Long id);
	public boolean isIngredientUsedInRecipes(Long id);
	public long getRecipeCountForIngredient(Long id);
}
