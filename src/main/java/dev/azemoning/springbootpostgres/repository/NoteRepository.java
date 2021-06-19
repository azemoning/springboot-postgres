package dev.azemoning.springbootpostgres.repository;

import dev.azemoning.springbootpostgres.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, String> {
    List<Note> findNotesByUserId(String userid);
    Note findNoteByUserId(String userId);
}
