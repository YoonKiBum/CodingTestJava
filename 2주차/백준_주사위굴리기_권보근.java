import java.util.*;
import java.io.*;

public class Main {
    static int N, M, r, c, K;
    static int[][] map;
    static int[] roll; // 굴리는 명령
    static int[] dice = new int[6];

    public static void copy(){
        if(map[r][c] == 0){
            map[r][c] = dice[5];
        }
        else{
            dice[5] = map[r][c];
            map[r][c] = 0;
        }
    }

    public static void rollDice(int dir){
        int up = dice[0], back = dice[1], right = dice[2], left = dice[3], front = dice[4], down = dice[5];
        int nr = 0, nc = 0;

        if(dir == 1){ // 동쪽
            nr = r;
            nc = c+1;

            if(nr < 0 || nr >= N || nc < 0 || nc >= M)
                return;

            dice[0] = left;
            dice[2] = up;
            dice[3] = down;
            dice[5] = right;

            r = nr;
            c = nc;

            copy();
        }
        else if(dir == 2){ // 서쪽
            nr = r;
            nc = c-1;

            if(nr < 0 || nr >= N || nc < 0 || nc >= M)
                return;

            dice[0] = right;
            dice[2] = down;
            dice[3] = up;
            dice[5] = left;

            r = nr;
            c = nc;

            copy();
        }
        else if(dir ==3){ // 북쪽
            nr = r-1;
            nc = c;

            if(nr < 0 || nr >= N || nc < 0 || nc >= M)
                return;

            dice[0] = front;
            dice[1] = up;
            dice[4] = down;
            dice[5] = back;

            r = nr;
            c = nc;

            copy();
        }
        else{ // 남쪽
            nr = r+1;
            nc = c;

            if(nr < 0 || nr >= N || nc < 0 || nc >= M)
                return;

            dice[0] = back;
            dice[1] = down;
            dice[4] = up;
            dice[5] = front;

            r = nr;
            c = nc;

            copy();
        }

        System.out.println(dice[0]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        roll = new int[K];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++){
            roll[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dice, 0);

        for(int i=0; i<K; i++){
            rollDice(roll[i]);
        }
    }
}
