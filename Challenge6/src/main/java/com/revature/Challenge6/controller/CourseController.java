package com.revature.Challenge6.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.Challenge6.model.Course;
import com.revature.Challenge6.service.CourseService;

public class CourseController {
	private CourseService courseService;
	
	@Autowired
	public void setcourseService(CourseService courseService) {
		this.courseService = courseService;
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
	
	//get method to pull firstnames
//	@RequestMapping(value = "/firstnames", method = RequestMethod.GET)
//	public ResponseEntity<List<Course>> getAllFirstNames(){
//		return new ResponseEntity<>(this.courseService.;
//	}


}
