package project.quack.dao;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import project.quack.cmn.DTO;
import project.quack.cmn.LoggerManager;
import project.quack.cmn.WorkDiv;
import project.quack.domain.Menu;
import project.quack.domain.Search;

public class MenuDao implements WorkDiv<Menu>, LoggerManager {

//	ArrayList<Food> data_food = new ArrayList<Food>();
//	ArrayList<Drink> data_drink = new ArrayList<Drink>();
//	ArrayList<Side> data_side = new ArrayList<Side>();
	public static ArrayList<Menu> data_menu = new ArrayList<Menu>();

	public final static String SAVE_FILE_PATH = "C:\\DCOM_0725\\03_JAVA\\workspace2\\QUACK\\menu.txt";

	public MenuDao() {
		readFile(SAVE_FILE_PATH);
		LOG.debug("data.size:" + MenuDao.data_menu.size());

		for (Menu menu : MenuDao.data_menu) {
			LOG.debug(menu.toString());
		}
	}
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(
				new FileReader("C:\\DCOM_0725\\03_JAVA\\workspace2\\QUACK\\food.txt"));
		BufferedReader br2 = new BufferedReader(
				new FileReader("C:\\DCOM_0725\\03_JAVA\\workspace2\\QUACK\\side.txt"));
		BufferedReader br3 = new BufferedReader(
				new FileReader("C:\\DCOM_0725\\03_JAVA\\workspace2\\QUACK\\drink.txt"));

		BufferedWriter bw = new BufferedWriter(
				new FileWriter("C:\\DCOM_0725\\03_JAVA\\workspace2\\QUACK\\menu.txt"));

		String c;

		while ((c = br.readLine()) != null) {
			bw.write(c);
			bw.newLine();

		}
		while ((c = br2.readLine()) != null) {
			bw.write(c);
			bw.newLine();
		}
		while ((c = br3.readLine()) != null) {
			bw.write(c);
			bw.newLine();
		}

		bw.flush();

		FileReader reader = new FileReader("C:\\\\DCOM_0725\\\\03_JAVA\\\\workspace2\\\\QUACK\\\\menu.txt");

		int ch;
		while ((ch = reader.read()) != -1) {
			System.out.print((char) ch);
		}

	}



	/**
	 * 파일 읽기
	 * 
	 * @param path
	 * @return
	 */
	public int readFile(String filepath) {
		int flag = 0;

		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(SAVE_FILE_PATH);
			br = new BufferedReader(fr);

			int data_menu = 0;
			String line = "";
			while ((line = br.readLine()) != null) {
				LOG.debug(line);
				// 001, 오리훈제, 30000원, true

				String inArray[] = line.split(",");

				//
				//
				boolean available = inArray[3].equals("1") ? true : false;

				Menu menu = new Menu(inArray[0], inArray[1], inArray[2], available);
				// ArrayList 에 추가
				MenuDao.data_menu.add(menu);
			}

			if (MenuDao.data_menu.size() > 0)
				flag++;

		} catch (IOException e) {
			LOG.debug("IOException:" + e.getMessage());

		} finally {
			if (null != br) {
				try {
					br.close();
				} catch (IOException e) {
					LOG.debug("IOException:" + e.getMessage());
				}
			}
		}

		return flag;
	}

	/**
	 * 파일 저장
	 * 
	 * @param filepath
	 * @return
	 */
	public int writeFile(String filepath) {
		int flag = 0;
		// ArrayList<Menu> -> File로 기록

		try (FileWriter fw = new FileWriter(filepath); BufferedWriter bw = new BufferedWriter(fw);) {
			//
			for (Menu menu : MenuDao.data_menu) {

				String delim = ",";

				int available = (menu.isAvailable() == true) ? 1 : 0;

				String outLine = menu.getMenuNum() + delim + menu.getMenuName() + delim + menu.getPrice() + delim
						+ menu.isAvailable() + "\n";
				bw.write(outLine);
			}
		} catch (IOException e) {
			System.out.println("IOException:" + e.getMessage());
		}

		return MenuDao.data_menu.size() > 0 ? 1 : 0;
	}

//	@Override
//	public List<Menu> orderHistory(DTO dto) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public List<Menu> doRetrieve(DTO dto) {
		// 데이터를 찾아 return
		List<Menu> list = new ArrayList<Menu>();

		// param
		Search search = (Search) dto;

		int div = search.getSearchDiv();
		String searchWord = search.getSearchWord();
		for (Menu menu : MenuDao.data_menu) {
			// LOG.debug(book.getTitle().indexOf( search.getSearchWord()));
			// LOG.debug(book.getTitle().matches(".*"+search.getSearchWord()+".*"));
			// str.matches(".*"+검색어+".*")

			// .: 임의의 문자 [단 ‘'는 넣을 수 없습니다.]
			// *: 앞 문자가 0개 이상의 개수가 존재할 수 있습니다.

//			if(search.getSearchDiv()==10 && book.getTitle().matches(".*"+search.getSearchWord()+".*")) {//제목으로 검색
//				list.add(book);
//			}

			switch (div) {

			case 10:// 메뉴번호
				if (menu.getMenuNum().matches(".*" + searchWord + ".*")) {// 메뉴이름으로 검색
					list.add(menu);
				}
				break;

			case 20:// 메뉴이름
				if (menu.getMenuName().matches(".*" + searchWord + ".*")) {// 제목으로 검색
					list.add(menu);
				}
				break;

			case 100:// 전체
				list.add(menu);
				break;
			}

		}

		return list;
	}

	/**
	 * 존재 확인
	 * 
	 * @param menu
	 * @return true(존재)/false(없음)
	 */
	public boolean isMenuExists(Menu menu) {
		boolean flag = false;

		for (Menu vo : MenuDao.data_menu) {
			if (menu.getMenuNum().equals(vo.getMenuNum())) {
				flag = true;
				break;
			}
		}

		return flag;
	}

	@Override
	public int doSave(Menu dto) {
		Menu menu = (Menu) dto;
		if (isMenuExists(menu) == true) {
			LOG.debug("menuNum을 확인 하세요.(" + menu.getMenuNum() + ")");
			return 0;
		}

		boolean isContains = MenuDao.data_menu.contains(menu);
		LOG.debug("isContains:" + isContains);
		// data_menu.add(dto)

		boolean flag = MenuDao.data_menu.contains(menu);
		return (flag == true) ? 1 : 0;
	}

	@Override
	public int doUpdate(Menu dto) {
		int flag = 0;
		// data_menu delete, insert

		if (isMenuExists(dto) == true) {
			int tmp = 0;
			tmp += doDelete(dto);
			tmp += doSave(dto);

			if (tmp == 2)
				flag++;
		}
		return 0;
	}

	@Override
	public int doDelete(Menu dto) {

		int flag = 0;

		for (int i = MenuDao.data_menu.size() - 1; i >= 0; i--) {
			Menu tmp = MenuDao.data_menu.get(i);
			if (dto.getMenuNum().equals(tmp.getMenuNum())) {
				Menu menu = MenuDao.data_menu.remove(i);
				LOG.debug("삭제 데이터:" + menu);
				flag = 1;
				break;
			}
		}
		// data_menu.remove(i)
		return flag;
	}

	@Override
	public Menu doSelectOne(Menu obj) {
		// data.get(i)
		Menu menu = null;
		// 1. 존재 확인

		// 2. 존재하면 Menu을 retrun
		if (isMenuExists(obj)) {
			for (Menu tmpMenu : MenuDao.data_menu) {
				if (tmpMenu.getMenuNum().equals(obj.getMenuNum())) {
					menu = tmpMenu;
					break;
				}
			}
		}
		return menu;
	}

	@Override
	public List<Menu> orderHistory(Menu dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
