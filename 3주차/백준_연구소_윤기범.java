import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static int[][] graph;
    public static ArrayList<Node> arr = new ArrayList<>();
    public static ArrayList<Node> virus = new ArrayList<>();
    public static int ans = 0;
    public static Node[] numbers = new Node[3];
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // 조합 함수
    public static void comb(int start, int cnt) {
        if(cnt == 3) { // 3개 구역에 벽을 세운 경우
            bfs(); // bfs 실행
            return;
        }

        for(int i = start; i < arr.size(); i++) {
            numbers[cnt] = arr.get(i);
            comb(i + 1, cnt + 1);
        }
    }

    public static void bfs() {
        // 임시 그래프 생성
        int[][] tempGraph = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                tempGraph[i][j] = graph[i][j];
            }
        }
        // 조합을 통해 만든 3개의 지역에 벽 세우기
        for(int i = 0; i < 3; i++) {
            Node node = numbers[i];
            tempGraph[node.x][node.y] = 1;
        }
        // 바이러스 큐에 삽입하기
        Queue<Node> q = new LinkedList<>();
        for(int i = 0; i < virus.size(); i++) {
            Node node = virus.get(i);
            q.offer(new Node(node.x, node.y));
        }

        boolean[][] visited = new boolean[n][m];
        int x = q.peek().x;
        int y = q.peek().y;
        visited[x][y] = true;
        tempGraph[x][y] = 2;

        while(!q.isEmpty()) {
            Node node = q.poll();
            x = node.x;
            y = node.y;
            for(int i = 0; i < 4; i++) { // 4방향 탐색
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;
                if(visited[nx][ny] == false && tempGraph[nx][ny] == 0) { // 바이러스가 없고 방문하지 않은 지역
                    q.offer(new Node(nx, ny));
                    visited[nx][ny] = true;
                    tempGraph[nx][ny] = 2;
                }
            }
        }

        int cnt = 0;
        // 안전지역 개수 구하기
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(tempGraph[i][j] == 0) {
                    cnt += 1;
                }
            }
        }

        ans = Math.max(ans, cnt); // 최댓값 구하기
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        for(int i = 0; i < n; i++) {
            st  = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] == 2) { // 바이러스인 경우 큐에 삽입
                    virus.add(new Node(i, j));
                } else if(graph[i][j] == 0) { // 안전구역인 경우 arr에 삽입
                    arr.add(new Node(i, j));
                }
            }
        }

        comb(0, 0);
        System.out.println(ans);
    }
}
