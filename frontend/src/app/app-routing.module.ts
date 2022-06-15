import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { EmployeeInfoComponent } from './employee/employee-info/employee-info.component';
import { SubmitReimbursementComponent } from './reimbursements/submit-reimbursement/submit-reimbursement.component';
import { ViewAllReimbursementsComponent } from './reimbursements/view-all-reimbursements/view-all-reimbursements.component';
import { ViewMyReimbursementsComponent } from './reimbursements/view-my-reimbursements/view-my-reimbursements.component';
import { LoginComponent } from './users/login/login.component';
import { LogoutComponent } from './users/logout/logout.component';

const routes: Routes = [
  { path: "submit-reimbursement", component: SubmitReimbursementComponent },
  { path: "view-my-reimbursements", component: ViewMyReimbursementsComponent },
  { path: "dashboard", component: DashboardComponent },
  { path: "view-all-reimbursements", component: ViewAllReimbursementsComponent },
  { path: "employee-info", component: EmployeeInfoComponent },
  { path: "login", component: LoginComponent },
  { path: "logout", component: LogoutComponent }

  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
