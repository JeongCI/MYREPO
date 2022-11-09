package com.pcwk.ehr.ed02.fileinputstream;

import java.io.*;

public class Ex05DataOutputStream {

	public static void main(String[] args) {
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		try {
			fos = new FileOutputStream("pcwk_c.dat");
			dos = new DataOutputStream(fos);
			
			dos.writeInt(16);
			dos.writeDouble(13.7);
			dos.writeBoolean(true);
			
			
		} catch (IOException e) {
			System.out.println("IOException : " + e.getMessage());
		} finally {
			if (null != dos) {
				try {
					dos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("pcwk_c.dat 생성완료");
	}

}
