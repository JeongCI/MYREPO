package com.pcwk.ehr;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Excel생성
 * @author ITSC
 *
 */
public class ExcelMain {
    final static Logger LOG = LogManager.getLogger(ExcelMain.class);
    
    
	public static void main(String[] args) {
		String fileNameXls  = "C:\\upload\\pcwk.xls";
		String fileNameXlxs = "C:\\upload\\pcwk.xlsx";	
		try {
			//int flag = xlsWrite("pcwk_1216",fileNameXls);
			int flag = xlxsWrite("pcwk_1216",fileNameXlxs);
			LOG.debug("===================");
			LOG.debug("=flag="+flag);
			LOG.debug("===================");
		} catch (IOException e) {
			LOG.debug("==========================");
			LOG.debug("=IOException="+e.getMessage());
			LOG.debug("==========================");
			e.printStackTrace();
		}
		LOG.debug(fileNameXls+"=생성 완료=");	
	}
	
	/**
	 * 엘셀: 2007이상 버전
	 * @param workBook
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static int xlxsWrite(String workBook, String fileName) throws IOException{
		int flag = 0;
		//fileName,
		//2007이상
		Workbook wk =new XSSFWorkbook();
		
		Sheet sheet01 = wk.createSheet(workBook);
		
		FileOutputStream fos=new FileOutputStream(fileName);
		wk.write(fos);
		fos.close();
		flag = 1;
		
		return flag;
	}
	
	/**
	 * 엘셀: 97~2003
	 * @param workBook
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static int xlsWrite(String workBook, String fileName) throws IOException{
		int flag = 0;
		//fileName,
		Workbook wk =new HSSFWorkbook();
		
		Sheet sheet01 = wk.createSheet(workBook);
		
		FileOutputStream fos=new FileOutputStream(fileName);
		wk.write(fos);
		fos.close();
		flag = 1;
		
		return flag;
	}
}
