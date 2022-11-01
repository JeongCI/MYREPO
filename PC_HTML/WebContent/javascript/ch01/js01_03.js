/**
 * 상수 
 */
 
 //문법을 타이트하게 검사 하시오
 'use strict';
 
 let cm = 200;
 //상수: 값을 할당하면 더이상 변경 불가
 const DIVISION_VALUE = 100;
 
 //DIVISION_VALUE = 200;
 
 console.log(cm+"/"+DIVISION_VALUE+"="+(cm/DIVISION_VALUE));
 
 //ES6추가(2015): ``
 
 const COUNT = 11; // 정수
 const SIZE = 17.2; // 실수
 
 console.log(`value: ${COUNT}, type: ${typeof COUNT}`);
 console.log(`value: ${SIZE}, type: ${typeof SIZE}`);
 
 // --------------------------------------------------------------------------
 console.clear(); //console 지우기
 
 let infi = 10/0;
 //infinity
 console.log(`infi: ${infi}`);
 
 let negativeInfi = -11/0;
 console.log(`negativeInfi:${negativeInfi} type:${typeof negativeInfi}`);
 
 //NaN Not a number
 let nAn = "not a number"/10;
 console.log(`nAn: ${nAn}`);
 
 console.clear();
 //number(숫자) 데이터
 // 정수, 소수점, 지수를 표현할 수 있다.
 
 let num01 = 11;
 console.log(`num01: ${num01} type: ${typeof num01}`);
 
 let num02 = 13.5;
 console.log(`num02: ${num02} type: ${typeof num02}`);
 
 let num03 = 1e+3;
 console.log(`num03: ${num03} type: ${typeof num03}`);
 
 //---------------------------------------------------------------------------
 console.clear();
 
 let char = "javascript";
 let brendan = "brendan";
 console.log(`char: ${char} type: ${typeof char}`);
 console.log(`brendan: ${brendan} type: ${typeof brendan}`);
 
 const helloBrendan = "hello"+"brendan";
 console.log(`helloBrendan: ${helloBrendan} type: ${typeof helloBrendan}`);
 
 let str01 = '문자 SMS "문자"';
 let str02 = "문자 SMS '문자'";
 console.log(`str01: ${str01} type: ${typeof str01}`);
 console.log(`str02: ${str02} type: ${typeof str02}`);
 
 console.clear();
 /*
 \n   행 바꿈
 \t   탭 문자
 \\   역슬러시
 \'   작은 따옴표
 \"   큰 따옴표
  */
  
  let esStr01 = "you \'re too smart.";
  let esStr02 = "javascript \n jquery";
  let esStr03 = "javascript \t jquery";
  console.log(`esStr01: ${esStr01}`);
  console.log(`esStr02: ${esStr02}`);
  console.log(`esStr03: ${esStr03}`);
  
  //---------------------------------------------------------------------------
  
  console.clear();
  let canRead = true;
  let test = 3<1;
  
  console.log(`canRead:${canRead}, type: ${typeof canRead}`);
  console.log(`test:${test}, type: ${typeof test}`);
  
  let jsTrue = 1;
  let jsFalse = 0;
  
  console.log(`jsTrue:${Boolean(jsTrue)}, type:${typeof jsTrue}`);
  console.log(`jsFalse:${Boolean(jsFalse)}, type:${typeof jsFalse}`);
  
  let nothing = null;
  console.log(`nothing:${nothing}, type:${typeof nothing}`);
  
  let x;
  console.log(`x:${x}, type:${typeof x}`);
  console.log(`x:${Boolean(x)}, type:${typeof x}`);
  
  //---------------------------------------------------------------------------
  
  console.clear();
  let dText = 'D PCWK';
  console.log(`dText: ${dText}, type: ${typeof dText}`);
  
  dText = 23;
  console.log(`dText: ${dText}, type: ${typeof dText}`);
  
  dText = '1'/'5';
  console.log(`dText: ${dText}, type: ${typeof dText}`);
  
  dText = '1'+5;
  console.log(`dText: ${dText}, type: ${typeof dText}`);
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  