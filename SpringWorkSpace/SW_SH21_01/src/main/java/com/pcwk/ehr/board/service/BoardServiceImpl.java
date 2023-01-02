package com.pcwk.ehr.board.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcwk.ehr.board.dao.BoardDao;
import com.pcwk.ehr.board.domain.BoardVO;
import com.pcwk.ehr.cmn.DTO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	BoardDao  boardDao;
	
	public BoardServiceImpl() {}
	
	
	@Override
	public int doSave(BoardVO inVO) throws SQLException {
		return boardDao.doSave(inVO);
	}

	@Override
	public int doDelete(BoardVO inVO) throws SQLException {
		return boardDao.doDelete(inVO);
	}

	@Override
	public int doUpdate(BoardVO inVO) throws SQLException {
		return boardDao.doUpdate(inVO);
	}

	@Override
	public BoardVO doSelectOne(BoardVO inVO) throws SQLException {
		//1.단건조회
		//2.조회 count증가
		
		
		//1.
		BoardVO outVO = boardDao.doSelectOne(inVO);
		
		//2.
		//등록자 ID , 로그인 사용자와 일치 하지 않으면 조회 count 증가
		//TODO
		boardDao.updateReadCnt(inVO);
		
		
		return outVO;
	}

	@Override
	public List<BoardVO> doRetrive(DTO inVO) throws SQLException {
		return boardDao.doRetrive(inVO);
	}

}
