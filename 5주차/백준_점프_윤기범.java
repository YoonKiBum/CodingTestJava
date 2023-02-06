import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n][n];
        long[][] dp = new long[n][n];
        int[] dx = {0, 1};
        int[] dy = {1, 0};

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(dp[i][j] != 0) {
                    for(int k = 0; k < 2; k++) {
                        if(graph[i][j] == 0)
                            continue;
                        int nx = i + graph[i][j] * dx[k];
                        int ny = j + graph[i][j] * dy[k];
                        if(nx < 0 || ny < 0 || nx >= n || ny >= n)
                            continue;
                        dp[nx][ny] += dp[i][j];
                    }
                }
            }
        }

        System.out.println(dp[n-1][n-1]);
    }
}
