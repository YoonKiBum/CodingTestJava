import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[][] map;
    static int ans = 0;

    public static void dfs(int row, int col, int dir){
        if(row==N-1 && col==N-1) {
            ans++;
            return;
        }

        // 가로로 놓기 위해서
        if(dir==0 || dir==2){
            if(col+1<N && map[row][col+1]==0)
                dfs(row, col+1, 0);
        }
        //세로로 놓기 위해서
        if(dir==1 || dir==2){
            if(row+1<N && map[row+1][col]==0)
                dfs(row+1, col, 1);
        }

        // 대각선으로 놓기 위해서
        if(dir==0 || dir==1 || dir==2){
            if(row+1<N && col+1<N){
                if(map[row+1][col]==0 && map[row][col+1]==0 && map[row+1][col+1]==0)
                    dfs(row+1, col+1, 2);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 1, 0);

        System.out.println(ans);
    }
}
