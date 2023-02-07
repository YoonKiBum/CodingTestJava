import java.util.*;
import java.io.*;

public class Main {  
  public static final int INF = (int)1e9;
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[] sugar = {3, 5};
    int[] dp = new int[5001];
    for(int i = 0; i < 5001; i++) {
      dp[i] = INF;
    }
    dp[0] = 0;

    for(int i = 0; i < 2; i++) {
      for(int j = 0; j < n + 1; j++) {
        if(j - sugar[i] >= 0) { // 현재 무게가 설탕 무게보다 큰 경우 (가능한 경우)
          dp[j] = Math.min(dp[j], dp[j-sugar[i]] + 1); // 기존 무게와 현재 만든 무게의 최소값 비교
        }
      }
    }

    if(dp[n] == INF)
      System.out.println(-1);
    else
      System.out.println(dp[n]);
  }
}
