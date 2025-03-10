package com.astrapay.service;

import com.astrapay.dto.ExampleDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ExampleService {
    private final List<ExampleDto> notes = new ArrayList<>();
    private Long currentId = 1L;

    public List<String> getAllNotes() {
        List<String> noteStr = new ArrayList<>();
        for (ExampleDto note : notes) {
            noteStr.add(note.getId() + ": " + note.getDescription() + " (By: " + note.getName() + ")");
        }
        return noteStr;
    }

    public Optional<String> getNoteById(Long id) {
        return notes.stream()
                .filter(note -> note.getId().equals(id))
                .map(note -> note.getId() + ": " + note.getDescription() + " (By: " + note.getName() + ")")
                .findFirst();
    }

    public String createNote(ExampleDto ExampleDto) {
        ExampleDto.setId(currentId++);
        notes.add(ExampleDto);
        return ExampleDto.getId() + ": " + ExampleDto.getTitle() + " (By: " + ExampleDto.getName() + ")";
    }

    public void deleteNoteById(Long id) {
        notes.removeIf(note -> note.getId().equals(id));
    }
}