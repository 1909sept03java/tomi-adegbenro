package com.hw1.q4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NFactorialTest {
	
	private static NFactorial nfactorial;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		nfactorial = new NFactorial();
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
		
		assertEquals(1, nfactorial.nFactorial(1));
		//fail("Not yet implemented");
	}

}
