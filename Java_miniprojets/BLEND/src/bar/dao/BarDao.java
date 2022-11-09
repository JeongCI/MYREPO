package bar.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import cmn.LoggerManger;
import cmn.WorkDiv;
import cocktail.domain.Cocktail;
import ingredient.domain.Ingredient;

public class BarDao implements WorkDiv<Ingredient>, LoggerManger {

	public static ArrayList<Ingredient> data = new ArrayList<Ingredient>();

	public final static String SAVE_FILE_PATH ="C:\\DCOM_0725\\03_JAVA\\workspace2\\BLEND\\barStock.txt";

	public BarDao() {
		int size = readFile(SAVE_FILE_PATH);
		LOG.debug("재고 데이터 개수: " + size);
	}

	int readFile(String filePath) {
		int flag = 0;
		try (FileReader fr = new FileReader(filePath); BufferedReader br = new BufferedReader(fr)) {
			String line = "";
			while ((line = br.readLine()) != null) {
				String[] eachIngred = line.split("/");
				Ingredient ingred = new Ingredient(eachIngred[0], Integer.parseInt(eachIngred[1]));
				BarDao.data.add(ingred);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		flag = BarDao.data.size();
		return flag;
	}

	/**
	 * 파일 쓰기
	 * 
	 * @param filePath
	 * @return 성공하면 BarDao의 원소 개수 반환
	 */
	public int writeFile(String filePath) {
		int flag = 0;
		try (FileWriter fw = new FileWriter("barStock.txt"); BufferedWriter bw = new BufferedWriter(fw)) {
			for (Ingredient ingred : BarDao.data) {
				String line = ingred.getName() + "/" + String.valueOf(ingred.getAmount()) + "\n";
				bw.write(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		flag = BarDao.data.size();
		return flag;
	}

	/**
	 * 재료 같은게 있는지 확인
	 * 
	 * @param Ingredient
	 * @return 같은 게 있으면 true 없으면 false 반환
	 */
	public boolean isIngredientExists(Ingredient dto) {
		boolean flag = false;
		for (Ingredient ingred : BarDao.data) {
			if (dto.getName().equalsIgnoreCase(ingred.getName())) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	/**
	 * 재료 추가 이름이 같은 재료가 있으면 실패.
	 * 
	 * @return 성공하면 1, 실패하면 0
	 */
	@Override
	public int doSave(Ingredient dto) {
		if (dto.getAmount() < 0) {
			System.out.println("음수의 양을 가진 재료를 등록할 수 없습니다.");
			System.out.println("재료의 양을 0으로 추가하는 것은 가능합니다.");
		}
		if (isIngredientExists(dto) == true) {
			LOG.debug("이름이 같은 재료가 있습니다.(" + dto.getName() + ")");
			return 0;
		}
		boolean flag = BarDao.data.add(dto);
		return flag == true ? 1 : 0;
	}

	/**
	 * 삭제. 재료의 이름이 같으면 삭제
	 * 
	 * @return 성공하면 1 실패하면 0
	 */
	@Override
	public int doDelete(Ingredient dto) {
		int flag = 0;
		for (int i = BarDao.data.size() - 1; i >= 0; i--) {
			if (dto.getName().equalsIgnoreCase(BarDao.data.get(i).getName())) {
				Ingredient ingred = BarDao.data.remove(i);
				flag = 1;
				LOG.debug(ingred.getName() + "의 재료가 바에서 제거되었습니다.");
				break;
			}
		}
		return flag;
	}

	/**
	 * 단건조회. 이름을 확인해서 같으면 관리하고 있는 재료를 반환
	 * 
	 * @return 재료를 하나 반환. 실패시 null 반환
	 */
	@Override
	public Ingredient doSelectOne(String ingredName) {

		Ingredient inputIngred = new Ingredient(ingredName);
		Ingredient outputIngred = null;

		if (isIngredientExists(inputIngred)) {
			for (Ingredient ingred : BarDao.data) {
				if (inputIngred.getName().equalsIgnoreCase(ingred.getName())) {
					outputIngred = ingred;
					break;
				}
			}
		} else {
			System.out.println("입력하신 이름의 재료가 존재하지 않습니다.");
			return null;
		}
		return outputIngred;
	}

	/**
	 * 있는 재료로 칵테일을 입력받은 갯수(잔수)만큼 만들 수 있는지 확인하는 메서드
	 * 
	 * @param Cocktail, int(잔 수)
	 * @return 가능하면 1 불가능하면 0 반환
	 */
	public int canMakeCocktail(Cocktail cocktail,int n) {
		int ingredCnt = 0;
		int flag = 0;
		for (Ingredient ingred : cocktail.getIngredArr()) {
			if (!isIngredientExists(ingred)) {
				System.out.println("만드려는 칵테일의 재료중 등록되지 않은 게 있는게 있습니다.");
				System.out.println("바 메뉴의 전체 재료 조회와 칵테일 메뉴의 칵테일 레시피 조회를 사용해보세요.");
				return 0;
			}
		}
		for (Ingredient ingred : cocktail.getIngredArr()) {
			for (int i = BarDao.data.size() - 1; i >= 0; i--) {
				if (ingred.getName().equalsIgnoreCase(BarDao.data.get(i).getName())) {
					if (BarDao.data.get(i).getAmount() >= n*ingred.getAmount()) {
						ingredCnt++;
					} else {
						System.out.println(ingred.getName() + "의 양이 부족합니다");
					}
				}

			}
			if (cocktail.getIngredArr().size() == ingredCnt) {
				flag = 1;
			}
		}
		return flag;
	}

	/**
	 * 재료 사용. 이름이 같은 재료를 찾아 그만큼 소비함.
	 * 
	 * @param Ingredient
	 * @return 성공하면1 실패하면0
	 */
	public int doUseIngredient(Ingredient dto) {
		int flag = 0;
		if (dto.getAmount() <= 0) {
			System.out.println("0 이하의 양을 소모할 수 없습니다. 재료 추가ㅣ 사용해주세요");
			return 0;
		}
		if (isIngredientExists(dto) == true) {
			for (int i = BarDao.data.size() - 1; i >= 0; i--) {
				if (dto.getName().equalsIgnoreCase(BarDao.data.get(i).getName())) {
					if (dto.getAmount() > BarDao.data.get(i).getAmount()) {
						LOG.debug("사용하려는 양이 남아있는 양보다 많습니다.");
						return 0;
						// check와 함께 보고 수정해야할지도
					} else {
						int tmp = BarDao.data.get(i).getAmount() - dto.getAmount();
						BarDao.data.get(i).setAmount(tmp);
						flag = 1;
						break;
					}
				} // for문종료
			}
		} else {
			System.out.println("입력하신 이름의 재료가 존재하지 않습니다.");
			return 0;
		}
		return flag;
	}

	/**
	 * 재료 추가. 이름이 같은 재료를 찾아 그만큼 추가함.
	 * 
	 * @param Ingredient
	 * @return 성공하면1 실패하면0
	 */
	public int doAddIngredient(Ingredient dto) {
		int flag = 0;
		if (dto.getAmount() <= 0) {
			System.out.println("0 이하의 양을 더할 수 없습니다. 재료 소모를 사용해주세요");
			return 0;
		}
		if (isIngredientExists(dto) == true) {
			for (int i = BarDao.data.size() - 1; i >= 0; i--) {
				if (dto.getName().equalsIgnoreCase(BarDao.data.get(i).getName())) {
					int tmp = BarDao.data.get(i).getAmount() + dto.getAmount();
					BarDao.data.get(i).setAmount(tmp);
					flag = 1;
					break;
				}
			} // for문종료
		} else {
			System.out.println("입력하신 이름의 재료가 존재하지 않습니다.");
			return 0;
		}
		return flag;
	}

	/**
	 * 칵테일을 만드는 메서드. 만들면 그만큼 재료 사용.
	 * 
	 * @param cocktail, int(잔 수)
	 * @return 성공하면1, 실패하면0
	 */
	public int doMakeCocktail(Cocktail cocktail, int n) {
		int flag = 0;
		if (canMakeCocktail(cocktail,n) == 1) {
			LOG.debug(cocktail.getName()+"을(를) "+n+"잔 만들었습니다.");
			for (Ingredient ingred : cocktail.getIngredArr()) {
				for (int i = BarDao.data.size() - 1; i >= 0; i--) {
					if (ingred.getName().equalsIgnoreCase(BarDao.data.get(i).getName())) {
						int tmp = BarDao.data.get(i).getAmount() - n*ingred.getAmount();
						BarDao.data.get(i).setAmount(tmp);
						LOG.debug(ingred.getName()+"이(가)"+tmp+"만큼 남았습니다");
					}
				}
			}
			flag = 1;
		}
		return flag;
	}

}
