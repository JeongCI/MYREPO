package com.pcwk.ehr.ed04.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex02ScannerFile {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new File("C:\\DCOM_0725\\03_JAVA\\WorkSpace2\\J12\\src\\com\\pcwk\\ehr\\ed04\\scanner\\data.txt"));
			
			int sum = 0; // 합계
			int cnt = 0; // 읽은 라인 수
			
			while(sc.hasNextInt()) {
				//System.out.println(sc.nextInt());
				sum+=sc.nextInt();
				cnt++;
			}
			
			System.out.println("sum : " + sum);
			System.out.println("cnt : " + cnt);
			System.out.println("avg : " + (sum/(double)cnt));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("정상종료");
		
	}

}
