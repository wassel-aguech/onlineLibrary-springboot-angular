import { Injectable } from '@angular/core';
import { environment } from '../anvironment/environment';
import { HttpClient } from '@angular/common/http';
import { Book } from '../models/book';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http : HttpClient   ) { }


  
  public getAllBook():Observable<Book[]>{
    return this.http.get<Book[]>(`${this.apiServerUrl}/Book/all`)
  }
  
  public addBook(book:Book):Observable<Book>{
    return this.http.post<Book>(`${this.apiServerUrl}/Book/add` , book)
  }

  public deleteBook(bookId: number):Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/Book/delete/${bookId}`)
  }


}
