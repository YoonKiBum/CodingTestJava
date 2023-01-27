import java.util.*;
import java.io.*;

public class Main {
    public static int r, c, T;
    public static int[][] graph;
    public static int cx1, cy1, cx2, cy2;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int ans = 0;
    static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void spread() {
        int[][] tempGraph = new int[r][c];

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(graph[i][j] != 0) { // 미세먼지가 존재하면
                    int x = i; int y = j;
                    int cnt = 0;
                    ArrayList<Node> arr = new ArrayList<>();
                    for(int k = 0; k < 4; k++) { // 4방향 체크하며 미세먼지 확산 가능칸 조회
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        if(nx < 0 || ny < 0 || nx >= r || ny >= c) // 맵 벗어나면
                            continue;
                        else if(graph[nx][ny] != -1) { // 공기청정기가 있는 곳이 아니면
                            cnt += 1;
                            arr.add(new Node(nx, ny));
                        }
                    }
                    int len = arr.size();
                    for(int k = 0; k < len; k++) { // 이동할 수 있는 칸 들을 조회하며
                        Node node = arr.get(k);
                        tempGraph[node.x][node.y] += (graph[x][y] / 5);
                    }
                    tempGraph[x][y] += (graph[x][y] - (graph[x][y] / 5) * cnt);
                }
            }
        }
        for(int i = 0; i < r; i++) { // 그래프 원복
            for(int j = 0; j < c; j++) {
                graph[i][j] = tempGraph[i][j];
            }
        }
    }

    public static void action() {
        // 공기청정기 위 (cx1-1, cy1)은 없어짐
        // 0열
        for(int i = cx1-1; i > 0; i--) {
            graph[i][0] = graph[i - 1][0];
        }
        // 0행
        for(int j = 0; j < c-1; j++) {
            graph[0][j] = graph[0][j + 1];
        }
        // c열
        for(int i = 0; i < cx1; i++) {
            graph[i][c - 1] = graph[i + 1][c - 1];
        }
        // cx1행
        for(int j = c-1; j > 0; j--) {
            graph[cx1][j] = graph[cx1][j-1];
        }
        graph[cx1][1] = 0;

        // 공기청정기 아래 (cx2 + 1, cy2)는 없어짐
        // 0열
        for(int i = cx2 + 1; i < r - 1; i++) {
            graph[i][0] = graph[i + 1][0];
        }
        // r행
        for(int j = 0; j < c-1; j++) {
            graph[r - 1][j] = graph[r - 1][j + 1];
        }
        // c열
        for(int i = r-1; i > cx2; i--) {
            graph[i][c-1] = graph[i - 1][c-1];
        }
        // cx2행
        for(int j = c-1; j > 0; j--) {
            graph[cx2][j] = graph[cx2][j - 1];
        }
        graph[cx2][1] = 0;
    }

    public static void calc() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ans += graph[i][j];
            }
        }
        ans += 2; // 공기청정기 처리
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        graph = new int[r][c];
        for(int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < c; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 공기청정기 위치 찾기
        for(int i = 0; i < r; i++) {
            if(graph[i][0] == -1) {
                cx1 = i; cy1 = 0;
                cx2 = i + 1; cy2 = 0;
                break;
            }
        }

        for(int t = 0; t < T; t++) {
            spread(); // 확산
            action(); // 공기청정기 동작
        }
        calc(); // 남아있는 먼지 구하기
        System.out.println(ans);
    }
}
