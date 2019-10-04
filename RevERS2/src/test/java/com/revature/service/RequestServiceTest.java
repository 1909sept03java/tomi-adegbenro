package com.revature.service;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.beans.Employee;

public class RequestServiceTest {
	private static RequestService reqServ;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		reqServ = new RequestService();
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
		Employee emp = new Employee(1, "Julius", "Caesar", 2, 0);
		String title = "Farewell Party";
		String sum = "Bought Pizza";
		float amt = 300;
		assertTrue(reqServ.createRequest(emp, title, sum, amt));
		//fail("Not yet implemented");
	}

}
