package com.pcwk.ehr.ed05.url;

import java.net.*;

public class Ex01URL {

	public static void main(String[] args) {
		String urlPath = "https://search.naver.com:443/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=%EB%A7%9B%EC%A7%91";
		try {
			URL url = new URL(urlPath);
			System.out.println("프로토콜 : " + url.getProtocol());
			System.out.println("호스트명 포트번호 : " + url.getAuthority());
			System.out.println("쿼리 : " + url.getQuery());
			System.out.println("전체 주소 : " + url.toURI());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		System.out.println("호출!");
	}
}
//프로토콜 : https
//호스트명 포트번호 : search.naver.com:443
//쿼리 : where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=%EB%A7%9B%EC%A7%91
//전체 주소 : https://search.naver.com:443/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=%EB%A7%9B%EC%A7%91
//호출!