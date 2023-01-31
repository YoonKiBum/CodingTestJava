## TO_DATE

### TO_DATE("문자열" or 컬럼, "날짜 포맷")
  - 문자열 또는 컬럼의 형식, 즉 -, /과 같은, 날짜 포맷과 일치해야 한다.
  - 문자열을 날짜형 데이터로 형 변환을 하기 위해서는 TO_DATE 함수를 사용하면 된다.
  - 년/월/일의 위치를 변경하여 포맷을 정의할 수 있다.
<br/>

### 종류
  - MONTH/MON : 길고 짧은 월의 이름 
  - MM : 월을 숫자
  - DAY : 일의 이름
  - DD : 일을 숫자로
  - HH/HH12/HH24 : 시간
  - MI : 분
  - SS : 초
<br/>

  - 사용 예시
```sql
SELECT TO_DATE('2021-12-12', 'YYYY-MM-DD')
     , TO_DATE('2021-12-12 17:10:00', 'YYYY-MM-DD HH24:MI:SS')
  FROM dual

SELECT TO_DATE('19/12/11', 'RR/MM/DD')
     , TO_DATE('21/12/12', 'RR/MM/DD')
  FROM dual
```
<br/>

  - TO_DATE 관련 함수 사용
```sql
SELECT TO_DATE('20200324', 'YYYYMMDDHH24MISS')-1  AS "전일"
     , LAST_DAY(TO_DATE('20200324', 'YYYYMMDDHH24MISS')) AS "당월 마지막 일"
     , ADD_MONTHS(TO_DATE('20200324', 'YYYYMMDDHH24MISS'),-1) AS "전월"
     , NEXT_DAY(TO_DATE(’92-JUN-27’, ‘YY-MON-DD’) , ‘Monday’) AS "다음에 오는 월요일"
     , MONTHS_BETWEEN(TO_DATE(’92-JUN-29’, ‘YY-MON-DD’), TO_DATE(’92-JUN-27’, ‘YY-MON-DD’)) AS "두 날짜 사이의 월 수"
```
<hr>
<br/>

## TO_CHAR

### 
  - 

```sql

```
<hr>
<br/>

## TO_NUMBER

### 
  - 

```sql

```
