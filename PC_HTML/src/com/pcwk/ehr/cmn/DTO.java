/**
* <pre>
* com.pcwk.cmn
* Class Name : DTO.java
* Description: 표준 Data Transfer object
* Author: ITSC
* Since: 2022/09/26
* Version 0.1
* Copyright (c) by H.R.KIM All right reserved.
* Modification Information
* 수정일   수정자    수정내용
*-----------------------------------------------------
*2022/09/26 최초생성
*-----------------------------------------------------
* </pre>
*/
package com.pcwk.ehr.cmn;

/**
 * @author ITSC
 *
 */
public class DTO {

   private int no ;		 //번호
   private int totalCnt; //총글수
   
   public DTO() {}

   /**
    * @return the no
    */
   public int getNo() {
      return no;
   }

   /**
    * @param no the no to set
    */
   public void setNo(int no) {
      this.no = no;
   }

	/**
	 * @return the totalCnt
	 */
	public int getTotalCnt() {
		return totalCnt;
	}
	
	/**
	 * @param totalCnt the totalCnt to set
	 */
	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}
	
	@Override
	public String toString() {
		return "DTO [no=" + no + ", totalCnt=" + totalCnt + "]";
	}
   
}