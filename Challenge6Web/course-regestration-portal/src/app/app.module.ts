import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { StudentComponent } from './student/student.component';
import { CourseComponent } from './course/course.component';
import { HttpClientModule } from '@angular/common/http';

const appRoutes: Routes = [
  { path: 'student',      component: StudentComponent },
  { path: 'course',      component: CourseComponent }
  
];

@NgModule({
  declarations: [
    AppComponent,
    StudentComponent,
    CourseComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes, {
      onSameUrlNavigation: 'reload'
    })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
