package com.revature.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.beans.BankAccount;
import com.revature.beans.BankUser;

class BankAccountDAOImplTest {
	
	private static BankAccountDAOImpl ba;
	BankUser buser = new BankUser(1, "badegbenro", "p4ss", 0);
	BankAccount myBankAccount = new BankAccount();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		ba = new BankAccountDAOImpl();
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
		//fail("Not yet implemented");
		myBankAccount = ba.viewAccountInfo(buser, 100);
	}

}
