package com.revature.calc;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CalculatorTest {
	
	private static Calculator calculator;
	/* 
	 * UNit Testing: testing most granular code possible - line and branch coverage of metods
	 * 
	 * TDD: style of development in which the tests are written before the code
	 * red-green refactiring: start with requirement, write test, build code to match
	 * 
	 * 1. calling add("") returns Double value
	 * 2. calling add() with null returns 0
	 * 3. calling add() with >2 comma-separated arguments throws Calculator Exception
	 * 4 calling add() with incorrect characters throws Calculator Exception
	 * 5. calling add() with 2 comma-separated numeric values returns their sum
	 */
	
	// if any exception is thrown, test will fail
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@BeforeClass
	public static void initializeCalculator() {
		calculator = new Calculator();
	}
	
	@Test
	public void emptyStringReturnsZero() throws CalculatorException {
		assertEquals(0, calculator.add(""), 0.0001);
	}
	
	@Test
	public void nullReturnsZero() throws CalculatorException {
		assertEquals(0, calculator.add(null), 0.0001);
	}
	
	@Test
	public void moreThanTwoThrowsException() throws CalculatorException {
		thrown.expect(CalculatorException.class);
		calculator.add("4,5,6,7");
	}

}
