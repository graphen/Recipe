package com.szamraj.spring_guru_9_spring_webapp3.service;

import java.util.Set;

import com.szamraj.spring_guru_9_spring_webapp3.command.RecipeCommand;

public interface RecipeService {
	public Set<RecipeCommand> getAllRecipes();
	public RecipeCommand findRecipeById(Long id);
	public RecipeCommand saveRecipe(RecipeCommand command);
	public void deleteRecipeById(Long id);
	boolean hasRecipeIngredients(Long id);
	long getIngredientCountForRecipe(Long id);
}
