package cocktail.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import cmn.LoggerManger;
import cmn.WorkDiv;
import cocktail.domain.Cocktail;
import ingredient.domain.Ingredient;

public class CocktailDao implements WorkDiv<Cocktail>, LoggerManger {

	public static ArrayList<Cocktail> data = new ArrayList<Cocktail>();

	public final static String SAVE_FILE_PATH = "C:\\DCOM_0725\\03_JAVA\\workspace2\\BLEND\\cocktails.txt";

	public CocktailDao() {
		int size = readFile(SAVE_FILE_PATH);
		LOG.debug("칵테일 레시피 데이터 개수: " + size);
	}

	int readFile(String filePath) {
		int flag = 0;
		try (FileReader fr = new FileReader(filePath); BufferedReader br = new BufferedReader(fr)) {
			String line = "";
			while ((line = br.readLine()) != null) {
				String[] inArr = line.split(",");
				String name = inArr[0];
				ArrayList<Ingredient> ingredArr = new ArrayList<Ingredient>();
				for (int i = 1; i < inArr.length; i++) {
					String[] eachIngred = inArr[i].split("/");
					Ingredient ingred = new Ingredient(eachIngred[0], Integer.parseInt(eachIngred[1]));
					ingredArr.add(ingred);
				}
				Cocktail cocktail = new Cocktail(name, ingredArr);
				CocktailDao.data.add(cocktail);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		flag = CocktailDao.data.size();
		return flag;
	}

	public int writeFile(String filePath) {
		int flag = 0;
		try (FileWriter fw = new FileWriter("cocktails.txt"); BufferedWriter bw = new BufferedWriter(fw)) {

			String delim = ",";
			for (Cocktail cocktail : CocktailDao.data) {
				String line = "";
				line += cocktail.getName();

				for (Ingredient ingred : cocktail.getIngredArr()) {
					line = line + delim + ingred.getName() + "/" + String.valueOf(ingred.getAmount());
				}
				line += "\n";
				bw.write(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		flag = CocktailDao.data.size();
		return flag;
	}

	/**
	 * 칵테일 같은게 있는지 확인
	 * 
	 * @param dto
	 * @return 같은 게 있으면 true 없으면 false
	 */
	// 칵테일 이름이 같음을 검증하기 위한 함수
	public boolean isCocktailExists(Cocktail dto) {
		boolean flag = false;
		for (Cocktail cocktail : CocktailDao.data) {
			if (dto.getName().equalsIgnoreCase(cocktail.getName())) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	/**
	 * 칵테일 추가. 이름이 같은 칵테일이 있으면 실패.
	 * 
	 * @return 성공하면1 실패하면 0
	 */
	@Override
	public int doSave(Cocktail dto) {
		if (isCocktailExists(dto) == true) {
			LOG.debug("이름이 같은 칵테일이 있습니다. (" + dto.getName() + ")");
			return 0;
		}
		boolean flag = CocktailDao.data.add(dto);
		return flag == true ? 1 : 0;
	}

	/**
	 * 업데이트. 이름이 같은 칵테일이 있으면 삭제하고 수정
	 * 
	 * @return 성공하면1 실패하면0
	 */
	public int doUpdate(Cocktail dto) {
		int flag = 0;
		if (isCocktailExists(dto)) {
			int tmp = 0;
			tmp += doDelete(dto);
			tmp += doSave(dto);
			if (tmp == 2) {
				flag = 1;
			}
		}
		return flag;
	}

	/**
	 * 삭제. 칵테일의 이름만 같으면 삭제
	 * 
	 * @return 성공하면1 실패하면0
	 */
	@Override
	public int doDelete(Cocktail dto) {
		int flag = 0;
		for (int i = CocktailDao.data.size() - 1; i >= 0; i--) {
			if (dto.getName().equalsIgnoreCase(CocktailDao.data.get(i).getName())) {
				CocktailDao.data.remove(i);
				flag = 1;
				break;
			}
		}
		return flag;
	}

	/**
	 * 단건조회 칵테일의 이름을 확인해서 같으면 관리하고있는 칵테일을 반환.
	 * 
	 * @return Cocktail을 하나 반환. 실패시 null반환
	 */
	@Override
	public Cocktail doSelectOne(String cocktailName) {

		ArrayList<Ingredient> ingredArr = new ArrayList<Ingredient>();
		Cocktail inputCocktail = new Cocktail(cocktailName, ingredArr);
		Cocktail outputCocktail = null;

		if (isCocktailExists(inputCocktail)) {
			for (Cocktail cocktail : CocktailDao.data) {
				if (cocktail.getName().equalsIgnoreCase(inputCocktail.getName())) {
					outputCocktail = cocktail;
					break;
				}
			}
		} else {
			System.out.println("입력하신 이름의 칵테일이 존재하지 않습니다.");
			return null;
		}
		return outputCocktail;
	}

	/**
	 * 미니게임, 파라미터와 리턴 없음.
	 */
	public void doMiniGame() {
		LOG.debug("칵테일 레시피 미니게임 실행");
		Cocktail cocktail = null;
		String input = "";
		int ingredCnt = 0;
		Scanner scanner = new Scanner(System.in);
		Loop1: do {
			int rand = (int) (Math.random() * CocktailDao.data.size());
			cocktail = CocktailDao.data.get(rand);
			int recipeRan = (int) (Math.random() * cocktail.getIngredArr().size());
			System.out.println("난이도를 입력해주세요!(1~3)");
			System.out.println("종료하시려면 0을 입력해주세요.");
			String difficulty = scanner.nextLine();
			switch (difficulty) {
			case "1":

				System.out.println("문제: " + "재료가 다음과 같은 칵테일의 이름은?");
				ingredCnt = 1;
				for (int i = 0; i < cocktail.getIngredArr().size(); i++) {
					System.out.println("재료" + ingredCnt + ": " + cocktail.getIngredArr().get(i).getName() + "/"
							+ cocktail.getIngredArr().get(i).getAmount());
					ingredCnt++;
				}
				do {
					input = scanner.nextLine();
					if (input.equalsIgnoreCase(cocktail.getName())) {
						System.out.println("정답입니다!!");
						break;
					}
					if (input.equalsIgnoreCase("q")) {
						System.out.println("이번 문제 풀기를 종료합니다.");
						System.out.println("정답은 " + cocktail.getName() + "이었습니다.");
						break;
					}
					System.out.println("틀렸습니다! 다시 입력해보세요!! 그만두시려면 Q를 입력해주세요.");
				} while (true);
				break;
			case "2":
				System.out.println("문제: " + "다음은 " + cocktail.getName() + "의 재료인데 한 가지가 빠져있습니다.");
				System.out.println("그 재료의 이름을 맞춰보세요.");
				ingredCnt = 1;
				for (int i = 0; i < cocktail.getIngredArr().size(); i++) {
					if (i == recipeRan) {
						continue;
					}
					System.out.println("재료" + ingredCnt + ": " + cocktail.getIngredArr().get(i).getName());
					ingredCnt++;
				}
				do {
					input = scanner.nextLine();
					if (input.equalsIgnoreCase(cocktail.getIngredArr().get(recipeRan).getName())) {
						System.out.println("정답입니다!!");
						break;
					}
					if (input.equalsIgnoreCase("q")) {
						System.out.println("이번 문제 풀기를 종료합니다.");
						System.out.println("정답은 " + cocktail.getIngredArr().get(recipeRan).getName() + "이었습니다.");
						break;
					}
					System.out.println("틀렸습니다! 다시 입력해보세요!! 그만두시려면 Q를 입력해주세요.");
				} while (true);
				break;
			case "3":
				System.out.println("문제: " + cocktail.getName() + "한 잔을 만들기 위해서");
				System.out.println(cocktail.getIngredArr().get(recipeRan).getName() + "은 얼마나 들어가야 할까요?(정수)");
				do {
					input = scanner.nextLine().trim();
					String REGEX = "[0-9]+";

					if (input.equalsIgnoreCase("q")) {
						System.out.println("이번 문제 풀기를 종료합니다.");
						System.out.println("정답은 " + cocktail.getIngredArr().get(recipeRan).getAmount() + "이었습니다.");
						break;
					} else {
						if(input.matches(REGEX)) {
						if (Integer.parseInt(input) == cocktail.getIngredArr().get(recipeRan).getAmount()) {
							System.out.println("정답입니다!!");
							break;
						}}else {
							System.out.println("정수만 입력해주세요!!");
							continue;
						}
					}
					System.out.println("틀렸습니다! 다시 입력해보세요!! 그만두시려면 Q를 입력해주세요.");
				} while (true);
				System.out.println();

				break;
			case "0":
				break Loop1;
			}
		} while (true);// 미니게임실행while, 제일 밖에꺼

		LOG.debug("칵테일 레시피 미니게임 종료합니다.");
		return;
	}

}
