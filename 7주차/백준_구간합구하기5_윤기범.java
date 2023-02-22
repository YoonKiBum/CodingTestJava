import java.util.*;
import java.io.*;

public class Main {
  public static int n, m;
  public static long[][] arr;
  public static long[][] dp;
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    StringBuilder sb = new StringBuilder();
    
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    arr = new long[n+1][n+1];
    dp = new long[n+1][n+1];

    for(int i = 1; i < n + 1; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for(int j = 1; j < n + 1; j++) {
        arr[i][j] = Long.parseLong(st.nextToken());
      }
    }
    
    for(int i = 1; i < n + 1; i++) {
      for(int j = 1; j < n + 1; j++) {
        dp[i][j] = dp[i][j-1] + arr[i][j];
      }
    }

    for(int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());

      long ans = 0;
      for(int j = x1; j <= x2; j++) {
        ans += (dp[j][y2] - dp[j][y1-1]);
      }

      sb.append(ans).append("\n");
    }
    System.out.print(sb);
  }
}
