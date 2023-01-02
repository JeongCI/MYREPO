package com.pcwk.ehr.code;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pcwk.ehr.cmn.StringUtil;
import com.pcwk.ehr.code.dao.CodeDao;
import com.pcwk.ehr.code.domain.CodeVO;

@RunWith(SpringJUnit4ClassRunner.class)//spring-test lib에 있음!
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"
		                          ,"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JWCodeDao {
	final Logger LOG = LogManager.getLogger(getClass());
	@Autowired //테스트 오브젝트가 만들어지고 나면 스프링 테스트 컨텍스트에 의해 자동으로 값으 주입된다.
	ApplicationContext context;
	
	@Autowired
	CodeDao dao;
	
	List<String> codes;
	
	@Before
	public void setUp() throws Exception {
		codes = Arrays.asList("PAGE_SIZE","BOARD_SEARCH");
	}
	
	@Test
	public void doRetrive() throws SQLException {
		List<CodeVO> list = dao.doRetrive(codes);
	}

	@Test
	public void beans() {
		LOG.debug("==============================");
		LOG.debug("context:"+context);	
		LOG.debug("dao:"+dao);
		LOG.debug("==============================");
		
		assertNotNull(context);
		assertNotNull(dao);
		assertNotNull(codes);
	}

}
