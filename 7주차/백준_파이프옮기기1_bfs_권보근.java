import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[][] map;

    static class Pipe {
        int row, col, dir; // dir 1: 가로 2: 세로 3: 대각

        Pipe(int r, int c, int d){
            this.row = r;
            this.col = c;
            this.dir = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map =  new int[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        if(map[N-1][N-1]==1) {
            System.out.println(0);
            return;
        }

        Queue<Pipe> pq = new LinkedList<>();
        pq.offer(new Pipe(0, 1, 1));

        int ans = 0;
        while(!pq.isEmpty()){
            Pipe cur = pq.poll();

            if(cur.row==N-1 && cur.col==N-1){
                ans++;
                continue;
            }

            int left_row = cur.row;
            int left_col = cur.col + 1;
            int under_row = cur.row + +1;
            int under_col = cur.col;
            int diagonal_row = cur.row + 1;
            int diagonal_col = cur.col + 1;

            if(cur.dir==1){
                if(left_col<N){
                    if(map[left_row][left_col]==0) {
                        pq.offer(new Pipe(left_row, left_col, 1));
                    }
                }

                if(diagonal_row<N && diagonal_col<N){
                    if(map[diagonal_row][diagonal_col]==0 && map[left_row][left_col]==0 && map[under_row][under_col]==0) {
                        pq.offer(new Pipe(diagonal_row, diagonal_col, 3));
                    }
                }
            }
            else if(cur.dir==2){
                if(under_row<N-1 || (under_col==N-1 && under_row<N)){
                    if(map[under_row][under_col]==0){
                        pq.offer(new Pipe(under_row, under_col, 2));
                    }
                }

                if(diagonal_row<N && diagonal_col<N){
                    if(map[diagonal_row][diagonal_col]==0 && map[left_row][left_col]==0 && map[under_row][under_col]==0) {
                        pq.offer(new Pipe(diagonal_row, diagonal_col, 3));
                    }
                }
            }
            else{
                if(left_col<N){
                    if(map[left_row][left_col]==0) {
                        pq.offer(new Pipe(left_row, left_col, 1));
                    }
                }

                if(under_row<N-1 || (under_col==N-1 && under_row<N)){
                    if(map[under_row][under_col]==0){
                        pq.offer(new Pipe(under_row, under_col, 2));
                    }
                }

                if(diagonal_row<N && diagonal_col<N){
                    if(map[diagonal_row][diagonal_col]==0 && map[left_row][left_col]==0 && map[under_row][under_col]==0) {
                        pq.offer(new Pipe(diagonal_row, diagonal_col, 3));
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
