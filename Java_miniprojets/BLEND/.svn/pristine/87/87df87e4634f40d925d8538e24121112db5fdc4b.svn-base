package bar.test;

import java.util.Scanner;

import bar.dao.BarDao;
import cmn.LoggerManger;
import cocktail.dao.CocktailDao;
import cocktail.domain.Cocktail;
import ingredient.domain.Ingredient;

public class BarDaoTest_psh implements LoggerManger {

	BarDao dao;

	public BarDaoTest_psh() {
		dao = new BarDao();
		// 칵테일 DaoTest와 합쳐져서 함께 메인 만들면
		// BarDao만들고 CocktailDao만들고 바로 재료검사하는 메서드 추가 예정
		// 제가 만들거니까 신경 안쓰셔두 돼욤
	}

	public static void main(String[] args) {
		BarDaoTest_psh main = new BarDaoTest_psh();

		Scanner scanner = new Scanner(System.in);
		String inCommand = "";
		do {
			System.out.println("====Menu====");
			System.out.println("C	: 새 재료 등록");// main.
			System.out.println("D	: 재료삭제");
			System.out.println("A	: 재료 양 추가");
			System.out.println("U	: 재료 소모");
			System.out.println("OS	: 재료목록 조회");
			System.out.println("Q	: 종료");
			System.out.println(">>");

			inCommand = scanner.nextLine();
			
			Ingredient ingredient = null;// 밑에 코드 작성할 때 ingredient클래스 쓸 때 쓰세요
			String[] dataArr = null;// 마찬가지, String 어레이 필요하면 갖다 쓰세요
			String readData = ""; // command 입력 데이터

			switch (inCommand.toUpperCase()) {
			case "C":
				System.out.println("등록 : 재료/양");

				readData = scanner.nextLine().trim();
				dataArr = readData.split("/");

				ingredient = new Ingredient(dataArr[0], Integer.parseInt(dataArr[1]));
				int saveFlag = main.dao.doSave(ingredient);
				if (saveFlag == 1) {
					LOG.debug(ingredient.getName() + "등록되었습니다.");
				} else {
					LOG.debug(ingredient.getName() + "등록실패!");
				}
				break;
			case "D":
				System.out.println("삭제 : 재료이름");

				readData = scanner.nextLine().trim();
				ingredient = new Ingredient(readData);
				int delFlag = main.dao.doDelete(ingredient);
				if (1 == delFlag) {
					LOG.debug(ingredient.getName() + "삭제 되었습니다.!.");
				} else {
					LOG.debug(ingredient.getName() + "삭제 실패!.");
				}
				break;
			case "U":
				System.out.println("사용 : 재료/양");

				readData = scanner.nextLine().trim();
				dataArr = readData.split("/");

				ingredient = new Ingredient(dataArr[0], Integer.parseInt(dataArr[1]));

				int useFlag = main.dao.doUseIngredient(ingredient);
				if (1 == useFlag) {
					LOG.debug(ingredient.getName() + "사용 되었습니다.!.");
					LOG.debug(main.dao.doSelectOne(ingredient.getName()));

				} else {
					LOG.debug(ingredient.getName() + "사용 실패!.");
				}
				break;
			case "A":
				System.out.println("사용 : 재료/양");

				readData = scanner.nextLine().trim();
				dataArr = readData.split("/");

				ingredient = new Ingredient(dataArr[0], Integer.parseInt(dataArr[1]));

				int addFlag = main.dao.doAddIngredient(ingredient);
				if (1 == addFlag) {
					LOG.debug(ingredient.getName() + "추가 되었습니다.!.");
					LOG.debug(main.dao.doSelectOne(ingredient.getName()));

				} else {
					LOG.debug(ingredient.getName() + "추가 실패!.");
				}
				break;
			case "OS":
				System.out.println("전체재료 조회 ");
				for (Ingredient igd : BarDao.data) {
					System.out.println(igd);
				}
				break;

			}// switch

		} while (!inCommand.equalsIgnoreCase("Q"));
		System.out.println("프로그램이 종료되었습니다!");
	}

}
