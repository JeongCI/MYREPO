/**
 * 
 */
 
 'use strict';
 
 function changeName(obj) {
  obj.name = '이상무';
}
 
 const pcwk = {name: 'javascript'};
 
 console.log(`before pcwk: ${pcwk.name}`); //before pcwk: javascript
 
 changeName(pcwk);
 
 console.log(`after pcwk: ${pcwk.name}`); //after pcwk: 이상무