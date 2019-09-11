package com.hw1.q10;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hw1.q8.Palindromes;

class TernaryTest {
	private static Ternary ternary;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		ternary = new Ternary();
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
		int expResult = 24;
		assertEquals(expResult, Ternary.minVal(54, 24));
		//fail("Not yet implemented");
	}

}
