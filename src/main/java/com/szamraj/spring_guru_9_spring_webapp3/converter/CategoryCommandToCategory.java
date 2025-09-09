package com.szamraj.spring_guru_9_spring_webapp3.converter;

import com.szamraj.spring_guru_9_spring_webapp3.command.CategoryCommand;
import com.szamraj.spring_guru_9_spring_webapp3.model.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

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
