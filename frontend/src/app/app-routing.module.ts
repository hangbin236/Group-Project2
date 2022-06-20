import { NgModule } from '@angular/core';
import { Route, RouterModule, Routes } from '@angular/router'; // CLI imports router
import { CommonModule } from '@angular/common';
import { LoginComponent } from './users/login/login.component';
import { UserAccountComponent } from './users/user-account/user-account.component';


const defaultRoute: Route  = sessionStorage.getItem('auth') == null ?
  { path: '',   redirectTo: 'login', pathMatch: 'full' } :
  { path: '',   redirectTo: 'user-account', pathMatch: 'full' } ;

const routes: Routes = [
  
  defaultRoute,    
  { path: 'login', component: LoginComponent},
  { path: 'user-account', component: UserAccountComponent},
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
    CommonModule
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
