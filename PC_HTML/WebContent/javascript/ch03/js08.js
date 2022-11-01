/**
 * 
 */
 
 let info = {
  subject: 'javascript',
  credit: 5,
  printOut: function() {
    return info.subject+','+info.credit;
  }
};

console.log(`info.subject: ${info.subject}`);
console.log(`info.credit: ${info.credit}`);
console.log(`info.printOut(): ${info.printOut()}`);

//--------------------------------------------------------------------------
console.clear();

//속성 추가
info.days = 10;
console.log(`info.days: ${info.days}`);

//속성 삭제
delete info.credit;
console.log(`info.credit: ${info.credit}`);

//속성 변경
info.printOut = function() {
  return info.subject+','+info.days;
};
console.log(`info.printOut(): ${info.printOut()}`);

