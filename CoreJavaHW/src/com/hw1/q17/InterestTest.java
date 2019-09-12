package com.hw1.q17;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hw1.q8.Palindromes;

class InterestTest {
	private static Interest interest;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		interest = new Interest();
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
		float p = 200000;
		float r = 19;
		float t = 5;
		float expResult = (p*r*t)/(100*12);
		
		assertEquals(expResult, Interest.interestCalc(p,r,t), 0.1);
		
				
		
		//fail("Not yet implemented");
	}

}
