import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-adduser',
  templateUrl: './adduser.component.html',
  styleUrls: ['./adduser.component.css']
})
export class AdduserComponent {

userform? : FormGroup
submitted = false
  constructor(private userservice : UserService , private router : Router){}

  ngOnInit(){
    this.userform = new FormGroup({
      name: new FormControl('', [Validators.required]),
      lastname: new FormControl('', [Validators.required]),
      email: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required),
      role: new FormControl('', Validators.required),
    })
  }


  
  onsubmit(){
    this.submitted = true
    if(this.userform?.invalid){
      return
     }
    this.userservice.addUser(this.userform?.value)
      .subscribe(
        Response =>alert('user added successfuly'),
        error => console.log('error!!', error),

      )
      this.router.navigate(['/user']);
  }
}
