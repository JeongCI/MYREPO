package com.pcwk.ehr.ed02.fileinputstream;

import java.io.*;

public class Ex08ScoreInputStream {

	public static void main(String[] args) {
		int sum = 0; // 합계
		float avg = 0.0f; // 평균
		int score = 0;
		int cnt = 1;
		FileInputStream fis = null;
		DataInputStream dis = null;
		try {
			fis = new FileInputStream("score.dat");
			dis = new DataInputStream(fis);
			while (true) {
				score = dis.readInt();
				sum += score;
				cnt++;
			}
		} catch (IOException e) {
			System.out.println("합계 : " + sum);
			System.out.println("평균 : " + sum / (float) cnt);
		} finally {
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
