import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[][] graph;
    public static int[][] dp;
    public static Queue<Info> arr = new LinkedList<>();

    public static void move() {
        while(!arr.isEmpty()) {
            Info info = arr.poll();
            int x1 = info.x1;
            int y1 = info.y1;
            int x2 = info.x2;
            int y2 = info.y2;
            int mode = info.mode;

            if(mode == 0) { // 가로
                if(y2 + 1 < n && graph[x2][y2 + 1] == 0) {
                    arr.offer(new Info(x1, y1 + 1, x2, y2 + 1, 0));
                    dp[x2][y2 + 1] += 1;
                }

                if(x2 + 1 < n && y2 + 1 < n){
                    if(graph[x2+1][y2+1] == 0 && graph[x2][y2 + 1] == 0 && graph[x2+1][y2] == 0) {
                        arr.offer(new Info(x1, y1 + 1, x2 + 1, y2 + 1, 2));
                        dp[x2 + 1][y2 + 1] += 1;
                    }
                }
            } else if(mode == 1) { // 세로
                if(x2 + 1 < n && graph[x2+1][y2] == 0) {
                    arr.offer(new Info(x1 + 1, y1, x2 + 1, y2, 1));
                    dp[x2 + 1][y2] += 1;
                }
                if(x2 + 1 < n && y2 + 1 < n) {
                    if(graph[x2+1][y2+1] == 0 && graph[x2+1][y2] == 0 && graph[x2][y2+1] == 0) {
                        arr.offer(new Info(x1 + 1, y1, x2 + 1, y2 + 1, 2));
                        dp[x2 + 1][y2 + 1] += 1;
                    }
                }
            } else { // 대각선
                if(y2 + 1 < n) {
                    if(graph[x2][y2+1] == 0) {
                        arr.offer(new Info(x1 + 1, y1 + 1, x2, y2 + 1, 0));
                        dp[x2][y2 + 1] += 1;
                    }
                }
                if(x2 + 1 < n) {
                    if(graph[x2+1][y2] == 0){
                        arr.offer(new Info(x1 + 1, y1 + 1, x2 + 1, y2, 1));
                        dp[x2 + 1][y2] += 1;
                    }
                }
                if(x2 + 1 < n && y2 + 1 < n) {
                    if(graph[x2+1][y2+1] == 0 && graph[x2+1][y2] == 0 && graph[x2][y2+1] == 0) {
                        arr.offer(new Info(x1 + 1, y1 + 1, x2 + 1, y2 + 1, 2));
                        dp[x2 + 1][y2 + 1] += 1;
                    }
                }
            }
        }

        System.out.println(dp[n-1][n-1]);
    }

    static class Info {
        int x1;
        int y1;
        int x2;
        int y2;
        int mode; // 0 가로, 1 세로, 2 대각선

        public Info (int x1, int y1, int x2, int y2, int mode) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.mode = mode;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        dp = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        arr.offer(new Info(0, 0, 0, 1, 0));
        if(graph[n-1][n-1] == 1) { // 예외처리
            System.out.println(0);
            return;
        }
        move();
    }
}

