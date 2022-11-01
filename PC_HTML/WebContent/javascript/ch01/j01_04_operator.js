/**
 * 
 */
 //문법을 타이트 하게 검사해라
 'use strict';
  
 let num01 = 2;
 let num02 = 3;
 
 console.log(`num01+num02=${num01+num02}`);
 console.log(`num01-num02=${num01-num02}`);
 console.log(`num01/num02=${num01/num02}`);
 console.log(`num01*num02=${num01*num02}`);
 console.log(`num01%num02=${num01%num02}`);
 //console.log(`num01**num02=${num01**num02}`);
 
 //증가 감소 연산자
 let age = 11;
 console.log(`age:${age}`);
 let preIncrement = ++age; // 증가한 이후 할당
 console.log(`preIncrement:${preIncrement}`);
 
 age = 11;
 preIncrement = age++; // 할단한 이후 증가
 console.log(`preIncrement:${preIncrement}`);