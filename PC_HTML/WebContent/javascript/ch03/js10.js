/**
 * 
 */
 //객체 리터럴
 let circle = {
  color: 'yellow',
  diameter: 100,
  radius: function() {
    return this.diameter/2;
  }
};
 
 console.log(`circle.color :${circle.color}`);
 console.log(`circle.diameter :${circle.diameter}`);
 console.log(`circle.radius() :${circle.radius()}`);
 
 console.clear();
 
 /*
  객체 속성에 쉽게 접근
  for(let 변수 in 객체) {
    실행문;
  }
 */
 for(let i in circle) {
  console.log(i+':'+circle[i]);
}
 
 //객체 생성자 함수
 function Triangle(b,h) {
  this.base = b;
  this.height = h;
  
  this.area = function() {
    return this.base*this.height/2;
  };
}

let triangle01 = new Triangle(15,15);
console.log(triangle01.base);
console.log(triangle01.height);
console.log(triangle01.area());
 
let triangle02 = new Triangle(10,10);
console.log(triangle02.base);
console.log(triangle02.height);
console.log(triangle02.area());
 