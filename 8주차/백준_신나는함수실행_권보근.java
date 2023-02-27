import java.io.*;
import java.util.*;
public class Main {
    static int[][][] dp = new int[21][21][21];
    public static int dfs(int a, int b, int c){
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        if (a > 20 || b > 20 || c > 20) {
            return dfs(20, 20, 20);
        }

        if (dp[a][b][c] != 0){
            return dp[a][b][c];
        }

        if (a<b && b<c) {
            dp[a][b][c] = dfs(a, b, c - 1) + dfs(a, b - 1, c - 1) - dfs(a, b - 1, c);
            return dp[a][b][c];
        }

        dp[a][b][c] = dfs(a - 1, b, c) + dfs(a - 1, b - 1, c) + dfs(a - 1, b, c - 1) - dfs(a - 1, b - 1, c - 1);
        return dp[a][b][c];


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a==-1 && b==-1 && c==-1)
                break;

            int ans = dfs(a, b, c);
            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(ans).append("\n");
        }

        System.out.println(sb);
    }
}
