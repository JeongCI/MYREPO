/**
* <pre>
* com.pcwk.ehr.board.domain
* Class Name : BoardVO.java
* Description: Board Value Object(board���̺�� Java �� 1��1 ����)
* Author: ITSC
* Since: 2022/09/26
* Version 0.1
* Copyright (c) by H.R.KIM All right reserved.
* Modification Information
* ������   ������    ��������
*-----------------------------------------------------
*2022/09/26 ���ʻ���
*-----------------------------------------------------
* </pre>
*/
package com.pcwk.ehr.board.domain;

import com.pcwk.ehr.cmn.DTO;

/**
 * @author ITSC
 *
 */
public class BoardVO extends DTO {
//   SEQ         NUMBER(7,0)         No         1   ����
//   TITLE       VARCHAR2(200 BYTE)   No         2   ����
//   contents   CLOB            Yes         3   ����
//   READ_CNT   NUMBER(6,0)         Yes   0      4   ��ȸ��
//   READ_DT      DATE            Yes   SYSDATE   5   �����
//   READ_ID      VARCHAR2(20 BYTE)   Yes         6   �����
//   MOD_DT      DATE            Yes   SYSDATE   7   ������
//   MOD_ID      VARCHAR2(20 BYTE)   Yes         8   ������

	private int seq;
	private String title;
	private String contents;
	private int readCnt;
	private String regDt;
	private String regId;
	private String modDt;
	private String modId;

	public BoardVO() {

	}

	/**
	 * @param seq
	 * @param title
	 * @param contents
	 * @param readCnt
	 * @param regDt
	 * @param regId
	 * @param modDt
	 * @param modId
	 */
	public BoardVO(int seq, String title, String contents, int readCnt, String regDt, String regId, String modDt,
			String modId) {
		super();
		this.seq = seq;
		this.title = title;
		this.contents = contents;
		this.readCnt = readCnt;
		this.regDt = regDt;
		this.regId = regId;
		this.modDt = modDt;
		this.modId = modId;
	}

	/**
	 * @return the seq
	 */
	public int getSeq() {
		return seq;
	}

	/**
	 * @param seq the seq to set
	 */
	public void setSeq(int seq) {
		this.seq = seq;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the contents
	 */
	public String getcontents() {
		return contents;
	}

	/**
	 * @param contents the contents to set
	 */
	public void setcontents(String contents) {
		this.contents = contents;
	}

	/**
	 * @return the readCnt
	 */
	public int getReadCnt() {
		return readCnt;
	}

	/**
	 * @param readCnt the readCnt to set
	 */
	public void setReadCnt(int readCnt) {
		this.readCnt = readCnt;
	}

	/**
	 * @return the regDt
	 */
	public String getregDt() {
		return regDt;
	}

	/**
	 * @param regDt the regDt to set
	 */
	public void setregDt(String regDt) {
		this.regDt = regDt;
	}

	/**
	 * @return the regId
	 */
	public String getregId() {
		return regId;
	}

	/**
	 * @param regId the regId to set
	 */
	public void setregId(String regId) {
		this.regId = regId;
	}

	/**
	 * @return the modDt
	 */
	public String getModDt() {
		return modDt;
	}

	/**
	 * @param modDt the modDt to set
	 */
	public void setModDt(String modDt) {
		this.modDt = modDt;
	}

	/**
	 * @return the modId
	 */
	public String getModId() {
		return modId;
	}

	/**
	 * @param modId the modId to set
	 */
	public void setModId(String modId) {
		this.modId = modId;
	}

	@Override
	public String toString() {
		return "BoardVO [seq=" + seq + ", title=" + title + ", contents=" + contents + ", readCnt=" + readCnt
				+ ", regDt=" + regDt + ", regId=" + regId + ", modDt=" + modDt + ", modId=" + modId + ", toString()="
				+ super.toString() + "]";
	}

}