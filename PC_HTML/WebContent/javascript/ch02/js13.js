/**
 * 
 */
 'use strict';
 function goLife() {
  console.log('즉시 실행 함수!');
}

(
  function() {
    goLife();
  }
)();

let instant = (function(){
    console.log('즉시 실행 함수9999999!');
})();