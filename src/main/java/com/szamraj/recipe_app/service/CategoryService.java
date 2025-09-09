package com.szamraj.recipe_app.service;

import java.util.Set;

import com.szamraj.recipe_app.command.CategoryCommand;

public interface CategoryService {
	public Set<CategoryCommand> getAllCategories();
	public CategoryCommand findCategoryById(Long id);
	public CategoryCommand findCategoryByDescription(String description);
	public CategoryCommand saveCategory(CategoryCommand categoryCommand);
	public void deleteCategoryById(Long id);
	boolean isCategoryUsedInRecipes(Long id);
	long getRecipeCountForCategory(Long id);
}
