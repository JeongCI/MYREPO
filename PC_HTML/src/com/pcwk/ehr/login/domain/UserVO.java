package com.pcwk.ehr.login.domain;

import com.pcwk.ehr.cmn.DTO;

public class UserVO extends DTO {
	
	private String userId;
	private String userPw;
	private String devType;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getDevType() {
		return devType;
	}
	public void setDevType(String devType) {
		this.devType = devType;
	}
	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", userPw=" + userPw + ", devType=" + devType + "]";
	}
	
	
	
}
