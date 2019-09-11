package com.hw1.q5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringMethodTest {
	
	private static StringMethod stringMethod;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		stringMethod = new StringMethod();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		String expectedResult = "the sly fo";
		int idx = 10;
		String initString = "the sly fox jumped over the lazy dog";
		assertEquals(expectedResult, StringMethod.stringReturn(initString, idx));
		//fail("Not yet implemented");
	}

}
