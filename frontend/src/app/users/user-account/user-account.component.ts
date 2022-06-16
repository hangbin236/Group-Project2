import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { UsersService } from '../services/users.service';
import { User } from '../models/user.model';
import { Reimbursement } from '../models/reimbursement.model';
import { ReimbursementsService } from '../services/reimbursements.service';


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
    private router: Router,
    private reimbursementService: ReimbursementsService
  ) { }

  ngOnInit(): void {
    this.getPersonalInfo();
    this.getEmployeeReimbursementRequests(this.user.emp_id);
  }

  // render user's personal info to the DOM
  getPersonalInfo(): void {
    this.userInfoPending = true;
    this.user = this.authService.getUserInfo() as User;
    this.userInfoPending = false;
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
    this.requestLoading = true;
    this.reimbursementService.getEmployeeReimbursementRequests(userId)
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

  getAllRequest(): void {
    this.employeeReimbursements = this.reimbursementService.getAllReimbursementRequest();
  }

  getPendingRequest(): void {
    this.employeeReimbursements = this.reimbursementService.getPendingReimbursementRequest();
  }

  getResolvedRequest(): void {
    this.employeeReimbursements = this.reimbursementService.getResolvedReimbursementRequest();
  }

  getRejectedRequest(): void {
    this.employeeReimbursements = this.reimbursementService.getRejectedReimbursementRequest();
  }


  // create ne request
  generateReimbursementRequest(): void {
    this.reimbursementService.generateReimbursementRequest(this.user.emp_id)
    .subscribe(
      (response) => {
        // when request is successful
        console.log(response);
        // retrieve data for DOM
       // this.getEmployeeReimbursementRequests(this.user.emp_id);
      },
      (err) => {
        // must change backend response to json
        console.log(err.message);

      }
    );
  }

  


}
