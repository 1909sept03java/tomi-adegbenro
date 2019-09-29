package com.revature.service;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.beans.Credentials;
import com.revature.beans.Employee;

public class AuthenticationServiceTest {
	private static AuthenticationService authServ;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		authServ = new AuthenticationService();
		
		
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
		//Credentials creds = new Credentials("jcaesar","p4ss");
		Credentials creds = new Credentials();
		creds.setUsername("jcaesar");
		creds.setPassword("p4ss");
		Employee emp = new Employee(1, "Julius", "Caesar", 2, 0);
		assertEquals(emp, authServ.authenticateUser(creds));
		//fail("Not yet implemented");
	}

}
