/**
 * 
 */
 'use strict';
 
 let luckyNum = [];
 
 for(let i = 1; i <=45; i++) {
  luckyNum.push(i);
}

 console.log(`luckyNum: ${luckyNum.toString()}`);
 
 let idx = Math.floor(Math.random() * luckyNum.length);
 console.log(`idx: ${idx}`);
 console.log(`오늘의 행문의 숫자 ${luckyNum[idx]}`);
 
 console.clear();
 
 //1 ~ 45중 중복되지 않는 숫자 6개 출력
 let lotto = [];
 for(let i = 1; i <= 45; i++) {
  lotto.push(i);
}
 let lottoNum = [];
 for(let i = 0; i < 10; i++) {
  lottoNum.push(Math.floor(Math.random()*lotto.length));
  }

 let lottoNum02 = lottoNum.filter(function(value,index,array){
   return index < 6;
 });
 
 let result = lottoNum02.sort(function(a,b){
  return a-b;
});
  
  console.log(`lottoNum : ${result}`);
 