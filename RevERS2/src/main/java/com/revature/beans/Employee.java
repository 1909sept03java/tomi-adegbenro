	package com.revature.beans;

public class Employee {
	
	private int empId;
	private String firstName;
	private String lastName;
	private int manager;
	private int mgrRole;
	//Constructors
	public Employee() {
		super();
	}
	public Employee(int empId, String firstName, String lastName, int manager,
			int mgrRole) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.manager = manager;
		this.mgrRole = mgrRole;
	}
	
	//Getters and Setters
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getManager() {
		return manager;
	}
	public void setManager(int manager) {
		this.manager = manager;
	}
	public int getMgrRole() {
		return mgrRole;
	}
	public void setMgrRole(int mgrRole) {
		this.mgrRole = mgrRole;
	}
	
	//HashCodes
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empId;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + manager;
		result = prime * result + mgrRole;
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
		Employee other = (Employee) obj;
		if (empId != other.empId)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (manager != other.manager)
			return false;
		if (mgrRole != other.mgrRole)
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", manager=" + manager + ", mgrRole=" + mgrRole + "]";
	}	
	

	
	
	

}
