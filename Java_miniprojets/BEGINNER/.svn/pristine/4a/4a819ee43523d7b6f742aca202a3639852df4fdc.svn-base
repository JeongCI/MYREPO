package begin.doc.domain;

import begin.doc.cmn.DTO;

/**
 * 회원 기본 정보 클래스
 * @author ITSC
 *
 */
public class Member extends DTO {
	
	private String memberID;	// 회원 ID
	private String memberPwd;	// 회원 비밀번호
	private String memberName;	// 회원 이름
	private int auth;			// 권한 (0:관리자/1:일반사용자)
	private int level;			// 레벨 (입문(0),초급(1),중급(2),고급(3)) -> 채팅 시 레벨에 따른 사용자이름 앞에 특수 기호
	private int status;			// 상태값 (0:미사용/1:사용)
	private String createDate;	// 사용자 생성 일자
	
	public Member() {}
	
	public Member(String memberID, String memberPwd, String memberName, int auth, int level, int status,
			String createDate) {
		super();
		this.memberID = memberID;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		this.auth = auth;
		this.level = level;
		this.status = status;
		this.createDate = createDate;
	}

	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public String getMemberPwd() {
		return memberPwd;
	}
	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public int getAuth() {
		return auth;
	}
	public void setAuth(int auth) {
		this.auth = auth;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}	
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Book [memberID=" + memberID + ", memberPwd=" + memberPwd + ", memberName=" + memberName + ", auth="
				+ auth + ", level=" + level + ", status=" + status + "]";
	}
}
