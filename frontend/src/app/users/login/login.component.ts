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


  constructor(){}

  ngOnInit(): void {
  }

  // loginValidation(){
  //   this.userService.validateUser(this.user).subscribe((response)=>{
  //     console.log(response);
  //     if(response.jobCode != 0 ){

  //       // login success
  //       // send the respone to auth service and store the info in the session storage
  //       this.authService.storeUserInfo(response);

  //       // also set the isLoggedIn variable of auth service to true
  //       this.authService.isLoggedIn = true;

  //       if(response.jobCode == 200){
            
  //           this.authService.jobCode=200;
            
  //           this.router.navigate(['employee-info']);

  //       }else if(response.jobCode == 100){
            
  //           this.authService.jobCode=100;
            
  //           this.router.navigate(['employee-info']);
  //       }
  //     }else{
  //       // login failed
  //       // stay back in this component and display
  //           // an error message on the the template
  //       this.invalidMessage = "Invalid Username/Password";
  //     }
    
  //   });
  // }



}
