import java.util.*;
import java.io.*;

class CCTV{
    int r, c;
    CCTV(int row, int column){
        this.r = row;
        this.c = column;
    }
}

public class Main{
    static int N, M;
    static int[][] map;
    static List<CCTV> cctvs = new ArrayList<>();
    static int ans = (int)1e9;

    public static int[][] copy(){
        int[][] copy = new int[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                copy[i][j] = map[i][j];
            }
        }
        return copy;
    }

    public static void fill(int r, int c, int dir){
        if(dir==0){
            for(int i=r-1; i>=0; i--) {
                if (map[i][c] == 6)
                    return;

                if (map[i][c] == 0)
                    map[i][c] = 7;
            }
        }
        else if(dir==1){
            for(int i=c+1; i<M; i++){
                if(map[r][i] == 6)
                    return;

                if(map[r][i] == 0)
                    map[r][i] = 7;
            }
        }
        else if(dir == 2){
            for(int i=r+1; i<N; i++){
                if(map[i][c] == 6)
                    return;

                if(map[i][c] == 0)
                    map[i][c] = 7;
            }
        }
        else{
            for(int i=c-1; i>=0; i--){
                if(map[r][i] == 6)
                    return;

                if(map[r][i] == 0)
                    map[r][i] = 7;
            }
        }
    }

    public static void rollback(int[][] copy){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                map[i][j] = copy[i][j];
            }
        }
    }


    public static void dfs(int depth){
        if(depth == cctvs.size()){
            int count = 0;

            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(map[i][j] == 0)
                        count++;
                }
            }

            ans = Math.min(ans, count);
            return;
        }

        CCTV cctv = cctvs.get(depth);
        int dir = map[cctv.r][cctv.c];

        if(dir == 1){
            for(int i=0; i<4; i++){
                int[][] copy = copy();
                fill(cctv.r, cctv.c, i);
                dfs(depth+1);
                rollback(copy);
            }
        }
        else if(dir == 2){
            for(int i=0; i<2; i++){
                int[][] copy = copy();
                fill(cctv.r, cctv.c, i);
                fill(cctv.r, cctv.c, i+2);
                dfs(depth+1);
                rollback(copy);
            }
        }
        else if(dir == 3){
            for(int i=0; i<4; i++){
                int[][] copy = copy();
                if(i==3){
                    fill(cctv.r, cctv.c, i);
                    fill(cctv.r, cctv.c, 0);
                    dfs(depth+1);
                }
                else{
                    fill(cctv.r, cctv.c, i);
                    fill(cctv.r, cctv.c, i+1);
                    dfs(depth+1);
                }
                rollback(copy);
            }

        }
        else if(dir == 4){
            for(int i=0; i<4; i++){
                int[][] copy = copy();
                for(int j=0; j<4; j++){
                    if(j!=i)
                        fill(cctv.r, cctv.c, j);
                }
                dfs(depth+1);
                rollback(copy);
            }
        }
        else{
            int[][] copy = copy();
            for(int i=0; i<4; i++){
                fill(cctv.r, cctv.c, i);
            }
            dfs(depth+1);
            rollback(copy);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j]>=1 && map[i][j]<=5)
                    cctvs.add(new CCTV(i, j));
            }
        }
        dfs(0);
        System.out.println(ans);
    }
}