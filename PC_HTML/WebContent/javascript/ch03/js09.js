/**
 * 
 */
 
 'use strict';
 
 function Info(subject, credit) {
  this. subject = subject;
  this.credit = credit;
  
  this.printOut = function() {
    return this.subject+','+this.credit;
  };
}

 let subject01 = new Info('html',1);
 subject01.days = 20;
 console.log(`subject01.days: ${subject01.days}`);
 console.log(`subject01.subject: ${subject01.subject}`);
 console.log(`subject01.credit: ${subject01.credit}`);
 console.log(`subject01.printOut(): ${subject01.printOut()}`);
 
 let subject02 = new Info('css',2);
 console.log(`subject02.subject: ${subject02.subject}`);
 console.log(`subject02.credit: ${subject02.credit}`);
 console.log(`subject02.printOut(): ${subject02.printOut()}`);