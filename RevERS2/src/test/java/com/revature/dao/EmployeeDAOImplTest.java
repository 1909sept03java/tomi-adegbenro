package com.revature.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.beans.Employee;

public class EmployeeDAOImplTest {
	private static EmployeeDAOImpl empDAOImpl;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empDAOImpl = new EmployeeDAOImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Employee mgrResult = new Employee(2,"Augustus", "Caesar", 2, 1);
		Employee emp = new Employee(1,"Julius", "Caesar", 2, 0);
		assertEquals(mgrResult, empDAOImpl.getMyManager(emp));
		//fail("Not yet implemented");
	}

}
