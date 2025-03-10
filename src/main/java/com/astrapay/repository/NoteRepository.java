package com.astrapay.repository;
import com.astrapay.dto.ExampleDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class NoteRepository {
    private final List<String> notes = new ArrayList<>();
    private Long currentId;

    public List<String> findAll() { 
        return notes.stream()
            .map(note -> note.getId() + ": " + note.getDescription() + " (By: " + note.getName() + ")")
            .collect(Collectors.toList());
    }

    public Optional<String> findById(Long id) {
        return notes.stream().filter(note -> note.getId().equals(id)).findFirst();
    }

    public Note save(Note note) {
        if (note.getId() == null) {
            note.setId(currentId++);
        }
        notes.add(note);
        return note;
    }

    public void deleteById(Long id) {
        notes.removeIf(note -> note.getId().equals(id));
    }
}