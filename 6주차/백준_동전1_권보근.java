import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[K+1];

        dp[0] = 1; // 가치 = 동전인 경우

        for(int i=1; i<=N; i++){
            int coin = Integer.parseInt(br.readLine());

            for(int j=coin; j<=K; j++){
                dp[j] = dp[j] + dp[j-coin];
            }
        }

        System.out.println(dp[K]);
    }
}
