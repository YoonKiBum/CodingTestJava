import java.util.*;
import java.io.*;

public class Main{
    static int N, M, K, X;

    static ArrayList<ArrayList<Integer>> adj; // 간선
    static int[] dist; // 모든 도시와 X와의 거리
    static boolean[] visited; // 방문

    public static void addEdge(int start, int dest){
        adj.get(start-1).add(dest);
    }

    public static void bfs(int X){
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.offer(X);
        visited[X-1] = true;

        while(!queue.isEmpty()){
            int cur = queue.poll();

            for(Integer next : adj.get(cur-1)){
                if(!visited[next-1]){
                    dist[next-1] = dist[cur-1] + 1;
                    queue.offer(next);
                    visited[next-1] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        adj = new ArrayList<ArrayList<Integer>>();
        dist = new int[N];
        visited = new boolean[N];

        //인접리스트, 거리 배열 초기화
        for(int i=0; i<N; i++){
            adj.add(new ArrayList<Integer>());
            dist[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            addEdge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        dist[X-1] = 0; // 자신과의 거리 0

        bfs(X);

        boolean flag = false;
        for(int i=0; i<N; i++){
            if(dist[i] == K){
                System.out.println(i+1);
                flag = true;
            }
        }

        if(!flag)
            System.out.println(-1);
    }
}