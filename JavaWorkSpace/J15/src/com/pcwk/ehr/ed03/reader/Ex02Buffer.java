package com.pcwk.ehr.ed03.reader;

import java.io.*;

public class Ex02Buffer {

	public static void main(String[] args) {
		String fileName = "C:\\DCOM_0725\\03_JAVA\\WorkSpace2\\J15\\src\\com\\pcwk\\ehr\\ed03\\reader\\Ex02Buffer.java";

		try (FileReader fr = new FileReader(fileName); BufferedReader br = new BufferedReader(fr);) {
			String line = "";

//				while((line = br.readLine()) != null) {}

			for (int i = 1; (line = br.readLine()) != null; i++) {
				System.out.println(i + ": " + line);
			}
		} catch (IOException e) {

		}
	}

}
