package cocktail.test;

import java.util.ArrayList;
import java.util.Scanner;

import cmn.LoggerManger;
import cocktail.dao.CocktailDao;
import cocktail.domain.Cocktail;
import ingredient.domain.Ingredient;

public class CocktailDaoTestLYK implements LoggerManger {

	CocktailDao dao;

	public CocktailDaoTestLYK() {
		dao = new CocktailDao();
	}

	// JinTonic1,Jin/30,Tonic/90
	public Cocktail getInputData(Scanner scanner) {
		ArrayList<Ingredient> ingredArr = new ArrayList<Ingredient>();

		String[] dataArr = scanner.nextLine().trim().split(",");
		String name = dataArr[0];
		for (int i = 1; i < dataArr.length; i++) {
			String[] eachIngred = dataArr[i].split("/");
			Ingredient ingred = new Ingredient(eachIngred[0], Integer.parseInt(eachIngred[1]));
			ingredArr.add(ingred);
		}
		Cocktail cocktail = new Cocktail(name, ingredArr);

		return cocktail;/////////////////////////////////
	}

	public static void main(String[] args) {
		CocktailDaoTestLYK main = new CocktailDaoTestLYK();

		Scanner scanner = new Scanner(System.in);
		String inCommand = "";
		do {
			System.out.println("====Menu====");
			System.out.println("C	: 등록");
			System.out.println("U	: 수정");
			System.out.println("D	: 삭제");
			System.out.println("OS	: 칵테일 목록 조회");
			System.out.println("AS	: 칵테일 레시피 조회");
			System.out.println("Q	: 종료");
			System.out.println(">>");

			inCommand = scanner.nextLine();
			inCommand = inCommand.trim();

			Cocktail Coctail = null;
			String[] dataArr = null;
			String readData = "";

			switch (inCommand.toUpperCase()) {
			case "OS":
				System.out.println("칵테일 목록 조회 ");
				for (Cocktail c : CocktailDao.data) {
					System.out.println(c.getName());

				}
				break;

			case "AS":// 칵테일 레시피 조회
				System.out.println("칵테일 레시피 조회: 칵테일 이름>>");
				String search = scanner.nextLine().trim();

				// 검색구분
				if (main.dao.isCocktailExists(new Cocktail(search))) {
					for (Cocktail c : CocktailDao.data) {
						if (search.equalsIgnoreCase(c.getName())) {
							System.out.println(c);

						}
					}
				}else {
					System.out.println("이름이 "+search+"인 칵테일은 없습니다.");
				}
				break;
			case "C":// 등록
				System.out.println("등록 예시: 칵테일이름,레시피/수량,레시피/수량,...");

				int saveFlag = main.dao.doSave(main.getInputData(scanner));
				if (saveFlag == 1) {
					LOG.debug("등록 되었습니다.");
				} else {
					LOG.debug("등록 실패.");
				}
				break;

			case "U":// 수정
				System.out.println("수정 예시: 칵테일이름,레시피/수량,레시피/수량,...>>");

				Coctail = main.getInputData(scanner);

				int upFlag = main.dao.doUpdate(Coctail);
				if (upFlag == 1) {
					LOG.debug("수정 되었습니다.");
				} else {
					LOG.debug("수정 실패.");
				}

				break;
			case "D":// 삭제
				System.out.println("삭제 : 칵테일 이름>>");
				readData = scanner.nextLine().trim();
				Coctail = new Cocktail(readData);
				int delFlag = main.dao.doDelete(Coctail);
				if (1 == delFlag) {
					LOG.debug(Coctail.getName() + "삭제 되었습니다.");
				} else {
					LOG.debug(Coctail.getName() + "삭제 실패.");
				}
				break;

			case "Q":// data 파일에 저장하고,종료
				int flag = main.dao.writeFile(CocktailDao.SAVE_FILE_PATH);
				LOG.debug("저장건수:" + flag);
				break;
			}// switch

		} while (!inCommand.equalsIgnoreCase("Q"));
		System.out.println("종료 되었습니다.");
	}
}
