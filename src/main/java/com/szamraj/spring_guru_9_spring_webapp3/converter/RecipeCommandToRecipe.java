package com.szamraj.spring_guru_9_spring_webapp3.converter;

import com.szamraj.spring_guru_9_spring_webapp3.command.RecipeCommand;
import com.szamraj.spring_guru_9_spring_webapp3.model.Recipe;
import com.szamraj.spring_guru_9_spring_webapp3.model.RecipeIngredient;
import com.szamraj.spring_guru_9_spring_webapp3.model.Category;
import com.szamraj.spring_guru_9_spring_webapp3.repository.CategoryRepository;
import com.szamraj.spring_guru_9_spring_webapp3.model.Difficulty;
import com.szamraj.spring_guru_9_spring_webapp3.model.Notes;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
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
