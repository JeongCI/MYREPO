/**
 * 
 */
 
 'use strict';
 
 function showMessage(message, from='unknown') {
  console.log(`message: ${message}`);
  console.log(`from: ${from}`);
}

 function showMessage02(message, from) {
  
  if(from ===undefined) {
    from = 'unknown';
  }
  console.log(`message: ${message}`);
  console.log(`from: ${from}`);
}

showMessage('hi');
showMessage02('hello');