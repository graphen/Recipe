package com.szamraj.recipe_app.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.szamraj.recipe_app.command.RecipeIngredientCommand;
import com.szamraj.recipe_app.model.Ingredient;
import com.szamraj.recipe_app.model.Recipe;
import com.szamraj.recipe_app.model.RecipeIngredient;
import com.szamraj.recipe_app.model.UnitOfMeasure;
import com.szamraj.recipe_app.repository.IngredientRepository;
import com.szamraj.recipe_app.repository.RecipeRepository;
import com.szamraj.recipe_app.repository.UnitOfMeasureRepository;

import java.util.Optional;

@Component
public class RecipeIngredientCommandToRecipeIngredient implements Converter<RecipeIngredientCommand, RecipeIngredient> {
	
	RecipeRepository recipeRepository;
	IngredientRepository ingredientRepository;
	UnitOfMeasureRepository unitOfMeasureRepository;
	
	public RecipeIngredientCommandToRecipeIngredient(RecipeRepository recipeRepository, 
			IngredientRepository ingredientRepository, 
			UnitOfMeasureRepository unitOfMeasureRepository) {
		this.recipeRepository = recipeRepository;
		this.ingredientRepository = ingredientRepository;
		this.unitOfMeasureRepository = unitOfMeasureRepository;
	}
	
	@Override
	public RecipeIngredient convert(RecipeIngredientCommand recipeIngredientCommand) {
		if (recipeIngredientCommand == null) {
			return null;
		}
		
		RecipeIngredient recipeIngredient = new RecipeIngredient();
		
		recipeIngredient.setId(recipeIngredientCommand.getId());
		
		if (recipeIngredientCommand.getRecipeId() != null) {
			Optional<Recipe> recipe = recipeRepository.findById(recipeIngredientCommand.getRecipeId());
			if (recipe.isPresent()) {
				recipeIngredient.setRecipe(recipe.get());
			}		
		}
		
		if (recipeIngredientCommand.getIngredientId() != null) {
			Optional<Ingredient> ingredient = ingredientRepository.findById(recipeIngredientCommand.getIngredientId());
			if (ingredient.isPresent()) {
				recipeIngredient.setIngredient(ingredient.get());
			}
		}
		
		recipeIngredient.setAmount(recipeIngredientCommand.getAmount());
		
		if (recipeIngredientCommand.getUnitOfMeasureId() != null) {
			Optional<UnitOfMeasure> uom = unitOfMeasureRepository.findById(recipeIngredientCommand.getUnitOfMeasureId());
			if (uom.isPresent()) {
				recipeIngredient.setUnitOfMeasure(uom.get());
			}
		}
		
		return recipeIngredient;
	}
}
