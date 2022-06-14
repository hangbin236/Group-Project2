import { Component, OnInit } from '@angular/core';
import { AuthService } from '../users/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  // constructor(private authService: AuthService) { }
  constructor(){}

  ngOnInit(): void {
  }

  // hasLoggedIn(){
  //   return this.authService.isLoggedIn;
  // }

  // getJobCode(){
  //   return this.authService.jobCode;
  // }

}
