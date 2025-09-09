package com.szamraj.spring_guru_9_spring_webapp3.converter;

import com.szamraj.spring_guru_9_spring_webapp3.command.NotesCommand;
import com.szamraj.spring_guru_9_spring_webapp3.model.Notes;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

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
