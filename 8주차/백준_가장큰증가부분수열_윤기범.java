import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
  
    int n = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    int[] arr = new int[n];
    for(int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());  
    }

    int[] dp = new int[n];
    for(int i = 0; i < n; i++) {
      dp[i] = arr[i]; // 초기값 세팅
    }
    
    for(int i = 0; i < n; i++) {
      for(int j = i + 1; j < n; j++) {
        if(arr[j] > arr[i]) {
          dp[j] = Math.max(dp[j], arr[j] + dp[i]);
        }
      }
    }

    // System.out.println(Arrays.toString(dp));
    
    int max = Integer.MIN_VALUE;
    for(int x : dp) {
      max = Math.max(max, x);
    }
    System.out.println(max);
  }
}
