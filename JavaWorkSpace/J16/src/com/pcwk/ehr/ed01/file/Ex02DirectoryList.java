package com.pcwk.ehr.ed01.file;

import java.io.*;

public class Ex02DirectoryList {

	public static void main(String[] args) {
		String path = "C:\\DCOM_0725\\03_JAVA\\WorkSpace2\\J15";

		File dir = new File(path);

		// 존재하지 않으면 종료 || 디렉토리가 아니면 종료
		if (!dir.exists() || !dir.isDirectory()) {
			System.out.println("유효하지 않은 디렉토리 입니다.");
			System.exit(0);
		}

		File[] fileArray = dir.listFiles();

		for (int i = 0; i < fileArray.length; i++) {
			String name = fileArray[i].getName();
			System.out.println(fileArray[i].isDirectory() ? "[" + name + "]" : name);
		}

	}

}
