import java.util.*;
import java.io.*;
import java.lang.Math;

class Node implements Comparable<Node> {
        int num, cost;
        
        Node(int num, int cost){
            this.num = num;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node o){
            return Integer.compare(this.cost, o.cost);
        }
    }

public class Main{
    static int INF = (int)1e9;
    static int distances[];
    static ArrayList<Node> adj[];
    
    public static void dijkstra(Node start){
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        
        distances[start.num] = 0;
        pq.offer(start);
        
        while(!pq.isEmpty()){
            Node current = pq.poll();
            if(distances[current.num] < current.cost) continue;  // 이미 처리된 노드

            for(Node next : adj[current.num]){
                if(distances[next.num] > distances[current.num] + next.cost){
                    distances[next.num] = distances[current.num] + next.cost;
                    
                    pq.offer(new Node(next.num, distances[next.num]));
                }                
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        int route1, route2;
        int N, E, V1, V2;
        int startV1, startV2, V1V2, V1N, V2N;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        
        distances = new int[N+1];
        adj = new ArrayList[N+1];
        
        for(int i=0; i<N+1; i++){
            adj[i] = new ArrayList<Node>();
            distances[i] = INF;
        }
        
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            adj[a].add(new Node(b, c));
            adj[b].add(new Node(a, c));
        }
        
        st = new StringTokenizer(br.readLine());
        V1 = Integer.parseInt(st.nextToken());
        V2 = Integer.parseInt(st.nextToken());
        
        Node node = new Node(1, 0);
        dijkstra(node);
        
        startV1 = distances[V1];
        startV2 = distances[V2];
        
        Arrays.fill(distances, INF);
        node = new Node(V1, 0);
        dijkstra(node);
        
        V1V2 = distances[V2];
        V1N = distances[N];
        
        Arrays.fill(distances, INF);
        node = new Node(V2, 0);
        dijkstra(node);
        
        V2N = distances[N];
        
        // route1 = 1 -> v1 -> v2 -> N
        if(startV1==INF || V1V2 == INF || V2N==INF)
            route1 = INF;
        else
            route1 = startV1 + V1V2 + V2N;
        
        // route2 = 1 -> v2 -> v1 -> N
        if(startV2==INF || V1V2 == INF || V1N==INF)
            route2 = INF;
        else
            route2 = startV2 + V1V2 + V1N;
        
        if(route1 == INF && route2 == INF)
            System.out.println(-1);
        else
            System.out.println(Math.min(route1, route2));
    }
}