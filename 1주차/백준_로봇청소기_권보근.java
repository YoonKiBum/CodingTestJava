import java.util.*;
import java.io.*;

public class Main{
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};
    static int N, M, cnt;

    public static int turnLeft(int d){
        if(d == 0)
            return 3;
        else
            return d-1;
    }

    public static void dfs(int r, int c, int d){
        int nd = d;

        // 네 방향 모두 청소 확인
        for(int i=0; i<4; i++){
            int nr = r + dr[nd];
            int nc = c + dc[nd];

            // 벽이거나, 이미 청소한 경우 다음 방향으로
            if(map[nr][nc] == 1 || visited[nr][nc] == true){
                nd = turnLeft(nd);
                continue;
            }

            // 청소할 공간 발견
            if(visited[nr][nc] == false && map[nr][nc] == 0){
                visited[nr][nc] = true; //청소
                cnt++;
                dfs(nr, nc, turnLeft(nd));
            }
        }

        // 뒤쪽으로 이동
        int br = r + dr[(d+3)%4];
        int bc = c + dc[(d+3)%4];

        if(map[br][bc] ==0){
            dfs(br, bc, d);
        }
        else {
            System.out.println(cnt);
            System.exit(0);
        }
    }

    public static void main(String args[]) throws IOException{
        int r, c, d;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                visited[i][j] = false;
            }
        }

        cnt = 1; // 처음 청소
        visited[r][c] = true; //청소
        dfs(r, c, d);
        System.out.println(cnt);
    }
}