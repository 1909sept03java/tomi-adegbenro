package com.revature.beans;

public class SuperUser extends BankUser{
	private int sUserId;
	private String sUserName;
	private String sPassword;
	private int superValid;
	
	

	

	public SuperUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SuperUser(String userName, String password) {
		super(userName, password);
		// TODO Auto-generated constructor stub
	}

	public SuperUser(int sUserId, String sUserName, String sPassword, int superValid) {
		super();
		this.sUserId = sUserId;
		this.sUserName = sUserName;
		this.sPassword = sPassword;
		this.superValid = superValid;
	}

	@Override
	public int getSuperUser() {
		// TODO Auto-generated method stub
		return super.getSuperUser();
	}

	@Override
	public void setSuperUser(int superUser) {
		// TODO Auto-generated method stub
		super.setSuperUser(superUser);
	}

	@Override
	public int getUserId() {
		// TODO Auto-generated method stub
		return super.getUserId();
	}

	@Override
	public void setUserId(int userId) {
		// TODO Auto-generated method stub
		super.setUserId(userId);
	}

	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return super.getUserName();
	}

	@Override
	public void setUserName(String userName) {
		// TODO Auto-generated method stub
		super.setUserName(userName);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
	}

	@Override
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		super.setPassword(password);
	}

	public int getsUserId() {
		return sUserId;
	}

	public void setsUserId(int sUserId) {
		this.sUserId = sUserId;
	}

	public String getsUserName() {
		return sUserName;
	}

	public void setsUserName(String sUserName) {
		this.sUserName = sUserName;
	}

	public String getsPassword() {
		return sPassword;
	}

	public void setsPassword(String sPassword) {
		this.sPassword = sPassword;
	}

	public int getSuperValid() {
		return superValid;
	}

	public void setSuperValid(int superValid) {
		this.superValid = superValid;
	}
	
	
	

}
