package com.szamraj.spring_guru_9_spring_webapp3.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.szamraj.recipe_app.command.RecipeCommand;
import com.szamraj.recipe_app.controller.RecipeController;
import com.szamraj.recipe_app.model.Recipe;
import com.szamraj.recipe_app.service.CategoryService;
import com.szamraj.recipe_app.service.IngredientService;
import com.szamraj.recipe_app.service.RecipeService;
import com.szamraj.recipe_app.service.UnitOfMeasureService;



class RecipeControllerTest {
	
	@Mock
	RecipeService recipeService;
	
	@Mock
	IngredientService ingredientService;
	
	@Mock
	UnitOfMeasureService unitOfMeasureService;
	
	@Mock
	CategoryService categoryService;
	
	RecipeController recipeController;
	
	ViewResolver viewResolver;
	
	@Mock
	Model model;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		recipeController = new RecipeController(recipeService, ingredientService, unitOfMeasureService, categoryService);
		viewResolver = new InternalResourceViewResolver("/", ".html");
	}

	@Test
	void testMockMVC() throws Exception {
		MockMvc mlckMVC = MockMvcBuilders.standaloneSetup(recipeController).setViewResolvers(viewResolver).build();
		mlckMVC.perform(get("/recipes"))
				.andExpect(status().isOk())
				.andExpect(view().name("recipes/list"))
				.andReturn();
	}
	
	@Test
	void testListAllRecipes() {
		//Given
		String expectedViewName = "recipes/list";
		Set<RecipeCommand> recipes = Set.of(new RecipeCommand(), new RecipeCommand());
		when(recipeService.getAllRecipes()).thenReturn(recipes);
		
		//when
		String viewName = recipeController.listRecipes(model);
		
		//then
		verify(recipeService).getAllRecipes();
		verify(model).addAttribute("recipes", recipes);
		assertEquals(expectedViewName, viewName);
		
	}
	
	@Test
	void testShowRecipe() {
		//Given
		Long recipeId = 1L;
		String expectedViewName = "recipes/detail";
		RecipeCommand recipe = new RecipeCommand();
		recipe.setId(recipeId);
		RedirectAttributes redirectAttributes = null;
		when(recipeService.findRecipeById(recipeId)).thenReturn(recipe);
		
		//when
		String viewName = recipeController.showRecipe(recipeId, model, redirectAttributes);
		
		//then
		verify(recipeService).findRecipeById(recipeId);
		verify(model).addAttribute("recipe", recipe);
		assertEquals(expectedViewName, viewName);
	}
}
