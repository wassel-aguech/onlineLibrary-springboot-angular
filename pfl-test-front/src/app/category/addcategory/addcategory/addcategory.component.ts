import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CategoryService } from 'src/app/services/category.service';

@Component({
  selector: 'app-addcategory',
  templateUrl: './addcategory.component.html',
  styleUrls: ['./addcategory.component.css']
})
export class AddcategoryComponent {

  categoryform? :FormGroup
  submitted=false

  constructor(private router : Router , private categoryservice : CategoryService){}


  ngOnInit(){

    this.categoryform = new FormGroup({
      name: new FormControl('', [Validators.required]),
  
    })
  }

  onsubmit(){
    this.submitted = true
    if(this.categoryform?.invalid){
      return
     }
    this.categoryservice.addCategory(this.categoryform?.value)
      .subscribe(
        Response =>alert('category added successfuly'),
        error => console.log('error!!', error),
      )
      this.router.navigate(['/category']);
  }


  }


