import java.util.*;
import java.io.*;

class Fire{
    int r, c, m, d, s;

    Fire(int row, int col, int mass, int dir, int speed){
        this.r = row;
        this.c = col;
        this.m = mass;
        this.d = dir;
        this.s = speed;
    }
}

class Main{
   static int N, M, K;
   static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
   static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
   static int[][] cnt, sumSpeed, sumMass, dir;
   static boolean[][] oddDir, evenDir;
   static Queue<Fire> fireBalls = new LinkedList<>();

   public static void after(){
       for(int i=0; i<N; i++){
           for(int j=0; j<N; j++){
               if(cnt[i][j]==1){
                   fireBalls.offer(new Fire(i, j, sumMass[i][j], dir[i][j], sumSpeed[i][j]));
               }
               else if(cnt[i][j]>=2){
                   if(sumMass[i][j]/5>0){
                       int startDir;
                       if(oddDir[i][j] && evenDir[i][j]){
                           startDir = 1;
                       }
                       else
                           startDir = 0;

                       for(int k=0; k<4; k++){
                           fireBalls.offer(new Fire(i, j, sumMass[i][j]/5, startDir+k*2, sumSpeed[i][j]/cnt[i][j]));
                       }
                       sumMass[i][j] = 4*(sumMass[i][j]/5);
                       sumSpeed[i][j] = 4*(sumSpeed[i][j]/cnt[i][j]);
                       cnt[i][j] = 4;
                   }
                   else{
                       sumMass[i][j] = 0;
                       sumSpeed[i][j] = 0;
                       cnt[i][j] = 0;
                   }
               }
           }
       }
   }

   public static void move(){
        evenDir = new boolean[N][N];
        oddDir = new boolean[N][N];

        while(!fireBalls.isEmpty()){
            Fire fire = fireBalls.poll();

            int nr = (N + (fire.s%N)*dr[fire.d] + fire.r) % N;
            int nc = (N  + (fire.s%N)*dc[fire.d] + fire.c) % N;


            cnt[fire.r][fire.c]--;
            cnt[nr][nc]++;
            sumMass[fire.r][fire.c] -= fire.m;
            sumMass[nr][nc] += fire.m;
            sumSpeed[fire.r][fire.c] -= fire.s;
            sumSpeed[nr][nc] += fire.s;
            dir[nr][nc] = fire.d;

            if(fire.d%2==0)
                evenDir[nr][nc] = true;
            else
                oddDir[nr][nc] = true;
        }

   }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        cnt = new int[N][N];
        sumMass = new int[N][N];
        sumSpeed = new int[N][N];
        dir = new int[N][N];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            cnt[r][c] = 1;
            sumSpeed[r][c] += s;
            sumMass[r][c] += m;
            fireBalls.offer(new Fire(r, c, m, d, s));
        }

        for(int i=0; i<K; i++){
            move();
            after();
        }

        int ans=0;
        for (Fire fireBall : fireBalls) {
            ans += fireBall.m;
        }

        System.out.println(ans);
    }
}