import com.sun.security.jgss.GSSUtil;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int N, M, K;
    static long[][] dp;

    public static long dfs(int row, int col, int desRow, int desCol){
        if(dp[row][col]!=-1)
            return dp[row][col];
        else if(row==desRow && col==desCol)
            return 1;

        dp[row][col] = 0;

        if(row+1<=desRow && col<=desCol)
            dp[row][col] += dfs(row+1, col, desRow, desCol);

        if(row<=desRow && col+1<=desCol)
            dp[row][col] += dfs(row, col+1, desRow, desCol);

        return dp[row][col];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new long[N][M];
        for(int i=0; i<N; i++){
            Arrays.fill(dp[i], -1);
        }

        if(K==0){
            System.out.println(dfs(0, 0, N-1, M-1));
        }
        else{
            int rowK = K/M;
            int colK = K%M;

            if(colK==0) {
                colK = M - 1;
                rowK--;
            }
            else
                colK -= 1;

            System.out.println(dfs(0, 0, rowK, colK)*dfs(rowK, colK, N-1, M-1));
        }
    }
}
