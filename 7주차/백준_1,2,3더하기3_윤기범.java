import java.util.*;
import java.io.*;

public class Main {
  public static int n;
  public static long[] dp = new long[1000001];
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;
    
    n =  Integer.parseInt(br.readLine());
    for(int i = 4; i < 1000001; i++) {
      dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % 1000000009;
    }

    for(int i = 0; i < n; i++) {
      int m = Integer.parseInt(br.readLine());
      System.out.println(dp[m]);
    }
  }
}
