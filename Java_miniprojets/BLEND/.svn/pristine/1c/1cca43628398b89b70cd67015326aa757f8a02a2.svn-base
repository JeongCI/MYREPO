package bar.test;

import java.util.Scanner;

import bar.dao.BarDao;
import cmn.LoggerManger;
import cocktail.dao.CocktailDao;
import cocktail.test.CocktailDaoTest;
import cocktail.test.CocktailDaoTestLYK;
import ingredient.domain.Ingredient;

public class BarDaoTest implements LoggerManger {

	BarDao dao;

	public BarDaoTest() {
		dao = new BarDao();
		// 칵테일 DaoTest와 합쳐져서 함께 메인 만들면
		// BarDao만들고 CocktailDao만들고 바로 재료검사하는 메서드 추가 예정
		// 제가 만들거니까 신경 안쓰셔두 돼욤
	}

	public static void main(String[] args) {
		BarDao dao = new BarDao();
		
		CocktailDaoTestLYK recipe = new CocktailDaoTestLYK();
		BarDaoTest bar = new BarDaoTest();

		Scanner scanner = new Scanner(System.in);
		String inCommand = "";

		do {
			System.out.println("====Menu====");
			System.out.println("C	: 새 재료 등록");
			System.out.println("D	: 재료삭제");
			System.out.println("A	: 재료 양 추가");
			System.out.println("US	: 재료 소모");
			System.out.println("OS	: 전체 재료 조회");
			System.out.println("Q	: 종료");
			System.out.println(">>");

			inCommand = scanner.nextLine();
			inCommand = inCommand.trim();

			Ingredient ingredient = null;// 밑에 코드 작성할 때 ingredient클래스 쓸 때 쓰세요
			String[] dataArr = null;// 마찬가지, String 어레이 필요하면 갖다 쓰세요
			String readData = ""; // command 입력 데이터

			switch (inCommand.toUpperCase()) {
			case "C":
				System.out.println("등록 : 재료/양(정수)>>");

				readData = scanner.nextLine().trim();
				dataArr = readData.split("/");

				ingredient = new Ingredient(dataArr[0], Integer.parseInt(dataArr[1]));
				int saveFlag = bar.dao.doSave(ingredient);
				if (saveFlag == 1) {
					LOG.debug(ingredient.getName() + "등록되었습니다.");
				} else {
					LOG.debug(ingredient.getName() + "등록실패!");
				}

				break;
			case "D":
				System.out.println("삭제 : 재료이름>>");
				ingredient = new Ingredient(scanner.nextLine());
				int delFlag = bar.dao.doDelete(ingredient);
				if (1 == delFlag) {
					LOG.debug(ingredient.getName() + "재료가 삭제 되었습니다.");
				} else {
					LOG.debug(ingredient.getName() + "재료 삭제 실패.");
				}
				break;
			case "A":
				System.out.println("재료 양 추가: 재료/양(정수)>>");
				readData = scanner.nextLine().trim();
				dataArr = readData.split("/");
				ingredient = new Ingredient(dataArr[0], Integer.parseInt(dataArr[1]));
				int addFlag = bar.dao.doAddIngredient(ingredient);
				if (1 == addFlag) {
					LOG.debug(ingredient.getName() + "재료가 " + ingredient.getAmount() + "만큼 추가되었습니다. 따라서 현재 남아있는 양은");
					LOG.debug(bar.dao.doSelectOne(ingredient.getName()));
				} else {
					LOG.debug(ingredient.getName() + "재료 소모 실패.");
				}
				break;
			case "US":
				System.out.println("재료 소모: 재료/양(정수)>>");
				readData = scanner.nextLine().trim();
				dataArr = readData.split("/");
				ingredient = new Ingredient(dataArr[0], Integer.parseInt(dataArr[1]));
				int useFlag = bar.dao.doUseIngredient(ingredient);
				if (1 == useFlag) {
					LOG.debug(ingredient.getName() + "재료가 " + ingredient.getAmount() + "만큼 사용되었습니다. 따라서 현재 남아있는 양은");
					LOG.debug(bar.dao.doSelectOne(ingredient.getName()));
				} else {
					LOG.debug(ingredient.getName() + "재료 사용 실패.");
				}

				break;
			case "OS":
				System.out.println("전체 재료및 양은 다음과 같습니다.");
				for (Ingredient ingred : BarDao.data) {
					System.out.println(ingred);
				}
				break;
			}
		} while (!inCommand.equalsIgnoreCase("Q"));

		bar.dao.writeFile(BarDao.SAVE_FILE_PATH);
		scanner.close();
		LOG.debug("============프로그램 종료!============");
	}

}
