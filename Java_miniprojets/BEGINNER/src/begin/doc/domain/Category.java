package begin.doc.domain;

import begin.doc.cmn.DTO;

/**
 * 카테고리 기본 정보 클래스
 * @author ITSC
 *
 */
public class Category extends DTO {
	
	private String cateID;
	private String cateName;
	// 카테고리 내용 추가 필요시 주석 해제
	 private String cateDesc;
	private int status;
	
	public Category() {}

	// 기존 생성자
	public Category(String cateID, String cateName, int status) {
		super();
		this.cateID = cateID;
		this.cateName = cateName;
		this.status = status;
	}

	// 내용 추가시 생성자
//	public Category(String cateID, String cateName, String cateDesc, int status) {
//		super();
//		this.cateID = cateID;
//		this.cateName = cateName;
//		this.cateDesc = cateDesc;
//		this.status = status;
//	}

	public String getCateID() {
		return cateID;
	}
	public void setCateID(String cateID) {
		this.cateID = cateID;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	// 내용 추가시 get, set 추가
//	public String getCateDesc() {
//		return cateDesc;
//	}
//	public void setCateDesc(String cateDesc) {
//		this.cateDesc = cateDesc;
//	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Category [cateID=" + cateID + ", cateName=" + cateName + ", status=" + status + "]";
	}

// 내용 추가시 toString 내용 추가
//	@Override
//	public String toString() {
//		return "Category{" +
//				"cateID='" + cateID + '\'' +
//				", cateName='" + cateName + '\'' +
//				", cateDesc='" + cateDesc + '\'' +
//				", status=" + status +
//				'}';
//	}
}
