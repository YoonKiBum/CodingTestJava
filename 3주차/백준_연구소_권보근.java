import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

class Node{
    int r, c;
    Node(int row, int column){
        this.r = row;
        this.c = column;
    }
}

public class Main{
    static int N, M;
    static int safeCnt=0;
    static int map[][];
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static Queue<Node> virus = new LinkedList<>();

    public static void dfs(int start, int depth){
        if(depth == 3){
            bfs();
            return;
        }

        for(int i=start; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    dfs(i, depth+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void bfs(){
        int virusMap[][] = new int[N][M];
        Queue<Node> tmp = new LinkedList<>(virus);

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
               virusMap[i][j] = map[i][j];
            }
        }

        while(!tmp.isEmpty()){
            Node current = tmp.poll();

            for(int i=0; i<4; i++){
                int nr = current.r + dr[i];
                int nc = current.c + dc[i];

                if(nr<0 || nr>=N || nc<0 || nc>=M || virusMap[nr][nc]!=0)
                    continue;

                virusMap[nr][nc] = 2;
                tmp.offer(new Node(nr, nc));
            }
        }

        int count=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(virusMap[i][j] == 0)
                    count++;
            }
        }

        safeCnt = Math.max(safeCnt, count);
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
                if(map[i][j] == 2)
                    virus.add(new Node(i, j));
            }
        }

        dfs(0, 0);

        System.out.println(safeCnt);
    }
}