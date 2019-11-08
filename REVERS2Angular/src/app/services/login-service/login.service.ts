import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Employee } from 'src/app/classes/employee';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private router: Router, private http: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({
      'Access-Control-Allow-Origin':'*'
    })
  };

  login(username: string, password: string) {
    this.http.post('http://localhost:8082/RevERS2/login', {username, password},this.httpOptions).subscribe(data =>{
      console.log(data);
    });

  }
  getSession(): Observable<Employee>{
    return this.http.get<Employee>('http://localhost:8082/RevERS2/session', this.httpOptions);
  }

  /*getSession() {
    this.http.get<string>('http://localhost:8082/RevERS2/session', this.httpOptions).subscribe(res =>{
      console.log(res);
    });
  }*/
}
