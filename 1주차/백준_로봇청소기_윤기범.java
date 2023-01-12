import java.util.*;
import java.io.*;

public class Main {
  public static int n, m, r, c, dir, ans = 0, turnCnt = 0;
  public static int[][] graph;
  public static int[] dx = {-1, 0, 1, 0};
  public static int[] dy = {0, 1, 0, -1};
  
  public static void turnLeft() {
    if(dir == 0)
      dir = 3;
    else
      dir -= 1;
  } 
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine(), " ");
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    dir = Integer.parseInt(st.nextToken());

    graph = new int[n][m];
    for(int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for(int j = 0; j < m; j++) {
        graph[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    ans = 1;
    graph[r][c] = 2; // 현재 위치 청소

    while(true) {
      if(turnCnt == 4) { // 이미 4방향 다 탐색한 경우
        int nr = r - dx[dir];
        int nc = c - dy[dir];
        if(graph[nr][nc] == 2) { // 후진 가능한 경우
          r = nr;
          c = nc;
          turnCnt = 0;
        } else { // 후진 못하는 경우
          break;
        }
      }
      turnCnt += 1;
      turnLeft();
      int nr = r + dx[dir];
      int nc = c + dy[dir];
      if (graph[nr][nc] == 0) { // 청소하지 않은 공간이 존재하는 경우
        r = nr;
        c = nc;
        graph[r][c] = 2;
        ans += 1;
        turnCnt = 0;    
      } else { // 그 외의 경우 continue
        continue;
      }
    }
    System.out.println(ans);
  }
}
