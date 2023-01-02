package com.pcwk.ehr.cmn;

public class DTO {
	private int totalCnt;//총글수
	private int num;//글번호
	
	//excel header이름
	private String header;//
	private String headerWidth;//header넓이
	private String align;//header넓이
	
	public DTO() {}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getHeaderWidth() {
		return headerWidth;
	}

	public void setHeaderWidth(String headerWidth) {
		this.headerWidth = headerWidth;
	}

	public String getAlign() {
		return align;
	}

	public void setAlign(String align) {
		this.align = align;
	}

	public int getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
  
	@Override
	public String toString() {
		return "DTO [totalCnt=" + totalCnt + ", num=" + num + ", header=" + header + ", headerWidth=" + headerWidth
				+ ", align=" + align + "]";
	}


	
	
	
}
