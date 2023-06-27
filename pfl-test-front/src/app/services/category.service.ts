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
    return this.http.get<Category[]>(`${this.apiServerUrl}/Category/all`)
  }

  getCategoryById(id: any) {
    return this.http.get(`${this.apiServerUrl}/Category/find/${id}`)
  }
  
  public addCategory(category:Category):Observable<Category>{
    return this.http.post<Category>(`${this.apiServerUrl}/Category/add` , category)
  }

  public deleteCategory(categoryId: number):Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/Category/delete/${categoryId}`)
  }

  public updateCategory(id :any ,category:Category):Observable<Category>{
    return this.http.put<Category>(`${this.apiServerUrl}/Category/update/${id}`, category)
  }



}
