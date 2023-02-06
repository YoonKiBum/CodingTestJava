import java.util.*;
import java.io.*;

public class Main {  
  public static int n, m;
  public static int[] dx = {-1, 0, 1, 0};
  public static int[] dy = {0, 1, 0, -1};
  public static int[][] graph;
  public static boolean[][] visited;
  public static int[][] dp;
  
  public static int dfs(int x, int y) {
      if(x == n-1 && y == m - 1) {
        return 1;
      }

      if(dp[x][y] != -1)
        return dp[x][y];

      dp[x][y] = 0;
      for(int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if(nx < 0 || ny < 0 || nx >= n || ny >= m)
          continue;
        if(graph[nx][ny] < graph[x][y]) {
          dp[x][y] += dfs(nx, ny);
        }
      }

    return dp[x][y];
  }
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    graph = new int[n][m];
    
    for(int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for(int j = 0; j < m; j++) {
        graph[i][j] = Integer.parseInt(st.nextToken());
      }
    }  

    visited = new boolean[n][m];    
    dp = new int[n][m];
    for(int i = 0; i < n; i++) { // -1로 초기화
      for(int j = 0; j < m; j++) {
        dp[i][j] = -1;
      }
    }
    System.out.println(dfs(0, 0));
  }
}
