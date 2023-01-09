import java.util.*;
import java.io.*;

public class Main {
    public static boolean[] visited;
    // 인접 리스트 방식 그래프
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    public static ArrayList<Integer> answer = new ArrayList<>();
    public static int n, m, k, x;
    public static int cnt = 0;

    // bfs방식
    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int length = q.size();
            for(int l = 0; l < length; l++) {
                int v = q.poll();
                // 거리정보 같으면 answer 에 넣기
                if (cnt == k) {
                    answer.add(v);
                }
                for(int i = 0; i < graph.get(v).size(); i++) {
                    int y = graph.get(v).get(i);
                    if (!visited[y]) {
                        q.offer(y);
                        visited[y] = true;
                    }
                }
            }
            cnt += 1;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        // 그래프 초기화
        for(int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n + 1];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
        }

        bfs(x);
        if(answer.size() == 0) {
            System.out.println(-1);
        }
        else {
            Collections.sort(answer);
            for(int i = 0; i < answer.size(); i++) {
                System.out.println(answer.get(i));
            }
        }
    }
}
