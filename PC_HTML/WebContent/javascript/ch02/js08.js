/**
 * 
 */
 'use strict';
 
 let i = 10;
 while(i>0) {
  console.warn(`while i => ${i}`);
  i--;
}
console.clear();
//do-while
  i = 1;
  let sum = 0;
 do {
  sum += i;
  console.error(`i => ${i}`);
  i++;
} while(i <= 10);

console.log(`sum=${sum}`);