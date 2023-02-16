import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] card = new int[N+1];
        int[] dp = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            card[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=N; i++){
            dp[i] = card[i];
            for(int j=1; j<i; j++){
                dp[i] = Math.max(dp[i], dp[i-j] + dp[j]);
            }
        }

        System.out.println(dp[N]);
    }
}
