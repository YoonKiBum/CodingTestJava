import java.util.*;
import java.io.*;

class CCTV {
    public int num;
    public int x;
    public int y;

    public CCTV(int num, int x, int y) {
        this.num = num;
        this.x = x;
        this.y = y;
    }
}
public class Main {
    public static int N, M, R;
    public static int[][] graph;
    public static int[][] copyGraph;
    public static int[] numbers;
    public static ArrayList<CCTV> arr = new ArrayList<>();
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int ans = (int)1e9;

    public static void perm(int cnt) {
        if(cnt == R) { // r개를 모두 택한 경우
            for(int i = 0; i < N; i++) { // 그래프 복사
                for(int j = 0; j < M; j++) {
                    copyGraph[i][j] = graph[i][j];
                }
            }
            for(int i = 0; i < arr.size(); i++) { // 모든 cctv를 조회
                direction(arr.get(i), numbers[i]);
            }
            check();
            return;
        }

        for(int i = 0; i < 4; i++) { // 4가지 방향
            numbers[cnt] = i;
            perm(cnt+1);
        }
    }

    public static void direction(CCTV cctv, int d) {
        int num = cctv.num; // cctv 번호 확인

        if(num == 1) { // 1이면 4방향 조회
            if(d == 0) watch(cctv, 0);
            else if(d == 1) watch(cctv, 1);
            else if(d == 2) watch(cctv, 2);
            else if(d == 3) watch(cctv, 3);
        } else if(num == 2) { // 2이면 위아래/ 왼오 조회
            if(d == 0 || d == 2) {
                watch(cctv, 0);
                watch(cctv, 2);
            } else {
                watch(cctv, 1);
                watch(cctv, 3);
            }
        } else if(num == 3) { // 3이면 위왼/ 오아/ 우왼/ 왼위 조회
            if(d == 0) {
                watch(cctv, 0);
                watch(cctv, 1);
            } else if(d == 1) {
                watch(cctv, 1);
                watch(cctv, 2);
            } else if(d == 2) {
                watch(cctv, 2);
                watch(cctv, 3);
            } else if(d == 3) {
                watch(cctv, 3);
                watch(cctv, 0);
            }
        } else if(num == 4) { // 4이면 왼위우/ 위오아/ 오아왼/ 아왼위 조회
            if(d == 0) {
                watch(cctv, 0);
                watch(cctv, 1);
                watch(cctv, 3);
            } else if(d == 1) {
                watch(cctv, 0);
                watch(cctv, 1);
                watch(cctv, 2);
            } else if(d == 2) {
                watch(cctv, 1);
                watch(cctv, 2);
                watch(cctv, 3);
            } else if(d == 3) {
                watch(cctv, 0);
                watch(cctv, 2);
                watch(cctv, 3);
            }
        } else { // 5이면 4방향 조회
            watch(cctv, 0);
            watch(cctv, 1);
            watch(cctv, 2);
            watch(cctv, 3);
        }
    }

    public static void watch(CCTV c, int d) { //
        CCTV cctv = c;
        int x = c.x;
        int y = c.y;
        int nx, ny;

        while(true) {
            nx = x + dx[d];
            ny = y + dy[d];
            if (nx < 0 || ny < 0 || nx >= N || ny >= M) // 좌표가 벗어난 경우
                break;
            if (copyGraph[nx][ny] == 6) // 벽
                break;
            else {
                copyGraph[nx][ny] = -1;
                x = nx;
                y = ny;
            }
        }
    }

    public static void check() {
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(copyGraph[i][j] == 0)
                    cnt++;
            }
        }
        ans = Math.min(ans, cnt);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        copyGraph = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(1 <= graph[i][j] && graph[i][j] <= 5) // cctv 인 경우
                    arr.add(new CCTV(graph[i][j], i, j));
            }
        }

        R = arr.size();
        numbers = new int[R]; // 순열을 위한 배열
        perm(0);

        System.out.println(ans);
    }
}
