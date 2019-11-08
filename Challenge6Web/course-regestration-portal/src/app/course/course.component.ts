import { Component, OnInit } from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.css']
})
export class CourseComponent implements OnInit {
 // Student: 
  Course: any[];
  myCourses: any[]=[];
  constructor(
    private httpClient: HttpClient, private router:Router
  ) { }

  ngOnInit() {
    this.loadCourse();
  }

  driver(){
    console.log(localStorage.getItem('Student'))
    let studentId = localStorage.getItem('Student');
    //loadStudent(studentId);


  }
  getCourses(){
    console.log(this.httpClient.get('http://localhost:8084/course/all'));
    return this.httpClient.get('http://localhost:8084/course/all');
  
  }
  
  loadCourse(){
    this.getCourses().subscribe(
      response =>this.handleSuccessfulResponse(response),
    );
  }
  handleSuccessfulResponse(response){
    this.Course=response;
     console.log(response);
     let len: number = Object.keys(response).length;
     console.log(len);
     for(let i = 0; i<len; i++){
      console.log(this.Course[i]);
      this.myCourses.push(this.Course[i]);
     }
    
    
  }
}

