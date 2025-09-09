package com.szamraj.spring_guru_9_spring_webapp3.converter;

import com.szamraj.spring_guru_9_spring_webapp3.command.RecipeIngredientCommand;
import com.szamraj.spring_guru_9_spring_webapp3.model.RecipeIngredient;
import com.szamraj.spring_guru_9_spring_webapp3.model.Recipe;
import com.szamraj.spring_guru_9_spring_webapp3.model.Ingredient;
import com.szamraj.spring_guru_9_spring_webapp3.model.UnitOfMeasure;
import com.szamraj.spring_guru_9_spring_webapp3.repository.RecipeRepository;
import com.szamraj.spring_guru_9_spring_webapp3.repository.UnitOfMeasureRepository;
import com.szamraj.spring_guru_9_spring_webapp3.repository.IngredientRepository;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

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
