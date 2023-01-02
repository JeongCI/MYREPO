package com.pcwk.ehr.naver.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.pcwk.ehr.cmn.SearchVO;

@Service("naverSearchService")
public class NaverSearchServiceImpl implements NaverSearchService {
//	blog	https://openapi.naver.com/v1/search/blog.json							
//	뉴스		https://openapi.naver.com/v1/search/news.json							
//	책		https://openapi.naver.com/v1/search/book.json							
//	cafe	https://openapi.naver.com/v1/search/cafearticle.json							
//	쇼핑		https://openapi.naver.com/v1/search/shop.json							

	final Logger LOG = LogManager.getLogger(getClass());
	final String BASE_URL = "https://openapi.naver.com/v1/search/";

	@Override
	public String doNaverSearch(SearchVO inVO) throws IOException {

		String clientId = "xkHJBdkGsqi8u1fyY_WT"; // Naver 회원 ID
		String clientSecret = "gHSDoIjdTs"; // Naver 회원 비번

		String blog = "blog.json";// blog (10)
		String news = "news.json";// 뉴스 (20)
		String book = "book.json";// 책 (30)
		String cafearticle = "cafearticle.json";// cafe (40)
		String shop = "shop.json";// 쇼핑 (50)

		StringBuilder responseData = new StringBuilder(2000);
		BufferedReader br = null;
		try {
			// 검색어
			String searchText = URLEncoder.encode(inVO.getSearchWord(), "UTF-8");

			String apiURL = "";
			String queryString = "?query=" + searchText + "&display=" + inVO.getPageSize() + "&start="
					+ inVO.getPageNo();

			switch (inVO.getSearchDiv()) {
			case "10":
				apiURL = BASE_URL + blog + queryString;
				break;
			case "20":
				apiURL = BASE_URL + news + queryString;
				break;
			case "30":
				apiURL = BASE_URL + book + queryString;
				break;
			case "40":
				apiURL = BASE_URL + cafearticle + queryString;
				break;
			case "50":
				apiURL = BASE_URL + shop + queryString;
				break;
			}

			LOG.debug("inVO:" + inVO);
			LOG.debug("apiURL:" + apiURL);

			URL url = new URL(apiURL);

			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);

			int responseCode = con.getResponseCode();
			LOG.debug("responseCode:" + responseCode);

			if (200 == responseCode) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));

				String inputLine = "";
				while ((inputLine = br.readLine()) != null) {
					responseData.append(inputLine);
				}

			}
		} catch (IOException e) {
			LOG.debug("IOException:" + e.getMessage());
			throw e;
		} finally {
			if (null != br) {
				try {
					br.close();
				} catch (IOException e) {

				}
			}
		}

		return responseData.toString();
	}

}
