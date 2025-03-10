package com.astrapay.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.astrapay.entity.Note;
import com.astrapay.exception.NoteNotFoundException;
import com.astrapay.repository.NoteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class NoteServiceImpl implements NoteService {

    NoteRepository repo;

    public List<Note> getNotes() {
        return (List<Note>) repo.getNotes();
    }

    public Note getNotesById(Long id) {
        Optional<Note> Note = repo.getNotesById(id);
        if(Note.isPresent()) return Note.get();
        else throw new NoteNotFoundException(id);
    }

    public Note saveNotes(Note note) {
        Note note = repo.getNotesById(note.getId()).get();
        note.setName(note.getName());
        note.setDescription(note.getDescription());
        return repo.saveNotes(note);
    }

    public void deleteById(Long id) {      
        repo.deleteById(id);
    }
}
