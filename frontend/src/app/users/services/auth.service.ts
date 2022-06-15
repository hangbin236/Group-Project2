import { Injectable } from '@angular/core';
import { User } from '../user.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  isLoggedIn: boolean = false;
  jobCode: number = 0;

  constructor() { }

  storeUserSession(user: User): void {
    sessionStorage.setItem("auth", JSON.stringify(user));
    this.isLoggedIn = true;
    this.jobCode = user.job_code;
  }

  getUserInfo(): any { 
    let userData: any = sessionStorage.getItem("auth");
    if(userData!=null){
      return JSON.parse(userData);
    }
    return null;
  }

  endUserSession(): void {
    sessionStorage.clear();
    this.isLoggedIn = false;
  }


}
