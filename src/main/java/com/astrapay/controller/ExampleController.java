package com.astrapay.controller;

import com.astrapay.dto.ExampleDto;
import com.astrapay.exception.ExampleException;
import com.astrapay.service.ExampleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "ExampleController")
@Slf4j
public class ExampleController {
    private final ExampleService exampleService;

    @Autowired
    public ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @GetMapping
    @ApiOperation(value = "Get all notes")
    @ApiResponses(
            value = {
                        @ApiResponse(code = 200, message = "OK", response = String.class)
            }
    )
    public ResponseEntity<List<String>> getAllNotes() {
        return ResponseEntity.ok(ExampleService.getAllNotes());
    }

    @GetMapping("/get/{id}")
    @ApiOperation(value = "Get note by ID")
    @ApiResponses(
            value = {
                        @ApiResponse(code = 200, message = "OK", response = String.class)
            }
    )
    public ResponseEntity<Optional<String>> getNoteById(@PathVariable String id) {
        return ResponseEntity.ok(ExampleService.getNoteById(id));
    }

    @PostMapping
    @ApiOperation(value = "Create a new note")
    @ApiResponses(
            value = {
                        @ApiResponse(code = 201, message = "Created", response = String.class)
            }
    )
    public ResponseEntity<String> createNote(@RequestBody @Validated ExampleDto ExampleDto) {
        log.info("Creating new note: {} by {}", ExampleDto.getId(), ExampleDto.getName());
        Note note = new Note(null, ExampleDto.getId(), ExampleDto.getName(), ExampleDto.getDescription());
        return ResponseEntity.status(HttpStatus.CREATED).body(ExampleService.createNote(note));
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Delete a note by ID")
    @ApiResponses(
            value = {
                        @ApiResponse(code = 204, message = "No Content")
            }
    )
    public ResponseEntity<Void> deleteNoteById(@PathVariable String id) {
        ExampleService.deleteNoteById(id);
        return ResponseEntity.noContent().build();
    }
}

