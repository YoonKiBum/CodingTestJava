import java.util.*;
import java.io.*;

public class Main {
  public static final int INF = (int)1e9;
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int[] dp = new int[k + 1]; // 전체 dp를 INF로 초기화
    for(int i = 0; i < k + 1; i++) {
      dp[i] = INF;
    }
    dp[0] = 0; // 0번째는 0으로 초기화

    int[] money = new int[n];
    for(int i = 0; i < n; i++) {
      money[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(money); // 혹시 금액이 오름차순으로 들어오지 않았다면

    for(int i = 0; i < n; i++) {
      for(int j = 1; j < k + 1; j++) {
        if(j - money[i] >= 0) { // 현재 무게가 해당 동전을 사용해서 만들 수 있는 무게라면
          dp[j] = Math.min(dp[j-money[i]] + 1, dp[j]); // 비교해서 최소값 사용
        }
      }
    }

    if(dp[k] == INF)
      System.out.println(-1);
    else
      System.out.println(dp[k]);
  }
}
