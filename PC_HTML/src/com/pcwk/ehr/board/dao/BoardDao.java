/**
* <pre>
* com.pcwk.ehr.board.dao
* Class Name : BoardDao.java
* Description: 게시판 Data Access Object
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
package com.pcwk.ehr.board.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.pcwk.ehr.board.domain.BoardVO;
import com.pcwk.ehr.cmn.DTO;
import com.pcwk.ehr.cmn.SearchVO;
import com.pcwk.ehr.cmn.WorkDiv;

/**
 * @author ITSC
 *
 */
public class BoardDao implements WorkDiv<BoardVO> {

	final Logger LOG = Logger.getLogger(this.getClass());

	public BoardDao() {

	}

	public int readCnt(BoardVO dto) {
//		UPDATE board
//		   SET READ_CNT = READ_CNT+1
//		 WHERE seq =:SEQ
		int flag = 0;
		Connection conn = null; // DB연결
		PreparedStatement pstmt = null; // sql + data
		StringBuilder sb = new StringBuilder(200);
		sb.append("UPDATE board                 \n");
		sb.append("   SET READ_CNT = READ_CNT+1 \n");
		sb.append("WHERE seq = ?              	\n");

		LOG.debug("1. sql : \n" + sb.toString());
		conn = getConnection();
		LOG.debug("2. sql : " + conn);

		LOG.debug("3. param : " + dto);
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			LOG.debug("4.pstmt:" + pstmt);
			pstmt.setInt(1, dto.getSeq());
			// DML SQL 실행
			flag = pstmt.executeUpdate();
			LOG.debug("5.flag:" + flag);

		} catch (SQLException e) {
			LOG.debug("=========================");
			LOG.debug("=SQLException = " + e.getMessage());
			LOG.debug("=========================");
			e.printStackTrace();
		} finally {
			// pstmt
			if (null != pstmt) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}

			// conn
			if (null != conn) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return flag;
	}

	public Connection getConnection() {
		// DB연결
		Connection connection = null;
		// 192.168.3.101
		// jdbc:oracle:thin:@IP:PORT:전역DB명칭
		// jdbc:oracle:thin:@192.168.3.101:1521:XE
		String dbURL = "jdbc:oracle:thin:@192.168.3.14:1521:XE";
		String dbUser = "scott";
		String dbPassword = "pcwk";

		// jdbc oracle driver load
		try {
			LOG.debug("1");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			LOG.debug("2");

			// db연결
			connection = DriverManager.getConnection(dbURL, dbUser, dbPassword);
			LOG.debug("3 connection:" + connection);

		} catch (ClassNotFoundException e) {
			LOG.debug("=========================");
			LOG.debug("ClassNotFoundException=" + e.getMessage());
			LOG.debug("=========================");
			e.printStackTrace();
		} catch (SQLException e) {
			LOG.debug("=========================");
			LOG.debug("ClassNotFoundException=" + e.getMessage());
			LOG.debug("=========================");
			e.printStackTrace();
		}
		LOG.debug("4 db연결:");

		return connection;
	}

	@Override
	public int doSave(BoardVO dto) {
		int flag = 0;
		Connection conn = null; // DB연결
		PreparedStatement pstmt = null; // sql + data
		StringBuilder sb = new StringBuilder(200);

		sb.append("	INSERT INTO board ( \n");
		sb.append("			seq,		\n");
		sb.append("			title,		\n");
		sb.append("			contents,	\n");
		sb.append("			reg_id,		\n");
		sb.append("			mod_id		\n");
		sb.append("		) VALUES (		\n");
		sb.append("	BOARD_SEQ.NEXTVAL,	\n");
		sb.append("			?,			\n");
		sb.append("			?,			\n");
		sb.append("			?,			\n");
		sb.append("			?			\n");
		sb.append("	)					\n"); // ';' 붙이면 오류

		LOG.debug("1. sql : \n" + sb.toString());
		conn = getConnection();
		LOG.debug("2. sql : " + conn);

		LOG.debug("3. param : " + dto);

		try {
			pstmt = conn.prepareStatement(sb.toString());
			LOG.debug("4. pstmt : " + pstmt);
//			pstmt.setInt(1, dto.getSeq());
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getcontents());
			pstmt.setString(3, dto.getregId());
			pstmt.setString(4, dto.getModId());

			// DML SQL 실행
			flag = pstmt.executeUpdate();
			LOG.debug("5. flag : " + flag);

		} catch (SQLException e) {
			LOG.debug("=========================");
			LOG.debug("=SQLException = " + e.getMessage());
			LOG.debug("=========================");
			e.printStackTrace();

			// 자원 반납
		} finally {
			// pstmt
			if (null != pstmt) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}

			// conn
			if (null != conn) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

		return flag;
	}

	@Override
	public List<BoardVO> doRetrieve(DTO dto) {
		List<BoardVO> list = new ArrayList<BoardVO>();
		SearchVO inVO = (SearchVO) dto;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // DB에서 전달된 정보를 자바에 호출

		// ---------------------------------------------------------------------
		// 1. JDBC DRIVER LOADING
		// 2. Connection : 데이터 베이스 커넥션 생성
		// 3. PreparedStatement / Statement(sql inject문제 발생)
		// 3.1. PreparedStatement param 설정
		// 4. 쿼리 수행(excuteQuery() (SELECT) / executeUpdate() (CUD) )
		// 5. 수행결과(ResultSet) : excuteQuery()
		// 6. 자원반납
		// -> 수행 역순 ResultSet -> PreaparedStatment -> Connection : close()
		// ---------------------------------------------------------------------

		// where
		StringBuilder sbWhere = new StringBuilder();
		// 검색 조건
		if (null != inVO) {
			if (inVO.getSearchDiv().equals("10")) {
				sbWhere.append("WHERE title LIKE '%'||?||'%' \n");
			} else if (inVO.getSearchDiv().equals("20")) {
				sbWhere.append("WHERE contents LIKE '%'||?||'%' \n");
			} else if (inVO.getSearchDiv().equals("30")) {
				sbWhere.append("WHERE title LIKE '%'||?||'%'");
				sbWhere.append("OR contents LIKE '%'||?||'%'");
			}
		}

		StringBuilder sb = new StringBuilder(1300);
		sb.append("SELECT A.*,B.*																			   \n");
		sb.append("FROM (																					   \n");
		sb.append("    SELECT TT1.rnum as no,																   \n");
		sb.append("           tt1.seq,																		   \n");
		sb.append("           tt1.title,																	   \n");
		sb.append("           tt1.mod_id,																	   \n");
		sb.append("           DECODE( TO_CHAR(SYSDATE,'YYYYMMDD'), TO_CHAR(tt1.mod_dt,'YYYYMMDD')			   \n");
		sb.append("                                              , TO_CHAR(tt1.mod_dt,'HH24:MI')			   \n");
		sb.append("                                              , TO_CHAR(tt1.mod_dt,'YYYY.MM.DD') ) mod_dt,  \n");
		sb.append("           tt1.read_cnt                                                                     \n");
		sb.append("    FROM (                                                                                  \n");
		sb.append("        SELECT ROWNUM AS RNUM, T1.*                                                         \n");
		sb.append("        FROM (                                                                              \n");
		sb.append("            SELECT *                                                                        \n");
		sb.append("            FROM board                                                                      \n");
		// where
		// ----------------------------------------------------------------------------------------------------
		sb.append(sbWhere.toString());
		// where
		// ----------------------------------------------------------------------------------------------------
		sb.append("            ORDER BY mod_dt DESC                                                            \n");
		sb.append("        )T1                                                                                 \n");
		sb.append("        WHERE rownum <= ? * (?-1)+?                        						           \n");
//		sb.append("        WHERE rownum <= &page_size * (&page_no-1)+&page_size                		           \n");
		sb.append("    )TT1                                                                                    \n");
		sb.append("    WHERE rnum >= ? * (?-1)+1                                                               \n");
//		sb.append("    WHERE rnum >= &page_size * (&page_no-1)+1                                               \n");
		sb.append(")A NATURAL JOIN                                                                             \n");
		sb.append("(SELECT COUNT(*) total_cnt                                                                  \n");
		sb.append("   FROM board                                                                               \n");
		// where
		// ----------------------------------------------------------------------------------------------------
		sb.append(sbWhere.toString());
		// where
		// ----------------------------------------------------------------------------------------------------
		sb.append(")B                                                                                          \n");
		LOG.debug("1.sql:\n" + sb.toString());
		conn = getConnection();
		LOG.debug("2.conn:" + conn);
		LOG.debug("3.param:" + inVO);

		try {
			pstmt = conn.prepareStatement(sb.toString());
			if (null != inVO) {
				// 제목 검색
				if (inVO.getSearchDiv().equals("10")) {
					// 검색어
					pstmt.setString(1, inVO.getSearchWord());
					pstmt.setInt(2, inVO.getPageSize());
					pstmt.setInt(3, inVO.getPageNo());
					pstmt.setInt(4, inVO.getPageSize());
					pstmt.setInt(5, inVO.getPageSize());
					pstmt.setInt(6, inVO.getPageNo());
					pstmt.setString(7, inVO.getSearchWord());
				} else if (inVO.getSearchDiv().equals("20")) {
					pstmt.setString(1, inVO.getSearchWord());
					pstmt.setInt(2, inVO.getPageSize());
					pstmt.setInt(3, inVO.getPageNo());
					pstmt.setInt(4, inVO.getPageSize());
					pstmt.setInt(5, inVO.getPageSize());
					pstmt.setInt(6, inVO.getPageNo());
					pstmt.setString(7, inVO.getSearchWord());
				} else if (inVO.getSearchDiv().equals("30")) {
					pstmt.setString(1, inVO.getSearchWord());
					pstmt.setString(2, inVO.getSearchWord());
					pstmt.setInt(3, inVO.getPageSize());
					pstmt.setInt(4, inVO.getPageNo());
					pstmt.setInt(5, inVO.getPageSize());
					pstmt.setInt(6, inVO.getPageSize());
					pstmt.setInt(7, inVO.getPageNo());
					pstmt.setString(8, inVO.getSearchWord());
					pstmt.setString(9, inVO.getSearchWord());
				} else {
					pstmt.setInt(1, inVO.getPageSize());
					pstmt.setInt(2, inVO.getPageNo());
					pstmt.setInt(3, inVO.getPageSize());
					pstmt.setInt(4, inVO.getPageSize());
					pstmt.setInt(5, inVO.getPageNo());
				}
			}

			// Select sql 실행
			rs = pstmt.executeQuery();
			while (rs.next() == true) { // 다건 데이터 조회
				BoardVO outVO = new BoardVO();

				outVO.setNo(rs.getInt("no"));
				outVO.setSeq(rs.getInt("seq"));
				outVO.setTitle(rs.getString("title"));
				outVO.setModId(rs.getString("mod_id"));
				outVO.setModDt(rs.getString("mod_dt"));
				outVO.setReadCnt(rs.getInt("read_cnt"));
				outVO.setTotalCnt(rs.getInt("total_cnt"));
				list.add(outVO);

				LOG.debug("5.outVO:" + outVO);
			}

		} catch (SQLException e) {
			LOG.debug("===============================");
			LOG.debug("=SQLException=" + e.getMessage());
			LOG.debug("===============================");
			e.printStackTrace();
		} finally {
			// 생성 역순으로 자원 반납
			if (null != rs) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if (null != pstmt) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
			if (null != conn) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

		return list;
	}

	@Override
	public int doUpdate(BoardVO dto) {
//		UPDATE board
//		SET title = ?
//		contents = ?
//		mod_dt = SYSDATE,
//		mod_id = ?
//		WHERE seq = ?

		int flag = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE board		 			\n");
		sb.append("	  SET title = ?,			\n");
		sb.append("		  contents = ?,	 		\n");
		sb.append("		  mod_dt = SYSDATE,		\n");
		sb.append("		  mod_id = ?		 	\n");
		sb.append("WHERE seq = ?	 			\n");

		LOG.debug("1.sql:\n" + sb.toString());
		conn = getConnection();
		LOG.debug("2.conn:" + conn);
		LOG.debug("3.param:" + dto);

		try {

			pstmt = conn.prepareStatement(sb.toString());
			LOG.debug("4.pstmt:" + pstmt);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getcontents());
			pstmt.setString(3, dto.getModId());
			pstmt.setInt(4, dto.getSeq());
			// DML SQL 실행
			flag = pstmt.executeUpdate();
			LOG.debug("5.flag:" + flag);

		} catch (SQLException e) {
			LOG.debug("===============================");
			LOG.debug("=SQLException=" + e.getMessage());
			LOG.debug("===============================");
			e.printStackTrace();
		} finally {
			if (null != pstmt) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
			if (null != conn) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

		return flag;
	}

	@Override
	public int doDelete(BoardVO dto) {
//		DELETE FROM board
//		WHERE seq = :v0;

		int flag = 0;
		Connection conn = null; // DB연결
		PreparedStatement pstmt = null; // sql + param
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM board	\n");
		sb.append("WHERE seq = ?		\n");

		LOG.debug("1.sql:\n" + sb.toString());
		conn = getConnection();
		LOG.debug("2.conn:" + conn);
		LOG.debug("3.param:" + dto);
		try {
			pstmt = conn.prepareStatement(sb.toString());
			LOG.debug("4.pstmt:" + pstmt);
			pstmt.setInt(1, dto.getSeq());
			// DML SQL 실행
			flag = pstmt.executeUpdate();
			LOG.debug("5.flag:" + flag);

		} catch (SQLException e) {
			LOG.debug("===============================");
			LOG.debug("=SQLException=" + e.getMessage());
			LOG.debug("===============================");
			e.printStackTrace();
			// 자원반납
		} finally {
			if (null != pstmt) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
			if (null != conn) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

		return flag;
	}

	@Override
	public BoardVO doSelectOne(BoardVO obj) {
		BoardVO outVO = null;

		Connection conn = null; // DB연결
		PreparedStatement pstmt = null; // sql + param
		ResultSet rs = null; // DB에서 전달된 정보를 자바에 호출
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT seq,											\n");
		sb.append("		title,											\n");
		sb.append("		contents,										\n");
		sb.append("		read_cnt,										\n");
		sb.append("		TO_CHAR(mod_dt,'YYYY.MM.DD HH24:MI:SS') mod_dt,	\n");
		sb.append("		mod_id											\n");
		sb.append("FROM board											\n");
		sb.append("WHERE seq = ?										\n");
		LOG.debug("1.sql:\n" + sb.toString());
		conn = getConnection();
		LOG.debug("2.conn:" + conn);
		LOG.debug("3.param:" + obj);

		try {
			pstmt = conn.prepareStatement(sb.toString());
			LOG.debug("4.pstmt:" + pstmt);
			pstmt.setInt(1, obj.getSeq());
			// Select sql 실행
			rs = pstmt.executeQuery();

			if (rs.next() == true) {
				outVO = new BoardVO();
				outVO.setSeq(rs.getInt("seq"));
				outVO.setTitle(rs.getString("title"));
				outVO.setcontents(rs.getString("contents"));
				outVO.setReadCnt(rs.getInt("read_cnt"));
				outVO.setModDt(rs.getString("mod_dt"));
				outVO.setModId(rs.getString("mod_id"));
				LOG.debug("5.outVO:" + outVO);
			}

		} catch (SQLException e) {
			LOG.debug("===============================");
			LOG.debug("=SQLException=" + e.getMessage());
			LOG.debug("===============================");
			e.printStackTrace();
		} finally {
			// 생성 역순으로 자원 반납
			if (null != rs) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if (null != pstmt) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
			if (null != conn) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

		return outVO;
	}

}
