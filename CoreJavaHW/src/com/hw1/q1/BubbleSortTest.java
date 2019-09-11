package com.hw1.q1;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BubbleSortTest {
	
	private static BubbleSort bubblesort;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		bubblesort = new BubbleSort();
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
		int[] expectedResult = {2, 4, 12, 30};
		int[] result = {12, 2, 30, 4};
		assertArrayEquals(expectedResult, BubbleSort.bubbleSort(result));
		//fail("Not yet implemented");
		
	}

}
