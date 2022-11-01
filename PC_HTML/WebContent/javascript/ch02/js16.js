/**
 * 
 */
 function pFunc(a,b,c){
  //console.log(`a arguments[0] = ${arguments[0]}`);
  //console.log(`b arguments[1] = ${arguments[1]}`);
  //console.log(`c arguments[2] = ${arguments[2]}`);
  
  for(i = 0; i<arguments.length;i++) {
    console.log(`arguments[${i}] : ${arguments[i]}`);
  }
}
pFunc(11,22,33);
//-----------------------------------------------------------------------------

