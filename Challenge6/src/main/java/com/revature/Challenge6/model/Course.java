package com.revature.Challenge6.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="COURSE")
public class Course {
	public Course(int id, String courseName) {
		super();
		this.id = id;
		this.courseName = courseName;
	}
	public Course(String courseName) {
		super();
		this.courseName = courseName;
	}
	public Course() {
		super();
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="studySetSequence")
	@SequenceGenerator(allocationSize=1, name="studySetSequence", sequenceName="SQ_STUDY_SET_PK")
	@Column(name="COURSE_ID")
	private int id;
	@Column(name="COURSE_NAME")
	private String courseName;
	// set up a unidirectional many-to-many relationship with Student
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER) //CascadeType.MERGE, FetchType.EAGER
	@JoinTable(name="STUDENT_COURSE",
			joinColumns = {@JoinColumn(name="COURSE_ID")},
			inverseJoinColumns = {@JoinColumn(name="STUDENT_ID")})
	private List<Student> students = new ArrayList<>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseName == null) ? 0 : courseName.hashCode());
		result = prime * result + id;
		result = prime * result + ((students == null) ? 0 : students.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (courseName == null) {
			if (other.courseName != null)
				return false;
		} else if (!courseName.equals(other.courseName))
			return false;
		if (id != other.id)
			return false;
		if (students == null) {
			if (other.students != null)
				return false;
		} else if (!students.equals(other.students))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", students=" + students + "]";
	}
	
	

}
