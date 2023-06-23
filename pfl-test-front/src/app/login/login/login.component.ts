import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  loginform? : FormGroup

constructor(){}



ngOnInit(){
  this.loginform = new FormGroup({
    title: new FormControl('', [Validators.required]),
    imageUrl: new FormControl('', [Validators.required]),
    content: new FormControl('', Validators.required),
  })
}










}
