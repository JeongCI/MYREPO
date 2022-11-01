/**
 * 
 */
 'use strict';
 
 let local01, local02, local03, local04, local05, local06;
 //true && true
 local01 = (3>2) && (5>3);
 console.log(`(3>2) && (5>3) => ${local01}`);
 
 //false && true
 local02 = (3<2) && (5>3);
 console.log(`(3<2) && (5>3) => ${local02}`);
 
 //true || ture
 local03 = (3>2) || (5>3);
 console.log(`(3>2) || (5>3) => ${local03}`);
 
 //false || ture
 local04 = (3<2) || (5>3);
 console.log(`(3<2) || (5>3) => ${local04}`);
 
 local05 = !(3>2);
 console.log(`!(3>2) => ${local05}`)