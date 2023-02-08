import java.util.*;
import java.io.*;

public class Main {  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    int[] dp = new int[n];
    int max = 0;
    
    st = new StringTokenizer(br.readLine(), " ");
    for(int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      dp[i] = 1; // 전체 dp 배열 1로 초기화(모든 숫자는 그 자체로 크기가 1인 증가하는 부분 수열이기 때문)
    }

    for(int i = 0; i < n; i++) {
      for(int j = i + 1; j < n; j++) {
        if(arr[j] > arr[i]) // arr[j]가 arr[i]보다 크다면 해당 dp[j]에 dp[i] + 1 하기
          dp[j] = Math.max(dp[j], dp[i] + 1); // 그 중 최대값 유지
      }
    }

    for(int a : dp) {
      if(max < a)
          max = a;
    }

    System.out.println(max);
  }  
}
