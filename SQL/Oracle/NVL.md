## NVL

### NVL(컬럼, "지정 값")
  - NVL 함수는 컬럼의 값이 NULL인 경우 지정 값을 출력하고, NULL이 아니면 컬럼 값을 그대로 출력한다.

```sql
SELECT empno
     , ename
     , comm         AS comm      
     , NVL(comm, 0) AS comm2 -- comm이 NULL이면 0을 출력하고, NULL이 아니면 comm의 값을 출력
     , NVL(comm, 'None') AS comm3 -- comm이 NULL이면 None을 출력하고, NULL이 아니면 comm의 값을 출력
  FROM emp
```
<hr>
<br/>

## NVL2

### NVL2(컬럼, "지정 값1", "지정 값2")
  - NVL2 함수는 컬럼의 값이 NULL이 아닌 경우 지정 값1을  출력하고, NULL인 경우 지정 값2를 출력한다.

```sql
SELECT empno
     , ename
     , comm                 AS comm 
     , NVL2(comm, 'Y', 'N') As comm2 --comm이 NULL이면 'Y'를 출력하고, NULL이 아닌 경우 'N'을 출
  FROM emp
```
