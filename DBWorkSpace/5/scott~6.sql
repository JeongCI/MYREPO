SELECT * FROM (SELECT weekno "week" , day, dayno FROM cal)
PIVOT ( MAX(dayno) FOR day IN(
                               'SUN' "SUN",
                               'MON' "MON",
                               'TUE' "TUE",
                               'WED' "WED",
                               'THU' "THU",
                               'FRI' "FRI",
                               'SAT' "SAT"
                               )
       );