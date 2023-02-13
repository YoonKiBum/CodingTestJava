import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int A = 0, B = 0;
        int x = 0, y = 0;

        int[][] arr = new int[n][m];
        int num = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr[i][j] = num;
                num += 1;
                if(arr[i][j] == k) {
                    x = i;
                    y = j;
                }
            }
        }

        int[][] dp = new int[n][m];
        dp[0][0] = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(i == n-1 && j == m-1)
                    continue;
                if(j == m-1) // 마지막 열
                    dp[i+1][j] += dp[i][j];
                else if(i == n-1) // 마지막 행
                    dp[i][j+1] += dp[i][j];
                else {
                    dp[i][j+1] += dp[i][j];
                    dp[i+1][j] += dp[i][j];
                }
            }
        }

        A = dp[x][y];

        dp = new int[n][m];
        dp[x][y] = 1;
        for(int i = x; i < n; i++) {
            for(int j = y; j < m; j++) {
                if(i == n-1 && j == m-1)
                    continue;
                if(j == m-1) // 마지막 열
                    dp[i+1][j] += dp[i][j];
                else if(i == n-1) // 마지막 행
                    dp[i][j+1] += dp[i][j];
                else {
                    dp[i][j+1] += dp[i][j];
                    dp[i+1][j] += dp[i][j];
                }
            }
        }

        B = dp[n-1][m-1];

        System.out.println(A * B);
    }
}
