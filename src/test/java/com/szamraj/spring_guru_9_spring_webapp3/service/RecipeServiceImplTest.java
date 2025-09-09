package com.szamraj.spring_guru_9_spring_webapp3.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Set;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.szamraj.spring_guru_9_spring_webapp3.model.Recipe;
import com.szamraj.spring_guru_9_spring_webapp3.command.RecipeCommand;
import com.szamraj.spring_guru_9_spring_webapp3.repository.RecipeRepository;
import com.szamraj.spring_guru_9_spring_webapp3.converter.RecipeToRecipeCommand;
import com.szamraj.spring_guru_9_spring_webapp3.converter.RecipeCommandToRecipe;


class RecipeServiceImplTest {
	
	RecipeService recipeService;
	
	@Mock
	RecipeRepository recipeRepository;
	
	@Mock
	RecipeToRecipeCommand receipeToReceipeCommand;
	
	@Mock
	RecipeCommandToRecipe receipeCommandToRecipe;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		when(recipeRepository.findAll()).thenReturn(Set.of(new Recipe(), new Recipe()));

		recipeService = new RecipeServiceImpl(recipeRepository, receipeToReceipeCommand, receipeCommandToRecipe);
	}

	@Test
	void testGetAllRecipes() {
		Recipe r1 = new Recipe();
		Recipe r2 = new Recipe();
		Iterable<Recipe> recipes = Set.of(r1, r2);
		RecipeCommand rc1 = new RecipeCommand();
		RecipeCommand rc2 = new RecipeCommand();
		when(receipeToReceipeCommand.convert(r1)).thenReturn(rc1);
		when(receipeToReceipeCommand.convert(r2)).thenReturn(rc2);
		when(recipeRepository.findAll()).thenReturn(recipes);
		
		Set<RecipeCommand> resipes = recipeService.getAllRecipes();
		assertEquals(2, resipes.size());
		verify(recipeRepository, times(1)).findAll();
	}
	
	@Test
	void testGetRecipeById() {
		Recipe recipe = new Recipe();
		recipe.setId(1L);
		when(recipeRepository.findById(anyLong())).thenReturn(Optional.of(recipe));
		RecipeCommand recipeCommand = new RecipeCommand();
		recipeCommand.setId(1L);
		when(receipeToReceipeCommand.convert(recipe)).thenReturn(recipeCommand);
		
		RecipeCommand foundRecipe = recipeService.findRecipeById(1L);
		assertNotNull(foundRecipe);
		assertEquals(1L, foundRecipe.getId());
		verify(recipeRepository, times(1)).findById(1L);
	}

}
