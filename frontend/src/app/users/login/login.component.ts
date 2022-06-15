import { Component, OnInit } from '@angular/core';
import { last } from 'rxjs';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { User } from '../user.model';
import { UsersService } from '../users.service';


@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  

  invalidMessage: string = "";

  user: User = {
    id: 0,
    password: '',
    jobCode: 0,
    firstName: '',
    lastName: '',
    email: ''
  }

  // constructor removes the login form, need to fix

  // constructor(private userService: UsersService,
  //   private authService: AuthService,
  //   private router: Router) { }



  constructor(){}

  ngOnInit(): void {
  }

  // loginValidation(){
  //   this.userService.validateUser(this.user).subscribe((response)=>{
  //     console.log(response);
  //     if(response.jobCode != 0 ){

  //       this.authService.storeUserInfo(response);

        
  //       this.authService.isLoggedIn = true;

  //       if(response.jobCode == 200){
            
  //           this.authService.jobCode=200;
            
  //           this.router.navigate(['employee-info']);

  //       }else if(response.jobCode == 100){
            
  //           this.authService.jobCode=100;
            
  //           this.router.navigate(['employee-info']);
  //       }
  //     }else{this.invalidMessage = "Invalid Username/Password";}
    
  //   });
  // }



}
