import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Form } from '@angular/forms';
import { Observable } from 'rxjs';
import { observableToBeFn } from 'rxjs/internal/testing/TestScheduler';
import { LoginForm } from '../models/loginForm.model';
import { Reimbursement } from '../models/reimbursement.model';
import { User } from '../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  baseUrl: string = "http://ec2-3-89-88-227.compute-1.amazonaws.com:8484/api";

  
  constructor(private http: HttpClient) { }

  getUserInfo(loginForm: LoginForm): Observable<User>{
    return this.http.post<User>(this.baseUrl + "/login", loginForm);
  }

  updateEmployeeInfo(user: User): Observable<User> {

    // send http request
    return this.http.put<User>(`${this.baseUrl}/employee`, user);
  }

  getAllEmployees(): Observable<User[]> {
    return this.http.get<User[]>(`${this.baseUrl}/employee`);
  }




}
