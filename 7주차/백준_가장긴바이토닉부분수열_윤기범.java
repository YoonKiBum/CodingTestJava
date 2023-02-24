import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    int[] dp = new int[n];
    int[] dp2 = new int[n];
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    for(int i = 0; i < n; i++) {
      dp[i] = 1;
    }

    int start = 0;
    // 가장 긴 증가하는 부분 수열
    for(int i = 0; i < n; i++) {
      for(int j = i + 1; j < n; j++) {
        if(arr[j] > arr[i]) {
          dp[j] = Math.max(dp[j], dp[i] + 1);
        }
      }
    }
    // System.out.println(Arrays.toString(dp));
    
    dp2 = new int[n];
    for(int i = 0; i < n; i++) {
      dp2[i] = 1;
    }
    
    // 가장 긴 감소하는 부분 수열
    for(int i = n-1; i >= 0; i--) {
      for(int j = i - 1; j >= 0; j--) {
        if(arr[j] > arr[i]) {
          dp2[j] = Math.max(dp2[j], dp2[i] + 1);
        }
      }
    }
    // System.out.println(Arrays.toString(dp2));

    int ans = 0;
    for(int i = 0; i < n; i++) {
      ans = Math.max(ans, dp[i] + dp2[i]);
    }
    System.out.println(ans - 1);
  }
}

