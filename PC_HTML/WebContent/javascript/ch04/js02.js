/**
 * 
 */
 'use strict';
 
 class User{
  //생성자
  constructor(name, passwd, age){
    this.name = name;
    this.passwd = passwd;
    this.age = age;
  }
  //getter
  get getAge(){
    return this.age;
  }
  //setter  
  set setAge(value){
    if(value < 0){
      value = 0;
    }
    this.age = value;
  }  
  
}

 let user01 = new User('pcwk','4321',22);
 
 console.log(`user01.name: ${user01.name}`);
 console.log(`user01.passwd: ${user01.passwd}`);
 
 //setter
 user01.setAge = -1;
 console.log(`user01.getAge: ${user01.getAge}`);
 