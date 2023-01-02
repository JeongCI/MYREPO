package com.pcwk.ehr;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingleToneMain {

	final static Logger LOG = LogManager.getFormatterLogger(SingleToneMain.class);
	
	public static void main(String[] args) {
		
		DaoFactory factory = new DaoFactory();
		
		UserDao userDao01 = factory.userDao();
		UserDao userDao02 = factory.userDao();
		//com.pcwk.ehr.UserDao@971d0d8
		//com.pcwk.ehr.UserDao@51931956
		
		LOG.debug("=====================");
		LOG.debug("=userDao01="+userDao01);
		LOG.debug("=userDao02="+userDao02);
		LOG.debug("=====================");
		
		//주소가 같다
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(DaoFactory.class);
		
		UserDao userDao03 = context.getBean("userDao", UserDao.class);
		UserDao userDao04 = context.getBean("userDao", UserDao.class);
		//com.pcwk.ehr.UserDao@6e9175d8
		//com.pcwk.ehr.UserDao@6e9175d8
		
		LOG.debug("=====================");
		LOG.debug("=userDao03="+userDao03);
		LOG.debug("=userDao04="+userDao04);
		LOG.debug("=====================");		
		
	}

}
