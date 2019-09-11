package com.hw1.q8;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PalindromesTest {
	private static Palindromes palindromes;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		palindromes = new Palindromes();
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
		ArrayList<String> originalList = new ArrayList<String>();
		originalList.add("karan");
		originalList.add("madam");
		originalList.add("tom");
		
		ArrayList<String> expectedList = new ArrayList<String>();
		expectedList.add("madam");
		assertEquals(expectedList, Palindromes.returnPalindromes(originalList));
		//fail("Not yet implemented");
	}

}
