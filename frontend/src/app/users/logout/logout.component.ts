import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private authService: AuthService,
    private router: Router) { }

  ngOnInit(): void {

    this.authService.removeUserInfo();

    this.authService.isLoggedIn = false;

    this.authService.jobCode = 0;

    this.router.navigate(['login']);

  }

}
