package com.pcwk.ehr.anno.domain;

import com.pcwk.ehr.cmn.DTO;

public class AnnoVO extends DTO {

	private String userId;//아이디
	private String passwd;//비번
	
	public AnnoVO() {}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	@Override
	public String toString() {
		return "AnnoVO [userId=" + userId + ", passwd=" + passwd + "]";
	}
	
	
}
