package com.astrapay.exception;

public class NoteEmptyException extends RuntimeException { 

    public NoteEmptyException() {
        super("The note cannot be save");
    }
    
}