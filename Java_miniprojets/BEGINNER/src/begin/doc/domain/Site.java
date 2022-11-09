package begin.doc.domain;

import begin.doc.cmn.DTO;

/**
 * 사이트 기본 정보 클래스
 * @author ITSC
 *
 */
public class Site extends DTO {
	
	private String siteID;		// 사이트 ID
	private String cateID;		// 카테고리 ID
	private String siteName;	// 사이트 이름
	private String siteURL;		// 사이트 URL
	private String desc;		// 사이트 설명
	private String addMember;	// 사이트 등록 사용자 이름
	private String addDate;		// 사이트 등록일자
	
	public Site() {}

	public Site(String siteID, String cateID, String siteName, String siteURL, String desc, String addMember,
			String addDate) {
		super();
		this.siteID = siteID;
		this.cateID = cateID;
		this.siteName = siteName;
		this.siteURL = siteURL;
		this.desc = desc;
		this.addMember = addMember;
		this.addDate = addDate;
	}

	public String getSiteID() {
		return siteID;
	}

	public void setSiteID(String siteID) {
		this.siteID = siteID;
	}

	public String getCateID() {
		return cateID;
	}

	public void setCateID(String cateID) {
		this.cateID = cateID;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getSiteURL() {
		return siteURL;
	}

	public void setSiteURL(String siteURL) {
		this.siteURL = siteURL;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getAddMember() {
		return addMember;
	}

	public void setAddMember(String addMember) {
		this.addMember = addMember;
	}

	public String getAddDate() {
		return addDate;
	}

	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}
	
	

	@Override
	public String toString() {
		return "Site [siteID=" + siteID + ", cateID=" + cateID + ", siteName=" + siteName + ", siteURL=" + siteURL
				+ ", desc=" + desc + ", addMember=" + addMember + ", addDate=" + addDate + "]";
	}

	public String getSite() {
		
		return  "Site [siteID=" + siteID + ", cateID=" + cateID + ", siteName=" + siteName + ", siteURL=" + siteURL
				+ ", desc=" + desc + ", addMember=" + addMember + ", addDate=" + addDate + "]";
	
	}
}
