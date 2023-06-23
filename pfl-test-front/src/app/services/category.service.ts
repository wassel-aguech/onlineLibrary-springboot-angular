import { Injectable } from '@angular/core';
import { environment } from '../anvironment/environment';
import { HttpClient } from '@angular/common/http';
import { Category } from '../models/category';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  private apiServerUrl = environment.apiBaseUrl;

  constructor( private http : HttpClient ) { }


  public getAllCategory():Observable<Category[]>{
    return this.http.get<Category[]>(`${this.apiServerUrl}/Categry/getallcategory`)
  }
  
  public addCategory(category:Category):Observable<Category>{
    return this.http.post<Category>(`${this.apiServerUrl}/Categry/addcategory` , category)
  }





}
