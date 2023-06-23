import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login/login.component';
import { RegisterComponent } from './register/register/register.component';
import { AddcategoryComponent } from './category/addcategory/addcategory/addcategory.component';
import { CategoryComponent } from './category/category/category/category.component';
import { AddbookComponent } from './book/addbook/addbook.component';
import { BookComponent } from './book/book/book.component';
import { UserComponent } from './user/user/user.component';
import { AdduserComponent } from './user/adduser/adduser.component';
import { BookforclientComponent } from './book/bookforclient/bookforclient/bookforclient.component';

const routes: Routes = [

  {path : "login" , component : LoginComponent},
  {path : "register" , component : RegisterComponent},
  {path : "addcategory" , component : AddcategoryComponent},
  {path : "category" , component : CategoryComponent},
  {path : "addbook" , component : AddbookComponent},
  {path : "book" , component : BookComponent},
  {path : "user" , component : UserComponent},
  {path : "adduser" , component : AdduserComponent},
  {path : "bookforclient" , component : BookforclientComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
