import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './user.model';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  baseUrl: string = "http://localhost:7474/users";

  constructor(private http: HttpClient) { }

  validateUser(user: User): Observable<User>{
    return this.http.post<User>(this.baseUrl, user);

  }
}
