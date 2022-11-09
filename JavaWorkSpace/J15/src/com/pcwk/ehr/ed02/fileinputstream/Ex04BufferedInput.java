package com.pcwk.ehr.ed02.fileinputstream;

import java.io.*;

public class Ex04BufferedInput {

	public static void main(String[] args) {

		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		try {
			fos = new FileOutputStream("pcwk1_9.txt");
			bos = new BufferedOutputStream(fos, 3);
			for (int i = '1'; i <= '9'; i++) {
				bos.write(i);
			}

			// flush()를 호출한 다음에
			// 기반 스트림의 close()를 호출.
//			bos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bos != null) {
					bos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
