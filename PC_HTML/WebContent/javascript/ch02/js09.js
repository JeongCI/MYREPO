/**
 * 
 */
  let table = '';
  table += '<table>';
 for(let i = 2; i<=3; i++) {
  table += '<tr>\n';
  for(let j = 1; j<=9; j++) {
    table += '<td>'+i+'*'+j+'='+(i*j)+ '</td>';
    console.log(`${i}*${j} = ${i*j}`);
  }
  table += '</tr>\n';
}
table += '</table>';
document.write(table);
