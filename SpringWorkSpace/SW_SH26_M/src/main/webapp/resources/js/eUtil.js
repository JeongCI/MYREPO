/**
 * 
 */
   let eUtil = {};
  //str 비어 있으면 true,
  //그렇치 않으면 false
  eUtil.ISEmpty = function(str){
    if(null !=str && undefined !=str){
      str = str.toString();
      
      if(str.replace(/ /gi,"").length == 0){
        return true;
      }
    }
    
    return false;
  }
    
  eUtil.toFormatDateString = function (dateStr, formatChar='-'){
    let formatDate="";
    
    if(eUtil.ISEmpty(dateStr)){
      return "";
    }
    
    dateStr = dateStr.replace(/ /gi,"");
    try{
         
      if(8==dateStr.length){
        formatDate = dateStr.replace(/(\d{4})(\d{2})(\d{2})/, '$1'+formatChar+'$2'+formatChar+'$3');
      }
      
    }catch(e){
      formatDate = dateStr;
      console.log(e);
    }
    
    return formatDate;
  } 