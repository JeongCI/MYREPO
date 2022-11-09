package com.pcwk.ehr.ed01.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Ex03PrintListFileDir {
	static int totalFiles = 0; // 총 파일 수
	static int totalDirs = 0; // 총 디렉토리 수

	public static void printFileDirList(File dir) {
		System.out.println(dir.getAbsolutePath() + " 디렉토리");

		File[] files = dir.listFiles(); // 디렉토리에 있는 파일과 디렉토리를 File[] return

		// 하위 디렉토리를 저장
		List<String> subDir = new ArrayList<>();

		for (int i = 0; i < files.length; i++) {
			String fileName = files[i].getName(); // 파일(디렉토리)명
			System.out.println(files[i].isDirectory() ? "[" + fileName + "]" : fileName);

			// 디렉토리이면 subDir에 저장
			if (files[i].isDirectory() == true) {
				subDir.add(String.valueOf(i));
			}
		}

		int dirNum = subDir.size(); // 하위 디렉토리 수
		int fileNum = files.length - dirNum; // 파일 수

		totalFiles += fileNum; // 파일 수 누적
		totalDirs += dirNum; // 디렉토리 수 누적

		System.out.println(fileNum + " 개의 파일, " + dirNum + " 개의 디렉토리");

		// 디렉토리이면 재귀 호출
		for (int i = 0; i < subDir.size(); i++) {
			int idx = Integer.parseInt(subDir.get(i));

			printFileDirList(files[idx]);
		}

	}

	public static void main(String[] args) {
		// 특정 디렉토리에 파일과 디렉토리 count

		String path = "";

		if (args.length != 1) {
			System.out.println("디렉토리를 입력 하세요.");
			System.exit(0);
		}
		path = args[0];
		System.out.println("path : " + path);

		File f = new File(path);

		if (!f.exists() || !f.isDirectory()) {
			System.out.println("유효하지 않은 디렉토리 입니다.");
			System.exit(0);
		}

		printFileDirList(f);
		System.out.println("===================================");
		System.out.println("총파일 : " + totalFiles);
		System.out.println("총디렉토리 : " + totalDirs);
		System.out.println("===================================");

	}

}
