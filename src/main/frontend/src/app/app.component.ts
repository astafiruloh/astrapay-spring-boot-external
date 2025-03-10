import { Component, OnInit } from '@angular/core';
import { NotesService } from './services/note.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  notes: any[] = [];
  newNote = { name: '', description: '' };
  selectedNote: any = null;

  constructor(private notesService: NotesService) {}

  ngOnInit() {
    this.loadNotes();
  }

  loadNotes() {
    this.notesService.getNotes().subscribe(data => this.notes = data);
  }

  getNoteById(id: number) {
    this.notesService.getNoteById(id).subscribe(data => this.selectedNote = data);
  }

  addNote() {
    this.notesService.createNote(this.newNote).subscribe({
      next: () => {
        this.newNote = { name: '', description: '' };
        this.loadNotes();
      },
      error: err => alert(err)
    });
  }

  deleteNote(id: number) {
    this.notesService.deleteNote(id).subscribe(() => this.loadNotes());
  }
}
