import java.util.*;
import java.io.*;


class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Set<Integer> set = new HashSet<>();
        int[] dp = new int[K+1];

        Arrays.fill(dp, (int)1e9);
        dp[0] = 0;

        for(int i=0; i<N; i++){
            set.add(Integer.parseInt(br.readLine()));
        }

        Integer[] coins = set.toArray(new Integer[0]);
        Arrays.sort(coins);

        for(int i=0; i<coins.length; i++){
            for(int j=coins[i]; j<=K; j++){

                dp[j] = Math.min(dp[j-coins[i]] + 1, dp[j]);
            }
        }

        if(dp[K]==(int)1e9)
            System.out.println(-1);
        else
            System.out.println(dp[K]);
    }
}
