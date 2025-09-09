package com.szamraj.recipe_app.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.szamraj.recipe_app.command.CategoryCommand;
import com.szamraj.recipe_app.model.Category;

@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category> {
	
	@Override
	public Category convert(CategoryCommand categoryCommand) {
		if(categoryCommand == null) {
			return null;
		}
		
		Category category = new Category();
		
		category.setId(categoryCommand.getId());
		category.setDescription(categoryCommand.getDescription());
		
		return category;
	}
}
