package com.pcwk.ehr.ed02.fileinputstream;

import java.io.*;

public class Ex06DataInputStream {

	public static void main(String[] args) {
		FileInputStream fis = null;
		DataInputStream dis = null;

		try {
			fis = new FileInputStream("pcwk_c.dat");
			dis = new DataInputStream(fis);

			// write기록 순서대로 다시 읽어야 한다.
			// 순서가 어긋나면 데이터는 깨진다.
			System.out.println(dis.readInt());
			System.out.println(dis.readDouble());
			System.out.println(dis.readBoolean());
		} catch (IOException e) {
			System.out.println("IOException : " + e.getMessage());
		} finally {

			// 보조스트림 종료 -> 기반스트림도 close() 호출
			if (null != dis) {
				try {
					dis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
