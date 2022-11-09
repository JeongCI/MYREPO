package cocktail.test;

import java.util.ArrayList;

import cmn.LoggerManger;
import cocktail.dao.CocktailDao;
import cocktail.domain.Cocktail;
import ingredient.domain.Ingredient;

public class CocktailDaoTest implements LoggerManger{

	CocktailDao dao;
	Cocktail cocktail1;
	Cocktail cocktail2;
	Ingredient ingred01;
	Ingredient ingred02;
	ArrayList<Ingredient> ingredArr;
	
	public CocktailDaoTest() {
		dao = new CocktailDao();
		ingred01 = new Ingredient("Jin", 30);
		ingred02 = new Ingredient("Tonic", 90);
		ingredArr = new ArrayList<Ingredient>();
		ingredArr.add(ingred01);
		ingredArr.add(ingred02);
		
		cocktail1 = new Cocktail("JinTonic",ingredArr);
	}
	
	public void doSave() {
		int flag = dao.doSave(cocktail1);
		if (flag == 1) {
			LOG.debug(cocktail1);
			LOG.debug("등록 성공");
		} else {
			LOG.debug("등록 실패");
		}
		dao.writeFile(CocktailDao.SAVE_FILE_PATH);
	}
	
	public void doDelete() {
		int flag = dao.doDelete(cocktail1);
		if(flag == 1 ) {
			LOG.debug(cocktail1);
			LOG.debug("삭제 성공");	
		}else {
			LOG.debug("나..뭘잘못한거지..");
		}
		dao.writeFile(CocktailDao.SAVE_FILE_PATH);
	}
	public static void main(String[] args) {
		CocktailDaoTest main = new CocktailDaoTest();
		//main.doSave();
		//main.doDelete();
		//main.dao.writeFile(CocktailDao.SAVE_FILE_PATH);
		
		
	}

}
