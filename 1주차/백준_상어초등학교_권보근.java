import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int likeCnt, emptyCnt, row, column;

    Node(int l, int e, int r, int c){
        this.likeCnt = l;
        this.emptyCnt = e;
        this.row = r;
        this.column = c;
    }

    @Override
    public int compareTo(Node o) {
        if(this.likeCnt > o.likeCnt)
            return -1;
        else if (this.likeCnt < o.likeCnt)
            return 1;
        else {
            if(this.emptyCnt > o.emptyCnt)
                return -1;
            else if (this.emptyCnt < o.emptyCnt) {
                return 1;
            } else {
                if (this.row < o.row)
                    return -1;
                else if (this.row > o.row)
                    return 1;
                else {
                    if(this.column < o.column)
                        return -1;
                    else
                        return 1;
                }
            }
        }
    }
}

public class Main{
    static int N;
    static int[][] map;
    static int[][] like;
    static int[] order;
    static int score = 0;
    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};

    public static void batchStudent(int num){
        int[] studentLike = like[num-1];

        int likeCnt;
        int emptyCnt;
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                likeCnt = 0;
                emptyCnt = 0;

                if(map[i][j] != 0) continue; //이미 자리가 있는 경우 넘어감

                for(int k=0; k<4; k++){
                    int nr = i + dr[k];
                    int nc = j + dc[k];

                    if(nr < 0 || nr >= N || nc <0 || nc >= N)
                        continue;
                    else{
                        if(map[nr][nc] == 0)
                            emptyCnt++;
                        else {
                            for(int l=0; l<4; l++){
                                if(map[nr][nc] == studentLike[l])
                                    likeCnt++;
                            }
                        }
                    }
                }

                Node node = new Node(likeCnt, emptyCnt, i, j);
                pq.offer(node);
            }
        }

        Node best = pq.poll();
        map[best.row][best.column] = num;
    }

    public static void calc(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                int cnt=0;

                for(int k=0; k<4; k++){
                    int nr = i + dr[k];
                    int nc = j + dc[k];

                    if(nr < 0 || nr >= N || nc <0 || nc >= N)
                        continue;
                    else{
                       for(int l=0; l<4; l++){
                           if(like[map[i][j]-1][l] == map[nr][nc])
                               cnt++;
                       }
                    }
                }

                if(cnt == 1)
                    score += 1;
                else if (cnt == 2)
                    score += 10;
                else if(cnt == 3)
                    score += 100;
                else if (cnt == 4)
                    score += 1000;
            }
        }

        System.out.println(score);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for(int i=0; i<N; i++) {
            Arrays.fill(map[i], 0);
        }

        like = new int[N*N][4];
        order = new int[N*N];

        for(int i=0; i<N*N; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            for(int j=0; j<4; j++){
                like[num-1][j] = Integer.parseInt(st.nextToken());
            }

            order[i] = num;
        }

        for(int i=0; i<N*N; i++){
            batchStudent(order[i]);
        }

        calc();
    }
}