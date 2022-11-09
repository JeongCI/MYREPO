package project.quack.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import project.quack.cmn.LoggerManager;
import project.quack.dao.CartDao;
import project.quack.domain.Cart;
import project.quack.domain.Search;

public class OrderDaoTest implements LoggerManager{

	CartDao dao;
	Cart cart01;
	Cart cart02;
	Cart cart03;

	public OrderDaoTest() {
		dao = new CartDao();
		cart01 = new Cart("001", "오리훈제", "30000", "");
		cart02 = new Cart("002", "오리주물럭", "30000", "");
		cart03 = new Cart("003", "오리백숙", "30000", "");
	}

	// 저장
	public void doSave() {
		int flag = dao.doSave(cart01);
		if (flag == 1) {
			LOG.debug(cart01);
			LOG.debug("등록 성공");
		} else {
			LOG.debug("등록 실패");
		}

		for (Cart cart : CartDao.data_cart) {
			System.out.println("Cart:" + cart);
		}

		dao.writeFile(CartDao.SAVE_FILE_PATH2);
	}

	// 삭제
	public void doDelete() {
		int flag = dao.doDelete(cart02);
		if (flag == 1) {
			LOG.debug(cart02);
			LOG.debug("삭제 성공");
		} else {
			LOG.debug("삭제 실패");
		}

		for (Cart cart : CartDao.data_cart) {
			System.out.println("cart:" + cart);
		}

		dao.writeFile(CartDao.SAVE_FILE_PATH2);
	}

	public void dispArrayList() {// ArrayList 출력
		for (Cart cart : CartDao.data_cart) {
			LOG.debug(cart);
		}
	}

	// 수정
	public void doUpdate() {

		cart01.setMenuNum(cart01.getMenuNum() + "_U");
		cart01.setMenuName(cart01.getMenuName() + "_U");
		cart01.setPrice(cart01.getPrice() + "_U");

		int flag = dao.doUpdate(cart01);
		if (1 == flag) {
			LOG.debug(cart01);
			LOG.debug("수정 성공");
		} else {
			LOG.debug("수정 실패");
		}

		dispArrayList();
		dao.writeFile(CartDao.SAVE_FILE_PATH2);
	}

	public void deleteAll() {
		dao.doDelete(cart01);
		dao.doDelete(cart02);
		dao.doDelete(cart03);
	}

	public void doSelectOne() {// 단건 조회(메뉴번호)

		cart01.setMenuNum("001");
		if (null != dao.doSelectOne(cart01)) {
			LOG.debug(dao.doSelectOne(cart01));
			LOG.debug("조회 성공");
		} else {
			LOG.debug("조회 실패");
		}
	}

	public void doRetrieve() {
		Search search = new Search(20, "오리주물럭");
		List<Cart> list = dao.doRetrieve(search);

		for (Cart cart : list) {
			LOG.debug("cart:" + cart);
		}

	}

	public Cart getInputData(Scanner scanner) {
		Cart cart = null;
		String[] dataArr = scanner.nextLine().trim().split(",");// 문자열 공백 제거, ","로 구분
		// 대여가능 여부
		// 1 -> true
		// 0 -> false
		//boolean avaliable = dataArr[3].equals("1") ? true : false;
		cart = new Cart(dataArr[0], dataArr[1], dataArr[2], dataArr[3]);

		return cart;
	}

	public static void main(String[] args) {
		OrderDaoTest main = new OrderDaoTest();

		Scanner scanner = new Scanner(System.in);
		String inCommand = "";// 명령어
		do {
			System.out.println("☆★☆★ QUACK ☆★☆★");
			System.out.println("1 : 주문하기    ");
			System.out.println("2 : 주문내역    ");
			System.out.println("3 : 취소하기    ");
			//System.out.println("4 : 결제하기  ");
			System.out.println("Q : 주문완료    ");
			System.out.print(">>");

			// scanner에서 데이터 입력
			inCommand = scanner.nextLine();
			inCommand = inCommand.trim();// 양쪽 공백, 대문자로 변환

			int total = 0;
			Cart cart = null;
			String[] dataArr = null;
			String readData = "";// command 입력 데이터

			switch (inCommand.toUpperCase()) {// 대상 문자열 대문자로 변환

			case "1":// 주문하기
				System.out.println("-----------------------------------------");
				System.out.println("-               [MENU]                  -");
				System.out.println("-----------------------------------------");
				
				Scanner sc2;
				try {
					sc2 = new Scanner(
							new File("C:\\DCOM_0725\\03_JAVA\\workspace2\\QUACK\\menu.txt"));
					while (sc2.hasNext()) {
						String str = sc2.next();
						System.out.println(str);
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println(
						"주문하기: 메뉴번호(001),메뉴이름(오리훈제),가격(30000),수량(1) 형식으로 추가하세요.\n ex)001,오리훈제,30000,1>>");
				// 메뉴번호,메뉴이름,가격,1(true) or 0(false)>>형식으로 입력

				cart = main.getInputData(scanner);
				int saveFlag = main.dao.doSave(cart);
				if (saveFlag == 1) {
					LOG.debug(cart.getMenuName() + " 추가 완료!");
				} else {
					LOG.debug(cart.getMenuName() + " 추가 실패!.");
				}

				break;


			case "2":// 장바구니 조회
				System.out.print("메뉴전체조회: 메뉴번호(001),cart 를 입력하여 조회하세요.\n e)001,cart>>");// 메뉴번호,메뉴이름>>으로 조회
				
				String[] searchArr = scanner.nextLine().trim().split(",");
				int searchDiv = 100;// 전체(100)
				
				// 검색구분
				if (searchArr[0].equals("메뉴번호")) {
					searchDiv = 10;// 메뉴번호(10)
				} else if (searchArr[0].equals("메뉴이름")) {
					searchDiv = 20;// 메뉴이름(20)
				}
				
				String searchWord = searchArr[1];
				
				Search search = new Search(searchDiv, searchWord);
				List<Cart> searchList = main.dao.doRetrieve(search);
				System.out.println("-----------------------------------------");
				System.out.println("메뉴번호\t메뉴이름\t가격(원)\t수량");
				System.out.println("-----------------------------------------");
				String delim = "\t";
				for (Cart tmp : searchList) {
					String outLine = tmp.getMenuNum() + delim + tmp.getMenuName() + delim + tmp.getPrice() + delim
							+ tmp.getAmount() + "\n";
					System.out.println(outLine);
				}
				
				break;
				
			case "3":// 메뉴 삭제
				System.out.print("메뉴삭제:메뉴번호(001)를 입력하여 삭제하세요.\n ex)001>>");// 메뉴번호로 삭제
				readData = scanner.nextLine().trim();
				cart = new Cart(readData, readData, readData, readData);//
				cart.setMenuNum(readData);
				int delFlag = main.dao.doDelete(cart);
				if (1 == delFlag) {
					LOG.debug(cart.getMenuNum() + " 삭제 완료!");
				} else {
					LOG.debug(cart.getMenuNum() + " 삭제 실패!");
				}

				break;
				
//			case "4":
//				
//				total += Integer.parseInt(cart.getPrice());
//				
//				System.out.println("결제할 금액:" + total + "원");
//				System.out.print("지불할 금액:");
//				int money = scanner.nextInt();
//				if (money < total) {
//					System.out.println("잔돈이 부족합니다.");
//					continue;
//				} else {
//					System.out.println("잔돈은 " + (money - total) + "원 입니다.");
//					System.out.println("인원을 입력하세요:");
//					int n = scanner.nextInt();
//					System.out.println("더치페이시:" + total / n + "원 입니다.");
//
//					total = 0;
//				}
//					for (int i = 0; i < 5; i++)
//						orderList[i] = "";
//				}
//				count = 0;

				
//				break;
				



			case "Q":// data파일에 저장하고, 종료
				int flag = main.dao.writeFile(CartDao.SAVE_FILE_PATH2);
				LOG.debug("저장건수:" + flag);
				break;
			}// --switch

		} while (!inCommand.equalsIgnoreCase("Q"));

		LOG.debug("==========================================================");
		LOG.debug("========================프로그램 종료=========================");
		LOG.debug("==========================================================");
	}

}
