package com.hw1.q22;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hw1.q17.Interest;

class LambdaExpTest {
	private static LambdaExp lambda;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		lambda = new LambdaExp();
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
		int expResult = 10;
		
		//assertEquals(expResult, LambdaExp.main(null));
				
		fail("Not yet implemented");
	}

}
