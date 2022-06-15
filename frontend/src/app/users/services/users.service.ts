import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Form } from '@angular/forms';
import { Observable } from 'rxjs';
import { User } from '../user.model';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  baseUrl: string = "http://localhost:7474/login";
  
  constructor(private http: HttpClient) { }

  getUserInfo(formData: any): Observable<User>{
    console.log(formData);
    return this.http.post<User>(this.baseUrl, formData);
  }
}
