package com.pcwk.ehr.ed03;

public class Ex04Morse {

	public static void main(String[] args) {
		String source = "SOSHELP";
		//배열과 ASCII코드 매핑
		//배열은 '0'번지 부터 시작, ASCII코드 'A'는 65부터 시작
		// ASCII코-'A'면 배열 '0'번지에 메핑됨
		
		String morse[] = {  "・－"
							,"－・・・"
							,"－・－・"
							,"－・・"
							,"・"
							,"・・－・"
							,"－－・"
							,"・・・・"
							,"・・"
							,"・－－－"
							,"－・－"
							,"・－・・"
							,"－－"
							,"－・"
							,"－－－"
							,"・－－・"
							,"－－・－"
							,"・－・"
							,"・・・"
							,"－"
							,"・・－"
							,"・・・－"
							,"・－－"
							,"－・・－"
							,"－・－－"
							,"－－・・"};

		String result = "";
		for(int i=0;i<source.length();i++) {
			result+=morse[source.charAt(i)-'A'];
		}
		
		System.out.println("source:"+source);
		System.out.println("result:"+result);
		
	}

}
