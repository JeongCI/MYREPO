package com.pcwk.ehr.ed07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

public class NaverBlogSearch {
	final static Logger LOG = Logger.getLogger(NaverBlogSearch.class);

	public static void main(String[] args) {
		// https://openapi.naver.com/v1/search/blog.json

		String clientId = "WHNtSCm0a1hA2oVWex0Y";
		String clientSecret = "pPYBIVPOpt";
		StringBuilder sb = new StringBuilder();
		
		try(FileWriter fw = new FileWriter(NaverBlogSearch.SAVE_JSON_FILE_PATH);
				BufferedWriter bw = new BufferedWriter(fw);) {
			String text = URLEncoder.encode("오라클", "UTF-8");
//			String apiURL = "https://openapi.naver.com/v1/search/blog.json?query=" + text+"&display=20";
			String apiURL = "https://openapi.naver.com/v1/search/book.json?query=" + text + "&display=10&start=2";

			URL url = new URL(apiURL);

			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);

			int responseCode = con.getResponseCode(); // 접속상태 코드
			LOG.debug("responeseCode : " + responseCode);

			BufferedReader br;
			if (responseCode == 200) { // 접속과, 조회 성공
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}

			LOG.debug("blog검색 : " + text);
			
			String inputLine = ""; // 데이터를 1줄씩 read
			while ((inputLine = br.readLine()) != null) { // 더이상 읽을 데이터가 없으면 null return
				bw.write(inputLine+'\n');
				sb.append(inputLine+"\n");
//				LOG.debug(inputLine);
			}
			System.out.println(sb.toString());
			
			// JSON 파싱
			Gson gson = new Gson();
			
			Channel channel = gson.fromJson(sb.toString(), Channel.class);
			List<Item> list = channel.getItems();
			
			for(Item item : list) {
				System.out.println(item.toString());
			}
			

			// stream을 닫기!
			br.close();

		} catch (Exception e) {

			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
