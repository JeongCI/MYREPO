/**
 * 
 */
 'use strict';
 
 class Person{
  //생성자
  constructor(name, age){
    //멤버 변수
    this.name = name;
    this.age = age;
  }  
  //메서드
  speak() {
    console.log(`name: ${this.name}, age: ${this.age}`);
  }
  
}

 const pcwk = new Person('PCWK',22);
 
 console.log(`pcwk.age: ${pcwk.name}`);
 console.log(`pcwk.age: ${pcwk.age}`);
 pcwk.speak();