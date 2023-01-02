package com.pcwk.ehr;

import java.sql.SQLException;

public class UserDaoTest {
	
	UserDao dao;
	UserVO userVO;
	
	public UserDaoTest() {
		dao = new DUserDao();
		userVO = new UserVO("p11", "이상무11", "4321");
	}
	
	public void add() {
		try {
			int flag = dao.add(userVO);
			if(1 == flag) {
				System.out.println("등록 성공");
			} else {
				System.out.println("등록 실패");
			}
			System.out.println("=============================================");
			
			UserVO outVO = dao.get(userVO.getuId());
			if(null != outVO) {
				System.out.println("조회 성공");
			} else {
				System.out.println("조회 실패");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void get() {
		UserVO outVO;
		try {
			outVO = dao.get(userVO.getuId());
			if(null != outVO) {
				System.out.println("조회 성공");
			} else {
				System.out.println("조회 실패");
			}		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
	
		UserDaoTest main = new UserDaoTest();
		main.add();
		//main.get();
		
	}

}
