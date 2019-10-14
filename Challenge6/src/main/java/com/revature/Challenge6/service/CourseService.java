package com.revature.Challenge6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.Challenge6.model.Course;
import com.revature.Challenge6.model.Student;
import com.revature.Challenge6.repository.CourseRepository;

@Service
public class CourseService {
	
	private CourseRepository courseRepository;
	
	@Autowired
	public CourseService(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
		
	}
	
	public List<Course> allCourses() {
		return this.courseRepository.findAll();
	}

	public Course getCourseById(int id) {
		return this.courseRepository.findById(id).orElse(null);
	}

	public void addCourse(Course c) {
		this.courseRepository.save(c);
	}
	
	public void deleteCourse(Course c) {
		this.courseRepository.delete(c);
	}
	
//	List<Course> getByFirstName(Student s) {
//		return this.courseRepository.getByFirstName(s);
//	}

}
