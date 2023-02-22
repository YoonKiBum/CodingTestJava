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
    arr = new int[n];
    dp = new int[n];
    
    st =  new StringTokenizer(br.readLine(), " ");
    for(int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
  
    for(int i = 0; i < n; i++) {
      dp[i] = 1;
    }

    for(int i = 0; i < n; i++) {
      for(int j = i + 1; j < n; j++) {
       if(arr[j] > arr[i]) {
         dp[j] = Math.max(dp[j], dp[i] + 1);
       }   
      }
    }

    Arrays.sort(dp);
    System.out.println(dp[n-1]);
  }
}
