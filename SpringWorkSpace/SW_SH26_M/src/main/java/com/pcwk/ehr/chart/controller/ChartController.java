package com.pcwk.ehr.chart.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonArray;
import com.pcwk.ehr.chart.domain.PerformanceVO;
import com.pcwk.ehr.chart.domain.PizzaVO;
import com.pcwk.ehr.user.domain.LevelPieVO;

@Controller("chartController")
@RequestMapping("chart")
public class ChartController {

	final Logger LOG = LogManager.getLogger(getClass());
	
	public ChartController() {}
	
	@RequestMapping(value="/line.do", method = RequestMethod.GET)
	public String lineView() throws SQLException{
		LOG.debug("========================");
		LOG.debug("=lineView()=");
		LOG.debug("========================");
		
		return "chart/line";		
	}
	
	@RequestMapping(value="/pie.do", method = RequestMethod.GET)
	public String pieView() throws SQLException{
		LOG.debug("========================");
		LOG.debug("=pieView()=");
		LOG.debug("========================");
		
		return "chart/pie";
	}
	
	@RequestMapping(value="/drawLineChart.do",method = RequestMethod.GET
			,produces = "application/json;charset=UTF-8")
	@ResponseBody //비동기 처리를 하는 경우, HTTP 요청 부분의 body부분이 그대로 브라우저에 전달된다.
	public String drawLineChart() {  
		String jsonString = "";
		LOG.debug("┌=============================┐");	
		LOG.debug("|drawLineChart=");		
		LOG.debug("└=============================┘");	
		
		PerformanceVO perform01=new PerformanceVO("2004",1000,400);
		PerformanceVO perform02=new PerformanceVO("2005",1170,460);
		PerformanceVO perform03=new PerformanceVO("2006",660,1120);
		PerformanceVO perform04=new PerformanceVO("2007",1030,540);
		
		List<PerformanceVO> list =new ArrayList<PerformanceVO>();
		list.add(perform01);
		list.add(perform02);
		list.add(perform03);
		list.add(perform04);
		
		//[[],[],[],[],[]]
		JsonArray  jArray=new JsonArray();//1차 배열
		JsonArray hArray=new JsonArray();
		hArray.add("Year");//년도
		hArray.add("매출");//매출
		hArray.add("지출");//매출
		jArray.add(hArray);  
		
		for(PerformanceVO vo   :list) {
			JsonArray sArray=new JsonArray();
			sArray.add(vo.getYear());//년도
			sArray.add(vo.getSales());//매출
			sArray.add(vo.getExpenses());//매출
			
			jArray.add(sArray);  
		}
		
		jsonString = jArray.toString();
		
		return jsonString;
		
	}
	
	@RequestMapping(value="/drawMemberPieChart.do",method = RequestMethod.GET
			,produces = "application/json;charset=UTF-8")
	@ResponseBody //비동기 처리를 하는 경우, HTTP 요청 부분의 body부분이 그대로 브라우저에 전달된다.
	public String drawMemberPieChart() {
		String jsonString = "";
		LOG.debug("┌=============================┐");	
		LOG.debug("|drawMemberPieChart=");		
		LOG.debug("└=============================┘");
		LevelPieVO  levelPie01=new LevelPieVO("BASIC", 12);
		LevelPieVO  levelPie02=new LevelPieVO("SILVER", 12);
		LevelPieVO  levelPie03=new LevelPieVO("GOLD", 9);
		
		List<LevelPieVO> list =new ArrayList<LevelPieVO>();
		list.add(levelPie01);
		list.add(levelPie02);
		list.add(levelPie03);
		
		//[[],[],[],[],[]]
		JsonArray  jArray=new JsonArray();//1차 배열
		
		for(LevelPieVO vo   :list) {
			JsonArray sArray=new JsonArray();
			sArray.add(vo.getLevelName()); //레벨명
			sArray.add(vo.getLevelCount());//레벨수
		
			jArray.add(sArray);  
		}
		jsonString = jArray.toString();
		LOG.debug("┌=============================┐");	
		LOG.debug("|jsonString="+jsonString);		
		LOG.debug("└=============================┘");		
		
		return jsonString;
	}
	
	
	@RequestMapping(value="/drawPieChart.do",method = RequestMethod.GET
			,produces = "application/json;charset=UTF-8")
	@ResponseBody //비동기 처리를 하는 경우, HTTP 요청 부분의 body부분이 그대로 브라우저에 전달된다.
	public String drawPieChart() {
		String jsonString = "";
		LOG.debug("┌=============================┐");	
		LOG.debug("|drawPieChart=");		
		LOG.debug("└=============================┘");
		
		PizzaVO  pizza01=new PizzaVO("버섯", 3);
		PizzaVO  pizza02=new PizzaVO("양파", 1);
		PizzaVO  pizza03=new PizzaVO("올리브", 1);
		PizzaVO  pizza04=new PizzaVO("호박", 1);
		PizzaVO  pizza05=new PizzaVO("페페로니", 2);
		
		List<PizzaVO> list =new ArrayList<PizzaVO>();
		list.add(pizza01);
		list.add(pizza02);
		list.add(pizza03);
		list.add(pizza04);
		list.add(pizza05);
		
		//[[],[],[],[],[]]
		JsonArray  jArray=new JsonArray();//1차 배열
		
		for(PizzaVO vo   :list) {
			JsonArray sArray=new JsonArray();
			sArray.add(vo.getTopping());//토핑
			sArray.add(vo.getSlices());//슬라이스
		
			jArray.add(sArray);  
		}
		
		jsonString = jArray.toString();
		
		LOG.debug("┌=============================┐");	
		LOG.debug("|jsonString="+jsonString);		
		LOG.debug("└=============================┘");		
		
		return jsonString;
	}
	
	
}















