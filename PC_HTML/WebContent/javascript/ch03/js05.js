/**
 * 
 */
 'use strict';
 
 function add() {
  let n = 0;
  return ++n;
}
 console.log(`add(): ${add()}`); //add(): 1
 console.log(`add(): ${add()}`); //add(): 1
 
 function addClosure() {
  let n = 0;
  return function() {
    return ++n;
  }
  
}

let increase = addClosure(); //let increase = function() {return ++n}

console.log(`increase(): ${increase()}`); // 1
console.log(`increase(): ${increase()}`); // 2
