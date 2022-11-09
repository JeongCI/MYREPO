package begin.doc.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import begin.doc.cmn.DTO;
import begin.doc.cmn.LoggerManager;
import begin.doc.cmn.WorkDiv;
import begin.doc.domain.Book;
import begin.doc.domain.Search;

/**
 * 도서 기능 구현 클래스 도서 목록 파일(book.txt)에 접근하여 데이터 가공 및 처리
 * 
 * @author ITSC
 *
 */

public class BookDao implements WorkDiv<Book>, LoggerManager {

	public static ArrayList<Book> data = new ArrayList<Book>();

	// 저장파일 경로
//	public final static String SAVE_FILE_PATH = "C:\\DCOM_0725\\03_JAVA\\workspace\\eclipse-workspace2\\BEGINNER\\src\\begin\\doc\\file\\book.csv";
	public final static String SAVE_FILE_PATH = "./src/begin/doc/file/book.csv";

	public BookDao() {
		readFile(SAVE_FILE_PATH);
//		LOG.debug("data.size():" + BookDao.data.size());

		for (Book book : BookDao.data) {
//			LOG.debug(book.toString());
		}
	}

	/**
	 * 파일 읽기
	 * 
	 * @param path
	 * @return
	 */
	public int readFile(String filePath) {
		int flag = 0;

		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(SAVE_FILE_PATH);
			br = new BufferedReader(fr);

			int data = 0;
			String line = "";// 데이터를 line단위로 관리
			while ((line = br.readLine()) != null) {
//				LOG.debug(line);
				String inArray[] = line.split(",");

				Book book = new Book(inArray[0], inArray[1], inArray[2], inArray[3], inArray[4]);
				BookDao.data.add(book);
			}
			if (BookDao.data.size() > 0)
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
	 * 파일 저장!
	 * 
	 * @param filePath
	 * @return
	 */
	public int writeFile(String filePath) {
		int flag = 0;
		// ArrayList<Book> -> File로 기록
		//
		// try -- with --resource
		try (FileWriter fw = new FileWriter(filePath); BufferedWriter bw = new BufferedWriter(fw);) {

			// 9791163031222,Do it! 지옥에서 온 문서 관리자 깃&깃허브 입문,이고잉 고경희,소프트웨어 공학,2019년 12월 06일,1
			for (Book book : BookDao.data) {

				String delim = ",";

				String outLine = book.getIsbn() + delim + book.getTitle() + delim + book.getAuthor() + delim
						+ book.getPublisher() + delim + book.getPublicationDate() + "\n";
				bw.write(outLine);
			}

		} catch (IOException e) {
			System.out.println("IOException:" + e.getMessage());
		}

		return BookDao.data.size();
	}

	/**
	 * 도서목록에 도서존재 확인
	 * 
	 * @param book
	 * @return true(존재)/false(없음)
	 */
	public boolean isBookExists(Book book) {
		boolean flag = false;

		for (Book vo : BookDao.data) {
			if (book.getTitle().equals(vo.getTitle())) {
				flag = true;
				break;
			}
		}

		return flag;
	}

	@Override
	public int doSave(Book dto) {
		Book book = dto;// param 읽기
		if (isBookExists(book) == true) {
			LOG.debug("ISBN을 확인 하세요.(" + book.getIsbn() + ")");
			return 0;
		}

		boolean isContains = BookDao.data.contains(book);
		LOG.debug("isContains:" + isContains);

		boolean flag = BookDao.data.add(book);

		return (flag == true) ? 1 : 0;
	}

	@Override
	public int doUpdate(Book dto) {
		int flag = 0;
		// data delete, insert
		// 1. 존재 여부 확인
		// 2. 삭제
		// 3. 등록
		if (isBookExists(dto) == true) {
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
			if (dto.getTitle().equals(tmp.getTitle())) {
				Book book = BookDao.data.remove(i);
				LOG.debug("삭제 데이터:" + book);
				flag = 1;
				break;
			}
		}

		return flag;
	}

	public Book doSelectOne(Book obj) {
		// data.get(i)
		Book book = null;
		// 1. 존재 확인
		String delim = "\t\t";
		// 2. 존재하면 Book을 retrun

		if (isBookExists(obj)) {
			System.out.println("-----------------------------------------------------------------------------");
			System.out.println("도서번호\t\t제목\t\t저자\t\t출판사\t\t출판일\t");
			System.out.println("-----------------------------------------------------------------------------");

			for (Book tmpBook : BookDao.data) {
				if (tmpBook.getTitle().equals(obj.getTitle())) {

					book = tmpBook;
					String outLine = book.getIsbn() + delim + book.getTitle() + delim + book.getAuthor() + delim
							+ book.getPublisher() + delim + book.getPublicationDate() + "\n";
					System.out.println(outLine);
					break;

				}
			}
		}

		return book;
	}

	@Override
	public int doFind(Book dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Book> doRetrieve(DTO dto) {
		List<Book> list = new ArrayList<Book>();
		// param
		Search search = (Search) dto;

		int div = search.getSearchDiv();
		String searchWord = search.getSearchWord();
		for (Book book : BookDao.data) {

			switch (div) {

			case 10:// 제목
				if (book.getTitle().matches(".*" + searchWord + ".*")) {// 제목으로 검색
					list.add(book);
				}
				break;

			case 20:// 저자
				if (book.getAuthor().matches(".*" + searchWord + ".*")) {// 제목으로 검색
					list.add(book);
				}
				break;

			case 100:// 전체
				list.add(book);
				break;
			}

		}

		return list;
	}

	@Override
	public boolean isExists(Book dto) {
		// TODO Auto-generated method stub
		return false;
	}

}
