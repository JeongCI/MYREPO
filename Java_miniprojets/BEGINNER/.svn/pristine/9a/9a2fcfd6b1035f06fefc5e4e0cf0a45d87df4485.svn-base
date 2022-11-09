package begin.doc.main;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import begin.doc.chatting.ChatClient2;
import begin.doc.cmn.LoggerManager;
import begin.doc.dao.BookDao;
import begin.doc.dao.CategoryDao;
import begin.doc.dao.MemberDao;
import begin.doc.dao.SiteDao;
import begin.doc.domain.Book;
import begin.doc.domain.Category;
import begin.doc.domain.Member;
import begin.doc.domain.Search;
import begin.doc.domain.Site;

/**
 * 메인 함수
 * 
 * @author ITSC
 *
 */
public class BeginnerMain implements LoggerManager {

	MemberDao mbDao;
	Member member01;
	BookDao dao;
	Book book01;
	CategoryDao categoryDao;
	Category category;
	SiteDao sDao;
	Site site;

	// default 생성자
	public BeginnerMain() {
		mbDao = new MemberDao();

		dao = new BookDao();
		book01 = new Book("isbn", "title", "author", "publisher", "publicationDate");

		categoryDao = new CategoryDao();
		sDao = new SiteDao();
	}

	public static void main(String[] args) {

		BeginnerMain main = new BeginnerMain();

		main.checkLoginId(args);
		int AuthCheck = main.checkLoginAuth(args);

		Scanner scan = new Scanner(System.in);
		String inCommand = ""; // 사용자 입력 변수
		Scanner scanner = new Scanner(System.in);

		// 20220914 수정
		main.mainList(AuthCheck);

		do {
			Member member = null;
			Book book = null;
			Site site = null;

			String readData = ""; // command 입력 데이터

			String[] dataArr = null;

			inCommand = scan.nextLine(); // 스캐너로 입력받아 inCommand 변수에 대입
			inCommand = inCommand.trim(); // 양쪽 공백 제거

			switch (inCommand.toUpperCase()) {
			case "0":
				main.clearScreen();
				main.mainList(AuthCheck);

				break;
				
			case "1":
				main.clearScreen();
				
				if (AuthCheck == 0) { // 관리자 (회원 관리)
					main.doPrintMemberMenuForAdmin(AuthCheck);
				} else { // 일반 사용자 (카테고리 목록)
					main.doPrintCategoryMenuForAdmin(AuthCheck);
				}

				break;
				
			// 회원 목록 조회
			case "1-1": 
				main.clearScreen();
				
				if (AuthCheck == 0) { // 관리자
					System.out.println("=== 전체 회원목록 조회 ===");
					int size = main.doAllMember();
					System.out.println("총 " + size + " 명");
				} else {
					System.out.println("=== 카테고리 목록 ===");
//					System.out.print("카테고리 ID 입력 >");

					List<Category> result = main.doAllCategory();
					main.categoryDao.doPrintCategoryListForBeauty(result);
					
//					Category searchCategory = main.getCategoryIdByInputData(scan);
//
//					if (main.categoryDao.isExists(searchCategory)) {
//						List<Site> siteList = main.categoryDao.searchFromSite(searchCategory);
//						main.categoryDao.doPrintSiteListForBeauty(siteList);
//					} else {
//						System.out.println("해당 카테고리 ID가 존재하지 않습니다.");
//					}

					main.doPrintCategoryMenuForAdmin(AuthCheck);
				}
				main.doPrintMemberMenuForAdmin(AuthCheck);
				break;
				
			// 회원 추가
			case "1-2": 
				
				if (AuthCheck == 0) { // 20220914
					
					System.out.print("회원등록(ID,비밀번호,이름,레벨) >");

					member = main.mbDao.getInputData(scan);
					int saveFlag = main.mbDao.doSave(member);

					if (saveFlag == 1) {
						LOG.debug(member.getMemberID() + " 등록 되었습니다.");
						main.mbDao.writeFile(MemberDao.SAVE_FILE_PATH);
					} else {
						LOG.debug(member.getMemberID() + " 등록 실패!.");
					}
					
					main.doPrintMemberMenuForAdmin(AuthCheck);
					
				} else { // 20220914
					System.out.print("해당 카테고리의 사이트 목록 확인(카테고리 이름 입력) >");
					Category searchCategory = main.getCategoryIdByInputData(scan);
					
					if (main.categoryDao.isExists(searchCategory)) {
						List<Site> siteList = main.categoryDao.searchFromSite(searchCategory);
						main.categoryDao.doPrintSiteListForBeauty(siteList);
					} else {
						System.out.println("해당 카테고리 ID가 존재하지 않습니다.");
					}
					
					main.doPrintCategoryMenuForAdmin(AuthCheck);
				}
				break;
			
			// 회원 삭제
			case "1-3":				
				System.out.print("삭제할 회원 ID를 입력하세요 >");
				readData = scan.nextLine().trim();

				member = new Member();
				member.setMemberID(readData);

				int delFlag = main.mbDao.doDelete(member);
				if (delFlag == 1) {
					LOG.debug(member.getMemberID() + " 삭제되었습니다.");
					main.mbDao.writeFile(MemberDao.SAVE_FILE_PATH);
				} else {
					LOG.debug(member.getMemberID() + " 삭제 실패!");
				}
				main.doPrintMemberMenuForAdmin(AuthCheck);
				break;
				
			// 카테고리 관리(관리자) / 사이트(일반 사용자)	
			case "2":
				main.clearScreen();
				
				if (AuthCheck == 0) { // 관리자 (카테고리 관리)
					main.doPrintCategoryMenuForAdmin(AuthCheck);
				} else { // 일반 사용자
					main.doPrintSiteMenu(AuthCheck);
				}
				
				break;
			
			// 카테고리 목록 확인 (관리자) / 사이트 목록 (일반 사용자)
			case "2-1":
				main.clearScreen();
				
				if (AuthCheck == 0) { // 관리자
					System.out.println("=== 전체 카테고리 조회 ===");
					List<Category> result = main.doAllCategory();
					main.categoryDao.doPrintCategoryListForBeauty(result);
					main.doPrintCategoryMenuForAdmin(AuthCheck);
				} else { // 일반 사용자
					System.out.println("=== 사이트 목록 ===");

					int size = main.doAllSite();
					main.doPrintSiteMenu(AuthCheck);
				}
				break;
			
			// 카테고리 추가(관리자) / 사이트 검색 (일반 사용자)
			case "2-2":
				
				if (AuthCheck == 0) { // 카테고리 추가 (관리자)
//					main.clearScreen();
					
					System.out.print("카테고리(ID,이름) 입력 >");
					Category category = main.getCategoryByInputData(scan);
					
					int categorySaveFlag = main.categoryDao.doSave(category);
					
					if (categorySaveFlag == 1) {
						System.out.println(category.getCateID() + " 등록 되었습니다.");
					} else {
						System.out.println(category.getCateID() + " 등록 실패!.");
					}
					main.doPrintCategoryMenuForAdmin(AuthCheck);
					
				} else { // 사이트 검색 (일반 사용자)
					
					System.out.print("검색할 사이트 이름 >");
					readData = scanner.nextLine().trim();

					List<Site> searchList2 = (List<Site>) main.doRetrieve(readData, "site");
					
					String delim = "\t\t";
					
					System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println("사이트ID\t\t카테고리ID\t\t사이트이름\t\t\t사이트 설명\t\t\t\tURL\t\t\t\t\t\t작성자\t\t생성일자");
					System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

					
					for(Site tmp : searchList2) {
						String outLine = tmp.getSiteID() + delim + tmp.getCateID() + delim + tmp.getSiteName() + delim 
									   + tmp.getSiteURL() + delim + tmp.getDesc() + delim + tmp.getAddMember() + delim
									   + tmp.getAddDate() + "\n";
						System.out.println(outLine);
					}

					main.doPrintSiteMenu(AuthCheck);
				}
				break;
			
			// 카테고리 삭제
			case "2-3":
				if (AuthCheck == 0) { // 관리자
					System.out.print("삭제할 카테고리ID 입력 >");
					Category deleteCategory = main.getCategoryIdByInputData2(scan);
					int categoryDeleteFlag = main.categoryDao.deleteFile(deleteCategory);
					
					if (categoryDeleteFlag == 1) {
						System.out.println(deleteCategory.getCateID() + " 삭제 되었습니다.");
					} else {
						System.out.println(deleteCategory.getCateID() + " 삭제 실패!.");
					}
					
					main.doPrintCategoryMenuForAdmin(AuthCheck);
				} else {
					System.out.println("권한이 없습니다.");
				}
				break;
			
			// 카테고리 관련 사이트 확인
			case "2-4":
				if (AuthCheck == 0) { // 관리자
					System.out.print("해당 카테고리의 사이트 목록(카테고리 이름 입력) >");
					Category searchCategory = main.getCategoryIdByInputData(scan);
					
					if (main.categoryDao.isExists(searchCategory)) {
						List<Site> siteList = main.categoryDao.searchFromSite(searchCategory);
						main.categoryDao.doPrintSiteListForBeauty(siteList);
					} else {
						System.out.println("해당 카테고리 ID가 존재하지 않습니다.");
					}
				} 
//				else {
//					System.out.println("권한이 없습니다.");
//				}
				main.doPrintCategoryMenuForAdmin(AuthCheck);
				break;

			// 도서 관리
			case "3":
				main.doPrintBookMenu(AuthCheck);
				break;

			// 도서 조회
			case "3-1":
				// String searchArr = scanner.nextLine().trim();
				// int searchDiv = 100;

				// String searchWord = searchArr;

				// Search search=new Search(searchDiv,searchWord);
				// List<Book> searchList = main.dao.doRetrieve(search);
				System.out.println("-----------------------------------------------------------------------------------------------------------");
				System.out.println("카테고리\t\t제목\t\t\t\t저자\t\t\t출판사\t\t출판일 \t");
				System.out.println("-----------------------------------------------------------------------------------------------------------");
				String delim = "\t\t";

				for (Book tmp : BookDao.data) {
					String outLine = tmp.getIsbn() + delim + tmp.getTitle() + delim + tmp.getAuthor() + delim
							+ tmp.getPublisher() + delim + tmp.getPublicationDate() + "\n";
					System.out.println(outLine);
				}
				// System.out.println(searchList);
				main.doPrintBookMenu(AuthCheck);
				break;

			// 도서 등록
			case "3-2":
				if (AuthCheck == 0) {// 관리자
					System.out.println("등록: 카테고리,제목,저자,출판사,출판일>>");
					book = main.getInputDataBook(scanner);
					int saveFlag = main.dao.doSave(book);
					
					if (saveFlag == 1) {
						LOG.debug(book.getTitle() + " 등록 성공!");
						main.dao.writeFile(BookDao.SAVE_FILE_PATH);
					} else {
						LOG.debug(book.getTitle() + " 등록 실패!");
					}
				}
				main.doPrintBookMenu(AuthCheck);
				break;

			// 도서 검색
			case "3-3":
				System.out.print("검색할 도서 제목 >");
				readData = scanner.nextLine().trim();
				book = new Book();
				book.setTitle(readData);
				
//				Search search = new Search(10, readData);
				
				// >> 20220921 도서 제목 검색 (키워드로 검색)
				List<Book> searchList = (List<Book>) main.doRetrieve(readData, "book");
				
				delim = "\t\t";
				
				System.out.println("-----------------------------------------------------------------------------------------------------------");
				System.out.println("카테고리\t\t제목\t\t\t\t저자\t\t\t출판사\t\t출판일 \t");
				System.out.println("-----------------------------------------------------------------------------------------------------------");

				
				for(Book tmp : searchList) {
					String outLine = tmp.getIsbn() + delim + tmp.getTitle() + delim + tmp.getAuthor() + delim 
								   + tmp.getPublisher() + delim + tmp.getPublicationDate() + "\n";
					System.out.println(outLine);
				}
				// << 20220921

//				Book selectOne = main.dao.doSelectOne(book);
//				if (null != selectOne) {
//					// LOG.debug(selectOne + " 조회 성공.");
//
//				} else {
//					LOG.debug(selectOne + " 조회 실패.");
//				}
				main.doPrintBookMenu(AuthCheck);
				break;

			// 도서 삭제
			case "3-4":
				if (AuthCheck == 0) {// 관리자
					System.out.print("삭제할 제목을 입력하세요>>");
					readData = scanner.nextLine().trim();
					book = new Book();
					book.setTitle(readData);
					delFlag = main.dao.doDelete(book);
					if (1 == delFlag) {
						LOG.debug(book.getTitle() + " 삭제 성공!");
						main.dao.writeFile(BookDao.SAVE_FILE_PATH);
					} else {
						LOG.debug(book.getTitle() + " 삭제 실패!");
					}
				}
				main.doPrintBookMenu(AuthCheck);
				break;
				
			// 사이트 관리
			case "4":
				if (AuthCheck == 0) { // 관리자
					main.doPrintSiteMenu(AuthCheck);
				} else { // 일반 사용자
					System.out.println("=== 사이트 목록 ===");

					int size = main.doAllSite();
					
					main.doPrintSiteMenu(AuthCheck);
//					System.out.println("총 " + size + " 개");
				}
				System.out.println("Q : 메인 목록 나가기");

				break;

			// 사이트 목록 확인
			case "4-1":
				if (AuthCheck == 0) {
					System.out.println("=== 전체 사이트 목록 ====");
					int size = main.doAllSite();

					System.out.println("총 " + size + " 개");
					
					main.doPrintSiteMenu(AuthCheck);
				}
				break;

			// 사이트 추가
			case "4-2":
				if (AuthCheck == 0) {
					System.out.println("사이트등록(카테고리[교육,커뮤니티,채용,도서],사이트ID,사이트 이름,URL,설명) >");
//					System.out.println("카테고리 >");

					site = main.sDao.getInputData(scan, args[0]);
					int saveFlag1 = main.sDao.doSave(site);

					if (saveFlag1 == 1) {
						LOG.debug(site.getSiteName() + " 등록 되었습니다.");
						main.sDao.writeFile(SiteDao.SAVE_FILE_PATH);
					} else {
						LOG.debug(site.getSiteName() + " 등록에 실패했습니다.");
					}
				}
				main.doPrintSiteMenu(AuthCheck);
				break;

			// 사이트 삭제
			case "4-3":
				System.out.print("삭제할 사이트 이름 >");
				readData = scan.nextLine().trim();

				site = new Site();
				site.setSiteName(readData);

				int delSiteFlag = main.sDao.doDelete(site);

				if (delSiteFlag == 1) {
					LOG.debug(site.getSiteName() + "삭제 되었습니다.");
					main.sDao.writeFile(SiteDao.SAVE_FILE_PATH);
				} else {
					LOG.debug(site.getSiteName() + "삭제 실패!");
				}
				main.doPrintSiteMenu(AuthCheck);
				break;

			// 사이트 검색
			case "4-4":
				System.out.print("검색할 사이트 이름 >");
				readData = scanner.nextLine().trim();
				
//				Site searchCategory = main.getSiteIdByInputData(scanner);
				
				
//				Search search2 = new Search(10, readData);
				
				// >> 20220921 사이트 제목 검색 (키워드로 검색)
				
				List<Site> searchList2 = (List<Site>) main.doRetrieve(readData, "site");
				
				delim = "\t\t";
				
				System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("사이트ID\t\t카테고리ID\t\t사이트이름\t\t\t사이트 설명\t\t\t\tURL\t\t\t\t\t\t추가한사람\t\t생성일자");
				System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

				
				for(Site tmp : searchList2) {
					String outLine = tmp.getSiteID() + delim + tmp.getCateID() + delim + tmp.getSiteName() + delim 
								   + tmp.getSiteURL() + delim + tmp.getDesc() + delim + tmp.getAddMember() + delim
								   + tmp.getAddDate() + "\n";
					System.out.println(outLine);
				}
				// << 20220921
				
				

//				if (main.sDao.isExists(searchCategory)) {
//					List<Site> siteList = main.sDao.searchFromSite(searchCategory);
//					main.sDao.doPrintSiteListForBeauty(siteList);
//				} else {
//					System.out.println("해당 사이트 이름이 존재하지 않습니다.");
//				}
				
				main.doPrintSiteMenu(AuthCheck);
				break;

			// 일반사용자 채팅 (20220914)
			case "C":

				System.out.println("=== 채팅 ===");

				ChatClient2 chat = new ChatClient2(args);
				chat.main();
			
			// 데이터 추가,삭제 저장 (사용안함)
			case "S":
				int memberFlag = main.mbDao.writeFile(MemberDao.SAVE_FILE_PATH);
				int bookFlag = main.dao.writeFile(BookDao.SAVE_FILE_PATH);
				int siteFlag = main.sDao.writeFile(SiteDao.SAVE_FILE_PATH);

				System.out.println("저장되었습니다.");
				break;
			}

		} while (!"Q".equalsIgnoreCase(inCommand));

		System.out.println("종료되었습니다.");
	}

	// 20220914 추가
	// 각 권한 별 메인 목록 화면
	public void mainList(int authcheck) {		
		System.out.println("\n=== MAIN MENU ===");

		if (authcheck == 0) { // 로그인한 회원 권한 : 관리자
			System.out.println("1 : 회원 관리");
			System.out.println("2 : 카테고리 관리");
			System.out.println("3 : 도서 관리");
			System.out.println("4 : 사이트 관리 ");
		} else { // 로그인한 회원 권한 : 일반 사용자
			System.out.println("1 : 카테고리");
			System.out.println("2 : 사이트");
			System.out.println("3 : 도서");
			System.out.println("C : 채팅");
		}
		System.out.println("Q : 시스템 종료\n");
		System.out.print("메뉴를 정수로 입력하세요 >");
	}
	
	// 회원 관리 메뉴
	public void doPrintMemberMenuForAdmin(int authcheck) {
		if(authcheck == 0) {
			System.out.println("\n=== 회원 관리 ===");
			System.out.println("0 : 메인 목록으로 이동");
			System.out.println("1-1 : 회원 목록 확인");
			System.out.println("1-2 : 회원 추가");
			System.out.println("1-3 : 회원 삭제");
			System.out.println("Q : 시스템 종료");
		}
	}
	
	// 카테고리 관리 메뉴
	public void doPrintCategoryMenuForAdmin(int authcheck) {
		if(authcheck == 0) {
			System.out.println("\n=== 카테고리 관리 ===");
			System.out.println("0 : 메인 목록으로 이동");
			System.out.println("2-1 : 카테고리 목록");
			System.out.println("2-2 : 카테고리 추가");
			System.out.println("2-3 : 카테고리 삭제");
			System.out.println("2-4 : 카테고리 관련 사이트 확인");
			System.out.println("Q : 시스템 종료");
		} else {
			System.out.println("\n=== 카테고리 ===");
			System.out.println("0 : 메인 목록으로 이동");
			System.out.println("1-1 : 카테고리 목록");
			System.out.println("1-2 : 해당 카테고리 사이트 목록 조회");
		}
	}
	
	public void doPrintBookMenu(int authcheck) {
		if(authcheck == 0) {
			System.out.println("\n=== 도서 관리 ===");
			System.out.println("0 : 메인 목록으로 이동");
			System.out.println("3-1 : 도서 목록");
			System.out.println("3-2 : 도서 등록");
			System.out.println("3-3 : 도서 검색");
			System.out.println("3-4 : 도서 삭제");
		} else { // 일반 사용자
			System.out.println("\n=== 도서 조회 ===");
			System.out.println("0 : 메인 목록으로 이동");
			System.out.println("3-1 : 도서 목록");
			System.out.println("3-3 : 도서 검색");
		}
		System.out.println("Q : 시스템 종료");
	}
	
	
	public void doPrintSiteMenu(int authcheck) {
		if(authcheck == 0) {
			System.out.println("\n=== 사이트 관리 ===");
			System.out.println("0 : 메인 목록으로 이동");
			System.out.println("4-1 : 사이트 목록 확인");
			System.out.println("4-2 : 사이트 추가");
			System.out.println("4-3 : 사이트 삭제");
			System.out.println("4-4 : 사이트 검색");			
		} else { // 일반 사용자
			System.out.println("\n=== 사이트 ===");
			System.out.println("0 : 메인 목록으로 이동");
			System.out.println("2-1 : 사이트 목록");
			System.out.println("2-2 : 사이트 검색");
		}
		System.out.println("Q : 시스템 종료");
	}
	
	
	// 콘솔 클리어 (IDE에서는 안먹음...)
	public void clearScreen() {
		
		for(int i=0; i<100; i++) {
			System.out.println();
		}
		
//		System.out.print("\033[H\033[2J");
//		System.out.flush();
	}

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

	// 전체 사이트 목록 조회
	public int doAllSite() {
		int size = sDao.doAllSite();
		return size;
	}

	// 전체 회원 목록 조회
	public int doAllMember() {
		int size = mbDao.doAllMember();
		return size;
	}

	// 전체 카테고리 목록 조회
	public List<Category> doAllCategory() {
		return categoryDao.getAllCategoryList();
	}
	
	public Category getCategoryByInputData(Scanner scan) {
		String[] dataArr = scan.nextLine().trim().split(",");
		return new Category(dataArr[0], dataArr[1], 1);
	}

	public Category getCategoryIdByInputData(Scanner scan) {	
		String dataArr = null;
		
		try {
			dataArr = scan.nextLine();
		} catch(NoSuchElementException e) {
			System.out.println("검색어가 입력되지 않았습니다.");
			System.out.println("시스템 종료");
			System.exit(0);
		}
		
		return new Category(null, dataArr, 1);	
		
	}
	
	public Category getCategoryIdByInputData2(Scanner scan) {	
		String dataArr = null;
		
		try {
			dataArr = scan.nextLine();
		} catch(NoSuchElementException e) {
			System.out.println("검색어가 입력되지 않았습니다.");
			System.out.println("시스템 종료");
			System.exit(0);
		}
		
		return new Category(dataArr, null, 1);	
		
	}

	// 도서 저장
	public void doSaveBook() {
		int flag = dao.doSave(book01);
		if (flag == 1) {
			LOG.debug(book01);
			LOG.debug("등록 성공");
		} else {
			LOG.debug("등록 실패");
		}

		for (Book book : BookDao.data) {
			System.out.println("book:" + book);
		}

		dao.writeFile(BookDao.SAVE_FILE_PATH);
		// dao.writeFileJson(BookDao.SAVE_JSON_FILE_PATH);
	}

	public void doSelectOne() {

		book01.setTitle("JAVA");
		if (null != dao.doSelectOne(book01)) {
			LOG.debug(dao.doSelectOne(book01));
			LOG.debug("조회 성공");
		} else {
			LOG.debug("조회 실패");
		}
	}

	// 도서 삭제
	public void doDelete() {
		int flag = dao.doDelete(book01);
		if (flag == 1) {
			LOG.debug(book01);
			LOG.debug("삭제 성공");
		} else {
			LOG.debug("삭제 실패");
		}

		for (Book book : BookDao.data) {
			System.out.println("book:" + book);
		}

		dao.writeFile(BookDao.SAVE_FILE_PATH);
	}

	public Book getInputDataBook(Scanner scanner) {
		Book book = null;
		String[] dataArr = scanner.nextLine().trim().split(",");
		book = new Book(dataArr[0], dataArr[1], dataArr[2], dataArr[3], dataArr[4]);

		return book;
	}

	// 사이트 검색
	public Site getSiteIdByInputData(Scanner scan) {
		String dataArr = scan.nextLine();

		Site site = new Site("cateId", "siteId", dataArr, "SiteUrl", "SiteDesc", "SiteInputUser", "SiteDate");

		return site;
	}
	
	// 도서 데이터 키워드 검색
	public Object doRetrieve(String searchWord, String cls) {
		Search search = new Search(10, searchWord);		// 무조건 제목 검색
		
		List<Book> list2 = null;
		
		if (cls == "book") {			
			List<Book> list = dao.doRetrieve(search);
			
			for(Book book : list) {
//				LOG.debug("book_search : " + book);
			}
			
			return list;
			
		} else if (cls == "site") {			
			List<Site> list = sDao.doRetrieve(search);
			
			for(Site site : list) {
//				LOG.debug("book_search : " + site);
			}
			
			return list;
		}

		return list2;
	}
	

}
