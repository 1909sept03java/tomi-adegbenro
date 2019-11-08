import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { StudentService } from '../student.service';
import { Student } from '../student';
import { Course } from '../course';
import {FormsModule} from '@angular/forms';
import { SSL_OP_SSLEAY_080_CLIENT_DH_BUG } from 'constants';

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
    let sProfile = this.getStudentProfile(this.studentId);
    this.x = localStorage.getItem('sObj');
    console.log("AfterParsing x "+ this.x);
    console.log("AfterParsing sProfile"+ sProfile);
    this.student = JSON.parse(this.x);
    console.log("New :"+this.student.id);
    this.getMyStudentCourse(this.student.id);
    /*this.studentService.fetchAllCourses().subscribe(response =>{
      console.log(response);
    });*/

  }
  getStudentProfile(std: string){
    let studentObject ="";
    console.log("here in getStdentProfile, std/studentId is "+std)
    this.studentService.fetchPlayerById(parseInt(std)).subscribe(response =>{
      console.log("After stdentService "+ response);
     
      studentObject = JSON.stringify(response);
      localStorage.setItem('sObj',studentObject);
     console.log("studentObject: "+studentObject)
    });
    console.log("studentObject now: "+studentObject)
    //return studentObject;
    return localStorage.getItem('sObj');
  }

  getMyStudentCourse(sId :number){
    this.studentService.fetchAllCourses().subscribe(response =>{
      console.log(response);
      let len: number = Object.keys(response).length;
      for(let i = 0; i<len; i++){
        console.log(response [i]);
        console.log(response[i].students.length);
        let len2:number = response[i].students.length;
        for(let j=0; j <len2; j++){
          if(sId === response[i].students[j].id){
            this.courseList.push(response[i]);

          }
        }
       }
    })
  }

}


