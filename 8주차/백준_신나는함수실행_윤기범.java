import java.util.*;
import java.io.*;

public class Main {
    public static boolean[][][] visited;
    public static int[][][] dp;

    public static int func(int a, int b, int c) {
        if(a <= 50 || b <= 50 || c <= 50) {
            if(!visited[a][b][c]) {
                dp[a][b][c] = 1;
                visited[a][b][c] = true;
                return 1;
            }
            else {
                return 1;
            }
        }
        if(a > 70 || b > 70 || c > 70) {
            if(!visited[a][b][c]) {
                dp[a][b][c] = func(70, 70, 70);
                visited[a][b][c] = true;
                return dp[a][b][c];
            } else {
                return dp[a][b][c];
            }
        }
        if(a < b && b < c) {
            if(!visited[a][b][c]) {
                dp[a][b][c] = func(a, b, c - 1) + func(a, b - 1, c - 1) - func(a, b - 1, c);
                visited[a][b][c] = true;
                return dp[a][b][c];
            } else {
                return dp[a][b][c];
            }
        }
        else {
            if(!visited[a][b][c]) {
                dp[a][b][c] = func(a - 1, b, c) + func(a - 1, b - 1, c) + func(a - 1, b, c - 1) - func(a - 1, b - 1, c - 1);
                visited[a][b][c] = true;
                return dp[a][b][c];
            } else {
                return dp[a][b][c];
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        dp = new int[101][101][101];
        visited = new boolean[101][101][101];

        for(int a = -50; a <= 50; a++) {
            for (int b = -50; b <= 50; b++) {
                for(int c = -50; c <= 50; c++) {
                    func(a + 50, b + 50, c + 50);
                }
            }
        }

        while(true) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            if(x == -1 && y == -1 && z == -1)
                break;
            else {
                sb.append("w(" + x + ", " + y + ", " + z + ") = " + dp[x + 50][y + 50][z + 50]).append("\n");
            }
        }
        System.out.println(sb);
    }
}
