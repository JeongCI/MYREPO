package com.pcwk.ehr.ed02.fileinputstream;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex07DataInputStream {

	public static void main(String[] args) {
		// 배열을 읽어 파일에 DataOutputStream으로 기록
		int score[] = { 88, 77, 66, 99, 88 };
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		try {
			fos = new FileOutputStream("score.dat");
			dos = new DataOutputStream(fos);
			for (int i = 0; i < score.length; i++) {
				dos.writeInt(score[i]);
			}
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
		System.out.println("파일 생성! \n 프로젝트 선택 F5를 클릭하세요");
	}

}
