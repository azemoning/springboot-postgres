package dev.azemoning.springbootpostgres.service;

import dev.azemoning.springbootpostgres.exception.ResourceNotFoundException;
import dev.azemoning.springbootpostgres.model.Note;
import dev.azemoning.springbootpostgres.model.User;
import dev.azemoning.springbootpostgres.repository.NoteRepository;
import dev.azemoning.springbootpostgres.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Note> getUserNotes(String userId) {
        return noteRepository.findNotesByUserId(userId);
    }

    @Override
    public Note addNote(String userId, Note note) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        note.setUser(user);
        return noteRepository.save(note);
    }

    @Override
    public Note updateNote(String noteId, Note note) {
        Note findNote = noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note not found"));
        findNote.setNote(note.getNote());
        return noteRepository.save(findNote);
    }

    @Override
    public Note deleteNote(Note note) {
        noteRepository.delete(note);
        return note;
    }
}
