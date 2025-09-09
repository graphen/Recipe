package com.szamraj.spring_guru_9_spring_webapp3.service;

import java.util.Set;

import com.szamraj.spring_guru_9_spring_webapp3.command.CategoryCommand;

public interface CategoryService {
	public Set<CategoryCommand> getAllCategories();
	public CategoryCommand findCategoryById(Long id);
	public CategoryCommand findCategoryByDescription(String description);
	public CategoryCommand saveCategory(CategoryCommand categoryCommand);
	public void deleteCategoryById(Long id);
	boolean isCategoryUsedInRecipes(Long id);
	long getRecipeCountForCategory(Long id);
}
