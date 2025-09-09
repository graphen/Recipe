package com.szamraj.spring_guru_9_spring_webapp3.converter;

import com.szamraj.spring_guru_9_spring_webapp3.command.RecipeIngredientCommand;
import com.szamraj.spring_guru_9_spring_webapp3.model.RecipeIngredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RecipeIngredientToRecipeIngredientCommand implements Converter<RecipeIngredient, RecipeIngredientCommand> {
	
	@Override
	public RecipeIngredientCommand convert(RecipeIngredient recipeIngredient) {
		if (recipeIngredient == null) {
			return null;
		}
		
		RecipeIngredientCommand recipeIngredientCommand = new RecipeIngredientCommand();
		
		recipeIngredientCommand.setId(recipeIngredient.getId());
		
		if(recipeIngredient.getRecipe() != null) {
			recipeIngredientCommand.setRecipeId(recipeIngredient.getRecipe().getId());
		}
		
		if(recipeIngredient.getIngredient() != null) {
			recipeIngredientCommand.setIngredientId(recipeIngredient.getIngredient().getId());
			recipeIngredientCommand.setIngredientDescription(recipeIngredient.getIngredient().getDescription());
		}
		
		recipeIngredientCommand.setAmount(recipeIngredient.getAmount());
		
		if (recipeIngredient.getUnitOfMeasure() != null) {
			recipeIngredientCommand.setUnitOfMeasureId(recipeIngredient.getUnitOfMeasure().getId());
			recipeIngredientCommand.setUnitOfMeasureDescription(recipeIngredient.getUnitOfMeasure().getDescription());
		}
		
		return recipeIngredientCommand;
	}
}
