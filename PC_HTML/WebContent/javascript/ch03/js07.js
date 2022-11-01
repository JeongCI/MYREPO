/**
 * 
 */
 'use strict';
 
 let str01 = 'pcwk_자바스크립트_89';
 
 console.log(`str01:${str01}`);
 
 let encodeStr = encodeURIComponent(str01);
 console.log(`encodeStr: ${encodeStr}`);
 
 let decodeStr = decodeURIComponent(encodeStr);
 console.log(`decodeStr: ${decodeStr}`);
 
 //------------------------------------------------------------------------
 
 console.clear();
 
 let num01 = 11;
 if(isNaN(num01)) {
  console.log('숫자 아님');
} else {
  console.log('숫자')
}

 let num02 = 1/0;
 if(isFinite(num02)) {
  console.log(`유한 :${isFinite(num02)}`);
} else {
  console.log(`무한 :${isFinite(num02)}`);
}

 //------------------------------------------------------------------------
 
 console.clear();
 
 let pStr01 = '13';
 console.log(`pStr01: ${pStr01}, type: ${typeof pStr01}`);
 console.log(`pStr01: ${Number(pStr01)}, type: ${typeof Number(pStr01)}`);
 
 let pStr02 = '100px';
 console.log(`pStr02: ${pStr02}, type: ${typeof pStr02}`);
 console.log(`pStr02: ${parseInt(pStr02)}, type: ${typeof parseInt(pStr02)}`);
 
 let pStr03 = '33.333%';
 console.log(`pStr03: ${pStr03}, type: ${typeof pStr03}`);
 console.log(`pStr03: ${parseFloat(pStr03)}, type: ${typeof parseFloat(pStr03)}`);
 
 //------------------------------------------------------------------------
 
 console.clear();
 
 var kStr01 = 'var num7 = 10';
 var kStr02 = 'var num8 = 20';
 
 eval(kStr01);
 eval(kStr02);
 
 console.log('kStr01:' + kStr01);
 console.log('kStr02:' + kStr02);
 
 
 var x = 2, y = 4;
 console.log(eval('x+y')); // 6
 
 
 
 
 
 
 
 
 
 
 
 