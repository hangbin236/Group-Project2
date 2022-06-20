import { Injectable } from '@angular/core';
import { User } from '../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {


  constructor() { }

  storeUserSession(user: User): void {
    sessionStorage.setItem("auth", JSON.stringify(user));
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
  }


}
