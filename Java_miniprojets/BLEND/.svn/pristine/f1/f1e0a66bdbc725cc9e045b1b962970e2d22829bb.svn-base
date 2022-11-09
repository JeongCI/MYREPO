package main;

import java.util.ArrayList;
import java.util.Scanner;

import bar.dao.BarDao;
import cmn.LoggerManger;
import cocktail.dao.CocktailDao;
import cocktail.domain.Cocktail;
import ingredient.domain.Ingredient;

public class mainMenu implements LoggerManger {

	public BarDao bar;
	public CocktailDao recipe;

	public mainMenu() {
		recipe = new CocktailDao();
		bar = new BarDao();
	}

	/**
	 * 칵테일 레시피에 있는 재료 중 등록이 안된 게 있으면 알려주는 메서드
	 * 
	 * @return 없는 재료가 있으면 1, 없으면 0
	 */
	public int ingredAutoCheck() {
		int flag = 0;
		for (Cocktail cocktail : recipe.data) {
			ArrayList<Ingredient> ingredArr = cocktail.getIngredArr();
			for (Ingredient ingred : ingredArr) {
				if (!bar.isIngredientExists(ingred)) {
					flag = 1;
				}
			}
		}
		return flag;
	}

	/**
	 * 칵테일 레시피에 있는 재료 중 등록이 안된 게 있으면 이름/양은0 으로 자동으로 등록하는 메서드
	 * 
	 * @return 성공하면 1, 실패하면 0
	 */
	public int ingredAutoReg() {
		int flag = 1;
		for (Cocktail cocktail : recipe.data) {
			ArrayList<Ingredient> ingredArr = cocktail.getIngredArr();
			for (Ingredient ingred : ingredArr) {
				if (!bar.isIngredientExists(ingred)) {
					bar.doSave(new Ingredient(ingred.getName()));
				}
			}
		}

		for (Cocktail cocktail : recipe.data) {
			ArrayList<Ingredient> ingredArr = cocktail.getIngredArr();
			for (Ingredient ingred : ingredArr) {
				if (!bar.isIngredientExists(ingred)) {
					flag = 0;
				}
			}
		}

		bar.writeFile(bar.SAVE_FILE_PATH);
		return flag;
	}

	/**
	 * 메인에서 사용하는 메서드. 스캐너를 입력받으면 한 줄을 입력받아 칵테일클래스의 생성자로 생성해서 돌려줌.
	 * @param scanner
	 * @return Cocktail클래스의 객체, 0을 입력받으면 null반환
	 */
	public Cocktail getInputCocktail(Scanner scanner) {
		ArrayList<Ingredient> ingredArr = new ArrayList<Ingredient>();

		String[] dataArr = scanner.nextLine().trim().split(",");
		String name = dataArr[0];
		if (name.equals("0")) {
			return null;
		}
		for (int i = 1; i < dataArr.length; i++) {
			String[] eachIngred = dataArr[i].split("/");
			if (eachIngred.length != 2) {
				System.out.println("각 칵테일 재료의 재료의 이름/양(정수)의 형식을 확인해주세요.");
				return new Cocktail(name);
			}
			Ingredient ingred = new Ingredient(eachIngred[0], Integer.parseInt(eachIngred[1]));
			ingredArr.add(ingred);
		}
		Cocktail cocktail = new Cocktail(name, ingredArr);

		return cocktail;
	}

	/**
	 * 메인에서 사용하는 메서드. 스캐너를 입력받으면 한 줄을 입력받아 재료클래스의 생성자로 생성해서 돌려줌.
	 * @param scanner
	 * @return Ingredient클래스의 객체, 0을 입력받으면 null을 반환
	 */
	public Ingredient getInputIngred(Scanner scanner) {
		String[] dataArr = null;
		while (true) {
			dataArr = scanner.nextLine().trim().split("/");
			if (dataArr.length == 1 & dataArr[0].equals("0")) {
				return null;
			}
			if (dataArr.length != 2) {
				System.out.println("재료의 이름/양(정수)의 형식을 맞춰 다시 입력해주세요.");
			} else {
				break;
			}
		}
		Ingredient ingredient = new Ingredient(dataArr[0], Integer.parseInt(dataArr[1]));
		return ingredient;
	}

	public static void main(String[] args) {
		mainMenu main = new mainMenu();
		Scanner scanner = new Scanner(System.in);
		if (main.ingredAutoCheck() == 1) {
			System.out.println("칵테일 레시피에 있는 재료 중 등록되지 않은 재료가 있어서 자동으로 등록됩니다.");
			main.ingredAutoReg();
			int size = main.bar.data.size();
			System.out.println("자동 등록 후 등록된 재료 종류는 " + size + "개 입니다.");
			System.out.println("확인하시려면 칵테일 바 재고 관리메뉴의 재료 전체 조회를 사용해주세요.\n");
		}
		String menuStatus = "";
		do {
			System.out.println("\n======== 메 뉴 ========");
			System.out.println("1. 칵테일 레시피 관리 메뉴");
			System.out.println("2. 칵테일 바 재고 관리 메뉴");
			System.out.println("0. 종료");
			System.out.println(">>");

			menuStatus = scanner.nextLine().trim();
			String inCommand = "";

			switch (menuStatus) {
			case "1":
				do {
					System.out.println("\n====칵테일 레시피 관리 메뉴====");
					System.out.println("1.등록");
					System.out.println("2.수정");
					System.out.println("3.삭제");
					System.out.println("4.전체 칵테일 목록 조회");
					System.out.println("5.칵테일 레시피 조회");
					System.out.println("6.칵테일 레시피 미니게임");
					System.out.println("0.종료");
					System.out.println("모든 메뉴에서 실행취소는 0을 입력해주세요.");
					System.out.println(">>");

					Cocktail cocktail = null;
					String readData = "";

					inCommand = scanner.nextLine().trim();

					switch (inCommand) {
					case "1":// 등록
						System.out.println("등록 예시: 칵테일이름,재료1/수량,재료2/수량,...>>");
						cocktail = main.getInputCocktail(scanner);
						if (cocktail != null) {
							if (cocktail.getIngredArr().size() == 0) {
								System.out.println("칵테일의 이름만이 아닌 이름과 재료를 양식에 맞게 입력해주세요.");
								break;
							}
							int saveFlag = main.recipe.doSave(cocktail);
							if (saveFlag == 1) {
								LOG.debug(cocktail.getName() + "의 데이터가 등록 되었습니다.");
							} else {
								LOG.debug(cocktail.getName() + "등록 실패.");
							}
							main.recipe.writeFile(CocktailDao.SAVE_FILE_PATH);
						} else {
							System.out.println("취소하고 칵테일 레시피 관리 메뉴로 돌아갑니다.");
						}
						break;
					case "2":// 수정
						System.out.println("수정 예시: 칵테일이름,재료1/수량,재료2/수량,...>>");
						cocktail = main.getInputCocktail(scanner);
						if (cocktail != null) {
							if (cocktail.getIngredArr().size() == 0) {
								System.out.println("칵테일의 이름만이 아닌 이름과 재료를 양식에 맞게 입력해주세요.");
								System.out.println("칵테일 레시피 관리 메뉴로 돌아갑니다.");
								break;
							}
							int upFlag = main.recipe.doUpdate(cocktail);
							if (upFlag == 1) {
								LOG.debug(cocktail.getName() + "의 데이터가 수정 되었습니다.");
							} else {
								LOG.debug(cocktail.getName() + "수정 실패.");
							}
							main.recipe.writeFile(CocktailDao.SAVE_FILE_PATH);
						} else {
							System.out.println("취소하고 칵테일 레시피 관리 메뉴로 돌아갑니다.");
						}
						break;
					case "3":// 삭제
						System.out.println("삭제 : 칵테일 이름>>");
						readData = scanner.nextLine().trim();
						if (readData.equals("0")) {
							System.out.println("취소하고 칵테일 레시피 관리 메뉴로 돌아갑니다.");
							break;
						}
						cocktail = new Cocktail(readData);
						int delFlag = main.recipe.doDelete(cocktail);
						if (1 == delFlag) {
							LOG.debug(cocktail.getName() + "의 데이터가 삭제 되었습니다.");
						} else {
							LOG.debug(cocktail.getName() + "삭제 실패.");
							System.out.println("칵테일 삭제는 이름만 입력하셔야 합니다.");
							System.out.println("전체 칵테일 목록 조회를 사용해보세요.");
						}
						main.recipe.writeFile(CocktailDao.SAVE_FILE_PATH);
						break;
					case "4":
						LOG.debug("전체 칵테일 목록 조회 ");
						for (Cocktail c : CocktailDao.data) {
							System.out.println(c.getName());
						}
						break;
					case "5":// 칵테일 레시피 조회
						LOG.debug("칵테일 레시피 조회: 칵테일 이름>>");
						String search = scanner.nextLine().trim();
						if (search.equals("0")) {
							System.out.println("취소하고 칵테일 레시피 관리 메뉴로 돌아갑니다.");
							break;
						}
						if (main.recipe.isCocktailExists(new Cocktail(search))) {
							for (Cocktail c : CocktailDao.data) {
								if (search.equalsIgnoreCase(c.getName())) {
									System.out.println(c);
								}
							}
						} else {
							System.out.println("같은 이름의 칵테일이 존재하지 않습니다.");
							System.out.println("전체 칵테일 목록 조회를 사용해보세요.");
						}
						break;
					case "6":
						main.recipe.doMiniGame();
						break;
					case "0":// data 파일에 저장하고,종료
						int flag = main.recipe.writeFile(CocktailDao.SAVE_FILE_PATH);
						LOG.debug("칵테일 레시피 저장건수:" + flag);
						break;
					default:
						System.out.println("유효한 명령어를 입력해 주세요!! 칵테일 레시피 관리 메뉴로 돌아갑니다.");
					}// switch
				} while (!inCommand.equals("0"));
				System.out.println("칵테일 레시피 관리 메뉴를 종료합니다.");
				break;
			case "2":
				do {
					System.out.println("\n====칵테일 바 재고 관리 메뉴====");
					System.out.println("1.새 재료 등록");
					System.out.println("2.재료삭제");
					System.out.println("3.재료 양 추가");
					System.out.println("4.재료 소모");
					System.out.println("5.전체 재료 조회");
					System.out.println("6.칵테일 만들기");
					System.out.println("7.재료 자동 등록");
					System.out.println("0.종료");
					System.out.println("모든 메뉴에서 실행취소는 0을 입력해주세요.");
					System.out.println(">>");

					inCommand = scanner.nextLine();
					inCommand = inCommand.trim();

					Ingredient ingredient = null;

					switch (inCommand) {
					case "1":
						System.out.println("등록 : 재료/양(정수)>>");

						ingredient = main.getInputIngred(scanner);
						if (ingredient != null) {
							int saveFlag = main.bar.doSave(ingredient);
							if (saveFlag == 1) {
								LOG.debug(ingredient.getName() + "의 데이터가 등록되었습니다.");
							} else {
								LOG.debug(ingredient.getName() + "등록실패.");
							}
							main.bar.writeFile(BarDao.SAVE_FILE_PATH);
						} else {
							System.out.println("취소하고 칵테일 재고 관리 메뉴로 돌아갑니다.");
						}
						break;
					case "2":
						System.out.println("삭제 : 재료이름>>");
						String inputString = scanner.nextLine().trim();
						if (inputString.equals("0")) {
							System.out.println("취소하고 칵테일 재고 관리 메뉴로 돌아갑니다.");
							break;
						}
						ingredient = new Ingredient(inputString);
						int delFlag = main.bar.doDelete(ingredient);
						if (1 == delFlag) {
							LOG.debug(ingredient.getName() + "재료가 삭제 되었습니다.");
						} else {
							LOG.debug(ingredient.getName() + "재료 삭제 실패.");
						}
						main.bar.writeFile(BarDao.SAVE_FILE_PATH);
						break;
					case "3":
						System.out.println("재료 양 추가: 재료/양(정수)>>");
						ingredient = main.getInputIngred(scanner);
						if (ingredient != null) {
							int addFlag = main.bar.doAddIngredient(ingredient);
							if (1 == addFlag) {
								LOG.debug(ingredient.getName() + "재료가 " + ingredient.getAmount()
										+ "만큼 추가되었습니다. 따라서 현재 남아있는 양은");
								LOG.debug(main.bar.doSelectOne(ingredient.getName()));
							} else {
								LOG.debug(ingredient.getName() + "재료 소모 실패.");
							}
							main.bar.writeFile(BarDao.SAVE_FILE_PATH);
						} else {
							System.out.println("취소하고 칵테일 재고 관리 메뉴로 돌아갑니다.");
						}
						break;
					case "4":
						System.out.println("재료 소모: 재료/양(정수)>>");
						ingredient = main.getInputIngred(scanner);
						if (ingredient != null) {
							int useFlag = main.bar.doUseIngredient(ingredient);
							if (1 == useFlag) {
								LOG.debug(ingredient.getName() + "재료가 " + ingredient.getAmount()
										+ "만큼 사용되었습니다. 따라서 현재 남아있는 양은");
								LOG.debug(main.bar.doSelectOne(ingredient.getName()));
							} else {
								LOG.debug(ingredient.getName() + "재료 사용 실패.");
							}
							main.bar.writeFile(BarDao.SAVE_FILE_PATH);
						} else {
							System.out.println("취소하고 칵테일 재고 관리 메뉴로 돌아갑니다.");
						}
						break;
					case "5":
						System.out.println("전체 재료및 양은 다음과 같습니다.");
						for (Ingredient ingred : BarDao.data) {
							System.out.println(ingred);
						}
						break;
					case "6":
						Cocktail cocktail = null;
						String name = "";
						int ea = 0;
						System.out.println("만들 칵테일의 이름과 잔 수를 입력해주세요 칵테일/수(정수)>>");
						do {
							String input = scanner.nextLine().trim();
							String[] inputArr = input.split("/");
							if (inputArr.length == 1 & inputArr[0].equals("0")) {
								name = "0";
								break;
							}
							if (inputArr.length != 2) {
								System.out.println("칵테일/수의 형식을 확인해 다시 입력해주세요.");
								continue;
							} else {
								name = inputArr[0];
								ea = Integer.parseInt(inputArr[1]);
								break;
							}
						} while (true);
						if (name.equals("0")) {
							System.out.println("취소하고 칵테일 재고 관리 메뉴로 돌아갑니다.");
							break;
						}
						if (main.recipe.isCocktailExists(new Cocktail(name))) {
							for (Cocktail c : CocktailDao.data) {
								if (name.equalsIgnoreCase(c.getName())) {
									cocktail = c;
								}
							}
						} else {
							System.out.println("같은 이름의 칵테일이 존재하지 않습니다.");
							System.out.println("칵테일 메뉴의 전체 칵테일 목록 조회를 사용해보세요.");
							break;
						}
						if (1 == main.bar.canMakeCocktail(cocktail, ea)) {
							main.bar.doMakeCocktail(cocktail, ea);
						} else {
							System.out.println(cocktail.getName() + "을(를) " + ea + "잔 만들 수 없습니다.");
							break;
						}
						main.bar.writeFile(BarDao.SAVE_FILE_PATH);
						break;
					case "7":
						if (main.ingredAutoReg() == 1) {
							System.out.println("재료들이 자동 등록되었습니다.");
							int size = main.bar.data.size();
							System.out.println("자동 등록 후 등록된 재료 종류는 " + size + "개 입니다.");
							System.out.println("확인하시려면 재료 전체 조회를 사용해주세요.");
						} else {
							System.out.println("재료 자동 등록실패.");
						}
						break;
					case "0":// data 파일에 저장하고,종료
						int flag = main.bar.writeFile(BarDao.SAVE_FILE_PATH);
						LOG.debug("칵테일 바 재료 저장건수:" + flag);
						break;
					default:
						System.out.println("유효한 명령어를 입력해 주세요!! 칵테일 바 재고 관리 메뉴로 다시 돌아갑니다.");
					}
				} while (!inCommand.equals("0"));
				LOG.debug("칵테일 바 재고 관리 메뉴를 종료합니다.");
				break;
			case "0":
				break;
			default:
				System.out.println("유효한 명령어를 입력해 주세요. 전체 메뉴로 돌아갑니다.");
			}

		} while (!menuStatus.equals("0"));
		LOG.debug("프로그램 종료");
	}

}
