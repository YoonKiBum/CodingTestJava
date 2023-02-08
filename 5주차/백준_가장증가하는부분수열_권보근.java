import java.util.*;
import java.io.*;


class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N];
        int[] seq = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            seq[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;

            for(int j=0; j<i; j++){
                if(seq[j]<seq[i] && dp[i]<=dp[j])
                    dp[i] = dp[j]+1;
            }
        }

        int ans = 0;
        for(int i=0; i<N; i++){
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
