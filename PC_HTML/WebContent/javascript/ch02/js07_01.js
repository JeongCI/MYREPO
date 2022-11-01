/**
 * 
 */
 
 'use strict';
 let classification = prompt('Firefox, Edge, Chrome, Safari, IE','');
 console.log(`classification: ${classification}`);
 
 switch(classification){
  case 'IE':
    classification += ': 버려!';
  break;
  
  case 'Firefox':
  case 'Chrome':
    classification += ': good!';
  break;
  
  default:
    classification += ': same all';
  break;
}

document.write(classification);