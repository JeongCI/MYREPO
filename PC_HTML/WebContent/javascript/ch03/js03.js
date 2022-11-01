/**
 * 
 */
 'use strict';
 
 let kor = 90;
 
 function getScore() {
  kor = 100;
  
  console.log(`kor: ${kor}`);
}

 getScore();
 console.log(`kor: ${kor}`);
 //---------------------------------------------------------------------------
 console.clear();
 
 var eng = 90;
 
 function getEngScore() {
  var eng = 100; // 지역변(전역과 다르게 구사할 것)
  
  console.log(`지역변수 eng:${eng}`);
}

getEngScore();
console.log(`eng: ${eng}`);
