package com.revature.Challenge6.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.Challenge6.model.Course;
import com.revature.Challenge6.model.Student;
import com.revature.Challenge6.service.CourseService;
import com.revature.Challenge6.service.StudentService;

@RestController
@RequestMapping(value = "/course")

public class CourseController {
	private CourseService courseService;
	private StudentService studentService;

	@Autowired
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
	
	@Autowired
	public void setstudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Course>> getAll(){
		return new ResponseEntity<>(this.courseService.allCourses(), HttpStatus.OK);
	}
	
	@RequestMapping(value ="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Course> getCourseById(@PathVariable int id){
		Course c = this.courseService.getCourseById(id);
		if (c ==null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND); 
		}else {
			return new ResponseEntity<>(c, HttpStatus.OK);
		}
	}
	
	@PostMapping("/addCourse")
	public ResponseEntity<String> addCourse(@RequestBody Course course){
		ResponseEntity<String> resp = null;
		try {
			this.courseService.addCourse(course);
			resp = new ResponseEntity<>("Course added SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<>("FAILED to add Course", HttpStatus.BAD_REQUEST);
		}
		return resp;
			
	}
	
	//@GetMapping("/enroll")
	@PutMapping("/enroll")
	//@PatchMapping("/enroll")
	//public ResponseEntity<String> updateCourseWithStudent(@RequestBody Course course, Student student){
	//public ResponseEntity<String> updateCourseWithStudent(@RequestBody int courseId, int studentId){
	public ResponseEntity<String> updateCourseWithStudent(@RequestParam("courseId") int courseId, @RequestParam("studentId") int studentId){
	//public ResponseEntity<String> updateCourseWithStudent(@RequestParam("courseId") int courseId){
	//public ResponseEntity<String> updateCourseWithStudent(@RequestBody Course course){
		System.out.println("studentId: "+studentId);
		Student student = this.studentService.getStudentById(studentId);
		Course course = this.courseService.getCourseById(courseId);
		//System.out.println(course.getCourseName());
		System.out.println(student.getFirstname());
		try {
			course.getStudents().add(student);
			System.out.println("course: "+course);
			System.out.println("student: "+student);
			this.courseService.updateCourse(course);
		} catch (Exception e1) {
			e1.printStackTrace();
			return new ResponseEntity<>("Something in the back end has an issue",HttpStatus.BAD_REQUEST);
		}
		return  new ResponseEntity<>("Success",HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update",method = RequestMethod.PUT)
	public ResponseEntity<String> updateCourse(@Valid @RequestBody Course c) {
		ResponseEntity<String> resp = null;
		try {
			this.courseService.updateCourse(c);
			resp = new ResponseEntity<>("Course update SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<>("FAILED TO update Course", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteStudent(@RequestBody Course course) {
		ResponseEntity<String> resp = null;
		try {
			this.courseService.deleteCourse(course);
			resp = new ResponseEntity<>("STUDENT DELETED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<>("FAILED TO DELETE COURSE", HttpStatus.BAD_REQUEST);
		}
		
		return resp;
		
	}


}
