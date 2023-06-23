import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Category } from 'src/app/models/category';
import { CategoryService } from 'src/app/services/category.service';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent {
  categories?: Category[];



  constructor(private router : Router ,private  categoryservice  : CategoryService){}

  ngOnInit(){

  }
  getallcategory() {
    this.categoryservice.getAllCategory().subscribe((response: any) => {
      console.log(response);
      this.categories = response
    }, (error) => {
      console.log(error);
    })}
}
