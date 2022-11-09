package com.pcwk.ehr.ed02.fileinputstream;

import java.io.*;

public class Ex03FileCopyFinally {

	public static void main(String[] args) {
		// 파일 copy
		String input = "C:\\DCOM_0725\\03_JAVA\\WorkSpace2\\J15\\src\\com\\pcwk\\ehr\\ed02\\fileinputstream\\Ex02FileCopy.java";
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(args[0]);
			fos = new FileOutputStream(args[1]);
			int data = 0;
			while ((data = fis.read()) != -1) {
				char ch = (char) data;
				System.out.print(ch);
				fos.write(data);
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일 경로를 확인 하세요");
			System.out.println("input : " + args[0]);
			System.out.println("파일 경로를 확인 하세요");
			System.out.println("output : " + args[1]);
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (null != fis) {
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (null != fos) {
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
