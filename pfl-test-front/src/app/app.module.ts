import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar/navbar.component';
import { FooterComponent } from './footer/footer/footer.component';
import { RegisterComponent } from './register/register/register.component';
import { LoginComponent } from './login/login/login.component';
import { FormsModule } from '@angular/forms';
import { AddcategoryComponent } from './category/addcategory/addcategory/addcategory.component';
import { CategoryComponent } from './category/category/category/category.component';
import { AddbookComponent } from './book/addbook/addbook.component';
import { BookComponent } from './book/book/book.component';
import { AdduserComponent } from './user/adduser/adduser.component';
import { UserComponent } from './user/user/user.component';
import { BookforclientComponent } from './book/bookforclient/bookforclient/bookforclient.component';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    RegisterComponent,
    LoginComponent,
    AddcategoryComponent,
    CategoryComponent,
    AddbookComponent,
    BookComponent,
    AdduserComponent,
    UserComponent,
    BookforclientComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
    
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
