package com.pcwk.ehr.ed05.crawling;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

import com.pcwk.ehr.cmn.LoggerManger;

public class CGVCrawiling implements LoggerManger{

	final static String URL = "http://www.cgv.co.kr/movies/?lt=1&ft=0"; // CGV moive chart
	public static void main(String[] args) {
		
		try {
			Document doc = Jsoup.connect(URL).get();
			// html 태그 구분자는 space
			// html css 구분자 "."
			Elements titles = doc.select("div.box-contents strong.title");
			
			Elements reserveRatio = doc.select("div.score strong.percent span");
			
			Elements openrun = doc.select("span.txt-info strong");
			
			Elements poster = doc.select("span.thumb-image img");
			
			for(int i = 0; i < 7; i++) {
				Element titleElement = titles.get(i);
				Element reserveRationElement = reserveRatio.get(i);
				Element openrunElement = openrun.get(i);
				Element posterElement = poster.get(i);
				
				String posterImgUrl = poster.get(i).attr("src");
				
				LOG.debug((i+1)+". "+titleElement.text()+", 예매율: "
						+reserveRationElement.text()
						+", 개봉일: " + openrunElement.text().replace("개봉", "")
						+", 포스터: "+ posterImgUrl);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}