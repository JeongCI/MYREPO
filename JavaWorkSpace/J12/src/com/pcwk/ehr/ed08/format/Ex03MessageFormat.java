package com.pcwk.ehr.ed08.format;

import java.util.*;
import java.io.*;
import java.text.*;

public class Ex03MessageFormat {

	public static void main(String[] args) throws FileNotFoundException {
		String tableName = "member";
		String msg = "INSERT INTO " + tableName 
				+ " VALUES(''{0}'', ''{1}'', ''{2}'', ''{3}'');";
		String fileName = "C:\\DCOM_0725\\03_JAVA\\WorkSpace2\\J12\\src\\com\\pcwk\\ehr\\ed08\\format\\member.txt";
		Scanner scanner = new Scanner(new File(fileName));
		
		while(scanner.hasNextLine()) {
			String str = scanner.nextLine();
//			System.out.println("str : " + str);
			
			String[] strArray = str.split(",");
			System.out.println(MessageFormat.format(msg, strArray));
		}
		scanner.close();
	}
}
