## 유형 : DP
[RGB 거리: 1149](https://www.acmicpc.net/problem/1149)

### 문제 접근 방식
  - 모든 경우를 직접 탐색하게 되면, N*N은 1초로 0.5초 안에 문제를 해결할 수 없다.
  - 각 색상을 선택한 경우는 이전 단계의 동일 색상이 아닌 다른 두 색상의 값 중 최소값을 선택하여 더하면 된다.
  - 따라서, 각 단계에서 각 색상을 선택한 경우의 값들을 저장해두면, 해당 값을 그대로 이용할 수 있으며 N번만큼만 반복한다.
<br></br>
  - 각 단계에서, 3가지 색상에 대한 값을 이전 단계의 값을 활용하여 구할 수 있다.
``` Java
        for(int i=1; i<N; i++){
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            rgb[i][0] = r + Math.min(rgb[i-1][1], rgb[i-1][2]);
            rgb[i][1] = g + Math.min(rgb[i-1][0], rgb[i-1][2]);;
            rgb[i][2] = b + Math.min(rgb[i-1][0], rgb[i-1][1]);;
        }
```

### 주의할 점
  - 특별하게 없다

### 부족한 점
  - 특별하게 없다          
