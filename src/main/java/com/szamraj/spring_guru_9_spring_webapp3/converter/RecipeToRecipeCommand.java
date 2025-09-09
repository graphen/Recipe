package com.szamraj.spring_guru_9_spring_webapp3.converter;
import com.szamraj.spring_guru_9_spring_webapp3.command.RecipeCommand;
import com.szamraj.spring_guru_9_spring_webapp3.command.NotesCommand;
import com.szamraj.spring_guru_9_spring_webapp3.model.Recipe;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand> {
	
	NotesToNotesCommand notesToNotesCommand;
	RecipeIngredientToRecipeIngredientCommand recipeIngredientToRecipeIngredientCommand;
	
	public RecipeToRecipeCommand(NotesToNotesCommand notesToNotesCommand, 
			RecipeIngredientToRecipeIngredientCommand recipeIngredientToRecipeIngredientCommand) {
		this.notesToNotesCommand = notesToNotesCommand;
		this.recipeIngredientToRecipeIngredientCommand = recipeIngredientToRecipeIngredientCommand;
	}

	@Override
	public RecipeCommand convert(Recipe recipe) {
		if (recipe == null) {
			return null;
		}
		
		RecipeCommand recipeCommand = new RecipeCommand();
		
		recipeCommand.setId(recipe.getId());
		
		recipeCommand.setDescription(recipe.getDescription());
		
		recipeCommand.setCookTime(recipe.getCookTime());
		
		recipeCommand.setPrepTime(recipe.getPrepTime());
		
		recipeCommand.setServings(recipe.getServings());
		
		recipeCommand.setSource(recipe.getSource());
		
		recipeCommand.setUrl(recipe.getUrl());
		
		recipeCommand.setDirections(recipe.getDirections());
		
		if (recipe.getRecipeIngredients() != null) {
			recipe.getRecipeIngredients().forEach(ingredient -> 
				recipeCommand.getRecipeIngredients().add(recipeIngredientToRecipeIngredientCommand.convert(ingredient))
			);
		}
		
		if (recipe.getDifficulty() != null) {
			recipeCommand.setDifficulty(recipe.getDifficulty().name());
		}
		
		recipeCommand.setImage(recipe.getImage());

		if (recipe.getCategories() != null) {
			recipe.getCategories().forEach(category -> recipeCommand.getCategories().add(category.getId()));
		}
		
		if (recipe.getNotes() != null) {
		    NotesCommand notesCommand = notesToNotesCommand.convert(recipe.getNotes());
		    if (notesCommand != null) {
		        recipeCommand.setNotes(notesCommand);
		    }
		}
		
		return recipeCommand;
	}
}

