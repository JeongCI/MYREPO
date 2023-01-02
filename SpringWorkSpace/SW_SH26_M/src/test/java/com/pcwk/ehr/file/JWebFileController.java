package com.pcwk.ehr.file;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.io.FileInputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)//spring-test lib에 있음!
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"
		                          ,"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-test-context.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JWebFileController {
	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	WebApplicationContext webApplicationContext;
	
	//브라우저 대역(Mock)
	MockMvc  mockMvc;
	
	@Value("${file.save.file_path}")
	private String file_path;
	
	MockMultipartFile mockMultipartFile01;//java파일
	MockMultipartFile mockMultipartFile02;//이미지파일
	/*
	 *  Content-Type: image/png
		Content-Type: image/jpeg
		Content-Type: image/gif
		Content-Type: image/webp
	 */
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		String  fileName01 = "AnnoController";
		String  fileExt01  = "java";
		String  filePath01 = "E:\\DCOM_0725\\06_SPRING\\workspace\\SW_SH23\\src\\main\\java\\com\\pcwk\\ehr\\anno\\controller\\AnnoController.java";

		mockMultipartFile01 = new MockMultipartFile("file01"
				, fileName01+"."+fileExt01
				, "multipart/form-data"
				, new FileInputStream(new File(filePath01)));
		
		String  fileName02 = "bg_fixed";
		String  fileExt02  = "png";
		String  filePath02 = "E:\\DCOM_0725\\06_SPRING\\workspace\\SW_SH23\\src\\main\\webapp\\resources\\images\\bg_fixed.png";
				
		//image
		mockMultipartFile02 = new MockMultipartFile("file02"
				, fileName02+"."+fileExt02
				, "multipart/form-data"
				, new FileInputStream(new File(filePath02)));		
	}


	
	@Test
	@Ignore
	public void upload() throws Exception{
		MockHttpServletRequestBuilder requestBuilder =
				MockMvcRequestBuilders.multipart("/file/upload.do")
				.file(mockMultipartFile01)
				.file(mockMultipartFile02);
		
		ResultActions resultActions = mockMvc.perform(requestBuilder)
				        .andDo(print())
						.andExpect(status().is2xxSuccessful());
		
	}
	
	@Test
	public void beans() {
		LOG.debug("┌=============================┐");	
		LOG.debug("|webApplicationContext="+webApplicationContext);		
		LOG.debug("|mockMvc="+mockMvc);
		LOG.debug("|file_path="+file_path);		
		LOG.debug("└=============================┘");			
				
		assertNotNull(webApplicationContext);
		assertNotNull(mockMvc);
	}

}






