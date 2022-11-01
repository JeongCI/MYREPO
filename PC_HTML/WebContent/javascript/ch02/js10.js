/**
 * 
 */
 let sum = 0;
 for(let i = 1; i <= 10; i++) {
  if(sum>=30) {
    console.log(`sum 30이상 : ${sum}, i: ${i}`);
    break;
  }
  sum += i;
  console.log(`sum=${sum}`);
}
console.clear();
//contunue
 for(let i = 1; i <= 20; i++) {
  if(i % 2 == 0) {
    continue;
  }
    console.log(`i = ${i}`);
}
