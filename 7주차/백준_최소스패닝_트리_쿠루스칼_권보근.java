import java.io.*;
import java.util.*;

/**
 * Kruskal - 간선이 적은 경우
 */
public class Main {
    static int V, E;
    static int[] parents;
    static ArrayList<Edge> edges = new ArrayList<>();

    static class Edge implements Comparable<Edge> {
        int from, to, cost;

        Edge(int f, int t, int c){
            this.from  = f;
            this.to = t;
            this.cost = c;
        }

        @Override
        public int compareTo(Edge e){
            return this.cost - e.cost;
        }
    }

    public static void makeParents(){
        for(int i=1; i<=V; i++){
            parents[i] = i;
        }
    }

    public static int findParents(int vertex){
        if(parents[vertex]==vertex)
            return vertex;
        else {
            parents[vertex] = findParents(parents[vertex]);
            return parents[vertex];
        }
    }

    public static boolean union(int from, int to){
        int fromParent = findParents(from);
        int toParent = findParents(to);

        if(fromParent==toParent)
            return false;
        else{
            parents[fromParent] = toParent;

            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        parents = new int[V+1];
        makeParents();

        for(int e=0; e<E; e++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());;
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.add(new Edge(from, to, cost));
        }
        Collections.sort(edges);

        int cnt = 0;
        int sum = 0;
        for(int i=0; i<edges.size(); i++){
            Edge cur = edges.get(i);

            if(union(cur.from, cur.to)){
                sum += cur.cost;
                cnt++;

                if(cnt==V-1){
                    System.out.println(sum);
                    return;
                }
            }
        }

        System.out.println(sum);
    }
}
