package com.pcwk.ehr.ed03.queue;

import java.util.*;

public class Ex02Queue {

	static Queue<String> q = new LinkedList<String>();
	static final int MAX_SIZE = 5; // Queue에 5개까지 저장

	public static void save(String input) {
		if (!input.equals("")) {
			q.offer(input);
		}

		if (q.size() > MAX_SIZE)

		{
			q.remove();
		}
	}

	public static void main(String[] args) {

		System.out.println("help를 입력하면 도움말을 볼 수 있습니다.");

		while (true) {
			System.out.print(">>");
			Scanner sc = new Scanner(System.in);

			String input = sc.nextLine().trim();

			System.out.println("input : " + input);
			if ("q".equalsIgnoreCase(input)) {
				System.out.println("종료합니다.");
				System.exit(0);
			} else if ("help".equalsIgnoreCase(input)) {
				System.out.println("help - 입력하면 도움말");
				System.out.println("q - 종료");
				System.out.println("histroy - 최근 입력한 명령어" + MAX_SIZE + "개 보여준다.");
			} else if ("".equals(input)) {
				continue;
			} else if ("history".equals(input)) {
				int i = 0;
				save("history");

				Iterator<String> iter = q.iterator();

				while (iter.hasNext()) {
					System.out.println(++i + ". " + iter.next());
				}

			}

		} // -- while

	}

}
