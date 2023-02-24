import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    String str1 = br.readLine();
    String str2 = br.readLine();
    int n = str1.length();
    int m = str2.length();
    int[][] dp = new int[n+1][m+1];
    
    for(int i = 0; i < m + 1; i++) {
      dp[0][i] = 0;
    }
    for(int i = 0; i < n + 1; i++) {
      dp[i][0] = 0;
    }

    for(int i = 1; i < n + 1; i++) {
      for(int j = 1; j < m + 1; j++) {
        if(str1.charAt(i-1) == str2.charAt(j-1))
          dp[i][j] = dp[i-1][j-1] + 1;
        else
          dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
      }
    }

    System.out.println(dp[n][m]);
  }
}

