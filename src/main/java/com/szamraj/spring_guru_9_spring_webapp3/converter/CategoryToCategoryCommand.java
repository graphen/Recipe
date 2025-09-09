package com.szamraj.spring_guru_9_spring_webapp3.converter;

import com.szamraj.spring_guru_9_spring_webapp3.command.CategoryCommand;
import com.szamraj.spring_guru_9_spring_webapp3.model.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

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
