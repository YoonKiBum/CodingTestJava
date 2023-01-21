import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main{
    static int N, M;
    static int dr[]={0, -1, 1};
    static int dc[]={1, 0, 0};
    static int sum=0;
    static int map[][];
    static boolean visited[][];

    public static void dfs(int row, int column, int value, int depth){
        if(depth == 3){
            sum = Math.max(sum, value);

            return;
        }

        int nr, nc;
        for(int i=0; i<3; i++){
            nr = row + dr[i];
            nc = column + dc[i];

            if(nr<0 || nr>=N || nc<0 || nc>=M || visited[nr][nc])
                continue;

            visited[nr][nc] = true;
            dfs(nr, nc, value + map[nr][nc], depth+1);
            visited[nr][nc] = false;

            if (depth == 1) {
                visited[nr][nc] = true;
                dfs(row, column, value + map[nr][nc], depth+1);
                visited[nr][nc] = false;
            }
        }


    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            Arrays.fill(visited[i], false);

            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                visited[i][j] = true;
                dfs(i, j, map[i][j], 0);
                visited[i][j] = false;
            }
        }

        System.out.println(sum);
    }
}