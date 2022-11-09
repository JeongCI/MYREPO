package begin.doc.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import begin.doc.cmn.DTO;
import begin.doc.cmn.LoggerManager;
import begin.doc.cmn.WorkDiv;
import begin.doc.domain.Member;

/**
 * 회원 기능 구현 클래스
 * 회원 목록 파일(member.txt)에 접근하여 데이터 가공 및 처리
 * @author ITSC
 *
 */
public class MemberDao implements WorkDiv<Member>, LoggerManager {

		// MemberDao 객체 생성 시, member.csv 파일을 읽어 ArrayList에 담는다.
		// 종료 시 데이터를 파일에 기록한다.
		
		public static ArrayList<Member> data = new ArrayList<Member>();
		
		// 저장경로 및 파일명
//		public final static String SAVE_FILE_PATH = "C:\\yoon_java_class\\workspace\\BEGINNER\\src\\begin\\doc\\file\\member.csv";
		public final static String SAVE_FILE_PATH = "./src/begin/doc/file/member.csv";
		
		// default 생성자
		public MemberDao() {
			readFile(SAVE_FILE_PATH);	// readFile() 함수 호출
//			LOG.debug("data.size() : " + MemberDao.data.size());
			
			for(Member mb : MemberDao.data) {
//				LOG.debug(mb.toString());
			}
		}
		
		/**
		 * main 클래스의 arguments 값으로 회원 ID를 받아 회원인지 확인
		 * @param memberId
		 * @return 0(회원아님) / 1(회원임)
		 */
		public int checkLoginId(String[] args) {
			int flag = 0;
			
			try(FileReader fr = new FileReader(SAVE_FILE_PATH);
					BufferedReader br = new BufferedReader(fr);) 
				{
					String line = "";
					
					while((line = br.readLine()) != null) {
						String inArray[] = line.split(",");
						
						// inArray[0]은 회원 ID값, inArray[1]은 회원 비밀번호.
						// member.csv 파일에 일치하는 ID가 없으면 flag = 0 으로 회원이 아님을 return
						// ID가 일치하고 비밀번호가 일치하면 flag = 1(성공), 비밀번호가 다르면 flag = 2 (비밀번호 불일치).
						if(args[0].equals(inArray[0])) {
							if(args[1].equals(inArray[1])) {
								flag = 1;
							} else {
								flag = 2;
							}
							break;
						}
						
					}
					
				} catch(IOException e) {
					LOG.debug("IOException : " + e.getMessage());
				}
			
			return flag;
		}
		
		/**
		 * main 클래스의 arguments 값으로 회원 ID를 받아 권한 확인
		 * @param memberId
		 * @return 0(관리자) / 1(일반사용자)
		 */
		public int checkLoginAuth(String memberId) {
			int flag = 0;
			
			try(FileReader fr = new FileReader(SAVE_FILE_PATH);
					BufferedReader br = new BufferedReader(fr);) 
				{
					String line = "";
					
					while((line = br.readLine()) != null) {
						String inArray[] = line.split(",");
						
						if(memberId.equals(inArray[0])) {	// 로그인된 회원ID와 일치한 데이터일때만 권한 체크
							// inArray[3]은 회원의 권한으로 0이면 관리자, 1이면 일반 사용자
							if(inArray[3] == "0" || "0".equals(inArray[3])) {
//								LOG.debug("checkLoginAuth() : 관리자, ID : " + inArray[0]);
								break;
							} else if(inArray[3] == "1" || "1".equals(inArray[3])) {
//								LOG.debug("checkLoginAuth() : 일반 사용자, ID : " + inArray[0]);
								flag++;
								break;
							} else {
								
							}
						}
					}
					
				} catch(IOException e) {
					LOG.debug("IOException : " + e.getMessage());
				}
			
			return flag;
		}
		
		/**
		 * member.csv 파일 읽기
		 * @param filePath
		 * @return flag (0:ArrayList 값 존재/1:ArrayList 값 없음)
		 */
		public int readFile(String filePath) {
			int flag = 0;
			
			FileReader fr = null;
			BufferedReader br = null;
			
			try {
				fr = new FileReader(filePath);
				br = new BufferedReader(fr);
				
				String line = "";	// member.csv의 데이터를 한줄씩 받아오는 변수
				
				// 한줄씩 받아온 데이터를 문자열 배열로 받은 후, 해당 데이터로 Member 객체 생성 
				while((line = br.readLine()) != null) {
//					LOG.debug("line : " + line);
					
					String[] inArray = line.split(",");
					
					Member mb = new Member(inArray[0], inArray[1], inArray[2], 
											Integer.parseInt(inArray[3]),
											Integer.parseInt(inArray[4]), 
											Integer.parseInt(inArray[5]), 
											inArray[6]);
					
					MemberDao.data.add(mb);	// ArrayList에 저장
				}
				
				// ArrayList data에 값이 있으면 flag 값 1로 변경
				if(MemberDao.data.size() > 0) {
					flag++;
				}
				
			} catch(IOException e) {
				LOG.debug("IOException : " + e.getMessage());
			} finally {
				if(br != null) {
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			
			return flag;
		}
		
		/**
		 * member.csv 파일 쓰기 (실제 파일에 기록)
		 * @param filePath
		 * @return ArrayList의 size()
		 */
		public int writeFile(String filePath) {
			
			// try-catch-resource
			try(FileWriter fw = new FileWriter(filePath);
				BufferedWriter bw = new BufferedWriter(fw);) 
			{
				for(Member mb : MemberDao.data) {
					String delim = ",";
					
					String outLine = mb.getMemberID() + delim + mb.getMemberPwd() + delim
									 + mb.getMemberName() + delim + mb.getAuth() + delim
									 + mb.getLevel() + delim + mb.getStatus() + delim
									 + mb.getCreateDate() + "\n";
					
					bw.write(outLine);
					
				}
				
			} catch (IOException e) {
				LOG.debug("IOException : " + e.getMessage());
			}
			
			return MemberDao.data.size();		
		}
		
		/**
		 * 모든 회원 목록 확인
		 * @return size (회원수)
		 */
		public int doAllMember() {
			int size = 0;
			
			System.out.println("회원ID\t\t비밀번호\t\t회원명\t\t권한\t\t레벨\t\t상태값\t\t생성일자");
			System.out.println("----------------------------------------------------------------------------------------------------------");
			
			try(FileReader fr = new FileReader(SAVE_FILE_PATH);
				BufferedReader br = new BufferedReader(fr);) 
			{
				String line = "";
				while((line = br.readLine()) != null) {
					size++;
					String[] inArray = line.split(",");
					
					for(int i=0; i<inArray.length; i++) {
						
						switch(i) {
						case 3 :	// 권한
							if("0".equals(inArray[i])) {
								System.out.print("관리자\t\t");							
							}
							else {
								System.out.print("일반사용자\t\t");
							}
							break;
						case 4 :	// 레벨
							if("0".equals(inArray[i])) {
								System.out.print("관리자\t\t");
							} else if("1".equals(inArray[i])) {
								System.out.print("입문\t\t");							
							} else if("2".equals(inArray[i])) {
								System.out.print("초급\t\t");							
							} else if("3".equals(inArray[i])) {
								System.out.print("중급\t\t");							
							} else if("4".equals(inArray[i])) {
								System.out.print("고급\t\t");							
							}
							break;
						case 5 :	// 상태값
							if("0".equals(inArray[i])) {
								System.out.print("미사용\t\t");
							} else {
								System.out.print("사용\t\t");							
							}
							break;
						default :
							System.out.print(inArray[i]+"\t\t");
						}

					}
					System.out.println();
					
				}
			
			} catch(IOException e) {
				LOG.debug("IOException : " + e.getMessage());
			}
			
			
			return size;
		}
		
		
		@Override
		public List<Member> doRetrieve(DTO dto) {
			return null;
		}

		/**
		 * ArrayList에 데이터 저장 (파일작성X)
		 */
		@Override
		public int doSave(Member dto) {
			Member mb = dto;
			if(isExists(dto) == true) {
				LOG.debug("사용자ID가 중복되었습니다.(" + mb.getMemberID()+")");
				return 0;
			}
			
			boolean isContains = MemberDao.data.contains(mb);
			LOG.debug("isContains : " + isContains);
			
			boolean flag = MemberDao.data.add(mb); 
			
			return (flag == true) ? 1 : 0;
		}
		
		
		// 20220914 추가 (main 함수에서 가져옴)
		public Member getInputData(Scanner scan) {
			// 20220914 추가 - 사용자 추가 시 생성 일시
			SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date today =  new Date();

			Member member = null;
			
			String[] dataArr = scan.nextLine().trim().split(",");
			
			if("입문".equals(dataArr[3])) {
				dataArr[3] = "1";
			} else if("초급".equals(dataArr[3])) {
				dataArr[3] = "2";		
			} else if("중급".equals(dataArr[3])) {
				dataArr[3] = "3";		
			} else if("고급".equals(dataArr[3])) {
				dataArr[3] = "4";		
			} else {	// 20220914
				dataArr[3] = "1";	// 입문,초급,중급,고급이 모두 아닐때, default "입문"
			}
			
			member = new Member(dataArr[0], dataArr[1], dataArr[2], 
								1,	// 일반 사용자 
								Integer.parseInt(dataArr[3]), 
								1,	// 상태값(사용함) 
								date.format(today));
			
			return member;
		}
		

		@Override
		public int doUpdate(Member dto) {
			return 0;
		}

		/**
		 * 회원 삭제 (상태값 변경)
		 * return flag (0:미삭제/1:삭제)
		 */
		@Override
		public int doDelete(Member dto) {
			int flag = 0;
			
			List<Member> result = new ArrayList<>();
			
			try (FileReader fr = new FileReader(SAVE_FILE_PATH);
				 BufferedReader br = new BufferedReader(fr);) 
			{
				String line = "";
				
				while((line=br.readLine()) != null) {
					String[] inArr = line.split(",");
					Member memb = new Member(inArr[0], inArr[1], inArr[2], 
											 Integer.parseInt(inArr[3]), 
											 Integer.parseInt(inArr[4]), 
											 Integer.parseInt(inArr[5]), 
											 inArr[6]);
					result.add(memb);
				}
				
			} catch (IOException e) {
				
			}
			
			try (FileWriter fw = new FileWriter(SAVE_FILE_PATH);
				 BufferedWriter bw = new BufferedWriter(fw);) 
			{
				
				String delim = ",";
				String outLine = "";
				
				for(Member member : result) {
					outLine = member.getMemberID() + delim + member.getMemberPwd() + delim +
							  member.getMemberName() + delim + member.getAuth() + delim +
							  member.getLevel() + delim;
					
					if(member.getMemberID().equals(dto.getMemberID())) {
						outLine += "0";
						flag++;
						// 20220921 추가
						member.setStatus(0);
					} else {
						outLine += member.getStatus();
					}
					
					outLine += delim + member.getCreateDate() + "\n";
					
//					System.out.print("outLine : " + outLine);
					
					bw.write(outLine);
				}
			} catch (IOException e) { }
			
//			for(int i=MemberDao.data.size()-1; i>=0; i--) {
//				Member tmp = MemberDao.data.get(i);
//				
//				if(dto.getMemberID().equals(tmp.getMemberID())) {
//					Member member = MemberDao.data.remove(i);
//					LOG.debug("삭제 데이터 : " + member);
//					flag = 1;
//					break;
//				}
//			}
			
			data = (ArrayList<Member>) result;
			
			return flag;
		}

		@Override
		public int doFind(Member dto) {
			return 0;
		}
		
		// 2022-09-11 추가
		@Override
		public boolean isExists(Member dto) {
			boolean flag = false;
			
			for(Member mb : MemberDao.data ) {
				if(dto.getMemberID().equals(mb.getMemberID())) {
					flag = true;
					break;
				}
			}
			
			return flag;
		}

}
