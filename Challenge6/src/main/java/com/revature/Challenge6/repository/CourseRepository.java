package com.revature.Challenge6.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.Challenge6.model.Course;
import com.revature.Challenge6.model.Student;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{
	
	//public List<Course> getByFirstName(Student s);

}
