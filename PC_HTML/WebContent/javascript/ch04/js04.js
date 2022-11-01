/**
 * 
 */
 'use strict';
 
 function add(num1, num2) {
  return num1+num2;
}

 function multiply(num1, num2) {
  return num1*num2;
}

 function surprise(callback) {
  const result = callback(11,10);
  
  console.log(`result: ${result}`);
}

 surprise(add);
 surprise(multiply);