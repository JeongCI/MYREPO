package begin.doc.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import begin.doc.cmn.DTO;
import begin.doc.cmn.WorkDiv;
import begin.doc.domain.Category;
import begin.doc.domain.Site;

/**
 * 카테고리 기능 구현 클래스 카테고리 목록 파일(category.csv)에 접근하여 데이터 가공 및 처리
 *
 * @author ITSC
 */
public class CategoryDao implements WorkDiv<Category> {

	// 저장경로 및 파일명
	public final static String SAVE_FILE_PATH = "./src/begin/doc/file/category.csv";
	public final static String SAVE_FILE_PATH_BY_SITE = "./src/begin/doc/file/site.csv";

	public List<Category> getAllCategoryList() {
		return readFile(SAVE_FILE_PATH);
	}

	@Override
	public List<Category> doRetrieve(DTO dto) {
		return null;
	}

	// 사용전 메인 메소드에서 관리자인자 확인 여부 필요
	@Override
	public int doSave(Category dto) {
		Category category = dto;

		if (isExists(dto) == true) {
			System.out.println("카테고리 ID가 중복되었습니다.(" + category.getCateID() + ")");
			return 0;
		}

		// 밑에꺼만 써도 될듯?
//        boolean isContains = readFile(SAVE_FILE_PATH).contains(dto);
//        System.out.println("isContains : " + isContains);

		return addFileForCategory(dto);
	}

	@Override
	public int doUpdate(Category dto) {
		return deleteFile(dto);
	}

	@Override
	public int doDelete(Category dto) {
		return deleteFile(dto);
	}

	@Override
	public int doFind(Category dto) {
		return 0;
	}

	@Override
	public boolean isExists(Category dto) {
		boolean flag = false;
		for (Category category : readFile(SAVE_FILE_PATH)) {
			if (dto.getCateName().equals(category.getCateName())) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	
	public List<Category> readFile(String filePath) {
		FileReader fr = null;
		BufferedReader br = null;
		List<Category> result = new ArrayList<>();

		try {
			fr = new FileReader(filePath);
			br = new BufferedReader(fr);

			String line = ""; // member.csv의 데이터를 한줄씩 받아오는 변수

			// 한줄씩 받아온 데이터를 문자열 배열로 받은 후, 해당 데이터로 Member 객체 생성
			while ((line = br.readLine()) != null) {
				String[] inArray = line.split(",");
				Category category = new Category(inArray[0], inArray[1], Integer.parseInt(inArray[2]));
				result.add(category);
			}

		} catch (IOException e) {
			System.out.println("IOException : " + e.getMessage());
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return result;
	}

	
	public int addFileForCategory(Category inputCategory) {
		String delim = ",";
		String outLine = "";

		List<Category> readList = readFile(SAVE_FILE_PATH);
		// try-catch-resource
		try (FileWriter fw = new FileWriter(SAVE_FILE_PATH); BufferedWriter bw = new BufferedWriter(fw);) {
			for (Category category : readList) {
				outLine += category.getCateID() + delim + category.getCateName() + delim + category.getStatus() + "\n";
			}

			// 추가될 한줄
			outLine += inputCategory.getCateID() + delim + inputCategory.getCateName() + delim
					+ inputCategory.getStatus() + "\n";
			bw.write(outLine);
		} catch (IOException e) {
			System.out.println("IOException : " + e.getMessage());
		}

		return readFile(SAVE_FILE_PATH).size() > 0 ? 1 : 0;
	}

	
	public int deleteFile(Category inputCategory) {
		String delim = ",";
		// try-catch-resource
		String outLine = "";
		List<Category> readList = readFile(SAVE_FILE_PATH);

		int checkFlg = checkDeleteAbleCategory(inputCategory, readList);
		if (checkFlg == 0)
			return 0;

		try (FileWriter fw = new FileWriter(SAVE_FILE_PATH); 
			 BufferedWriter bw = new BufferedWriter(fw);) 
		{
			for (Category category : readList) {
				outLine = category.getCateID() + delim + category.getCateName() + delim;
				if (category.getCateID().equals(inputCategory.getCateID())) {
					outLine += "0" + "\n";
				} else {
					outLine += category.getStatus() + "\n";
				}
				bw.write(outLine);
			}
		} catch (IOException e) {
			System.out.println("IOException : " + e.getMessage());
		}
		return readFile(SAVE_FILE_PATH).size() > 0 ? 1 : 0;
	}

	
	public int checkDeleteAbleCategory(Category inputCategory, List<Category> readList) {
		int existFlag = 0;

		if (inputCategory == null || inputCategory.getCateID() == null || "".equals(inputCategory.getCateID())) {
			System.out.println("입력한 아이디가 없습니다. 아이디를 입력해주세요.");
			return 0;
		}

		for (Category category : readList) {
			if (category.getCateID().equals(inputCategory.getCateID())) {
				existFlag = 1;
				if (category.getStatus() == 0) {
					System.out.println("이미 삭제된 아이디입니다.");
					return 0;
				}
			}
		}

		if (existFlag == 0) {
			System.out.println("해당 아이디가 없습니다.");
			return 0;
		}
		return 1;
	}

	
	public List<Site> searchFromSite(Category searchCategory) {
		FileReader fr = null;
		BufferedReader br = null;
		List<Site> result = new ArrayList<>();

		try {
			fr = new FileReader(SAVE_FILE_PATH_BY_SITE);
			br = new BufferedReader(fr);

			String line = ""; // site.csv의 데이터를 한줄씩 받아오는 변수
			// 한줄씩 받아온 데이터를 문자열 배열로 받은 후, 해당 데이터로 Member 객체 생성
			while ((line = br.readLine()) != null) {
				String[] inArray = line.split(",");
				
				switch(inArray[0]) {
				case "cateId0":
					inArray[0] = "기본";
					break;
				case "cateId1":
					inArray[0] = "교육";
					break;
				case "cateId2":
					inArray[0] = "커뮤니티";
					break;
				case "cateId3":
					inArray[0] = "채용";
					break;
				case "cateId4":
					inArray[0] = "도서";
					break;
				case "cateId5":
					inArray[0] = "테스트";
					break;
				}
				
				if (inArray[0].equals(searchCategory.getCateName())) {
					Site site = new Site(inArray[0], inArray[1], inArray[2], inArray[3], inArray[4], inArray[5], inArray[6]);
					result.add(site);
				}
			}
		} catch (IOException e) {
			System.out.println("IOException : " + e.getMessage());
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return result;
	}

	
	public void doPrintCategoryListForBeauty(List<Category> result) {
		System.out.println("카테고리ID\t\t카테고리명\t\t상태값");
		System.out.println("-------------------------------------------------------------");

		if (result == null || result.size() == 0) {
			System.out.println("카테고리가 존재하지 않습니디.");
		} else {
			for (Category category : result) {
				System.out.print(category.getCateID() + "\t\t");
				System.out.print(category.getCateName() + "\t\t");

				if (category.getStatus() == 1) {
					System.out.println("사용");
				} else {
					System.out.println("미사용");
				}
			}
		}
		System.out.println("총 " + result.size() + " 건");
	}

	
	public void doPrintSiteListForBeauty(List<Site> result) {
		System.out.println("카테고리ID\t\t사이트ID\t\t사이트명\t\t\t사이트 설명\t\t\t\tURL\t\t\t\t\t\t등록자명\t\t등록일자");
		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

		if (result == null || result.size() == 0) {
			System.out.println("연관 사이트가 존재하지 않습니다.");
		} else {
			for (Site site : result) {
				System.out.print(site.getSiteID() + "\t\t");
				System.out.print(site.getCateID() + "\t\t");
				System.out.print(site.getSiteName() + "\t\t");
				System.out.print(site.getSiteURL() + "\t\t");
				System.out.print(site.getDesc() + "\t\t");
				System.out.print(site.getAddMember() + "\t\t");
				System.out.println(site.getAddDate() + "\t\t");
			}
		}
		System.out.println("총 " + result.size() + " 건");
	}
}