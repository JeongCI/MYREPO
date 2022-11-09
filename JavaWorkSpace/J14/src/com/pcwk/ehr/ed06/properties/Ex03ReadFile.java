package com.pcwk.ehr.ed06.properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
public class Ex03ReadFile {

	public static void main(String[] args) {
		Properties prop = new Properties();
		
		try {
			prop.load(new FileInputStream("C:\\DCOM_0725\\03_JAVA\\WorkSpace2\\J14\\src\\com\\pcwk\\ehr\\ed06\\properties\\input.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String nameValue = prop.getProperty("name");
		String dataValue = prop.getProperty("data");
		String[] dataArray = dataValue.split(",");
		System.out.println("name : " + nameValue);
		System.out.println("data : " + dataValue);
		
		for(int i = 0; i <dataArray.length; i++) {
			System.out.println(dataArray[i]);
		}
	}

}
