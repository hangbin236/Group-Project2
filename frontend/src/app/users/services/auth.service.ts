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
    this.jobCode = user.jobCode;
  }

  getUserInfo(): void{ 
    let userData: any = sessionStorage.getItem("userInformation");
    if(userData!=null){
      return JSON.parse(userData);
    }
  }

  endUserSession(): void {
    sessionStorage.clear();
    this.isLoggedIn = false;
  }


}
