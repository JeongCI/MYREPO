package com.pcwk.ehr.ed01.file;

import java.io.*;

public class Ex04FindExt {

	public static void main(String[] args) {
		String pathName = "C:\\DCOM_0725\\03_JAVA\\WorkSpace2\\J16\\src\\com\\pcwk\\ehr\\ed01\\file\\Ex04FindExt.java";

		File f = new File(pathName);
		String fileName = f.getName();
		String filePath = f.getParent();
		System.out.println("fileName : " + fileName);
		System.out.println("filePath : " + filePath);

		int idx = fileName.lastIndexOf(".");
		System.out.println(idx);
		String ext = fileName.substring(idx + 1);
		System.out.println("확장자 : " + ext);
	}

}
//fileName : Ex04FindExt.java
//filePath : C:\DCOM_0725\03_JAVA\WorkSpace2\J16\src\com\pcwk\ehr\ed01\file
//11
//확장자 : java