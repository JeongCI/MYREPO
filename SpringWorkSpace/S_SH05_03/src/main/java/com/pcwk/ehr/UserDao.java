package com.pcwk.ehr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.sun.xml.internal.ws.api.pipe.ThrowableContainerPropertySet;

public class UserDao {

   final Logger LOG = LogManager.getFormatterLogger(getClass());
   
   //Spring이 제공하는 JdbcTemplate
   private JdbcTemplate jdbcTemplate;

   // java제공 DataSource
   private DataSource dataSource;

   // Default생성자 반드시 필요!
   public UserDao() {
   }

   // setter injection
   public void setDataSource(DataSource dataSource) {
      this.dataSource = dataSource;
      jdbcTemplate = new JdbcTemplate(dataSource);
   }
   
   @SuppressWarnings("deprecation")
public List<UserVO> getAll(UserVO inVO) throws SQLException{
	   List<UserVO> list = new ArrayList<UserVO>();
	   
	   StringBuilder sb = new StringBuilder();
	   sb.append("SELECT  u_id,      			\n");
	   sb.append("        name,        			\n");
	   sb.append("        passwd       			\n");
	   sb.append("FROM  hr_member      			\n");
	   sb.append("WHERE u_id like ? || '%'      \n");
	   sb.append("ORDER BY u_id			        \n");
	   
	   LOG.debug("1. sql log \n" + sb.toString());
	   LOG.debug("2. param log \n" + inVO.getuId());
	   
	   Object[] args = {inVO.getuId()};
	   list = jdbcTemplate.query(sb.toString(), args,new RowMapper<UserVO>() {

		@Override
		public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserVO user = new UserVO();
		    user.setuId(rs.getString("u_id"));
		    user.setName(rs.getString("name"));
		    user.setPassWd(rs.getString("passwd"));
		    
			return user;
		}
		   
	   });
	   
	   for(UserVO vo: list) {
		   LOG.debug("3. vo : "+vo);
	   }
	   
	   return list;
   }
   
   @SuppressWarnings("deprecation")
public int getCount(UserVO inVO) throws SQLException {
	   int cnt = 0;
	   StringBuilder sb = new StringBuilder();
	   sb.append("SELECT COUNT(*) cnt      \n");
	   sb.append("FROM HR_MEMBER           \n");
	   sb.append("WHERE u_id LIKE ? || '%'   \n");
	   
	   LOG.debug("1. sql log \n" + sb.toString());
	   LOG.debug("2. param log \n"+inVO);	   
	   
	   Object[] args = {inVO.getuId()};
	   LOG.debug("2.1. args : "+args[0].toString());
	   
	   cnt = jdbcTemplate.queryForObject(sb.toString(), args, Integer.class);
	   LOG.debug("3. cnt: "+cnt);
	   return cnt;
   }
   
   //단건삭제
   public int deleteOne(UserVO inVO) throws SQLException {
	      int flag = 0;
	      
		  StringBuilder sb = new StringBuilder();
		  sb.append("DELETE FROM HR_MEMBER \n");
		  sb.append("WHERE u_id = ?		\n");
		  LOG.debug("1. sql log \n" + sb.toString());
		  LOG.debug("2. param : \n"+ inVO);	   
		  
		  Object[] args = {inVO.getuId()};
		  flag = this.jdbcTemplate.update(sb.toString(), args);
		  LOG.debug("3. flag : "+ flag);	 
	      
	      return flag;
	   }
   

   // 단건조회
   public UserVO get(String id) throws SQLException {
      UserVO userVO = null;

      StringBuilder sb = new StringBuilder();
      sb.append("SELECT  u_id,      \n");
      sb.append("        name,        \n");
      sb.append("        passwd       \n");
      sb.append("FROM  hr_member      \n");
      sb.append("WHERE u_id = ?       \n");

      LOG.debug("1. sql log \n" + sb.toString());
      LOG.debug("2. param log \n" + id);
      
      Object[] args = {id}; 
      LOG.debug("2.1. param args log :" + args[0].toString());
      
      userVO = jdbcTemplate.queryForObject(sb.toString(), new RowMapper<UserVO>() {

		@Override
		public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserVO user = new UserVO();
		    user.setuId(rs.getString("u_id"));
		    user.setName(rs.getString("name"));
		    user.setPassWd(rs.getString("passwd"));
			return user;
		}
      }, args);
      
      LOG.debug("3. userVO : " + userVO);
      
      return userVO;
   }

   // 데이터 등록
   public int add(UserVO inVO) throws SQLException {
      int flag = 0;
      
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
      
      Object[] args = {inVO.getuId(), inVO.getName(), inVO.getPassWd()};
	  flag = this.jdbcTemplate.update(sb.toString(), args);
	  LOG.debug("3. flag : "+ flag);	 

      return flag;
   }
}