package com.pcwk.ehr.ed01.file;

import java.io.*;

public class Ex01File {

	public static void main(String[] args) throws IOException {
		if (args.length != 1) {
			System.out.println("파라메터를 입력하세요.");
			System.exit(0);
		}
		// C:\DCOM_0725\03_JAVA\WorkSpace2\J16\src\com\pcwk\ehr\ed01\file\Ex01File.java
		String filePath = "C:\\DCOM_0725\\03_JAVA\\WorkSpace2\\J16\\src\\com\\pcwk\\ehr\\ed01\\file\\Ex01File.java";

		// 파일 객체 생성
		File file = new File(args[0]);

		File file01 = new File("C:\\DCOM_0725\\03_JAVA\\WorkSpace2\\J16\\src\\com\\pcwk\\ehr\\ed01\\file",
				"Ex01File99.java");

		File dir = new File("C:\\DCOM_0725\\03_JAVA\\WorkSpace2\\J16\\src\\com\\pcwk\\ehr\\ed01\\file");

		File file02 = new File(dir, "Ex01File.java");

		// 신규파일 생성
		boolean isCreated = file01.createNewFile();
		System.out.println("신규파일 생성 : " + isCreated);

		// File인지 디렉토리인지 구분.
		System.out.println("파일 여부 : " + file01.isFile());
		System.out.println("디렉토리 여부 : " + dir.isDirectory());
		
		// 특정 directory에 파일 

		// File명 추출
		System.out.println("경로를 제외한 파일명 : " + file01.getName());
		System.out.println("파일 디렉토리 : " + file01.getParent());
		System.out.println("디렉토리+파일 : " + file01.getAbsolutePath());

		// os별 파일 구분자
		System.out.println("pathSeparator : " + file01.pathSeparator); // window pathSeparator : ;
		System.out.println("separator : " + file01.separator); // windows separator : \

		System.out.println("=================================");
		System.out.println("user.dir : " + System.getProperty("user.dir"));
		System.out.println("sun.boot.class.path : " + System.getProperty("sun.boot.class.path"));
	}

}
