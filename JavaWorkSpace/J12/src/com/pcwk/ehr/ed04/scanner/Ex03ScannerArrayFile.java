package com.pcwk.ehr.ed04.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex03ScannerArrayFile {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new File(
					"C:\\DCOM_0725\\03_JAVA\\WorkSpace2\\J12\\src\\com\\pcwk\\ehr\\ed04\\scanner\\dataArray.txt"));
			int totalSum = 0; // 총합
			int cnt = 0; // 건수

			while (sc.hasNextLine()) { // 읽을 데이터가 있으면 true
				String line = sc.nextLine();

				String[] numArray = line.split(",");

				int sum = 0;
				for (String s : numArray) {
					sum += Integer.parseInt(s);
				}
				totalSum += sum;
				cnt++;

				System.out.println("sum(Line) : " + sum);
			}

			System.out.print("Line : " + cnt);
			System.out.println(", 총합 : " + totalSum);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("프로그램 종료");

	}

}