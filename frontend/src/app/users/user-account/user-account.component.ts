import { Component, OnInit } from '@angular/core';
import { ChildActivationStart, Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { UsersService } from '../services/users.service';
import { User } from '../user.model';


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

  constructor(
    private authService: AuthService,
    private userService: UsersService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.getPersonalInfo();
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
      (err) => console.log(err),
    );
  }

}
