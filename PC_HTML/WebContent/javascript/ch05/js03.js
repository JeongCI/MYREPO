/**
 * 
 */
 'use strict';
 
 let sub = new Map();
 sub.set('html',1);
 sub.set('css',2);
 sub.set('javascript',3);
 
 console.log(`sub.get('javascript') : ${sub.get('javascript')}`);
 console.log(`sub.has('cas') : ${sub.has('css')}`);
 
 for(let key of sub.keys()) {
  console.log(`key:${key}, ${sub.get(key)}`);
}
 
 //set
 let sub01 = new Set();
 sub01.add('a');
 sub01.add('b');
 sub01.add('c');
 sub01.add('b');
 
 for(let value of sub01.values()) {
  console.log(`value : ${value}`)
}