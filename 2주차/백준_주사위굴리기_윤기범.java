import java.util.*;
import java.io.*;

public class Main {
    public static int n, m, x, y, k;
//    public static int[] dice = {0, 0, 0, 0, 0, 0};
    public static int up = 0, down = 0, left = 0, right = 0, front = 0, back = 0;
    public static int[][] graph;
    public static int[] move;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {1, -1, 0, 0};
    public static void action(int dir) {
        int temp;
        if(dir == 1) { // 동
            temp = up;
            up = left;
            left = down;
            down = right;
            right = temp;
        } else if(dir == 2) { // 서
            temp = up;
            up = right;
            right = down;
            down = left;
            left = temp;
        } else if(dir == 3) { // 북
            temp = up;
            up = front;
            front = down;
            down = back;
            back = temp;
        } else { // 남
            temp = up;
            up = back;
            back = down;
            down = front;
            front = temp;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        for(int i = 0; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        move = new int[k];
        for(int i = 0; i < k; i++) {
            move[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < k; i++) {
            int nx = x + dx[move[i] - 1];
            int ny = y + dy[move[i] - 1];
            if(nx < 0 || ny < 0 || nx >= n || ny >= m) // 지도를 벗어나면 처리해주지 않음
                continue;
            else { // 지도를 벗어나지 않은 경우
                action(move[i]); // 주사위 굴리기
                x = nx;
                y = ny;
            }
            if(graph[x][y] == 0) { // 지도가 0이면
                graph[x][y] = down;
            } else if(graph[x][y] != 0) { // 지도가 0이 아니면
                down = graph[x][y];
                graph[x][y] = 0;
            }
            System.out.println(up);
        }
    }
}

