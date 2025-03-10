import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class NotesService {
  private apiUrl = 'http://localhost:8080/notes';

  constructor(private http: HttpClient) {}

  getNotes(): Observable<any> {
    return this.http.get<any>(this.apiUrl);
  }

  getNoteById(id: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/${id}`);
  }

  createNote(note: any): Observable<any> {
    if (!note.name || !note.description) {
      return new Observable(observer => {
        observer.error('Note name and description cannot be empty');
      });
    }
    return this.http.post<any>(this.apiUrl, note);
  }

  deleteNote(id: number): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/${id}`);
  }
}