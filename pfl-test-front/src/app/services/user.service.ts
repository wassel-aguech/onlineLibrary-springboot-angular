import { Injectable } from '@angular/core';
import { environment } from '../anvironment/environment';
import { HttpClient } from '@angular/common/http';
import { User } from '../models/user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http : HttpClient   ) { }


  
  public getAllUser():Observable<User[]>{
    return this.http.get<User[]>(`${this.apiServerUrl}/User/getalluser`)
  }
  
  public addUser(user:User):Observable<User>{
    return this.http.post<User>(`${this.apiServerUrl}/Book/adduser` , user)
  }}
