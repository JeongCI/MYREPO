package com.pcwk.ehr.ed01.file;

import java.io.*;

public class Ex05ReadJava {
	
	static int found = 0; // 특정 단어 count

	public static void findInFile(File dir, String keyWrod) throws IOException {
		File[] files = dir.listFiles(); // file, directory
		
		for(int i = 0; i < files.length; i++) {
			if(files[i].isDirectory() == true) {
				findInFile(files[i], keyWrod);
			} else {
				// *.java 파일 만 읽는다.
				String fileName = files[i].getName(); // 파일명
				int idx = fileName.lastIndexOf(".");
				String ext = fileName.substring(idx+1);
				
				if(!"java".equals(ext)) {
					continue;
				}
				
				FileReader fr = new FileReader(files[i]);
				BufferedReader br = new BufferedReader(fr);
				
				String data = ""; // 한줄 데이터
				int lineNum = 0; // 라인 넘버
				
				while((data = br.readLine()) != null) {
					lineNum++;
					// 해당 라인에 keyword가 있으면
					if(data.indexOf(keyWrod) != -1) {
						System.out.println(lineNum + "\t" + data);
						found++;
					}
				}
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
				
				br.close();
			}
		} // -- for
	}
	public static void main(String[] args) {
		
		// param : 디렉토리, 검색어
		if(args.length != 2) {
			System.out.println("디렉토리 검색어를 입력 하세요.");
			System.exit(0);
		}
		
		for(String str : args) {
			System.out.println(str);
		}
		
		File dir = new File(args[0]);
		String keyWord = args[1];
		
		if(!dir.exists() || !dir.isDirectory()) {
			System.out.println("유효하지 않은 디렉토리 입니다.");
			System.exit(0);
		}
		
		try {
			findInFile(dir, keyWord);
		} catch (IOException e) {
			System.out.println("==========================");
			System.out.println("IOException : " + e.getMessage());
			System.out.println("==========================");
			e.printStackTrace();
		}
		System.out.println("총 " + found+"개의 라인에서 " + keyWord + "을 찾았습니다.");
		
	}

}
