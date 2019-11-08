import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { identifierModuleUrl } from '@angular/compiler';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  all_students = 'http://localhost:8084/student/all';
  single_student = 'http://localhost:8084/student/';
  all_courses = 'http://localhost:8084/course/all';

  constructor(
    private httpClient: HttpClient//, private router: Router
  ) { }

  public fetchAllStudent() {
    return this.httpClient.get(this.all_students);
  }

  public fetchPlayerById(id: number) {
    //let id: string;
    //this.currentMessage.subscribe(message => id = message);
    //let playUrl = 'http://localhost:8082/GamingMarketplace/player/' + id;
    return this.httpClient.get(this.single_student+id);
  }

  public fetchAllCourses() {
    return this.httpClient.get(this.all_courses);
  }


}
