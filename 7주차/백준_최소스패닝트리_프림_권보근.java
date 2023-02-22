import java.io.*;
import java.util.*;

/**
 * Prim - 간선이 많은 경우 -> 정점 활용
 * O(E*logV)
 */
public class Main {
    static int V, E;
    static ArrayList<Node>[] adj;
    static boolean[] visited;
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    static class Node implements Comparable<Node> {
        int vertex, cost;

        Node(int v, int c){
            this.vertex = v;
            this.cost = c;
        }

        @Override
        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        visited = new boolean[V+1];
        adj = new ArrayList[V+1];
        for(int i=1; i<=V; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adj[from].add(new Node(to, cost));
            adj[to].add(new Node(from, cost));
        }

        int sum = 0;
        int cnt = 0;

        pq.offer(new Node(1, 0));
        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(visited[cur.vertex])
                continue;

            sum += cur.cost;
            visited[cur.vertex] = true;
            cnt++;

            if(cnt==V){
                System.out.println(sum);
                return;
            }


            for(Node next : adj[cur.vertex]){
                if(visited[next.vertex])
                    continue;

                pq.offer(next);
            }
        }

        System.out.println(sum);
    }
}
