import { Component, OnInit } from '@angular/core';
import { LoginService } from '../services/login-service/login.service';
import { Employee } from '../classes/employee';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string = null;
  password: string = null;
  employee: Employee = null;

  constructor(public loginService: LoginService) { }

  ngOnInit() {

  }

  loginUser(){
    this.loginService.login(this.username, this.password);
    console.log(this.username);
    console.log(this.password);
    /*this.loginService.getSession().subscribe(data => {
      this.employee = data;
      console.log(data);
    });*/
    this.loginService.getSession();

  }

}
