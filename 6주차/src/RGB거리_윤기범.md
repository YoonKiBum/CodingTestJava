### 유형 : dp
### 윤기범
https://www.acmicpc.net/problem/1149

### 문제 접근 방식
  - 문제를 읽고 dp로 판단함
  - 같은색이면 안되기 때문에 같은 열 제외하기
  - 이를 점화식으로 쓰면 다음과 같다. a[i][j] = min(arr[i-1][j-1], arr[i-1][j+1]) + arr[i][j]
  ```java
    for(int i = 1; i < n; i++) {
      for(int j = 0; j < 3; j++) {
        if(j == 0) {
          arr[i][j] += Math.min(arr[i-1][1], arr[i-1][2]);
        } else if(j == 1) {
          arr[i][j] += Math.min(arr[i-1][0], arr[i-1][2]);
        } else {
          arr[i][j] += Math.min(arr[i-1][0], arr[i-1][1]);
        }
      }
    }
  ```
### 주의할 점
  - 특별하게 없음

### 보완할 점
  - 특별하게 없음
