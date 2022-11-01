/**
 * 
 */
 let bit01, bit02, bit03, bit04, bit05, bit06;
 
 bit01 = 1 & 3;
 console.log(`1 & 3 => ${bit01}`);
 
 bit02 = 1 | 3;
 console.log(`1 | 3 => ${bit02}`);
 
 bit03 = 1 ^ 3;
 console.log(`1 ^ 3 => ${bit03}`);
 
 bit04 = ~2; // 양수를 음수로 변환: 2의 보수 + 1
 console.log(`~2 => ${bit04}`);
 
 bit05 = 1 << 2;
 console.log(`1 << 2 => ${bit05}`);
 
 bit06 = 8 >> 1;
 console.log(`8 >> 1 => ${bit06}`);