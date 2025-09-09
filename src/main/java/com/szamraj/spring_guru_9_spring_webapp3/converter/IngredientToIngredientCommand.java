package com.szamraj.spring_guru_9_spring_webapp3.converter;

import com.szamraj.spring_guru_9_spring_webapp3.command.IngredientCommand;
import com.szamraj.spring_guru_9_spring_webapp3.model.Ingredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

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
