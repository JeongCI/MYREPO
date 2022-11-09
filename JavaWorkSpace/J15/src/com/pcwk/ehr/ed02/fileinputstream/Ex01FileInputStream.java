package com.pcwk.ehr.ed02.fileinputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ex01FileInputStream {

	public static void main(String[] args) {
		String file = "C:\\DCOM_0725\\03_JAVA\\WorkSpace2\\J15\\src\\com\\pcwk\\ehr\\ed02\\fileinputstream\\Ex01FileInputStream.java";
		try {
			FileInputStream fis = new FileInputStream(args[0]);
//			FileInputStream fis = new FileInputStream(new File(file));
			int data = 0;
			while ((data = fis.read()) != -1) {
				char c = (char) data;
				System.out.print(c);
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일 경로를 확인 하세요");
			System.out.println("경로 : " + args[0]);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
