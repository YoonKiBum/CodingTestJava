import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int T, N, M;
    static int[][] planes;
    static int[] visited;
    static int ans;

    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();

        q.offer(start);
        visited[start] = 1;

        while(!q.isEmpty()){
            int cur = q.poll();
            ans++;

            for(int i=1; i<=N; i++){
                if(planes[cur][i]!=0 && visited[i]==0){
                    q.offer(i);
                    visited[i] = 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            planes = new int[N+1][N+1];
            visited = new int[N+1];
            ans = 0;

            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                planes[a][b] = 1;
                planes[b][a] = 1;
            }

            bfs(1);
            sb.append(ans-1).append("\n");
        }
        System.out.println(sb);
    }
}
