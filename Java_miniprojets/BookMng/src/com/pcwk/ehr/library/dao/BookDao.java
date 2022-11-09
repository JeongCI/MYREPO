package com.pcwk.ehr.library.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

import com.pcwk.ehr.cmn.DTO;
import com.pcwk.ehr.cmn.LoggerManger;
import com.pcwk.ehr.cmn.WorkDiv;
import com.pcwk.ehr.library.domain.Book;
import com.pcwk.ehr.library.domain.Search;

public class BookDao implements WorkDiv<Book>, LoggerManger {
	// BookDao객체 생서시 파일에 있는 내용을 읽어 ArrayList<DTO> 담는다.
	// 종료시 data를 파일에 기록
	public static ArrayList<Book> data = new ArrayList<Book>();

	// 저장파일 경로
	public final static String SAVE_FILE_PATH = "C:\\DCOM_0725\\03_JAVA\\WorkSpace2\\BookMng\\book.csv";
//	public final static String SAVE_JSON_FILE_PATH = "";

	public BookDao() {
		readFile(SAVE_FILE_PATH);
		LOG.debug("data : " + BookDao.data.size());

		for (Book book : BookDao.data) {
			LOG.debug(book.toString());
		}
	}

	/**
	 * 파일 읽기
	 * 
	 * @param filePath
	 * @return
	 */
	int readFile(String filePath) {
		int flag = 0;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(SAVE_FILE_PATH);
			br = new BufferedReader(fr);

			int data = 0;
			String line = ""; // 데이터를 line단위로 관리
			while ((line = br.readLine()) != null) {
				LOG.debug(line);

				String inArray[] = line.split(",");

				// 대여 가능 여부
				// 1 -> true / 0 -> false
				boolean avaliable = inArray[5].equals("1") ? true : false;

				Book book = new Book(inArray[0], inArray[1], inArray[2], inArray[3], inArray[4], avaliable);
				// ArrayList 추가
				BookDao.data.add(book);

			}

			if (BookDao.data.size() > 0)
				flag++;

		} catch (IOException e) {
			LOG.debug("IOException :" + e.getMessage());
		} finally {
			if (null != br) {
				try {
					br.close();
				} catch (IOException e) {
					LOG.debug("IOException :" + e.getMessage());
				}
			}
		}

		return flag;
	}

	/**
	 * 파일 저장!
	 * 
	 * @param filePath
	 * @return
	 */
	public int writeFile(String filePath) {
		int flag = 0;
		// ArrayList<Book> -> File로 기록

		try (FileWriter fw = new FileWriter(filePath); BufferedWriter bw = new BufferedWriter(fw);) {

			for (Book book : BookDao.data) {
				String delim = ",";

				int avaliable = (book.isBorrow() == true) ? 1 : 0;

				String outLine = book.getIsbn() + delim + book.getTitle() + delim + book.getAuthor() + delim
						+ book.getGenre() + delim + book.getPublicationDate() + delim + book.isBorrow() + "\n";
				bw.write(outLine);
			}

		} catch (IOException e) {
			System.out.println("IOException : " + e.getMessage());
		}

		return BookDao.data.size();
	}

	/**
	 * 도서목록에 도서존재 확인
	 * 
	 * @param book
	 * @return true / false
	 */
	public boolean isBookExitst(Book book) {
		boolean flag = false;

		for (Book vo : BookDao.data) {
			if (book.getIsbn().equals(vo.getIsbn())) {
				flag = true;
				break;
			}
		}

		return flag;
	}

	@Override
	public int doSave(Book dto) {
		Book book = dto; // param 읽기

		if (isBookExitst(book) == true) {
			LOG.debug("ISBN을 확인 하세요." + book.getIsbn());
			return 0;
		}

		boolean isContains = BookDao.data.contains(book);
		LOG.debug("isContains : " + isContains);

		boolean flag = BookDao.data.add(book);

		return (flag == true) ? 1 : 0;
	}

	@Override
	public List<Book> doRetrieve(DTO dto) {
		// 데이터를 찾아 return
		List<Book> list = new ArrayList<Book>();

		// param
		Search search = (Search) dto;

		int div = search.getSerachDiv();
		String searchWord = search.getSearchWord();

		for (Book book : BookDao.data) {
//			LOG.debug(book.getTitle().indexOf(search.getSearchWord()));
//			LOG.debug(book.getTitle().matches(".*" +search.getSearchWord()+ ".*"));
			// str.matches(",*" + 검색어 + ".*"

			// .: 임의의 문자 [ 단 "*" 는 넣을 수 없다]
			// *: 앞 문자가 0개 이상의 개수가 존재할 수 있다.
//			if(search.getSerachDiv() == 10 && book.getTitle().matches(".*" +search.getSearchWord()+ ".*")) {
//				list.add(book);
//			}
//		}

			switch (div) {
			case 10: // 제목
				if (book.getTitle().matches(".*" + searchWord + ".*")) {
					list.add(book);
				}
				break;

			case 20: // 저자
				if (book.getAuthor().matches(".*" + searchWord + ".*")) {
					list.add(book);
				}
				break;

			case 100: // 전체
				list.add(book);
				break;
			}
		}

		return list;
	}

	@Override
	public int doUpdate(Book dto) {
		int flag = 0;
		if (isBookExitst(dto) == true) {
			int tmp = 0;
			tmp += doDelete(dto);
			tmp += doSave(dto);

			if (tmp == 2)
				flag++;
		}
		return flag;
	}

	@Override
	public int doDelete(Book dto) {
		int flag = 0;
		for (int i = BookDao.data.size() - 1; i >= 0; i--) {
			Book tmp = BookDao.data.get(i);
			if (dto.getIsbn().equals(tmp.getIsbn())) {
				Book book = BookDao.data.remove(i);
				LOG.debug("삭제 데이터: " + book);
				flag = 1;
				break;
			}

		}

		return flag;
	}

	@Override
	public Book doSelectOne(Book obj) {
		Book book = null;
		if (isBookExitst(obj)) {
			for (Book tmpBook : BookDao.data) {
				if (tmpBook.getIsbn().equals(obj.getIsbn())) {
					book = tmpBook;
					break;
				}
			}
		}

		return book;
	}

}
