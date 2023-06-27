import { Component } from '@angular/core';
import { Book } from 'src/app/models/book';
import { BookService } from 'src/app/services/book.service';

@Component({
  selector: 'app-bookforclient',
  templateUrl: './bookforclient.component.html',
  styleUrls: ['./bookforclient.component.css']
})
export class BookforclientComponent {


  books? : Book[]


  constructor( private bookservice : BookService){}


  ngOnInit(){
this.getallbook();
  }
  getallbook() {
    this.bookservice.getAllBook().subscribe((response: any) => {
      console.log(response);
      this.books = response
    }, (error) => {
      console.log(error);
    })}

  
}
