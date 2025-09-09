package com.szamraj.recipe_app.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.szamraj.recipe_app.command.IngredientCommand;
import com.szamraj.recipe_app.model.Ingredient;

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {
	
	@Override
	public IngredientCommand convert(Ingredient ingredient) {
		if (ingredient == null) {
			return null;
		}

		IngredientCommand ingredientCommand = new IngredientCommand();

		ingredientCommand.setId(ingredient.getId());
		ingredientCommand.setDescription(ingredient.getDescription());

		return ingredientCommand;
	}	
}
