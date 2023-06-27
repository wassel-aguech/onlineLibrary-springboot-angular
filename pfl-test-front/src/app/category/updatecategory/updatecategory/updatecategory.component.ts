import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CategoryService } from 'src/app/services/category.service';

@Component({
  selector: 'app-updatecategory',
  templateUrl: './updatecategory.component.html',
  styleUrls: ['./updatecategory.component.css']
})
export class UpdatecategoryComponent {

  categoryform? :FormGroup
  submitted=false
  blogform? : FormGroup
  listcategory:any;
  id:any
  constructor(private cateroryservice : CategoryService , private router: Router , private route : ActivatedRoute){}


  ngOnInit(){
    this.categoryform = new FormGroup({
      name: new FormControl('', [Validators.required]),
  
    })
    this.getonecategory();
  }

  getonecategory() {
    this.id = this.route.snapshot.params['id']
    this.cateroryservice.getCategoryById(this.id).subscribe((response) => {
      this.categoryform?.patchValue(response);
    }, (Error) => {
      console.log('error')
    })
  }

  update() {
    this.cateroryservice.updateCategory(this.id , this.categoryform?.value).subscribe((Response) => {
      alert('category updated success !!')
      this.router.navigateByUrl('/category')
    }, (Error) => {
      console.log('error')
    })
  }



}
