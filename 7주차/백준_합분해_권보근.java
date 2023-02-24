import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[][] dp = new long[K][N+1];
        Arrays.fill(dp[0], 1);

        for(int i=1; i<K; i++){
            dp[i][0] = 1;

            for(int j=1; j<=N; j++){
                for(int k=0; k<=j; k++){
                    dp[i][j] += dp[i-1][k];
                }
                dp[i][j] = dp[i][j]%1000000000;
            }
        }

        System.out.println(dp[K-1][N]);
    }
}
