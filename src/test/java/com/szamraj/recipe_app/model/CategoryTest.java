package com.szamraj.recipe_app.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.szamraj.recipe_app.model.Category;
import com.szamraj.recipe_app.model.Recipe;

class CategoryTest {

	Category category;

	@BeforeEach
	void setUp() throws Exception {
		category = new Category();
	}

	@Test
	void testGetId() {
		Long id = 42L;
		category.setId(id);
		assertEquals(id, category.getId());
	}

	@Test
	void testGetDescription() {
		String desc = "Test Description";
		category.setDescription(desc);
		assertEquals(desc, category.getDescription());
	}

	@Test
	void testGetRecipes() {
		Set<Recipe> recipes = new HashSet<>();
		Recipe recipe = new Recipe();
		recipes.add(recipe);
		category.setRecipes(recipes);
		assertEquals(recipes, category.getRecipes());
	}

}