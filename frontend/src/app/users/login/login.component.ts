import { Component, OnInit } from '@angular/core';
import { last } from 'rxjs';
import { User } from '../user.model';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: User ={
    
    password: '',
    jobcode: '',
    fname: '',
    lname:'',
    email: '',

  }  

  constructor() { }

  ngOnInit(): void {
  }

}
