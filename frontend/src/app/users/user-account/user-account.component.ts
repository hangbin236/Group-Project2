import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { UsersService } from '../services/users.service';
import { User } from '../models/user.model';
import { Reimbursement } from '../models/reimbursement.model';


@Component({
  selector: 'app-user-account',
  templateUrl: './user-account.component.html',
  styleUrls: ['./user-account.component.css']
})
export class UserAccountComponent implements OnInit {

  user: User = {
    emp_id: 0,
    password: '',
    job_code: 0,
    fname: '',
    lname: '',
    email: '',
  }
  userInfoPending: boolean = true;
  requestLoading: boolean = true;
  employeeReimbursements: Reimbursement[] = [];
  

 

  constructor(
    private authService: AuthService,
    private userService: UsersService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.getPersonalInfo();
    this.getEmployeeReimbursementRequests(this.user.emp_id);
  }

  // render user's personal info to the DOM
  getPersonalInfo(): void {
    this.user = this.authService.getUserInfo() as User;
  }

  updateEmployeeInfo(): void {
    this.userService.updateEmployeeInfo(this.user)
    .subscribe(
      (response) => {
        // when request is successful
        console.log(response);
        // update session
        sessionStorage.setItem('auth', JSON.stringify(this.user));
      },
      (err) => {
        console.log(err);

      }
    );
  }

  getEmployeeReimbursementRequests(userId: number): void {
    this.userService.getEmployeeReimbursementRequests(userId)
    .subscribe(
      (response) => {
        // when request is successful
        console.log(response);
        
        this.employeeReimbursements = response;
        // update session
        sessionStorage.setItem('reimbursements', JSON.stringify(this.employeeReimbursements));
        this.requestLoading = false;
      },
      (err) => {
        this.requestLoading = false;
        console.log(err);
      }
    );
  }

  


}
