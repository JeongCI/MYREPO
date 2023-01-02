package com.pcwk.ehr;

public class UserVO {
	private String uId; 	// 사용자 아이디
	private String name; 	// 이름
	private String passWd; 	// 비밀번호

	public UserVO() {
	}

	public UserVO(String uId, String name, String passWd) {
		super();
		this.uId = uId;
		this.name = name;
		this.passWd = passWd;
	}

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassWd() {
		return passWd;
	}

	public void setPassWd(String passWd) {
		this.passWd = passWd;
	}

	@Override
	public String toString() {
		return "UserVO [uId=" + uId + ", name=" + name + ", passWd=" + passWd + "]";
	}
	
}
