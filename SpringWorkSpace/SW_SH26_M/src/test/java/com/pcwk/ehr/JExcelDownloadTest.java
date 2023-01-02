package com.pcwk.ehr;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.record.HSSFRecordTypes;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pcwk.ehr.cmn.SearchVO;
import com.pcwk.ehr.cmn.StringUtil;
import com.pcwk.ehr.user.dao.UserDao;
import com.pcwk.ehr.user.domain.Level;
import com.pcwk.ehr.user.domain.UserVO;

@RunWith(SpringJUnit4ClassRunner.class) // spring-test lib에 있음!
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-test-context.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JExcelDownloadTest {
	final Logger LOG = LogManager.getLogger(getClass());

	@Autowired // 테스트 오브젝트가 만들어지고 나면 스프링 테스트 컨텍스트에 의해 자동으로 값으 주입된다.
	ApplicationContext context;

	@Autowired
	UserDao dao;

	SearchVO searchVO;

	String fileNameCSV = "c:\\upload\\pcwk.csv";
	String fileNameXls = "c:\\upload\\pcwk.xls";
	String fileNameXlsx = "c:\\upload";

	// 테스트 데이터
	UserVO userVO1;
	UserVO userVO2;
	UserVO userVO3;
	UserVO userVO4;
	UserVO userVO5;
	UserVO search;

	@Before
	public void setUp() throws Exception {
		// 페이지+검색
		searchVO = new SearchVO(10, 1, "", "", "");
		search = new UserVO("p99", "이상무99_05", "4321", Level.GOLD, 100, 31, "jamesol@paran.com", "날짜_사용하지 않음");

		userVO1 = new UserVO("p99_01", "이상무99_01", "4321", Level.BASIC, 1, 0, "jamesol@paran.com", "날짜_사용하지 않음");
		userVO2 = new UserVO("p99_02", "이상무99_02", "4321", Level.SILVER, 50, 2, "jamesol@paran.com", "날짜_사용하지 않음");
		userVO3 = new UserVO("p99_03", "이상무99_03", "4321", Level.GOLD, 100, 31, "jamesol@paran.com", "날짜_사용하지 않음");
		userVO4 = new UserVO("p99_04", "이상무99_04", "4321", Level.SILVER, 50, 2, "jamesol@paran.com", "날짜_사용하지 않음");
		userVO5 = new UserVO("p99_05", "이상무99_05", "4321", Level.GOLD, 100, 31, "jamesol@paran.com", "날짜_사용하지 않음");

	}

	@Test
	public void excelDownload() throws SQLException, IOException {
		// 1.데이터 삭제
		// 2.데이터 입력
		// 3.조회

		// 1.
		dao.doDelete(userVO1);
		dao.doDelete(userVO2);
		dao.doDelete(userVO3);
		dao.doDelete(userVO4);
		dao.doDelete(userVO5);

		// 2.
		dao.doSave(userVO1);
		dao.doSave(userVO2);
		dao.doSave(userVO3);
		dao.doSave(userVO4);
		dao.doSave(userVO5);

		assertEquals(5, dao.getCount(search));

		xlxsWrite("pcwk_1219", fileNameXlsx);
	}

	/**
	 * 엘셀: 2007이상 버전
	 * 
	 * @param workBook
	 * @param fileName
	 * @return
	 * @throws IOException
	 * @throws SQLException 
	 */
	private int xlxsWrite(String workBook, String fileName) throws IOException, SQLException {
		//Excel download 일반화
		//1.header 이름 [] 
		//2.header 넓이 []
		//3.data정렬       []
		//4.데이터 출력 순서
		
		int flag = 0;
		// fileName,
		// 2007이상
		Workbook wk = new XSSFWorkbook();

		Sheet sheet01 = wk.createSheet(workBook);
		int rowNo = 0;// row번호
		int cellNo = 0;//cell번호
		
		// header(NO,아이디, 이름, 등급, 이메일, 등록일)
		String header = "NO,아이디,이름,등급,이메일,등록일";
		String[] headerArray = header.split(",");
		
		//header row생성
		
		//header style지정
		CellStyle  headerStyle = wk.createCellStyle();
		
		
		//header line
		headerStyle.setBorderTop(BorderStyle.THIN);
		headerStyle.setBorderBottom(BorderStyle.THIN);
		headerStyle.setBorderLeft(BorderStyle.THIN);
		headerStyle.setBorderRight(BorderStyle.THIN);
		
		//header background
		headerStyle.setFillForegroundColor(IndexedColors.AQUA.index);//배경색
		headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);//채우기
		
		//정렬
		headerStyle.setAlignment(HorizontalAlignment.CENTER);
		
		//Font
		Font  headerFont = wk.createFont();
		headerFont.setFontName("나눔고딕");//글씨체
		headerFont.setFontHeight((short)300);//크기
		headerFont.setBold(true);//볼드체
		headerStyle.setFont(headerFont);
		
		Cell cell = null;
		
		Row headerRow = sheet01.createRow(rowNo++);
		sheet01.setColumnWidth(0, 3000);
		sheet01.setColumnWidth(1, 3000);
		sheet01.setColumnWidth(2, 6000);
		sheet01.setColumnWidth(3, 6000);
		sheet01.setColumnWidth(4, 9000);
		sheet01.setColumnWidth(5, 3000);
		
		for(String headerText:headerArray) {
			cell = headerRow.createCell(cellNo++);
			cell.setCellStyle(headerStyle);
			cell.setCellValue(headerText);
			
			//column 넓이 지정
			
			
		}

		// 데이터
		List<UserVO> list = dao.doRetrive(searchVO);
		
		CellStyle  dataStyleCenter = wk.createCellStyle();
		dataStyleCenter.setBorderTop(BorderStyle.THIN);
		dataStyleCenter.setBorderBottom(BorderStyle.THIN);
		dataStyleCenter.setBorderLeft(BorderStyle.THIN);
		dataStyleCenter.setBorderRight(BorderStyle.THIN);
		dataStyleCenter.setAlignment(HorizontalAlignment.CENTER);
		
		CellStyle  dataStyleLeft = wk.createCellStyle();
		dataStyleLeft.setBorderTop(BorderStyle.THIN);
		dataStyleLeft.setBorderBottom(BorderStyle.THIN);
		dataStyleLeft.setBorderLeft(BorderStyle.THIN);
		dataStyleLeft.setBorderRight(BorderStyle.THIN);
		dataStyleLeft.setAlignment(HorizontalAlignment.LEFT);
		
		CellStyle  dataStyleRight = wk.createCellStyle();
		dataStyleRight.setBorderTop(BorderStyle.THIN);
		dataStyleRight.setBorderBottom(BorderStyle.THIN);
		dataStyleRight.setBorderLeft(BorderStyle.THIN);
		dataStyleRight.setBorderRight(BorderStyle.THIN);
		dataStyleRight.setAlignment(HorizontalAlignment.RIGHT);
		
		//LOG.debug("list:"+list.size());
		for(int i=0;i<list.size();i++) {
			Row dataRow = sheet01.createRow(rowNo++);
			
			UserVO vo = list.get(i);
			cellNo = 0;
			//NO
			cell = dataRow.createCell(cellNo++);
			cell.setCellStyle(dataStyleCenter);
			cell.setCellValue(vo.getNum());		
			
			//ID
			cell = dataRow.createCell(cellNo++);
			cell.setCellStyle(dataStyleCenter);
			cell.setCellValue(vo.getuId());					
			
			//이름
			cell = dataRow.createCell(cellNo++);
			cell.setCellStyle(dataStyleLeft);
			cell.setCellValue(vo.getName());
			
			//등급
			cell = dataRow.createCell(cellNo++);
			cell.setCellStyle(dataStyleCenter);
			cell.setCellValue(vo.getLevel().toString());
			
			//이메일
			cell = dataRow.createCell(cellNo++);
			cell.setCellStyle(dataStyleLeft);
			cell.setCellValue(vo.getEmail());
			
			//등록일
			cell = dataRow.createCell(cellNo++);
			cell.setCellStyle(dataStyleCenter);
			cell.setCellValue(vo.getRegDt());	
			
		}
		
        //파일명: YYYYMMDD+32
		String saveFileName = StringUtil.getPK()+"."+"xlsx";
		File  outFile=new File(fileName, saveFileName);
		
		
		FileOutputStream fos = new FileOutputStream(outFile);
		wk.write(fos);
		fos.close();
		flag = 1;

		return flag;
	}

	/**
	 * 엘셀: 97~2003
	 * 
	 * @param workBook
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static int xlsWrite(String workBook, String fileName) throws IOException {
		int flag = 0;
		// fileName,
		Workbook wk = new HSSFWorkbook();

		Sheet sheet01 = wk.createSheet(workBook);

		FileOutputStream fos = new FileOutputStream(fileName);
		wk.write(fos);
		fos.close();
		flag = 1;

		return flag;
	}

	@Test
	public void beans() {
		LOG.debug("==============================");
		LOG.debug("=context=" + context);
		LOG.debug("=dao=" + dao);
		LOG.debug("==============================");
		assertNotNull(context);
		assertNotNull(dao);
	}

}
