package com.ltp.gradesubmission.exception;

public class NoteNotFoundException extends RuntimeException { 

    public NoteNotFoundException(Long id) {
        super("The Note id '" + id + "' does not exist in our records");
    }
    
}