/**
 * 
 */
 'use strict';
 
 let reg = /Javascript/;
 
 // true
 console.log(`reg.test('Javascript') : ${reg.test('Javascript')}`);
 
 //false
 console.log(`reg.test('Javascrip') : ${reg.test('Javascrip')}`);
 
 let str = 'Java script';
 console.log(str.match(reg)); // null
 
 str = 'Javascript';
 console.log(str.match(reg));
 
 let hpReg = /^\d{10,11}/; // \d숫자 검색 : {10, 11}는 숫자가 10 ~ 11자리 의미,^(시작), $(끝)
 
 let hp1 = '010123456';
 let hp2 = '01012345678';
 
 console.log(hpReg.test(hp1));
 console.log(hpReg.test(hp2));