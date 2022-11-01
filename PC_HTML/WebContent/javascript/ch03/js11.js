/**
 * 
 */
  function Triangle(b,h) {
  this.base = b;
  this.height = h;
}

 Triangle.prototype.area = function () {
  return this.base * this.height/2;
};

 Triangle.prototype.printOut = function() {
  return '밑변 : ' + this.base + ' 높이 : '+this.height+' 넓이 : ' + this.area();
}

 let triangle01 = new Triangle(30,20);
 console.log(triangle01.area()); // 300

 let triangle02 = new Triangle(40,50);
 console.log(`triangle02.printOut() : ${triangle02.printOut()}`);



