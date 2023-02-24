## 유형 : BFS
[17070: 파이프 옮기기 1](https://www.acmicpc.net/problem/17070)

### 문제 접근 방식
  - 현재 파이프가 가로, 세로, 대각선으로 놓여져있는지 각 상태를 확인하여, 각 경우에 따라 가능한 경우, 파이프의 끝점을 이동하면 된다.
  - 
  - 
<br></br>
  - Pipe 클래스는 파이프의 끝점의 좌표와 방향 정보를 가지고 있다
``` Java
    static class Pipe {
        int row, col, dir; // dir 1: 가로 2: 세로 3: 대각

        Pipe(int r, int c, int d){
            this.row = r;
            this.col = c;
            this.dir = d;
        }
    }
```

  - 큐를 생성하여 시작 파이프를 삽입
  - 파이프가 이동할 수 있는 걍 경우의 좌표를 생성
``` Java
Queue<Pipe> pq = new LinkedList<>();
        pq.offer(new Pipe(0, 1, 1));

        int ans = 0;
        while(!pq.isEmpty()){
            Pipe cur = pq.poll();

            if(cur.row==N-1 && cur.col==N-1){
                ans++;
                continue;
            }

            int left_row = cur.row;
            int left_col = cur.col + 1;
            int under_row = cur.row + +1;
            int under_col = cur.col;
            int diagonal_row = cur.row + 1;
            int diagonal_col = cur.col + 1;
```

- 현재 파이프의 놓여진 방향에 따라 이동할 수 있는 경우 큐에 삽입
- 세로의 경우, 파이프가 세로 또는 대각선으로 이동할 수 있는데, 맨 아래 칸에 파이프가 세로 방향으로 존재하면 어떠한 이동도 불가능하기 때문에, 세로로 존재하는 파이프의 끝점이 만약 세로로 이동했을 때 제일 아래인 경우는 제외한다.
``` Java
if(cur.dir==1){
                if(left_col<N){
                    if(map[left_row][left_col]==0) {
                        pq.offer(new Pipe(left_row, left_col, 1));
                    }
                }

                if(diagonal_row<N && diagonal_col<N){
                    if(map[diagonal_row][diagonal_col]==0 && map[left_row][left_col]==0 && map[under_row][under_col]==0) {
                        pq.offer(new Pipe(diagonal_row, diagonal_col, 3));
                    }
                }
            }
            else if(cur.dir==2){
                if(under_row<N-1 || (under_col==N-1 && under_row<N)){
                    if(map[under_row][under_col]==0){
                        pq.offer(new Pipe(under_row, under_col, 2));
                    }
                }

                if(diagonal_row<N && diagonal_col<N){
                    if(map[diagonal_row][diagonal_col]==0 && map[left_row][left_col]==0 && map[under_row][under_col]==0) {
                        pq.offer(new Pipe(diagonal_row, diagonal_col, 3));
                    }
                }
            }
            else{
                if(left_col<N){
                    if(map[left_row][left_col]==0) {
                        pq.offer(new Pipe(left_row, left_col, 1));
                    }
                }

                if(under_row<N-1 || (under_col==N-1 && under_row<N)){
                    if(map[under_row][under_col]==0){
                        pq.offer(new Pipe(under_row, under_col, 2));
                    }
                }

                if(diagonal_row<N && diagonal_col<N){
                    if(map[diagonal_row][diagonal_col]==0 && map[left_row][left_col]==0 && map[under_row][under_col]==0) {
                        pq.offer(new Pipe(diagonal_row, diagonal_col, 3));
                    }
                }
            }
        }
```

### 주의할 점
  - 도착 지점에 벽이 존재하는 경우 어떠한 경우라도 불가능하기 때문에 바로 0을 출력 -> 시간이 반으로 줄어듬

### 부족한 점
  - DP로 해결하는 방법
  - dp[X][Y][3] -> (X, Y)까지 파이프를 이동시킬 수 있는 방법의 수
  - dp[X][Y][0] -> 가로 방향으로 놓이는 경우, dp[X][Y][1] -> 세로 방향으로 놓이는 경우, dp[X][Y][2] -> 대각선으로 놓이는 경우
  - 가로 방향으로 놓이는 경우: 이전 끝점, 즉 dp[X][Y-1]이 가로인 경우와 대각선인 경우를 합한 방법의 수를 갖는다
  - 세로 방향으로 놓이는 경우: 이전 끝점, 즉 dp[X-1][Y]가 세로인 경우와 대각선인 경우를 합한 방법의 수를 갖는다.
  - 대각선 방향으로 놓이는 경우: 이전 끝점, 즉 dp[X-1][Y-1]이 가로, 세로, 대각선인 경우를 합한 방법의 수를 갖는다.
  - 추가적으로 대각선의 경우 (wall[x - 1][y] == 0 && wall[x][y - 1] == 0)인지도 확인해야 한다.
          
