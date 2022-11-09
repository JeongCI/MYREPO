SELECT * FROM UNPIVOT
UNPIVOT (
    empno for job IN (CLERK
                      ,MANAGER
                      ,PRESIDENT
                      ,ANALYST
                      ,SALESMAN
                      )
)
;