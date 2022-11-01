/**
 * 
 */
 'use strict';
 
 let subject = [11,13,'Javascript','CSS','JQuery'];
 
 //배열의 길이
 console.log(`subject.length : ${subject.length}`);
 
 //배열의 index
 console.log(`subject[2] : ${subject[2]}`);
 
 //배열과 반복문
 for(let i = 0; i < subject.length;i++) {
  console.log(`subject[${i}] : ${subject[i]}`);
}

//배열에 요소 추가 : push('jsp')
 let newLentgh = subject.push('jsp');
  console.log(`newLentgh : ${newLentgh}`);
  
  //toString() : 배열을 문자열로 변환
  console.log(`subject.toString() : ${subject.toString()}`);
  
  //join('-') : 배열 요소를 '-' 로 연결한 문자를 출력
  console.log(`subject.join('-') : ${subject.join('-')}`);
  
 //for .. in : 배열의 인덱스 변환
 let country = ['미국', '영국', '중국', '태국'];
 
 for(let i in country) {
  console.log(`i:${i} , country[${i}], ${country[i]}`);
} 

 //향상된 for문
 //for .. of 문
 for(let i of country) {
  console.log(`i:${i}`);
}

 //forEach()
 let numArray = [10,20,30,40,50,60,70];
 let sum = 0;
 numArray.forEach(function(value, index, array){
  console.log(`index :${index} : value: ${value} , ${array}`);
  sum += value;
});

console.log(`sum :${sum}`);

 //sort() : 정렬
 let info = [50,45,11,13,16];
 console.log(`info: ${info}`);
 
 info.sort(function(a,b){
  return a-b; //오름차순 (b - a 내림차순)
});
 console.log(`info: ${info}`); 
 
 //map() : 기존 배열을 이용해서 새로운 배열을 만들 수 있다.
 let base = [10,20,30];
 let area = base.map(function(value,index,array){
                      return value*2;
                    });
 console.log(`base :${base}`);
 console.log(`area : ${area}`);
 
 //filter() : 조건에 맞는 데이터만 가져온다. 새로운 배열 생성
 let data = ['javascript',50,45,'jquery'];
 //data 배열중에 type이 number인 데이터만 출력
 let numArray99 = data.filter(function(value, index, array){
                              return typeof value === 'number';
                            });
 console.log(`numArray99:${numArray99}`);