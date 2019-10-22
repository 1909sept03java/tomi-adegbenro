package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.revature.client.StudentClient;
import com.revature.model.Student;

public class StudentClientController {
	
private StudentClient studentClient;
	
	@Autowired
	public void setStudentClient(StudentClient studentClient) {
		this.studentClient = studentClient;
	}
	
	@GetMapping(value="/getAllStudents")
	public ResponseEntity<List<Student>> getAllStudents() {
		return new ResponseEntity<>(this.studentClient.getStudents(), HttpStatus.OK);
	}

}
