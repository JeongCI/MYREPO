package com.pcwk.ehr.naver.service;

import java.io.IOException;

import com.pcwk.ehr.cmn.SearchVO;

/**
 * Naver  검색 API
 * blog
 * 뉴스
 * 책
 * cafe
 * 쇼핑
 * @author ITSC
 *
 */
public interface NaverSearchService {

	/**
	 * Naver 검색
	 * @param inVO
	 * @return JSON(String)
	 * @throws IOException
	 */
	String doNaverSearch(SearchVO inVO)throws IOException;
}
