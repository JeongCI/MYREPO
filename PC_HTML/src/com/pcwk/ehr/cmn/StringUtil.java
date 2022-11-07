package com.pcwk.ehr.cmn;

public class StringUtil {

	/**
	 * Null처리
	 * 
	 * @param input
	 * @param replace
	 * @return
	 */
	public static String nvl(String input, String replace) {
		String retString = "";

		retString = (input == null) ? replace : input;

		return retString.trim();
	}
	public static String nvl(String input) {
		return nvl(input, "");
	}

	public static String toReplace(String str) {
		if (str == null) {
			return null;
		}

		return str.replaceAll("[&]", "&amp;")
				  .replaceAll("[<]", "&lt;")
				  .replaceAll("[>]", "&gt;")
				  .replaceAll("[\"]","&quot;");
	}
	
	/**
	 * 
	 * @param maxNum: 총글수
	 * @param currPageNo: 현재페이지
	 * @param rowPerPage: 10/ 20/ 30/ 50/ 100
	 * @param buttomCount: 10
	 * @param url: http://localhost:8089/PC_HTML/board/board.do?work_div=doRetrieve&page_no=1&search_div=&search_word=&page_size=10
	 * @param scriptName: javascript function name
	 * @return
	 */
		
		/* 
         <table class="page_table">
          <tr >
           <td class="txt_center">
             <ul>
              <li>
	              <a href="javascript:doRetrieve(url, 1)">&laquo;
	              </a>
              </li>
              <li><a href=""javascript:doRetrieve(url, 계산)">&lt;</a></li>
		           <% for(int i=1;i<=10;i++){ %>
		           <li><a href="#"><%=i %></a></li>
		           <% } %>
              <li><a href="#">&gt;</a></li>
              <li><a href="#">&raquo;</a></li>                         
             </ul>
           </td>          
          </tr>
         </table>
		 * */
	
	public static String renederPaging(int maxNum, int currPageNo, int rowPerPage, int bottomCount,String url, String scriptName) {
		StringBuilder html=new StringBuilder(2000);
        
		/*
		 * maxNum:총글수 (21)
		 * currPageNo : 현재 페이지(1)
		 * rowPerPage : 10
		 * bottomCount: 10
		 * << < 1 2 3 4 5 6 7 8 9 10 > >>
		 */
		
		int maxPageNo   = ((maxNum -1)/rowPerPage) + 1;
		int startPageNo = ((currPageNo - 1)/bottomCount) * bottomCount +1;//1,11,21,31,..
		int endPageNo   = ((currPageNo - 1)/bottomCount+1)* bottomCount; //10,20,30,40,..
		
		int nowBlockNo  = ((currPageNo-1)/bottomCount)+1;//1
		int maxBlockNo  = ((maxNum  -1)/bottomCount)+1;//3
		
		if(currPageNo > maxPageNo) {
			return "";
		}
		
		html.append("<table class=\"page_table\">  \n");
		html.append("<tr>\n");
		html.append("<td class=\"txt_center\"> \n");
		html.append("<ul> \n");
		
		// <<
		if(nowBlockNo > 1 && nowBlockNo <= maxBlockNo) {
			html.append("<li> \n");
			html.append("<a href=\"javascript:"+scriptName+"('"+url+"',1);\"> \n");
			html.append("&laquo;");
			html.append("</a> \n");
			html.append("</li> \n");
		}
		
		// <
		if(startPageNo > bottomCount) {
			html.append("<li> \n");
			html.append("<a href=\"javascript:"+scriptName+"('"+url+"',"+(startPageNo-bottomCount)+");\"> \n");
			html.append("&lt;");
			html.append("</a> \n");
			html.append("</li> \n");			
		}
		
		// 1 2 .. 10
		int inx = 0;
		for(inx = startPageNo;inx<=maxPageNo && inx <=endPageNo;inx++) {
			if(inx == currPageNo) {//현제 페이지 이면
				html.append("<li class=\"now_page\"> \n");
				html.append(inx);
				html.append("</li> \n");				
			}else {
				html.append("<li> \n");
				html.append("<a href=\"javascript:"+scriptName+"('"+url+"',"+inx+");\"> \n");
				html.append(inx);
				html.append("</a> \n");
				html.append("</li> \n");					
				
			}
		}
		
		// >
		if(maxPageNo > inx) {
			html.append("<li> \n");
			html.append("<a href=\"javascript:"+scriptName+"('"+url+"',"+((nowBlockNo*bottomCount)+1)+");\"> \n");
			html.append("&gt;");
			html.append("</a> \n");
			html.append("</li> \n");				
		}
		
		// >>
		if(maxPageNo > inx) {
			html.append("<li> \n");
			html.append("<a href=\"javascript:"+scriptName+"('"+url+"',"+maxPageNo+");\"> \n");
			html.append("&raquo;");
			html.append("</a> \n");
			html.append("</li> \n");			
		}
		
		
		html.append("</ul> \n");
		html.append("</td> \n");
		html.append("</tr> \n");
		html.append("</table> \n");
		
		
		
		return html.toString();
	}
}