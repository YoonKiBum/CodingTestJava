import java.util.*;
import java.io.*;

class Node {
    int r, c;

    Node(int row, int column){
        this.r = row;
        this.c = column;
    }
}

public class Main{
    static int N, L, R;
    static boolean[][] visited;
    static ArrayList<Node>[] adj;
    static int[][] graph;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int cnt=0;
    static boolean flag = true;

    public static void addLine(){
        flag = false;

        adj = new ArrayList[N*N];
        for(int i=0; i<N*N; i++){
            adj[i] = new ArrayList<Node>();
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<4; k++){
                    int nr = i + dr[k];
                    int nc = j + dc[k];

                    if(nr<0 || nr>=N || nc <0 || nc>=N)
                        continue;
                    else{
                        int population = Math.abs(graph[i][j] - graph[nr][nc]);
                        if(population>= L && population<=R){
                            adj[i*N + j].add(new Node(nr, nc));
                            flag = true;
                        }
                    }
                }
            }
        }
    }

    public static void fill(int shareCnt, int sharePopulation){
        int fill = sharePopulation/shareCnt;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(graph[i][j] == (int)1e9){
                    graph[i][j] = fill;
                }
            }
        }
    }

    public static void bfs(int r, int c){
        Queue<Node> queue = new LinkedList<>();
        int shareCnt=0, sharePopulation=0;

        queue.offer(new Node(r, c));

        while(!queue.isEmpty()){
            Node current = queue.poll();

            if(visited[current.r][current.c])
                continue;
            else{
                visited[current.r][current.c] = true;
                shareCnt++;
                sharePopulation += graph[current.r][current.c];
                graph[current.r][current.c] = (int)1e9;

                for(Node node : adj[current.r*N+ current.c]){
                    queue.offer(node);
                }
            }
        }

        fill(shareCnt, sharePopulation);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        visited = new boolean[N][N];
        graph =  new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(flag){
            addLine();

            if(flag){
                for(int i=0; i<N; i++){
                    Arrays.fill(visited[i], false);
                }
                for(int i=0; i<N; i++){
                    for(int j=0; j<N; j++){
                        if(!visited[i][j] && adj[i*N + j].size() != 0){
                            bfs(i, j);
                        }
                    }
                }
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}