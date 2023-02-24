## 유형 : DP(LCS)
[9251: LCS](https://www.acmicpc.net/problem/9251)<br></br>
[참고 자료](https://velog.io/@emplam27/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EA%B7%B8%EB%A6%BC%EC%9C%BC%EB%A1%9C-%EC%95%8C%EC%95%84%EB%B3%B4%EB%8A%94-LCS-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-Longest-Common-Substring%EC%99%80-Longest-Common-Subsequence)

### 문제 접근 방식
  - LCS는 두 수열에서, 존재할 수 있는 가장 긴 공통 부분 수열을 찾아내는 문제이다.
  - 비교하는 두 문자가 같은 경우, 현재 비교하는 문자를 제외한 이전 문자, 즉 LCS[i-1][j-1]에 현재 문자가 공통에 들어가기 때문에 +1을 한다
  - 비교하는 두 문자가 다른 경우, 현재까지 비교한 문자들 내의, 최장 공통 부분 수열 길이를 저장하고 있어야 하기 때문에, LCS[i-1][j]와 LCS[i][j-1] 중 더 큰 값을 저장한다. 두 LCS 값은 비교 중인 두 개의 각 부분 문자열에서 현재 비교 중인 문자열을 뺀 경우이다.
<br></br>
  - 비교하는 두 문자가 같은 경우
``` Java
                if(a==b){
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                }
```

  - 비교하는 두 문자가 다른 경우
``` Java
                else{
                    lcs[i][j] = Math.max(lcs[i][j-1], lcs[i-1][j]);
                }
```

### 주의할 점
  - LCS의 크기를 N+1 X M+1로 선언했기 때문에, 각 문자열은 현재 탐색 중인 LCS의 인덱스-1을 해야 한다

### 부족한 점
  - 최장 공통 문자열 학습(참고 자료)
  - 최장 공통 부분 수열의 길이는 학습하였지만 이를 구하는 방법 학습(참고 자료)
``` Java
StringBuilder sb = new StringBuilder();
        int i=N, j=M;
        while(lcs[i][j]!=0){
            int cur = lcs[i][j];

            if(lcs[i-1][j]==cur && lcs[i][j-1]==cur){
                i = i-1;
            }
            else if(lcs[i-1][j]==cur){
                i = i-1;
            }
            else if(lcs[i][j-1]==cur){
                j = j-1;
            }
            else{
                sb.append(str1.charAt(i-1));
                i = i-1;
                j= j-1;
            }
        }
        sb.reverse();
```
