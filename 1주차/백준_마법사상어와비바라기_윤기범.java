import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n, m, dir, cnt;
    public static ArrayList<Node> cloud = new ArrayList<>();
    public static ArrayList<Node> cloud2;
    public static int[][] graph;
    public static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    public static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] dx2 = {-1, -1, 1, 1};
    public static int[] dy2 = {-1, 1, 1, -1};
    static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void moveCloud() {
        for(int i = cloud.size() - 1; i >= 0; i--) {
            Node node = cloud.get(i);
            int x = node.x;
            int y = node.y;

            int nx = x + (dx[dir] * cnt) % n;
            int ny = y + (dy[dir] * cnt) % n;

            if(nx < 0) { // x가 음수라면
                nx += n;
            }
            if(ny < 0) { // y가 음수라면
                ny += n;
            }
            if(nx >= n) {
                nx -= n;
            }
            if(ny >= n) {
                ny -= n;
            }
            cloud.remove(i);
            cloud.add(new Node(nx, ny));
        }
    }

    public static void makeRain() {
        cloud2 = new ArrayList<>();

        // 구름이 있는 곳에 비오게 하기
        for(int i = 0; i < cloud.size(); i++) {
            Node node = cloud.get(i);
            graph[node.x][node.y] += 1;
            cloud2.add(new Node(node.x, node.y)); // 기존에 구름 있는칸은 구름 재생성 하지 않기 위함
        }
        // 구름 대각선 확인하여 물 있으면 증가시키가
        for(int i = 0; i < cloud.size(); i++) {
            Node node = cloud.get(i);
            int x = node.x;
            int y = node.y;
            int count = 0;
            for(int j = 0; j < 4; j++) {
                int nx = x + dx2[j];
                int ny = y + dy2[j];
                if(nx < 0 || ny < 0 || nx >= n || ny >= n)
                    continue;
                if(graph[nx][ny] >= 1)
                    count += 1;
            }
            graph[x][y] += count;
        }
        cloud.clear(); // 구름 없애기
    }

    public static void makeCloud() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(graph[i][j] >= 2) {
                    boolean flag = false;
                    for(int k = 0; k < cloud2.size(); k++) { // 기존에 구름이 있던 칸이라면
                        Node node = cloud2.get(k);
                        if(i == node.x && j == node.y) {
                            flag = true;
                            break;
                        }
                    }
                    if(!flag) { // 기존에 구름이 없던 칸이면 새로 구름 생성
                        cloud.add(new Node(i, j));
                        graph[i][j] -= 2;
                    }
                }
            }
        }
        cloud2.clear();
    }

    public static void waterAmount() {
        int sum = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(graph[i][j] >= 1) {
                    sum += graph[i][j];
                }
            }
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 초기 구름 좌표 설정
        cloud.add(new Node(n - 1, 0));
        cloud.add(new Node(n - 1, 1));
        cloud.add(new Node(n - 2, 0));
        cloud.add(new Node(n - 2, 1));

        for(int t = 0; t < m; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            dir = Integer.parseInt(st.nextToken()) - 1;
            cnt = Integer.parseInt(st.nextToken());
            moveCloud();
            makeRain();
            makeCloud();
        }
        waterAmount();
    }
}
