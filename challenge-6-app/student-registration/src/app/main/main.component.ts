import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import { StudentService } from '../student.service';
import { Student } from '../student';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  studentId: any;
  myStudents: any[]=[];
  Student: Student [] = [];

  constructor(public studentService: StudentService, public router:Router
    ) { }

  ngOnInit() {
    this.studentService.fetchAllStudent().subscribe(response =>{
      let len: number = Object.keys(response).length;
     console.log(len);
     for(let i = 0; i<len; i++){
      console.log(response [i]);
      this.Student.push(response[i]);
     }
    });
  }

  profile(){
    console.log(this.studentId);
    //Student
    localStorage.setItem('studentId',this.studentId);
    this.router.navigate(['student']);

  }

  //allStudents

}
