package com.szamraj.recipe_app.service;

import java.util.Set;

import com.szamraj.recipe_app.command.RecipeCommand;

public interface RecipeService {
	public Set<RecipeCommand> getAllRecipes();
	public RecipeCommand findRecipeById(Long id);
	public RecipeCommand saveRecipe(RecipeCommand command);
	public void deleteRecipeById(Long id);
	boolean hasRecipeIngredients(Long id);
	long getIngredientCountForRecipe(Long id);
}
