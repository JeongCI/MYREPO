/**
 * 
 */
 'use strict';
 function process() {
  let kor = 99;
  let eng = 88;
  let math = 90;
  
  let avg = (kor+eng+math)/3;
  
  return avg;
}

const avgResult = process();
console.log(`avgResult : ${avgResult}`);
