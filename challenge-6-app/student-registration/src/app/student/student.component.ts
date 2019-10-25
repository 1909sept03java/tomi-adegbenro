import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { StudentService } from '../student.service';
import { Student } from '../student';
import { Course } from '../course';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {

  studentId: string;
  student: Student = {id:0, firstname:"", lastname:""};
  courseList: Course[] = [];
  x: any;
  constructor(public studentService: StudentService, public router:Router
    ) { }

  ngOnInit() {
    this.studentId = localStorage.getItem('studentId');
    console.log("Here in Student is: "+this.studentId);
    //this.x = this.getStudentProfile;
    this.getStudentProfile(this.studentId);
    this.x = localStorage.getItem('sObj');
    console.log("AfterParsing "+ this.x);
    this.student = JSON.parse(this.x);
    console.log("New :"+this.student.id)

  }
  getStudentProfile(std: string){
    
    this.studentService.fetchPlayerById(parseInt(std)).subscribe(response =>{
      console.log(response);
     
      let studentObject = JSON.stringify(response);
      localStorage.setItem('sObj',studentObject);
      
    });
    
  }

}


