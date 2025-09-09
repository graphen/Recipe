package com.szamraj.recipe_app.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.szamraj.recipe_app.command.RecipeCommand;
import com.szamraj.recipe_app.model.Category;
import com.szamraj.recipe_app.model.Difficulty;
import com.szamraj.recipe_app.model.Notes;
import com.szamraj.recipe_app.model.Recipe;
import com.szamraj.recipe_app.model.RecipeIngredient;
import com.szamraj.recipe_app.repository.CategoryRepository;

import java.util.Optional;

@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {
	
	RecipeIngredientCommandToRecipeIngredient recipeIngredientCommandToRecipeIngredient;
	NotesCommandToNotes notesCommandToNotes;
	CategoryRepository categoryRepository;
	
	public RecipeCommandToRecipe(RecipeIngredientCommandToRecipeIngredient recipeIngredientCommandToRecipeIngredient,
			NotesCommandToNotes notesCommandToNotes, CategoryRepository categoryRepository) {
		super();
		this.recipeIngredientCommandToRecipeIngredient = recipeIngredientCommandToRecipeIngredient;
		this.notesCommandToNotes = notesCommandToNotes;
		this.categoryRepository = categoryRepository;
	}
	
	@Override
	public Recipe convert(RecipeCommand recipeCommand) {
		if (recipeCommand == null) {
			return null;
		}
		
		Recipe recipe = new Recipe();
		
		recipe.setId(recipeCommand.getId());
		
		recipe.setDescription(recipeCommand.getDescription());
		
		recipe.setCookTime(recipeCommand.getCookTime());
		
		recipe.setPrepTime(recipeCommand.getPrepTime());
		
		recipe.setServings(recipeCommand.getServings());
		
		recipe.setSource(recipeCommand.getSource());
		
		recipe.setUrl(recipeCommand.getUrl());
		
		recipe.setDirections(recipeCommand.getDirections());
		
		if (recipeCommand.getRecipeIngredients() != null) {
			recipeCommand.getRecipeIngredients().forEach(ingredientCommand -> {
				RecipeIngredient ingredient = recipeIngredientCommandToRecipeIngredient.convert(ingredientCommand);
				ingredient.setRecipe(recipe); //IMPORTANT - set the parent recipe
				recipe.getRecipeIngredients().add(ingredient);
			});
		}
		
		recipe.setDifficulty(recipeCommand.getDifficulty() != null ? 
			Difficulty.valueOf(recipeCommand.getDifficulty()) : null);
		
	    if (recipeCommand.getImage() != null) {
	        recipe.setImage(recipeCommand.getImage());
	    }
		
		if (recipeCommand.getCategories() != null) {
			recipeCommand.getCategories().forEach(categoryId -> {
				Optional<Category> category = categoryRepository.findById(categoryId);
				if (category.isPresent()) {
					recipe.getCategories().add(category.get());
				}
			});
		}
		
		if (recipeCommand.getNotes() != null) {
			Notes notes = notesCommandToNotes.convert(recipeCommand.getNotes());
	        if (notes != null) {
	            notes.setRecipe(recipe); // IMPORTANT: set recipe reference in notes if needed
	        }
			recipe.setNotes(notes);
		}
		
		return recipe;
	}
}
