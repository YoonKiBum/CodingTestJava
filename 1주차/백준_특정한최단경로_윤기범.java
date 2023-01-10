import java.util.*;
import java.io.*;

public class Main {
    public static int n, e, v1, v2, INF = (int)1e9;
    public static long ans = 0, ans2 = 0;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    public static int[] distance;

    static class Node implements Comparable<Node> {
        int node;
        int dist;

        public Node(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }

    // 다익스트라 함수
    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        distance[start] = 0;
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.node;
            int dist = node.dist;
            if(distance[now] < dist)
                continue;
            for(int i = 0; i < graph.get(now).size(); i++) {
                int cost = dist + graph.get(now).get(i).dist;
                if(cost < distance[graph.get(now).get(i).node]) {
                    distance[graph.get(now).get(i).node] = cost;
                    pq.offer(new Node(graph.get(now).get(i).node, cost));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        distance = new int[n + 1];
        for(int i = 0; i < n + 1; i++){
            distance[i] = INF;
        }

        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine(), " ");
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        // ans : 1 -> v1 -> v2 -> N 경우
        // ans2 : 1 -> v2 -> v1 -> N 경우
        dijkstra(1);
        ans += distance[v1];
        ans2 += distance[v2];

        // distance 배열 초기화
        for(int i = 0; i < n + 1; i++){
            distance[i] = INF;
        }
        dijkstra(v1);
        ans += distance[v2];
        ans2 += distance[n];

        // distance 배열 초기화
        for(int i = 0; i < n + 1; i++){
            distance[i] = INF;
        }
        dijkstra(v2);
        ans += distance[n];
        ans2 += distance[v1];

        long answer = Math.min(ans, ans2);
        if (answer >= INF)
            System.out.println(-1);
        else
            System.out.println(answer);
    }
}
