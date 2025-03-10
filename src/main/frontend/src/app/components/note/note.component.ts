import { Component, OnInit } from '@angular/core';
import { NoteService, Note } from '../../services/note.service';

@Component({
  selector: 'app-note',
  templateUrl: './note.component.html',
  styleUrls: ['./note.component.css']
})
export class NoteComponent implements OnInit {
  notes: string[] = [];
  newNote: Note = { title: '', content: '', name: '', description: '' };

  constructor(private noteService: NoteService) {}

  ngOnInit(): void {
    this.fetchNotes();
  }

  fetchNotes() {
    this.noteService.getNotes().subscribe(data => {
      this.notes = data;
    });
  }

  addNote() {
    if (this.newNote.title && this.newNote.content) {
      this.noteService.addNote(this.newNote).subscribe(() => {
        this.fetchNotes();
        this.newNote = { title: '', content: '', name: '', description: '' };
      });
    }
  }

  deleteNote(id: number) {
    this.noteService.deleteNote(id).subscribe(() => {
      this.fetchNotes();
    });
  }
}
