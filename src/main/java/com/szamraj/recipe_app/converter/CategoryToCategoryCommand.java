package com.szamraj.recipe_app.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.szamraj.recipe_app.command.CategoryCommand;
import com.szamraj.recipe_app.model.Category;

@Component
public class CategoryToCategoryCommand implements Converter<Category, CategoryCommand> {

	@Override
	public CategoryCommand convert(Category category) {
		if(category == null) {
			return null;
		}
		
		CategoryCommand categoryCommand = new CategoryCommand();
		
		categoryCommand.setId(category.getId());
		categoryCommand.setDescription(category.getDescription());
		
		return categoryCommand;
	}
}
