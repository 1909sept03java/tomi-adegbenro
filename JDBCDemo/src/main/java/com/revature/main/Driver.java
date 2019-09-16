package com.revature.main;

import com.revature.beans.Cave;
import com.revature.dao.CaveDAO;
import com.revature.dao.CaveDAOImpl;

public class Driver {

	public static void main(String[] args) {
		
		
		CaveDAO cd = new CaveDAOImpl(); //CaveDOA is our variable declaration
		
		for (Cave c : cd.getCaves()) {
			System.out.println(c);
		}
		Cave A = new Cave(50,"Baltimore", 100);
		//cd.createCave(A);
		for (Cave b : cd.getCaves()) {
			System.out.println(b.getName());
		}
		System.out.println(cd.getCaveById(1));
	}

}