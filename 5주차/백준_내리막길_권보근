import java.util.*;
import java.io.*;


class Main {
    static int N, M;
    static int[][] map;
    static int[][] dp;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static int dfs(int row, int col){
        if(row==M-1 && col==N-1)
            return 1;

        if(dp[row][col]==-1){
            dp[row][col] = 0;

            for(int i=0; i<4; i++){
                int nr = row + dr[i];
                int nc = col + dc[i];

                if(nr<0 || nr>=M || nc<0 || nc>=N)
                    continue;

                if(map[row][col]>map[nr][nc]){
                    dp[row][col] += dfs(nr, nc);
                }
            }
        }

        return dp[row][col];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        dp = new int[M][N];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0, 0));

    }
}
