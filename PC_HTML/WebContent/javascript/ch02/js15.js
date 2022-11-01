/**
 * 
 */
 'use strict';
 
 //param : 이름, html성적, CSS성적, js성적
 //60점 이상이면 path
 //return ''
 
 function isExamPath(name, html, css, js) {
  let comment = name+' 학생은 ';
  
  if(html>= 60 && css >= 60 && js >= 60) {
    comment += '전과목 pass';
  } else {
  if(html < 60) {
    comment += 'html 재시험';
    }
  if(css < 60) {
    comment += 'css 재시험';
    }
  if(js < 60) {
    comment += 'js 재시험';
    }
  }
  
  return comment;
}

 console.log(isExamPath('이상무',80,90,95));
 console.log(isExamPath('이상무2',80,90,59));
 console.log(isExamPath('이상무3',58,20,59));