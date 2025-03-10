package com.astrapay.repository;

import com.astrapay.entity.Note;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import java.util.*;;

@Repository
public interface NoteRepository extends CrudRepository<Note, Long>{
    Optional<Note> getNotes();
    Optional<Note> getNotesById(Long id);
    void saveNotes(Note note);
    void deleteById(Long id);
}