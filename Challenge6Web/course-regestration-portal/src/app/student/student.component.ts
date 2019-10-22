import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})


export class StudentComponent implements OnInit {

  studentId: string;
  lastname: string;
  myStudents: any[]=[];
  Student: any[];
  constructor(
    private httpClient: HttpClient, private router:Router
  ) { }

  ngOnInit() {
    this.loadStudents();
  }
  getStudents(){
    console.log(this.httpClient.get('http://localhost:8084/student/all'));
      return this.httpClient.get('http://localhost:8084/student/all');
    
  }

  loadStudents(){
    this.getStudents().subscribe(
      response => this.handleSuccessfulResponse(response),
    );
  }

  handleSuccessfulResponse(response){
    this.Student=response;
     console.log(response);
     let len: number = Object.keys(response).length;
     console.log(len);
     for(let i = 0; i<len; i++){
      console.log(this.Student [i]);
      this.myStudents.push(this.Student[i]);
     }
    
    
  }

  profile(){
    console.log(this.studentId);
    localStorage.setItem('Student',this.studentId)
    this.router.navigate(['course'])

  }
}
