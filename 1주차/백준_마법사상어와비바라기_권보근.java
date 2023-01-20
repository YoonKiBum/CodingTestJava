import java.util.*;
import java.io.*;

class Cloud{
    int r, c;

    Cloud(int row, int column){
        this.r = row;
        this.c = column;
    }
}

public class Main {
    static int N;
    static int M;
    static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};
    static boolean[][] exists;
    static int[][] basket;
    static Queue<Cloud> clouds = new LinkedList<>();

    public static void makeClouds(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(basket[i][j] >= 2 && !exists[i][j]){
                    clouds.offer(new Cloud(i, j));
                    exists[i][j] = true;
                    basket[i][j] -= 2;
                }
                else if(exists[i][j])
                    exists[i][j] = false;
            }
        }
    }

    public static void copy(Queue<Cloud> temp){
        int count, nr, nc;

        while(!temp.isEmpty()){
            count = 0;
            Cloud c = temp.poll();
            exists[c.r][c.c] = true;

            for(int i=1; i<8; i+=2){
                nr = c.r + dr[i];
                nc = c.c + dc[i];

                if(nr<0 || nr >=N || nc <0 || nc>=N)
                    continue;

                if(basket[nr][nc] > 0)
                    count++;
            }
            basket[c.r][c.c] += count;
        }
    }

    public static void move(int dir, int distance){
        int nr=0, nc=0;

        Queue<Cloud> temp = new LinkedList<>();

        while(!clouds.isEmpty()){
            Cloud c= clouds.poll();

            nr = (N + c.r + (distance%N)*dr[dir-1])%N;
            nc = (N + c.c + (distance%N)*dc[dir-1])%N;

            basket[nr][nc] += 1;
            exists[c.r][c.c] = false;

            temp.offer(new Cloud(nr, nc));
        }
        copy(temp);
        makeClouds();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        basket = new int[N][N];
        exists = new boolean[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            Arrays.fill(exists[i], false);
            for(int j=0; j<N; j++){
                basket[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 초기 구름
        clouds.offer(new Cloud(N-1, 0));
        clouds.offer(new Cloud(N-1, 1));
        clouds.offer(new Cloud(N-2, 0));
        clouds.offer(new Cloud(N-2, 1));
        exists[N-1][0] = true;
        exists[N-1][1] = true;
        exists[N-2][0] = true;
        exists[N-2][1] = true;



        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            move(dir, distance);
        }

        int answer=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(basket[i][j]>0)
                    answer += basket[i][j];
            }
        }
        System.out.println(answer);
    }
}