import java.util.*;
import java.io.*;

public class BellmanFord {
    public static int n, m;
    public static final int INF = (int)1e9;
    public static long[] distance;
    public static ArrayList<Node> arr = new ArrayList<>();

    static class Node {
        int nodeA;
        int nodeB;
        int cost;

        public Node(int nodeA, int nodeB, int cost) {
            this.nodeA = nodeA;
            this.nodeB = nodeB;
            this.cost = cost;
        }
    }

    public static boolean bf(int start) {
        distance[start] = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                Node node = arr.get(j);
                int curNode = node.nodeA;
                int nextNode = node.nodeB;
                int cost = node.cost;
                // 현재 간선을 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
                if(distance[curNode] != INF && distance[nextNode] > distance[curNode] + cost) {
                    distance[nextNode] = distance[curNode] + cost;
                    // n번째 라운드에서도 값이 갱신된다면 음수 순환이 존재
                    if (i == n-1)
                        return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        distance = new long[n + 1];
        for(int i = 0; i < n + 1; i++) {
            distance[i] = INF;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            arr.add(new Node(nodeA, nodeB, cost));
        }

        boolean negativeCycle = bf(1);

        if(negativeCycle) {
            System.out.println(-1);
        } else {
            for(int i = 2; i < n + 1; i++) {
                if(distance[i] == INF)
                    System.out.println("-1");
                else
                    System.out.println(distance[i]);
            }
        }
    }
}

