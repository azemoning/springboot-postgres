package dev.azemoning.springbootpostgres.service;

import dev.azemoning.springbootpostgres.model.Note;
import dev.azemoning.springbootpostgres.model.User;

import java.util.List;

public interface NoteService {
    List<Note> getUserNotes(String userId);
    Note addNote(String userId, Note note);
    Note updateNote(String noteId, Note note);
    Note deleteNote(Note note);
}
