package com.pcwk.ehr.ed05.autocloseable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.pcwk.ehr.cmn.LoggerManger;

public class TryWithResource implements LoggerManger {
	// 리소스를 자동해제 하도록 제공해주는 문구
	// AutoCloseable인터페이스를 구현해야함.
	// close()를 명시적으로 넣을 필요 없음.
	//JVM이 알아서 close() 처리함.

	public static void main(String[] args) {
		LOG.debug("1");
		FileInputStream fis = null;
		try {
			LOG.debug("2");
			// C:\DCOM_0725\03_JAVA\WorkSpace2\J10\src\com\pcwk\ehr\ed05\autocloseable\TryWithResource.java
			fis = new FileInputStream("C:\\DCOM_0725\\03_JAVA\\WorkSpace2\\J10\\src\\com\\pcwk\\ehr\\ed05\\autocloseable\\TryWithResource1.java");
			LOG.debug("2.1");
			
		}catch(FileNotFoundException e) {
			LOG.debug("3 FileNotFoundException : "+e.getMessage());
		}catch(IOException e) {
			LOG.debug("3 IOException : "+e.getMessage());
		}finally {
			try {
				if(null != fis) {
					fis.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		LOG.debug("프로그램 종료");
		
	}

}