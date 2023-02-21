import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] indegree = new int[N+1];
        List<Integer>[] graph = new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            graph[first].add(second);
            indegree[second]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++){
            if(indegree[i]==0)
                queue.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            int cur = queue.poll();
            sb.append(cur).append(" ");

            if(graph[cur].size()>0){
                for(int j=0; j<graph[cur].size(); j++){
                    if(--indegree[graph[cur].get(j)]==0)
                        queue.offer(graph[cur].get(j));
                }
            }
        }

        System.out.println(sb);
    }
}
