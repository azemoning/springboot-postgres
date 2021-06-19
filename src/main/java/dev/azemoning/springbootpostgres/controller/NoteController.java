package dev.azemoning.springbootpostgres.controller;

import dev.azemoning.springbootpostgres.model.Note;
import dev.azemoning.springbootpostgres.model.User;
import dev.azemoning.springbootpostgres.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @GetMapping("note/{userId}")
    public ResponseEntity<Object> getUserNotes(@PathVariable String userId) {
        return new ResponseEntity<>(noteService.getUserNotes(userId), HttpStatus.OK);
    }

    @PostMapping("note/{userId}")
    public ResponseEntity<Object> addUserNote(@PathVariable String userId, @RequestBody Note note) {
        return new ResponseEntity<>(noteService.addNote(userId, note), HttpStatus.CREATED);
    }

    @PutMapping("note/{userId}/{id}")
    public ResponseEntity<Object> updateUserNote(Note note, @RequestBody Note updatedNote) {
        return new ResponseEntity<>(noteService.updateNote(note.getId(), updatedNote), HttpStatus.OK);
    }

    @DeleteMapping("note/{userId}/{id}")
    public ResponseEntity<Object> deleteUserNote(Note note) {
        return new ResponseEntity<>(noteService.deleteNote(note), HttpStatus.OK);
    }
}
