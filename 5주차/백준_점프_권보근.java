import java.util.*;
import java.io.*;


class Main {
    static int N;
    static long[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new long[N][N];
        dp[0][0] = 1L;

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++){
                int move = Integer.parseInt(st.nextToken());

                if(dp[i][j]>=1 && move!=0){
                    if(i+move<N)
                        dp[i+move][j] += dp[i][j];
                    if(j+move<N)
                        dp[i][j+move] += dp[i][j];
                }
            }
        }

        System.out.println(dp[N-1][N-1]);
    }
}
