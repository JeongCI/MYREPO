SELECT DECODE(day,'SUN',dayno) "SUN",
       DECODE(day,'MON',dayno) "MON",
       DECODE(day,'TUE',dayno) "TUE",
       DECODE(day,'WED',dayno) "WED",
       DECODE(day,'THU',dayno) "THU",
       DECODE(day,'FRI',dayno) "FRI",
       DECODE(day,'SAT',dayno) "SAT"
FROM cal
;