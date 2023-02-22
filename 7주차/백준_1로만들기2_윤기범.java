import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[] dp;
    public static int[] array;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        array = new int[n + 1];
        dp = new int[n + 1];

        if(n == 1) {
            System.out.println(0); // 1인 경우 바로 1 이므로 횟수는 0
            System.out.println(1); // 1인 경우 바로 1 이므로 경로는 1
            return;
        }
        for(int i = 0; i < n + 1; i++) {
            dp[i] = (int)1e9;
        }
        dp[0] = 0;
        dp[1] = 0;

        int path = 0;

        for(int i = 2; i < n + 1; i++) {
            if(i % 3 == 0) {
                dp[i] = dp[i / 3] + 1;
                path = i / 3;
            }
            if(i % 2 == 0) {
                if(dp[i] > dp[i/2] + 1)
                    path = i / 2; // path를 통하는게 더 작다면 변경
                dp[i] = Math.min(dp[i], dp[i/2] + 1);
            }
            if(dp[i] > dp[i-1] + 1)
                path = i - 1; // path를 통하는게 더 작다면 변경
            dp[i] = Math.min(dp[i], dp[i-1] + 1);
            array[i] = path;
        }
        System.out.println(dp[n]);

        int temp = n;
        sb.append(temp).append(" ");
        while(true) {
            temp = array[temp];
            sb.append(temp).append(" ");
            if(temp == 1)
                break;
        }

        System.out.print(sb);
    }
}
