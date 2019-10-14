package com.revature.Challenge6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.Challenge6.model.Student;
import com.revature.Challenge6.repository.StudentRepository;

@Service
public class StudentService {
	
	private StudentRepository studentRepository;
	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	public List<Student> allStudents() {
		return this.studentRepository.findAll();
	}

	public Student getStudentById(int id) {
		return this.studentRepository.findById(id).orElse(null);
	}

	public void addStudent(Student s) {
		this.studentRepository.save(s);
	}
	
	public void deleteCourse(Student s) {
		this.studentRepository.delete(s);
	}

}
