/**
 * 
 */
 'use strict';
 //소수점 자리수 표현
 let num = new Number(328.575);
 console.log(`num : ${num.toFixed()}`); //329
 console.log(`num : ${num.toFixed(1)}`);//328.5
 console.log(`num : ${num.toFixed(2)}`);//328.57
 
 //진수 변환
 let num01 = 12;
 console.log(`12의 2진수 : ${num01.toString(2)}`);  //1100
 console.log(`12의 16진수 : ${num01.toString(16)}`);//c
 
 //소수점 계산에 관한 문제
 let n01= 46000;
 let n02 = 0.7;
 console.log(`46000*0.7 : ${n01*n02}`);
 
 //곱해지는 소수가 정수가 나오도록 소수의 자리수를 곱한 뒤 소수 자리수 만큼 다시 나누어 준다.
 console.log(n01*(0.7*10)/10);
 
 console.clear();
 //String
 
 
 
 
 
 
 