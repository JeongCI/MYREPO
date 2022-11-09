package com.pcwk.ehr.ed10.pfinally;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;

public class FinallyMain {
	final static Logger LOG = Logger.getLogger(FinallyMain.class);

	public static void main(String[] args) {
		FileInputStream fis = null;
		
		try {
			LOG.debug("1");
			fis = new FileInputStream("C:\\DCOM_0725\\03_JAVA\\WorkSpace2\\J09\\src\\com\\pcwk\\ehr\\ed10\\pfinally\\FinallyMain99.java");
		}catch(FileNotFoundException e) {
			LOG.debug("2"+e.getMessage());
			
		}finally {
			try {
				if(null != fis) {
				fis.close();
				}
			} catch (IOException e) {
				LOG.debug("3");
			}
			LOG.debug("3.1 finally");
		}
		
		LOG.debug("프로그램 종료");
		
		
	}

}