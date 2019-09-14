package com.hw1.q18;

public interface ConvertCase extends CheckCase{
	
	//String convertLowerCase();
	
	//String convertUpperCase();

	public String convertLowerCase(String s);

	public String convertUpperCase(String s);

	@Override
	default boolean checkUpperCase(String s) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	default boolean checkLowerCase(String s) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
