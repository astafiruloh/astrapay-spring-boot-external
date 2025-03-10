package com.astrapay.service;

import java.util.List;

import com.astrapay.entity.Note;

public interface NoteService {
    List<Note> getNotes();
    Note getNotesById(Long id);
    Note saveNotes(Note note);
    void deleteById(Long id);
}