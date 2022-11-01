/**
 * 기본적인 명령어 
 */
 
 //입력: prompt('입력제목','입력내용') - 잘 사용하지 않음.
 //prompt('출력 페이지를 입력하세요.','');
 
 //출력: alert('출력할 내용')
 //alert('자바스크립트');
 
 //화면에 출력
 //document.write("pcwk 자바스크립트");
 
 //브라우저 콘솔 로그: 소스보안으로 개별 완료후 모두 삭제 /  f12 console 로그에 출력
 //console.log("자바스크립트");
 
 //confirm: confirm("확인 내용"); true(예) / false(아니오)
 //confirm("삭제하시겠습니까?");
 
 //----------------------------------------------------------
 //변수
 //----------------------------------------------------------
 //var는 변수를 중복 선언 가능!
 var num = 10;
 var num = 20;
 console.log("num="+num);
 
 //let 변수는 중복 선언 불가!
 let age = 23;
 //let age = 32;
 console.log("age="+age);
 
 //var 자바스크립트 엔진에 의해 최상단으로 들어 올려진다.
 //선언하지 않은 상태에서 할당 사용.
 text = "Hoisting";
 console.log("text="+text);
 var text;
 
 //let 변수는 hoisting없음
 //jsVar = "자바스크립트";
 let jsVar;
 
 
 
 
 
 
 
 
 
 
 