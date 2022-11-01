/**
 * 
 */
 'use strict';
 
 function factorial(n) {
  
  if(n==0) {
    console.log('호출 끝');
  } else {
    console.log(`호출 factorial(${n}): ${n}`);
    factorial(n-1);
  }
}

factorial(10);

/*
js06.js:11 호출 factorial(10): 10
js06.js:11 호출 factorial(9): 9
js06.js:11 호출 factorial(8): 8
js06.js:11 호출 factorial(7): 7
js06.js:11 호출 factorial(6): 6
js06.js:11 호출 factorial(5): 5
js06.js:11 호출 factorial(4): 4
js06.js:11 호출 factorial(3): 3
js06.js:11 호출 factorial(2): 2
js06.js:11 호출 factorial(1): 1 
*/