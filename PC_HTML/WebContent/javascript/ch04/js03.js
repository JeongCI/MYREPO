/**
 * 
 */
 'use strict';
 
 class Shape{
  
  constructor(width, height, color){
    this.width = width;
    this.height = height;
    this.color = color;
  }
  
  draw() {
    console.log(`drawing: ${this.color} color!`);
  }
  
  getArea(){
    return this.width * this.height; 
  }
  
}
 
 class Rectangle extends Shape{
    
}

 let rectangle = new Rectangle(10,10,'Red');
 rectangle.draw();
 
 console.log(`rectangle.getArea() : ${rectangle.getArea()}`);
 
 class Triangle extends Shape{
  
  draw() {
    //parent.메서드.call
    super.draw();
    console.log(`Triangle drawing blue color.`);
  }
  getArea() {
    return (this.width * this.height) / 2;
  }
  toString() {
    return `Triangle: color:${this.color}`;
  }
}
 console.log('------------------------------------------------------------');
 let triangle = new Triangle(10,10,'Blue');
 triangle.draw();
 console.log(`triangle.getArea() : ${triangle.getArea()}`);
 console.log(`triangle.toString() : ${triangle.toString()}`);
 console.log(`triangle instanceof Shape: ${triangle instanceof Shape}`);
 console.log(`triangle instanceof Rectangle: ${triangle instanceof Rectangle}`);