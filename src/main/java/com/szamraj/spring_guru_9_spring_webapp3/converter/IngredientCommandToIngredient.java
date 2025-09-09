package com.szamraj.spring_guru_9_spring_webapp3.converter;

import com.szamraj.spring_guru_9_spring_webapp3.command.IngredientCommand;
import com.szamraj.spring_guru_9_spring_webapp3.model.Ingredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {

	@Override
	public Ingredient convert(IngredientCommand ingredientCommand) {
		if (ingredientCommand == null) {
			return null;
		}

		Ingredient ingredient = new Ingredient();

		ingredient.setId(ingredientCommand.getId());
		ingredient.setDescription(ingredientCommand.getDescription());

		return ingredient;
	}
}
