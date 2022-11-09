package begin.doc.main;

import java.util.List;
import java.util.Scanner;

import begin.doc.cmn.LoggerManager;
import begin.doc.dao.MemberDao;
import begin.doc.dao.SiteDao;
import begin.doc.domain.Member;
import begin.doc.domain.Site;

/**
 * 메인 함수
 * 
 * @author ITSC
 *
 */
public class BeginnerMainsite implements LoggerManager {

	private static final String dao = null;
	MemberDao mbDao;
	Member member01;
	SiteDao sDao;
	Site site;

	// default 생성자
	public BeginnerMainsite() {
		sDao = new SiteDao();
		mbDao = new MemberDao();
		// memberID, memberPwd, memberName, auth, level, status, createDate
//		member01 = new Site("test", "testpwd", "테스트", 1, 1, 1, "2022-09-12");
	}

	public static void main(String[] args) {

		BeginnerMainsite main = new BeginnerMainsite();

		main.checkLoginId(args);
		int AuthCheck = main.checkLoginAuth(args);

		// main.doSave();

		Scanner scan = new Scanner(System.in);
		String inCommand = ""; // 사용자 입력 변수

		System.out.println("=== MENU ===");

		if (AuthCheck == 0) { // 로그인한 회원 권한 : 관리자
			System.out.println("1 : 회원 관리");
			System.out.println("2 : 카테고리 관리");
			System.out.println("3 : 사이트 목록 ");
		} else { // 로그인한 회원 권한 : 일반 사용자
			System.out.println("1 : 카테고리 목록");
			System.out.println("2 : 사이트 검색");
			System.out.println("3 : 사이트 목록 ");
			System.out.println("4 : 사이트 추가 ");

		}
		System.out.println("Q : 시스템 종료");

		do {
			Member member = null;
			Site site = null;
			String readData = ""; // command 입력 데이터

			inCommand = scan.nextLine(); // 스캐너로 입력받아 inCommand 변수에 대입
			inCommand = inCommand.trim(); // 양쪽 공백 제거

			Scanner scanner = new Scanner(System.in);

			switch (inCommand.toUpperCase()) {
			case "0":
				System.out.println("=== MENU ===");
				if (AuthCheck == 0) { // 관리자
					System.out.println("1 : 회원 관리");
					System.out.println("2 : 카테고리 관리");
					System.out.println("3 : 사이트 목록 ");

				} else { // 일반 사용자
					System.out.println("1 : 카테고리 목록");
					System.out.println("2 : 사이트 검색");
					System.out.println("3 : 사이트 목록 ");
					System.out.println("4 : 사이트 추가 ");
				}
				System.out.println("Q : 시스템 종료");
				break;
			case "1":
				if (AuthCheck == 0) { // 관리자
					System.out.println("=== 회원 관리 ===");
					System.out.println("0 : 메인 목록으로 이동");
					System.out.println("1-1 : 회원 목록 확인");
					System.out.println("1-2 : 회원 추가");
					System.out.println("1-3 : 회원 삭제");
				} else { // 일반 사용자
					System.out.println("=== 카테고리 ===");
				}
				System.out.println("Q : 시스템 종료");
				break;
			case "2":
				if (AuthCheck == 0) { // 관리자
					
				} else { // 일반 사용자 (사이트 검색)
					System.out.println("=== 사이트 ===");
					System.out.println("상세 내용이 보고 싶은 사이트 ID 입력)");
					Site searchCategory = main.getSiteIdByInputData(scanner);
					
					if (main.sDao.isExists(searchCategory)) {
						List<Site> siteList = main.sDao.searchFromSite(searchCategory);
						main.sDao.doPrintSiteListForBeauty(siteList);
					} else {
						System.out.println("해당 사이트 이름이 존재하지 않습니다.");
					}
				}
				
				break;
			case "3":
				if (AuthCheck == 0) { // 관리자
					System.out.println("=== 카테고리 관리 ===");
					System.out.println("=== 사이트 관리 ===");
					System.out.println("0 : 메인 목록으로 이동");
					System.out.println("3-1 : 사이트 목록 확인");
					System.out.println("3-2 : 사이트 추가");
					System.out.println("3-3 : 사이트 삭제");
					System.out.println("");

				} else { // 일반 사용자
					System.out.println("=== 사이트 목록 ===");
					
					int size = main.doAllSite();
//					System.out.println("총 " + size + " 개");
					
				}
				System.out.println("Q : 메인 목록 나가기");
				break;
			case "3-1":
				if (AuthCheck == 0) {
					System.out.println("=== 전체 사이트목 조회====");
					int size = main.doAllSite();
					System.out.println("총 " + size + " 개");
				}
				break;

			case "3-2": // 사이트 추가
				if (AuthCheck == 0) {
					System.out.println("사이트등록(카테고리ID,사이트ID,사이트NAME,설명,URL,등록날짜)");

					site = main.sDao.getInputData(scan, args[0]);
					int saveFlag1 = main.sDao.doSave(site);

					if (saveFlag1 == 1) {
						LOG.debug(site.getSiteID() + site.getCateID() + site.getSiteName() + site.getDesc()
								+ site.getSiteURL() + site.getAddDate() + " 등록 되었습니다.");
					} else {
						LOG.debug(site.getCateID() + " 등록 되었습니다.");
					}
				}
				break;
			case "3-3": // 사이트 삭제
				System.out.println("삭제할 사이트 입력");
				readData = scan.nextLine().trim();

				site = new Site();
				site.setSiteName(readData);

				int delFlag = main.sDao.doDelete(site);

				if (delFlag == 1) {
					LOG.debug(site.getClass() + "삭제 되었습니다.");
				} else {
					LOG.debug(site.getClass() + "삭제 실패!");
				}
				break;
				
			case "4" :	// 사이트 추가
				System.out.println("사이트등록(카테고리ID,사이트ID,사이트NAME,설명,URL,등록날짜)");

				site = main.sDao.getInputData(scan, args[0]);
				int saveFlag1 = main.sDao.doSave(site);

				if (saveFlag1 == 1) {
					LOG.debug(site.getSiteID() + site.getCateID() + site.getSiteName() + site.getDesc()
							+ site.getSiteURL() + site.getAddDate() + " 등록 되었습니다.");
				} else {
					LOG.debug(site.getCateID() + " 등록 되었습니다.");
				}
				
				break;

//			case "3-4": // 사이트 목록조회
//
//				System.out.print("목록조회: 제목,검색어");
//				
//				String[] searchArr = scanner.nextLine().trim().split(",");
//				
//				//검색구분
//				int searchDiv = 100;
//				if(searchArr[0].equals("사이트이름")) {
//					searchDiv =10;
//				}else if(searchArr[0].equals("")) {
//					searchDiv = 20;
//				}
//				String searchWord = searchArr[1];
//				
//				int SearchDiv = Integer.parseInt(searchArr[0]);//
//				String searWord = searchArr[1];
//				
//				Search search=new Search(searchDiv, searchWord);
//				List<Site> searchList = main.sDao.doRetrieve(search);
//				System.out.println("--------------------------------------------");
//				System.out.println("도서번호\t\t\t제목\t\t\t저자\t\t\t장르\t\t\t출판일\t\t\t대출가능 여부");
//				System.out.println("---------------------------------------------");
//				String delim = "\t";
//				for(Site tmp :searchList) {
//					String outLine = tmp.getSiteName() + delim +tmp.getSiteURL() +delim +tmp.getDesc() +"\n";
//					System.out.println(outLine);
//				}
//				break;

			case "OS":// 단건조회

				System.out.println("=== 사이트 ===");
				System.out.println("상세 내용이 보고 싶은 사이트 ID 입력)");
				Site searchCategory = main.getSiteIdByInputData(scanner);
				
				if (main.sDao.isExists(searchCategory)) {
					List<Site> siteList = main.sDao.searchFromSite(searchCategory);
					main.sDao.doPrintSiteListForBeauty(siteList);
				} else {
					System.out.println("해당 사이트 이름이 존재하지 않습니다.");
				}
				
				

//				System.out.print("단건조회:");
//				readData = scanner.nextLine().trim();
//				site = new Site();
//
//				site.setSiteName(readData);
//				int Flag = main.sDao.doselect(site);
//				if (1 == Flag) {
//					LOG.debug(site.getSite() + "조회되었습니다.!");
//				} else {
//					LOG.debug(site.getSite() + "조회 실패!");
//
//				}
				break;

			case "S":
				int flag = main.mbDao.writeFile(MemberDao.SAVE_FILE_PATH);
				int flag2 = main.sDao.writeFile(SiteDao.SAVE_FILE_PATH);
				LOG.debug("저장건수 : " + flag);
				break;
			}

		} while (!"Q".equalsIgnoreCase(inCommand));

		System.out.println("종료되었습니다.");

	}

	// 콘솔 클리어 (IDE에서는 안먹음...)
	public void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	// 회원 여부 확인
	// 회원 여부 확인
	public void checkLoginId(String[] args) {

		// 20220914 추가 (args에 회원ID 누락 시 예외 처리)
		try {
			if (args[0].length() < 1) {
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("회원ID를 입력하세요.");
			System.out.println("시스템 종료");
			System.exit(0);
		}

		// 20220914 추가 (args에 비밀번호 누락 시 예외 처리)
		try {
			if (args[1].length() < 1) {
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("비밀번호를 입력하세요.");
			System.out.println("시스템 종료");
			System.exit(0);
		}

		// 20220914 수정 (로그인 시, 회원ID, 회원 비밀번호 두 개 받음)
		int flag = mbDao.checkLoginId(args);

		if (flag == 1) {
			LOG.debug("회원입니다.");
		} else if (flag == 2) {
			LOG.debug("비밀번호가 틀렸습니다. \n시스템 종료.");
			System.exit(0);
		} else {
			LOG.debug("회원이 아닙니다. \n시스템 종료.");
			System.exit(0);
		}
	}

	// 회원 권한 확인
	public int checkLoginAuth(String[] args) {
		int flag = 0;
		int AuthCheck = mbDao.checkLoginAuth(args[0]);

		if (AuthCheck == 1) {
			flag++;
			LOG.debug("일반사용자");
		} else {
			LOG.debug("관리자");
		}

		return flag; // 0:관리자/1:일반사용자
	}

	// 사이트 검색
	public Site getSiteIdByInputData(Scanner scan) {
		String dataArr = scan.nextLine();

		Site site = new Site("cateId", "siteId", dataArr, "SiteUrl", "SiteDesc", "SiteInputUser", "SiteDate");

		return site;
	}

	// 전체 사이트목록 조회
	public int doAllSite() {
		int size = sDao.doAllSite();
		return size;
	}

	public Site getInputData(Scanner scan) {
		Site site = null;

		String[] dataArr = scan.nextLine().trim().split(",");

		if ("".equals(dataArr[3])) {
			dataArr[3] = "1";
		} else if ("".equals(dataArr[3])) {
			dataArr[3] = "2";
		} else if ("".equals(dataArr[3])) {
			dataArr[3] = "3";
		} else if ("".equals(dataArr[3])) {
			dataArr[3] = "4";
		}

		site = new Site(dataArr[0], dataArr[1], dataArr[2], dataArr[3], dataArr[4], dataArr[5], dataArr[6]);

		return site;
	}

	public Site SitegetInputData1(Scanner scan) {
		String[] dataArr = scan.nextLine().trim().split(",");
		return new Site(dataArr[0], dataArr[1], dataArr[2], dataArr[3], dataArr[4], dataArr[5], dataArr[6]);
	}

	public Site SitegetInputData(Scanner scan) {
		Site site = null;

		String[] dataArr = scan.nextLine().trim().split(",");

		site = new Site(dataArr[0], dataArr[1], dataArr[2], dataArr[3], dataArr[4], dataArr[5], dataArr[6]);

		return site;
	}

	public void doSave() {
		int flag = sDao.doSave(site);

		if (flag == 1) {
			LOG.debug(member01);
			LOG.debug("등록 성공");
		} else {
			LOG.debug("등록 실패");
		}

		for (Site s : SiteDao.data) {
			System.out.println("site : " + s);
		}

		sDao.writeFile(SiteDao.SAVE_FILE_PATH);
	}

}
