package com.pcwk.ehr;

public class DaoFactory {
	
	public UserDao userDao() {
		//객체를 어떻게 만들지 결정하고, 돌려준다.
		ConnectionMaker  connectionMaker = new NConnectionMaker();
		UserDao userDao = new UserDao(new NConnectionMaker());
		
		return userDao;
	}
	
}
