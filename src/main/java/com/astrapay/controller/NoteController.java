package com.astrapay.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.*;

import com.astrapay.entity.Note;
import com.astrapay.service.NoteService;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
@RequestMapping("/note")
public class NoteController {

    NoteService noteService;
    
    @GetMapping("/all")
    public ResponseEntity<List<Course>> getNotes() {
        return new ResponseEntity<>(noteService.getNotes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNotesById(@PathVariable Long id) {
        return new ResponseEntity<>(noteService.getNotes(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Course> saveNotes(@RequestBody Note note) {
        return new ResponseEntity<>(noteService.saveNotes(note), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Long id) {
        noteService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
