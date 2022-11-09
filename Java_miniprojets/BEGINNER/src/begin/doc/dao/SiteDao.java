package begin.doc.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import begin.doc.cmn.DTO;
import begin.doc.cmn.LoggerManager;
import begin.doc.cmn.WorkDiv;
import begin.doc.domain.Search;
import begin.doc.domain.Site;

/**
 * 사이트 기능 구현 클래스 사이트 목록 파일(site.txt)에 접근하여 데이터 가공 및 처리
 * 
 * @author ITSC
 *
 */
public class SiteDao implements WorkDiv<Site>, LoggerManager {

	// SiteDao 객체 생성 시, site.csv 파일을 읽어 ArrayList에 담는다.
	// 종료시 데이터를 파일에 기록한다.

	public static ArrayList<Site> data = new ArrayList<Site>();

	// 저장경로 및 파일명
	public final static String SAVE_FILE_PATH = "./src/begin/doc/file/site.csv";

	// default생성자
	public SiteDao() {
		readFile(SAVE_FILE_PATH); // readFILE() 함수 호출
		// LOG.debug("data.size() : " + SiteDao.data.size());

		for (Site s : SiteDao.data) {
			// LOG.debug(s.toStirng());
		}
	}

	/**
	 * main 클래스의 arguments 값으로 사이트 ID를 받아 회원인지 확인
	 * 
	 * @param siteId
	 * @return 0(회원아님) / 1(회원임)
	 */

	public int siteiId(String siteId) {
		int flag = 0;
		try (FileReader fr = new FileReader(SAVE_FILE_PATH); BufferedReader br = new BufferedReader(fr);) {
			String line = "";

			while ((line = br.readLine()) != null) {
				String inArray[] = line.split(",");

				// inArray[0]은 사이트 ID값, EducationSiteList.csv 파일에 일치하는 ID가 없으면 시스템 종료.
				// LOG.debug("sitecheckId() : 관리자, ID : " + inArray[0]);
				if (siteId.equals(inArray[0])) {
					flag++;
					break;
				} else if (inArray[3] == "1" || "1".equals(inArray[3])) {
					// LOG.debug("sitecheckID() : 일반 사용자, ID : " + inArray[0])
				} else {
				}
			}
		} catch (IOException e) {
			LOG.debug("IOException : " + e.getMessage());
		}
		return flag;
	}

	/**
	 * main 클래스의 arguments 값으로 회원 ID를 받아 권한 확인
	 * 
	 * @param siteId
	 * @return 0(관리자) / 1(일반 사용자)
	 */

	public int checkLoginAuth(String siteId) {
		int flag = 0;

		try (FileReader fr = new FileReader(SAVE_FILE_PATH); BufferedReader br = new BufferedReader(fr);) {
			String line = "";

			while ((line = br.readLine()) != null) {
				String inArray[] = line.split(",");

				if (siteId.equals(inArray[0])) { // 로그인된 회원ID와 일치한 데이터일때만 권한 체크
					// inArray[3]은 회원의 권한으로 0이면 관리자, 1이면 일반 사용자
					if (inArray[3] == "0" || "0".equals(inArray[3])) {
//							LOG.debug("checkLoginAuth() : 관리자, ID : " + inArray[0]);
						break;
					} else if (inArray[3] == "1" || "1".equals(inArray[3])) {
//							LOG.debug("checkLoginAuth() : 일반 사용자, ID : " + inArray[0]);
						flag++;
						break;
					} else {

					}
				}
			}

		} catch (IOException e) {
			LOG.debug("IOException : " + e.getMessage());
		}

		return flag;
	}

	/**
	 * Site.csv 파일 읽기
	 * 
	 * @param filePath
	 * @return flag (0:ArrayList 값 존재/1:ArrayList 값 없음)
	 */
	public int readFile(String filePath) {
		int flag = 0;

		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(filePath);
			br = new BufferedReader(fr);

			String line = ""; // member.csv의 데이터를 한줄씩 받아오는 변수

			// 한줄씩 받아온 데이터를 문자열 배열로 받은 후, 해당 데이터로 Member 객체 생성
			while ((line = br.readLine()) != null) {
//				LOG.debug("line : " + line);

				String[] inArray = line.split(",");

				Site s = new Site(inArray[0], inArray[1], inArray[2], inArray[3], inArray[4], inArray[5], inArray[6]);

				SiteDao.data.add(s); // ArrayList에 저장
			}

			// ArrayList data에 값이 있으면 flag 값 1로 변경
			if (SiteDao.data.size() > 0) {
				flag++;
			}

		} catch (IOException e) {
			LOG.debug("IOException : " + e.getMessage());
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return flag;
	}

	/**
	 * site.csv 파일 쓰기 (실제 파일에 기록)
	 * 
	 * @param filePath
	 * @return ArrayList의 size()
	 */
	public int writeFile(String filePath) {

		// try-catch-resource
		try (FileWriter fw = new FileWriter(filePath); BufferedWriter bw = new BufferedWriter(fw);) {
			for (Site s : SiteDao.data) {
				String delim = ",";

				String outLine = s.getSiteID() + delim + s.getCateID() + delim + s.getSiteName() + delim
						+ s.getSiteURL() + delim + s.getDesc() + delim + s.getAddMember() + delim + s.getAddDate()
						+ "\n";

				bw.write(outLine);

			}

		} catch (IOException e) {
			LOG.debug("IOException : " + e.getMessage());
		}

		return SiteDao.data.size();
	}

	/**
	 * 모든 회원 목록 확인
	 * 
	 * @return size (회원수)
	 */
	public int doAllSite() {
		int size = 0;

		System.out.println("카테고리ID\t\t사이트ID\t\t사이트이름\t\t\t사이트 설명\t\t\t\t\t사이트 URL\t\t\t\t\t추가한사람\t\t생성일자");
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

		try (FileReader fr = new FileReader(SAVE_FILE_PATH); BufferedReader br = new BufferedReader(fr);) {
			String line = "";
			while ((line = br.readLine()) != null) {
				size++;
				String[] inArray = line.split(",");

				for (int i = 0; i < inArray.length; i++) {
					
					System.out.print(inArray[i] + "\t\t");
				
				}
				System.out.println();
			}

		} catch (IOException e) {
			LOG.debug("IOException : " + e.getMessage());
		}

		return size;
	}

	@Override
	public List<Site> doRetrieve(DTO dto) {
		// 데이터를 찾아 return
		List<Site> list = new ArrayList<Site>();
		// param
		Search search = (Search) dto;
		
		int div = search.getSearchDiv();
		String searchWord = search.getSearchWord();
		for (Site site : SiteDao.data) {

			switch (div) {

			case 10: // 사이트이름
				if (site.getSiteName().matches(".*" + searchWord + ".*")) {
					list.add(site);
				}
				break;

			case 20:// 사이트URL
				if (site.getSiteURL().matches(".*" + searchWord + ".*")) {
					list.add(site);
				}
				break;

			case 100:// 전체
				list.add(site);
				break;
			}

		}

		return list;
	}

	/**
	 * ArrayList에 데이터 저장(파일작성x)
	 */

	@Override
	public int doSave(Site dto) {
		Site s = dto;
		if (isExists(dto) == true) {
			LOG.debug("사이트 ID가 중복되었습니다. (" + s.getSiteURL() + ")");
			return 0;
		}
		boolean isContains = SiteDao.data.contains(s);
		LOG.debug("isContains : " + isContains);

		boolean flag = SiteDao.data.add(s);

		return (flag == true) ? 1 : 0;
	}

	// 시간데이터 추가
	public Site getInputData(Scanner scan, String loginID) {
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date today = new Date();

		Site site = null;

		String[] dataArr = scan.nextLine().trim().split(",");
		
		switch(dataArr[0]) {
		case "교육" :
			dataArr[0] = "cateId1";
			break;
		case "커뮤니티" :
			dataArr[0] = "cateId2";
			break;
		case "채용" :
			dataArr[0] = "cateId3";
			break;
		case "도서" :
			dataArr[0] = "cateId4";
			break;
		default :
			dataArr[0] = "cateId0";
		}

		site = new Site(dataArr[0], dataArr[1], dataArr[2], dataArr[4], dataArr[3], loginID, date.format(today));

		return site;

	}

	@Override
	public int doUpdate(Site dto) {

		return 0;
	}

	/**
	 * 사이트 삭제 return flag (0:미삭제/1:삭제)
	 */
	@Override
	public int doDelete(Site dto) {
		int flag = 0;

		for (int i = SiteDao.data.size() - 1; i >= 0; i--) {
			Site tmp = SiteDao.data.get(i);

			if (dto.getSiteName().equals(tmp.getSiteName())) {
				Site site = SiteDao.data.remove(i);
				LOG.debug("삭제 데이터 : " + site);
				flag = 1;
				break;
			}
		}

		return flag;
	}

//	@Override
//	public int doFind(DTO dto) {
//		// 데이터를 찾아 return
//		List<Site> list = new ArrayList<Site>();
//		// param
//		Search search = (Search) dto;
//		int div = search.getSearchDiv();
//		String searchWord = search.getSearchWord();
//		for (Site site : SiteDao.data) {
//			// LOG.debug(site.getName().indexof(search.getSearchWord()));
//			// LOG.debug(site.getName().mathch(".*"+search.getSearchWord()+".*"));
//			// str.mathes(".*"+검색어+".*")
//		}
//		return div;
//	}

	@Override
	public boolean isExists(Site dto) {
		boolean flag = false;

		for (Site sb : SiteDao.data) {
			if (dto.getSiteName().equals(sb.getSiteName())) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	@Override
	public int doFind(Site dto) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	public List<Site> searchFromSite(Site searchSite) {
        FileReader fr = null;
        BufferedReader br = null;
        List<Site> result = new ArrayList<>();

        try {
            fr = new FileReader(SAVE_FILE_PATH);
            br = new BufferedReader(fr);

            String line = "";    // site.csv의 데이터를 한줄씩 받아오는 변수
            // 한줄씩 받아온 데이터를 문자열 배열로 받은 후, 해당 데이터로 Member 객체 생성
            while ((line = br.readLine()) != null) {
                String[] inArray = line.split(",");
                if (inArray[2].equals(searchSite.getSiteName())) {
                    Site site = new Site(inArray[0], inArray[1], inArray[2],
                            inArray[3], inArray[4], inArray[5], inArray[6]);
                    result.add(site);
                }
            }
        } catch (IOException e) {
            System.out.println("IOException : " + e.getMessage());
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }
	
	
	public void doPrintSiteListForBeauty(List<Site> result) {
        System.out.println("사이트 ID\t\t카테고리ID\t\t사이트명\t\tURL\t\t설명\t\t등록자명 \t\t 등록일자");
        System.out.println("----------------------------------------------------------------------------------------------------------");
        if (result == null || result.size() == 0) {
            System.out.println("연관 사이트가 존재하지 않습니다.");
        } else {
            for (Site site : result) {
                System.out.print(site.getSiteID() + "\t\t");
                System.out.print(site.getCateID() + "\t\t");
                System.out.print(site.getSiteName() + "\t\t");
                System.out.print(site.getSiteURL() + "\t\t");
                System.out.print(site.getDesc() + "\t\t");
                System.out.print(site.getAddMember() + "\t\t");
                System.out.println(site.getAddDate() + "\t\t");
            }
        }
        System.out.println("총 " + result.size() + " 건");
    }

}
