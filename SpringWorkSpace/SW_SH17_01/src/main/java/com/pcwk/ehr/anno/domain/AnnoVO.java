package com.pcwk.ehr.anno.domain;

import com.pcwk.ehr.cmn.DTO;

public class AnnoVO extends DTO {
	
	private String userId; //아이디
	private String userPwd; // 비번
	
	public AnnoVO() {}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getuserPwd() {
		return userPwd;
	}

	public void setuserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	@Override
	public String toString() {
		return "AnnoVO [userId=" + userId + ", userPwd=" + userPwd + "]";
	}
	
}
