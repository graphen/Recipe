package com.szamraj.recipe_app.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.szamraj.recipe_app.command.NotesCommand;
import com.szamraj.recipe_app.model.Notes;

@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {

	@Override
	public Notes convert(NotesCommand notesCommand) {
		if (notesCommand == null) {
			return null;
		}
		
		Notes notes = new Notes();
		
		notes.setId(notesCommand.getId());
		notes.setRecipeNotes(notesCommand.getRecipeNotes());
		
		return notes;
	}
}
