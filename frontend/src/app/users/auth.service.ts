import { Injectable } from '@angular/core';
import { User } from './user.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  // the prupose of this service is to set, get and remove a session storage item
  // also it will help to know is a user logged in or not
  // also it will help to know the role of the user who has logged in

  // varibale which tells whether a user is logged in or not
  isLoggedIn: boolean = false;

  //variable which tells the role of the user who has logged in
  jobCode: number = 0;

  constructor() { }

  storeUserInfo(user: User): void{
    sessionStorage.setItem("userInformation", JSON.stringify(user));
  }

  retreiveUserInfo(): void{
    //return JSON.parse(sessionStorage.getItem("userInformation"));
  }

  removeUserInfo(): void{
    sessionStorage.removeItem("userInformation");
  }
}
