package com.pcwk.ehr.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.servlet.View;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.pcwk.ehr.cmn.StringUtil;
import com.pcwk.ehr.file.domain.FileVO;
import com.pcwk.ehr.user.domain.UserVO;

import net.coobird.thumbnailator.Thumbnailator;

@Controller("fileController")
@RequestMapping("file")
@Configuration  //환경설정 파일 읽기, 경로 설정
@PropertySource("classpath:/resource/config/env_dev.properties")
public class FileController {

	@Value("${file.save.file_path}")
	private String FILE_PATH ;// 일반 파일
	
	@Value("${file.save.img_path}")  
	private String IMG_PATH = "";// 이미지
	
	@Value("${file.save.img_view_path}")																												
	private String IMG_VIEW_PATH = "";
	

	final Logger LOG = LogManager.getLogger(getClass());
	String addYYYYMMPath = "";

	@Resource(name = "downloadView")
	View download;
	
	public FileController() {
		//init();
	}

	/**
	 * 파일 다운로드
	 * @param fileVO
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping(value="/download.do", method = RequestMethod.POST)
	public ModelAndView download(FileVO fileVO, ModelAndView modelAndView) {
		LOG.debug("=========================");
		LOG.debug("=download()=");
		LOG.debug("=fileVO()="+fileVO);
		LOG.debug("=========================");
		
		//원본파일명
		//File객체
		
		File downloadFile =new File(fileVO.getSavePath(),fileVO.getSaveFileName());
		//view지정 : com.pcwk.ehr.file.DownloadView
		modelAndView.setView(download);
		
		//원본파일명
		modelAndView.addObject("orgFileNm", fileVO.getOrgFileName());
		
		//파일객체
		modelAndView.addObject("downloadFile", downloadFile);
		
		return modelAndView;
	}
	
	

	
	
	public void init() {
		// 1. 디렉토리 동적 생성: yyyy 디렉토리, mm디렉토리
		// ex)c:\\upload\\2022\\12
		String yyyyFolder = StringUtil.getCurrentDate("yyyy");
		// LOG.debug("|yyyyFolder="+yyyyFolder);
		String mmFolder = StringUtil.getCurrentDate("MM");
		// LOG.debug("|mmFolder="+mmFolder);
		// LOG.debug("|File.separator="+ File.separator );

		LOG.debug("|FILE_PATH="+FILE_PATH);
		LOG.debug("|IMG_PATH="+IMG_PATH);
		LOG.debug("|IMG_VIEW_PATH="+IMG_VIEW_PATH);
		
		
		// \2022\12
		addYYYYMMPath = File.separator + yyyyFolder + File.separator + mmFolder;
		LOG.debug("|addYYYYMMPath=" + addYYYYMMPath);

		//IMG_VIEW_PATH =IMG_VIEW_PATH+"/"+yyyyFolder+"/"+mmFolder ;   
		
		// 일반 파일
		File nomalFileDir = new File(FILE_PATH + addYYYYMMPath);
		if (nomalFileDir.isDirectory() == false) {
			boolean isNormalMake = nomalFileDir.mkdirs();
			LOG.debug("┌=============================┐");
			LOG.debug("|isNormalMake=" + isNormalMake);
		}

		// 이미지파일
		File imageFileDir = new File(IMG_PATH + addYYYYMMPath);
		if (imageFileDir.isDirectory() == false) {
			boolean isImageMake = imageFileDir.mkdirs();
			LOG.debug("|isImageMake=" + isImageMake);
		}

		LOG.debug("└=============================┘");
	}

	@RequestMapping(value="/viewFile.do")
	public String viewFile()throws Exception{
		LOG.debug("┌=============================┐");
		LOG.debug("|viewFile=");	
		LOG.debug("└=============================┘");
		LOG.debug("|FILE_PATH="+FILE_PATH);
		LOG.debug("|IMG_PATH="+IMG_PATH);
		LOG.debug("|IMG_VIEW_PATH="+IMG_VIEW_PATH);
		
		
		return "file/fileUpload";
	}
	
	/**
	 * ajax 파일 업로드
	 * @param mReg
	 * @return JSON(List<FileVO>)
	 * @throws IOException
	 */
	@RequestMapping(value="/ajaxUpload.do",method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody //비동기 처리를 하는 경우, HTTP 요청 부분의 body부분이 그대로 브라우저에 전달된다.
	public String ajaxUpload(MultipartHttpServletRequest mReg, HttpServletRequest req) throws IOException {
		String jsonString = "";
		
		init();

		List<FileVO> list = new ArrayList<FileVO>();

		Iterator<String> fileNames = mReg.getFileNames();

		while (fileNames.hasNext()) {
			String upfileName = fileNames.next();
			LOG.debug("|upfileName=" + upfileName);

			FileVO outVO = new FileVO();

			MultipartFile multipartFile = mReg.getFile(upfileName);
			// 원본파일명
			outVO.setOrgFileName(multipartFile.getOriginalFilename());

			if(null == outVO.getOrgFileName() || "".equals(outVO.getOrgFileName())) {
				continue;
			}
			
			
			String ext = "";
			if (outVO.getOrgFileName().indexOf(".") > -1) {
				int idx = outVO.getOrgFileName().lastIndexOf(".");
				ext = outVO.getOrgFileName().substring(idx + 1);
			}

			// 확장자
			outVO.setExt(ext);

			// 파일사이즈
			outVO.setFileSize(multipartFile.getSize());

			String savePath = "";
			
			
			if ("png".equalsIgnoreCase(ext) || "jpeg".equalsIgnoreCase(ext) || "jpg".equalsIgnoreCase(ext)
					|| "gif".equalsIgnoreCase(ext)) {
				savePath = this.IMG_PATH + addYYYYMMPath;
				
				String yyyyFolder = StringUtil.getCurrentDate("yyyy");
				// LOG.debug("|yyyyFolder="+yyyyFolder);
				String mmFolder = StringUtil.getCurrentDate("MM");
				
				String tomcatYearMonthFolder = IMG_VIEW_PATH+"/"+yyyyFolder+"/"+mmFolder ;
				//Tomcat 실제 경로
				String tomcatRealPath = req.getServletContext().getRealPath(tomcatYearMonthFolder);
				savePath = tomcatRealPath;
				
				LOG.debug("|tomcatRealPath="+tomcatRealPath);		
				outVO.setImageViewPath(tomcatYearMonthFolder);
				LOG.debug("|getImageViewPath="+outVO.getImageViewPath());		
			} else {
				savePath = this.FILE_PATH + addYYYYMMPath;
			}

			// 저장경로
			outVO.setSavePath(savePath); 
			
			// 저장파일명
			String saveFileName = StringUtil.getPK()+"."+ext;
			outVO.setSaveFileName(saveFileName);
			
			LOG.debug("|outVO="+outVO);
			
			
			
			File  saveFileObj = new File(outVO.getSavePath(),outVO.getSaveFileName());
			
			multipartFile.transferTo(saveFileObj);
			
			//image파일인지 판단
			//s_저장파일명
			if(isImageFile(saveFileObj)) {
			   	FileOutputStream  thumbnail = new FileOutputStream(
			   			                              new File(outVO.getSavePath(),"s_"+outVO.getSaveFileName()));
			   	try {
			   		Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 100, 100);
			   	}catch(IOException e) {
			   		LOG.debug(e.getMessage());
			   		throw e;
			   	}
			   	
			   	
			}
			
			
			
			list.add(outVO);
		}  
		
		jsonString = new Gson().toJson(list);
		LOG.debug("|jsonString="+jsonString);
		return jsonString;
	}
	
	/**
	 * 파일이 image인지 판단
	 * @param file
	 * @return true/false
	 */
	private boolean isImageFile(File file) {
		try {
			String contentType = Files.probeContentType(file.toPath());
			LOG.debug("|contentType="+contentType);
			return null !=contentType && contentType.startsWith("image");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	/**
	 * 파일 업로드 method = RequestMethod.POST
	 * 
	 * @param modelAndView
	 * @param mReg
	 * @return modelAndView
	 * @throws IOException
	 */
	@RequestMapping(value = "/upload.do", method = RequestMethod.POST)
	public ModelAndView upload(ModelAndView modelAndView, MultipartHttpServletRequest mReg) throws IOException {
		LOG.debug("┌=============================┐");
		LOG.debug("|upload=");

		init();

		List<FileVO> list = new ArrayList<FileVO>();

		Iterator<String> fileNames = mReg.getFileNames();

		while (fileNames.hasNext()) {
			String upfileName = fileNames.next();
			LOG.debug("|upfileName=" + upfileName);

			FileVO outVO = new FileVO();

			MultipartFile multipartFile = mReg.getFile(upfileName);
			// 원본파일명
			outVO.setOrgFileName(multipartFile.getOriginalFilename());

			if(null == outVO.getOrgFileName() || "".equals(outVO.getOrgFileName())) {
				continue;
			}
			
			
			String ext = "";
			if (outVO.getOrgFileName().indexOf(".") > -1) {
				int idx = outVO.getOrgFileName().lastIndexOf(".");
				ext = outVO.getOrgFileName().substring(idx + 1);
			}

			// 확장자
			outVO.setExt(ext);

			// 파일사이즈
			outVO.setFileSize(multipartFile.getSize());

			String savePath = "";
			if ("png".equalsIgnoreCase(ext) || "jpeg".equalsIgnoreCase(ext) || "jpg".equalsIgnoreCase(ext)
					|| "gif".equalsIgnoreCase(ext)) {
				savePath = this.IMG_PATH + addYYYYMMPath;
			} else {
				savePath = this.FILE_PATH + addYYYYMMPath;
			}

			// 저장경로
			outVO.setSavePath(savePath);
			
			// 저장파일명
			String saveFileName = StringUtil.getPK()+"."+ext;
			outVO.setSaveFileName(saveFileName);
			
			LOG.debug("|outVO="+outVO);
			
			File  saveFileObj = new File(outVO.getSavePath(),outVO.getSaveFileName());
			multipartFile.transferTo(saveFileObj);
			
			list.add(outVO);
		}

		modelAndView.addObject("list", list);
		modelAndView.setViewName("file/fileUpload");
		return modelAndView;
	}

}
