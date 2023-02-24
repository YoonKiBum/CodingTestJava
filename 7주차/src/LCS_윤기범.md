### 유형 : dp
### 윤기범
https://www.acmicpc.net/problem/9251

### 문제 접근 방식
  - 문제를 읽고 dp로 판단함
  - 구글링 참고
  - 각각의 문자들을 2차원 배열로 표현한다.
    - 이 후 문자들을 비교하여(행, 열) 같으면 좌상단 + 1
    - 다르면 왼쪽, 위쪽 중 큰 값을 택한다. 
  - 표로 그리면 다음과 같다.
  <table>
    <tr>
      <td>0</td>
      <td>A</td>
      <td>C</td>
      <td>A</td>
      <td>Y</td>
      <td>K</td>
      <td>P</td>
    </tr>
    <tr>
      <td>C</td>
      <td>0</td>
      <td>1</td>
      <td>1</td>
      <td>1</td>
      <td>1</td>
      <td>1</td>
    </tr>
    <tr>
      <td>A</td>
      <td>1</td>
      <td>1</td>
      <td>2</td>
      <td>2</td>
      <td>2</td>
      <td>2</td>
    </tr>
    <tr>
      <td>P</td>
      <td>1</td>
      <td>1</td>
      <td>2</td>
      <td>2</td>
      <td>2</td>
      <td>3</td>
    </tr>
    <tr>
      <td>C</td>
      <td>1</td>
      <td>2</td>
      <td>2</td>
      <td>2</td>
      <td>2</td>
      <td>3</td>
    </tr>
    <tr>
      <td>A</td>
      <td>1</td>
      <td>2</td>
      <td>3</td>
      <td>3</td>
      <td>3</td>
      <td>3</td>
    </tr>
    <tr>
      <td>K</td>
      <td>1</td>
      <td>2</td>
      <td>3</td>
      <td>3</td>
      <td>4</td>
      <td>4</td>
    </tr>
  </table>
  
### 주의할 점
  - 특별하게 없음
  
### 보완할 점
  - 방법 숙지 -> 2차원 dp 테이블 생성 방식
