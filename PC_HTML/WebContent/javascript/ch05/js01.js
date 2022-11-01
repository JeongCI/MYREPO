/**
 * 
 */
 
 'use strict';
 
 //let dateObj = new Date();
 let dateObj = new Date(2022,11,30,12,50);
 
 let datInfo = {
  year : dateObj.getFullYear(), //년도 4자리
  month : dateObj.getMonth()+1, //월 0 ~ 11 까지 +1 필요
  day : dateObj.getDate(), // 1 ~ 31일 까지
  week : dateObj.getDay(), //  0 ~ 6 까지 (일요일 : 0, 토요일 : 6)
  hours : dateObj.getHours(), // 시간
  minutes : dateObj.getMinutes(), // 분
  seconds : dateObj.getSeconds(), // 초
  milseconds : dateObj.getMilliseconds() // 1/1000 초 
}

 for(let i in datInfo) {
  console.log(`${i} : ${datInfo[i]}`);
}