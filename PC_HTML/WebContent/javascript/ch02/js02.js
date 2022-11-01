/**
 * 대입 연산자 
 */
 'use strict'
 let str = 'JAVASCRIPT';
     str += ' JQuery';
     
console.log(str);

//+=연산자를 이용한 문자열 연결
 let table ='';
     table += '  <table>                                '   ;
     table += '  <tr>                                '   ;
     table += '    <td>Javascript99</td><td>JQuery88</td>'   ;
     table += '  </tr>                               '   ;
     table += '</table>                              '   ;
 console.log(table);
 document.write(table);
 
 let num1 = 5;
 let num2 = 10;
 console.log(`num1 =${num1}`);
 console.log(`num2 =${num2}`);
 
 num1 += 10;
 num2 -= 10;
 console.log(`num1 += 10 =${num1}`);
 console.log(`num2+= 10 =${num2}`);