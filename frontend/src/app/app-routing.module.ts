import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SubmitReimbursementComponent } from './reimbursements/submit-reimbursement/submit-reimbursement.component';
import { ViewMyReimbursementsComponent } from './reimbursements/view-my-reimbursements/view-my-reimbursements.component';
import { LoginComponent } from './users/login/login.component';

const routes: Routes = [
  { path: "submit-reimbursement", component: SubmitReimbursementComponent },
  { path: "view-my-reimbursements", component: ViewMyReimbursementsComponent },
  { path: "login", component: LoginComponent }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
