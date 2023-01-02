package com.pcwk.ehr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sun.xml.internal.ws.api.pipe.ThrowableContainerPropertySet;

public class UserDao {

   final Logger LOG = LogManager.getFormatterLogger(getClass());

   // java제공 DataSource
   private DataSource dataSource;

   // Default생성자 반드시 필요!
   public UserDao() {
   }

   // setter injection
   public void setDataSource(DataSource dataSource) {
      this.dataSource = dataSource;
   }
   
   //
   public int getCount(UserVO inVO) throws SQLException {
	   int cnt = 0;
	   Connection c = null;
	   PreparedStatement ps = null;
	   ResultSet rs = null;
	   
	   c = dataSource.getConnection();
	   
	   StringBuilder sb = new StringBuilder();
	   sb.append("SELECT COUNT(*) cnt      \n");
	   sb.append("FROM HR_MEMBER           \n");
	   sb.append("WHERE u_id LIKE ? || '%'   \n");
	   
	   LOG.debug("1. sql log \n" + sb.toString());
	   LOG.debug("2. param log \n"+inVO);	   
	   
	   ps = c.prepareStatement(sb.toString());
	   ps.setString(1, inVO.getuId());
	   
	   rs = ps.executeQuery();

	   if (rs.next()) {
		   cnt = rs.getInt("cnt");
	   }	   
	   
	   LOG.debug("3. cnt: "+cnt);
	   
	   rs.close();
	   ps.close();
	   c.close();
	   
	   return cnt;
   }
   
   //전체삭제
   public int deleteOne(UserVO inVO) throws SQLException {
	      int flag = 0;
	      Connection c = null;
	      PreparedStatement ps = null;

	      c = dataSource.getConnection();
	      
	      StringBuilder sb = new StringBuilder();
	      sb.append("DELETE FROM HR_MEMBER \n");
	      sb.append("WHERE u_id = ?		   \n");
	      
	      LOG.debug("1. sql log \n" + sb.toString());
	      LOG.debug("2. param log \n");
	      
	      ps = c.prepareStatement(sb.toString());
	      ps.setString(1, inVO.getuId());
	      
	      flag = ps.executeUpdate();
	      //자원반납
	      ps.close();
	      c.close();
	      LOG.debug("3. flag: "+flag);
	      
	      return flag;
	   }
   

   // 단건조회
   public UserVO get(String id) throws SQLException {
      UserVO userVO = null;
      Connection c = null;
      PreparedStatement ps = null;
      ResultSet rs = null;

      c = dataSource.getConnection();

      StringBuilder sb = new StringBuilder();
      sb.append("SELECT  u_id,      \n");
      sb.append("        name,        \n");
      sb.append("        passwd       \n");
      sb.append("FROM  hr_member      \n");
      sb.append("WHERE u_id = ?       \n");

      LOG.debug("1. sql log \n" + sb.toString());
      LOG.debug("2. param log \n" + id);

      ps = c.prepareStatement(sb.toString());
      ps.setString(1, id);

      rs = ps.executeQuery();

      if (rs.next()) {
         userVO = new UserVO();
         userVO.setuId(rs.getString("u_id"));
         userVO.setName(rs.getString("name"));
         userVO.setPassWd(rs.getString("passwd"));
      }
      
      //userVO null이면 예외 발생
      if(null == userVO) {
    	  throw new NullPointerException("ID를 확인하세요");
      }
      
      LOG.debug("3. userVO \n" + userVO);

      rs.close();
      ps.close();
      c.close();
      return userVO;
   }

   // 데이터 등록
   public int add(UserVO inVO) throws SQLException, ClassNotFoundException {
      int flag = 0;
      Connection c = null;
      PreparedStatement ps = null;

      c = dataSource.getConnection();

      StringBuilder sb = new StringBuilder();
      sb.append("INSERT INTO hr_member (   \n");
      sb.append("    u_id,                 \n");
      sb.append("    name,                 \n");
      sb.append("    passwd                \n");
      sb.append(") VALUES (                \n");
      sb.append("    ?,                    \n");
      sb.append("    ?,                    \n");
      sb.append("    ?                     \n");
      sb.append(")                         \n");

      LOG.debug("1. sql log \n" + sb.toString());
      LOG.debug("2. param log \n" + inVO);

      ps = c.prepareStatement(sb.toString());
      ps.setString(1, inVO.getuId());
      ps.setString(2, inVO.getName());
      ps.setString(3, inVO.getPassWd());

      // sql수행
      flag = ps.executeUpdate();
      LOG.debug("3. flag:" + flag);

      ps.close();
      c.close();

      LOG.debug("1. DRIVER loading 성공");
      LOG.debug("2. Connection 성공:" + c);

      return flag;
   }
}