/**
* <pre>
* com.pcwk.ehr.test
* Class Name : BoardDaoTest.java
* Description:
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
package com.pcwk.ehr.test;

import java.util.UUID;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.pcwk.ehr.board.dao.BoardDao;
import com.pcwk.ehr.board.domain.BoardVO;
import com.pcwk.ehr.cmn.DTO;
import com.pcwk.ehr.cmn.SearchVO;

/**
 * @author ITSC
 *
 */
public class BoardDaoTest {
	static final Logger LOG = Logger.getLogger(BoardDaoTest.class);

	BoardDao dao;
	BoardVO vo01;
	BoardVO vo02;
	BoardVO vo03;
	SearchVO search;

	public BoardDaoTest() {
		dao = new BoardDao();

		vo01 = new BoardVO(11, "����11", "����11", 0, "", "pcwk", "", "pcwk");
		vo02 = new BoardVO(1011, "����1011", "����1011", 0, "", "pcwk", "", "pcwk");
		vo03 = new BoardVO(2011, "����2011", "����2011", 0, "", "pcwk", "", "pcwk");
		
		search = new SearchVO();
	}

	public void connectDB() {

	}

	public void doSave() {
		int flag = dao.doSave(vo01);
		if (1 == flag) {
			LOG.debug("��� ����");
		} else {
			LOG.debug("��� ����");
		}

	}

	public void doDelete() {
		int flag = dao.doDelete(vo01);
		if (1 == flag) {
			LOG.debug("���� ����");
		} else {
			LOG.debug("���� ����");
		}
	}

	public void doUpdate() {
		vo01.setTitle(vo01.getTitle() + "_U");
		vo01.setContents(vo01.getContents() + "_U");
		vo01.setModId(vo01.getModId() + "_U");

		int flag = dao.doUpdate(vo01);
		if (1 == flag) {
			LOG.debug("���� ����");
		} else {
			LOG.debug("���� ����");
		}
	}

	public void doSelectOne() {
		BoardVO outVO = dao.doSelectOne(vo01);

		if (outVO.getSeq() == vo01.getSeq() && outVO.getTitle().equals(vo01.getTitle())
				&& outVO.getContents().equals(vo01.getContents()) && outVO.getReadCnt() == vo01.getReadCnt()
				&& outVO.getModId().equals(vo01.getModId())) {
			LOG.debug("��ȸ ����");
		} else {
			LOG.debug("��ȸ ����");
		}

	}
	
	public void doRetrieve() {
		search.setPageSize(20);
		search.setPageNo(1);
		search.setSearchDiv(""); //�˻����� : ""(��ü),10(����), 20(����), 30(����+����)
		search.setSearchWord(""); //�˻���
		
		List<BoardVO> list = dao.doRetrieve(search);
		for(BoardVO vo : list) {
			LOG.debug(vo);
		}
	}
	
	public void readCnt() {
		BoardVO outVO = dao.doSelectOne(vo01);
		int flag = dao.readCnt(vo01);

		if (1 == flag) {
			LOG.debug("��ȸcount ����");
		} else {
			LOG.debug("��ȸ count ���� ����");
		}
	}
	
	//scott�� �ɾ�鼭 ������ �����ؼ� 2�� ���� Ȯ��
	
	public void getUUID() {
		UUID uuid = UUID.randomUUID();
		LOG.debug("uuid:"+uuid.toString().replaceAll("-", ""));
		LOG.debug("uuid:"+uuid.toString().replaceAll("-", "").length()); //32bit
	}
	
	public void getYMDHMS() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date today = new Date();
		LOG.debug(sdf.format(today));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BoardDaoTest main = new BoardDaoTest();
//		main.doDelete();
//		main.doSave();
//		main.doSelectOne();
//		main.doRetrieve();
//		main.doUpdate();
//		main.readCnt();
		main.getUUID();

	}

}
