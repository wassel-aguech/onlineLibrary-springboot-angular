import { Component } from '@angular/core';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent {


  users? : User[]


  constructor( private userservice : UserService){}


  ngOnInit(){
this.getalluser();
  }
  getalluser() {
    this.userservice.getAllUser().subscribe((response: any) => {
      console.log(response);
      this.users = response
    }, (error) => {
      console.log(error);
    })}


    delete(id: any) {
      this.userservice.deleteUser(id).subscribe((response: any) => {
        alert('delete succsess')
        this.getalluser();
      }, (error) => {
        console.log(error);
  
      })
    }

}
