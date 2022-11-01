/**
 * 
 */
 'use strict';
 
 let str = 'Javascript';
 
 console.log(`str: ${str}`);
 
 //length: 문자열의 길이
 console.log(`str.length: ${str.length}`);
 
 //charAt(n) : 인덱스 번호에 위치한 문자를 반환.(인덱스 번호는 0부터 시작)
 console.log(`str.charAt(8): ${str.charAt(8)}`);
 
 str = 'pc.wk.java';
 //lastIndexOf('a') : 'a'를 오른쪽 부터 문자를 검색해서 일치하는 index 위치 반환
 console.log(`str.lastIndexOf('.') : ${str.lastIndexOf('.')}`);
 
 //indexof : 왼쪽부터 문자를 검색해서 일치하는 index위치 반환
 console.log(`str.indexOf('.') : ${str.indexOf('.')}`);
 
 //substring(4,9) : 문자열 인덱스 4부터 index 9이전 까지
 str = 'Javascript';
 console.log(`str.substring(4,9) : ${str.substring(4,9)}`); 
 
 //substr(4, 6) : index번호 4번 부터 6개 문자를 자르시오
 console.log(`str.substr(4,6) : ${str.substr(4,6)}`);
 
 //split('-') : '-'문자를 기준으로 문자열을 분할하고 배열로 return
 str = '010-1234-5678';
 let phoneNumber = str.split('-');
 for(let i = 0; i < phoneNumber.length; i++) {
  console.log(`phoneNumber[${i}]: ${phoneNumber[i]}`);
} 

 //replace('a','A') : 'a'를 'A' 로 바꾸시오
 str = 'Javascript';
 console.log(`${str} : str.replace('a','A') : ${str.replace('a','A')}`);
 
 //toLowerCase() : 소문자로 변경
 //toUpperCase() : 대문자로 변경
 //trim() : 문자열의 앞 뒤 공백 제거
 //concat() : 문자와 문자를 결합
 
 str = ' Javascript ';
 console.log(`${str} : str.trim() : ${str.trim()}`);