import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    long[] dp = new long[100001];
    dp[1] = 3;
    dp[2] = 7;
    for(int i = 3; i < n + 1; i++) {
      dp[i] = (dp[i-1] * 2 + dp[i-2]) % 9901;
    }

    System.out.println(dp[n]);
  }
}
