package com.szamraj.spring_guru_9_spring_webapp3.converter;

import com.szamraj.spring_guru_9_spring_webapp3.command.NotesCommand;
import com.szamraj.spring_guru_9_spring_webapp3.model.Notes;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class NotesToNotesCommand implements Converter<Notes, NotesCommand> {

	@Override
	public NotesCommand convert(Notes notes) {
		if (notes == null) {
			return null;
		}

		NotesCommand notesCommand = new NotesCommand();

		notesCommand.setId(notes.getId());
		notesCommand.setRecipeNotes(notes.getRecipeNotes());

		return notesCommand;
	}
}
