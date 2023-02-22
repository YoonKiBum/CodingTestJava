import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] box = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = 0;
        for(int i=0; i<N; i++){
            box[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;

            for(int j=0; j<i; j++){
                if(box[j]<box[i])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
            
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }
}
