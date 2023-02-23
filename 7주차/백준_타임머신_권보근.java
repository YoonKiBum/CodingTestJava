import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static int INF = Integer.MAX_VALUE;
    static ArrayList<Edge> edgeList;
    static long[] distance;

    static class Edge {
        int from, to, cost;

        Edge(int f, int t, int c){
            this.from = f;
            this.to = t;
            this.cost = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edgeList = new ArrayList<>();
        distance = new long[N+1];
        Arrays.fill(distance, INF);

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edgeList.add(new Edge(from, to, cost));
        }

        int start = 1;
        distance[start] = 0;

        // 정점의 개수만큼 반복
        for(int i=1; i<=N; i++){
            // 간선의 개수만큼 반복
            for(int j=0; j<edgeList.size(); j++){
                Edge edge = edgeList.get(j);

                // from, 즉 출발지까지 접근 할 수 없다면 continue
                if(distance[edge.from]==INF)
                    continue;

                // to까지 가는 비용보다  from까지 가는 비용 + from에서 to까지 가는 비용이 낮다면 갱신
                if(distance[edge.to]>distance[edge.from]+edge.cost){
                    // V번 째 횟수에 갱신된다면, 음수 사이클이 존재
                    if(i==N){
                        System.out.println(-1);
                        return;
                    }

                    distance[edge.to] = distance[edge.from]+edge.cost;
                }

            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=2; i<=N; i++){
            if(distance[i]==INF)
                sb.append(-1).append("\n");
            else
                sb.append(distance[i]).append("\n");
        }

        System.out.println(sb);
    }
}
