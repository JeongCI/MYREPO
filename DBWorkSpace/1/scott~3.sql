SELECT ename,
       job
FROM emp
;

SELECT ename || job "ename and job"
FROM emp
;
SELECT ename || ' ' || job "ename and job"
FROM emp
;

--SMITH 's job is CLERK
SELECT ename || ' ''s job is ' || job "NAME AND JOB"
FROM emp
;

SELECT ename || '(' || job || ')' || ' , ' || ename || '''' ||job||  '''' "NAME AND JOB"
FROM emp
;