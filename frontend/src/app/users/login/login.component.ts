import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Form } from '@angular/forms';
import { AuthService } from '../services/auth.service';
import { UsersService } from '../services/users.service';
import { User } from '../models/user.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: User = {
    id: 0,
    password: '',
    job_code: 0,
    fname: '',
    lname: '',
    email: '',
}

  constructor(
    private userService: UsersService,
    private authService: AuthService,
    private router: Router
    ) { }

  ngOnInit(): void {
  }


  logInUser() {
    // access form data
    let loginForm = {
      'email' : this.user.email,
      'password' : this.user.password
    }

    // process formData for validation
    this.userService.getUserInfo(loginForm).subscribe(
      (response) => {
        console.log(response);
        this.user = response;
        this.authService.storeUserSession(response);
        this.router.navigateByUrl('user-account');
      },
      (error) => console.log(error)   
    );
  }

}
