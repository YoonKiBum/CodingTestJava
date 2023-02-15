import java.util.*;
import java.io.*;

public class Main {
  public static int n;
  public static int[] arr;
  public static int[] dp;
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    
    arr = new int[n + 1];
    dp = new int[n + 1];

    st = new StringTokenizer(br.readLine(), " ");
    for(int i = 1; i < n + 1; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    for(int i = 1; i < n + 1; i++) {
      for(int j = i; j >= 1; j--) {
        dp[i] = Math.max(dp[i], dp[i-j] + arr[j]);
      }
    }

    System.out.println(dp[n]);
  }
}
