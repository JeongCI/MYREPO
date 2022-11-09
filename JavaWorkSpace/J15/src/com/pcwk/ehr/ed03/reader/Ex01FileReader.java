package com.pcwk.ehr.ed03.reader;

import java.io.*;

public class Ex01FileReader {

	public static void main(String[] args) {
		FileReader fr = null;
		try {
			fr = new FileReader("test.txt");
			int data = 0;
			while((data = fr.read()) != -1) {
				System.out.print((char)data);
			}
		} catch (IOException e) {
			System.out.println("IOException : " + e.getMessage());
		} finally {
			if (null != fr) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("파일 읽기 성공!");
	}

}
//Hello, 안녕하세요
//점심 맛있게 드세요
//집 가고싶다
//파일 읽기 성공!