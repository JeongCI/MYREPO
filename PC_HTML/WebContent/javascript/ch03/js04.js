/**
 * 
 */
 
 'use strict';
 var num = 10; {
  var num = 20; // 전역 변수
  console.log(`num: ${num}`);
}
  console.log(`num: ${num}`); // 20출력
  //--------------------------------------------------------------------
  console.clear();
  
  let num01 = 10; {
   let num01 = 20; // 지역 변수
   console.log(`num01:${num01}`); // 20 
  }  
   console.log(`num01:${num01}`); // 10
  //--------------------------------------------------------------------
  console.clear();
  
  const num02 = 10; {
    const num02 = 20; // 지역 변수
    console.log(`num02: ${num02}`); // 20
  }
    console.log(`num02: ${num02}`); // 10
  //--------------------------------------------------------------------
  console.clear();
  
  var num03 = 10;
  if(num03==10) {
    var sum = 20; //전역변수
  }
    console.log(`sum: ${sum}`); // 20
  //--------------------------------------------------------------------
  console.clear();
  
  let num04 = 10;
  if(num04==10) {
    let sum02 = 20; // 안대안대
  }
  console.log(`sum02 :${sum02}`); // 안대안대