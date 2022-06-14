import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { SubmitReimbursementComponent } from './reimbursements/submit-reimbursement/submit-reimbursement.component';
import { ViewMyReimbursementsComponent } from './reimbursements/view-my-reimbursements/view-my-reimbursements.component';
import { EmployeeInfoComponent } from './employee/employee-info/employee-info.component';
import { LoginComponent } from './users/login/login.component';
import { LogoutComponent } from './users/logout/logout.component';

import { ViewAllReimbursementsComponent } from './reimbursements/view-all-reimbursements/view-all-reimbursements.component';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    SubmitReimbursementComponent,
    ViewMyReimbursementsComponent,
    EmployeeInfoComponent,
    LoginComponent,
    LogoutComponent,
    ViewAllReimbursementsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
