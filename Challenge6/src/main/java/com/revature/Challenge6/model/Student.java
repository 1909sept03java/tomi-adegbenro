package com.revature.Challenge6.model;

	import javax.persistence.CascadeType;
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.FetchType;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.JoinColumn;
	import javax.persistence.ManyToOne;
	import javax.persistence.SequenceGenerator;
	import javax.persistence.Table;

	@Entity
	@Table(name="STUDENT")
	public class Student {
		
		public Student() {
			super();
		}
		public Student(String firstname, String lastname) {
			super();
			this.firstname = firstname;
			this.lastname = lastname;
		}
		public Student(int id, String firstname, String lastname) {
			super();
			this.id = id;
			this.firstname = firstname;
			this.lastname = lastname;
		}
		
		@Id // indicates that this is the primary key! ("persistent identity" of a Student)
		// generate values for this PK
		@GeneratedValue(strategy=GenerationType.AUTO, generator="studentSequence")
		@SequenceGenerator(allocationSize=1, name="studentSequence", sequenceName="SQ_STUDENT_PK")
		@Column(name="STUDENT_ID")
		private int id;
		// don't strictly need these unless you want to customize your column definitions
		@Column(name="FIRSTNAME")
		private String firstname;
		@Column(name="LASTNAME")
		private String lastname;
//		// establish a foreign key from Flashcard to Topic
//		// Topic has to be a correctly mapped entity for this to work
//		@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
//		@JoinColumn(name="TOPIC_ID")
//		private Topic topic;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getFirstname() {
			return firstname;
		}
		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}
		public String getLastname() {
			return lastname;
		}
		public void setLastname(String lastname) {
			this.lastname = lastname;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
			result = prime * result + id;
			result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
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
			Student other = (Student) obj;
			if (firstname == null) {
				if (other.firstname != null)
					return false;
			} else if (!firstname.equals(other.firstname))
				return false;
			if (id != other.id)
				return false;
			if (lastname == null) {
				if (other.lastname != null)
					return false;
			} else if (!lastname.equals(other.lastname))
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "Student [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + "]";
		}
		
		
		

}
