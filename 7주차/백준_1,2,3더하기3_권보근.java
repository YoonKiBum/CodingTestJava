import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());

            long[] dp = new long[N+1];

            dp[1] = 1;
            if(N>=2)
                dp[2] = 2;
            if(N>=3)
                dp[3] = 4;

            if(N>=4){
                for(int i=4; i<=N; i++){
                    dp[i] = (dp[i-1] + dp[i-2] + dp[i-3])%1000000009;
                }
            }

            sb.append(dp[N]).append("\n");
        }

        System.out.println(sb);
    }
}
