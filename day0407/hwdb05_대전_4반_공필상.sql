-- hwdb05_대전_4반_공필상

-- 1
select ENAME,JOB,SAL
from emp a join dept b using(deptno)
where b.LOC="CHICAGO";

-- 2
select EMPNO,ENAME,JOB,DEPTNO
from emp 
where EMPNO not in(select mgr from emp where mgr is not null);

-- 3
select ENAME,JOB,MGR
from emp
where MGR =(select mgr from emp where ename="BLAKE");

-- 4
select ENAME,HIREDATE
from emp
order by HIREDATE limit 0,5;

-- 5
select ENAME,JOB,DNAME
from emp join dept using(deptno)
where mgr = (select empno from emp where ENAME ="JONES");
