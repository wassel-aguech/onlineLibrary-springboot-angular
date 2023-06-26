import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Category } from 'src/app/models/category';
import { BookService } from 'src/app/services/book.service';
import { CategoryService } from 'src/app/services/category.service';

@Component({
  selector: 'app-addbook',
  templateUrl: './addbook.component.html',
  styleUrls: ['./addbook.component.css']
})
export class AddbookComponent {

  bookform?: FormGroup
  submitted? = false;
  categories?: Category[];


  constructor(private router : Router , private bookservice : BookService , private categoryservice : CategoryService){}


  ngOnInit(){
    this.bookform = new FormGroup({
      title: new FormControl('', [Validators.required]),
      author: new FormControl('', [Validators.required]),
      description: new FormControl('', Validators.required),
      file: new FormControl('', Validators.required),

    })
   this.getallcategory()

  }


  onsubmit(){
    this.submitted = true
    //if(this.bookform?.invalid){
      //return
     //}
    this.bookservice.addBook(this.bookform?.value)
      .subscribe(
        Response =>alert('book added successfuly'),
        error => console.log('error!!', error),
      )
      this.router.navigate(['/book']);
  }

  getallcategory() {
    this.categoryservice.getAllCategory().subscribe((response: any) => {
      console.log(response);
      this.categories = response
    }, (error) => {
      console.log(error);
    })}



}
