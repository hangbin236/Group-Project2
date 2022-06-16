import { Injectable } from '@angular/core';
import { User } from './user.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  isLoggedIn: boolean = false;

  jobCode: number = 0;

  constructor() { }

  storeUserInfo(user: User): void{
    sessionStorage.setItem("userInformation", JSON.stringify(user));
  }

  retreiveUserInfo(): void{
    let userData: any = sessionStorage.getItem("userInformation");
    if(userData!=null){
      return JSON.parse(userData);
    }
  }

  removeUserInfo(): void{
    sessionStorage.removeItem("userInformation");
  }
 }
