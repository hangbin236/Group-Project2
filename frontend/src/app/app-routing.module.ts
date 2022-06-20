import { NgModule } from '@angular/core';
import { Route, RouterModule, Routes } from '@angular/router'; // CLI imports router
import { CommonModule } from '@angular/common';
import { LoginComponent } from './users/login/login.component';
import { UserAccountComponent } from './users/user-account/user-account.component';


const defaultRoute: Route  = sessionStorage.getItem('auth') == null ?
  { path: '',   redirectTo: 'login', pathMatch: 'full' } :
  { path: '',   redirectTo: 'user-account', pathMatch: 'full' } ;

const routes: Routes = [

import { LogoutComponent } from './users/logout/logout.component';

const routes: Routes = [
  { path: "submit-reimbursement", component: SubmitReimbursementComponent },
  { path: "view-my-reimbursements", component: ViewMyReimbursementsComponent },
  { path: "view-all-reimbursements", component: ViewAllReimbursementsComponent },
  { path: "employee-info", component: EmployeeInfoComponent },
  { path: "login", component: LoginComponent },
  { path: "logout", component: LogoutComponent }


  
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
