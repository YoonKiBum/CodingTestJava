import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[][] graph; // 그래프
    public static int[][] arr; // 좌표
    public static ArrayList<Node> available; // 가능한 곳
    public static ArrayList<Node> available2; // 임시로 만든 가능한 곳
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int[] score = {0, 1, 10, 100, 1000};
    public static int ans = 0;

    // 1번 조건 메소드
    public static void first(int row) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int cnt = 0;
                int cnt2 = 0;
                for(int k = 0; k < 4; k++) {  // 4방향 탐색
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(nx < 0 || ny < 0 || nx >= n || ny >= n) // 그래프 벗어난 경우
                        continue;
                    // 현재 구역이 빈칸이며 4방향 중 한곳이 좋아하는 학생인 경우
                    if((graph[i][j] == 0) && (graph[nx][ny] == arr[row][1] || graph[nx][ny] == arr[row][2]
                            || graph[nx][ny] == arr[row][3] || graph[nx][ny] == arr[row][4])) {
                        cnt += 1;
                    }
                    if(graph[nx][ny] == 0) // 4방향이 빈칸인 경우 (2번 조건을 위함)
                        cnt2 += 1;
                }
                if(cnt != 0) { // 1번 조건을 만족하는 경우 available에 넣는다.
                    available.add(new Node(cnt, cnt2, i, j));
                }
            }
        }
    }

    // 2번 조건 체크 메소드
    public static void second() {
        available2 = new ArrayList<>(); // 임시 available2
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int cnt = 0;
                for(int k = 0; k < 4; k++) { // 4방향 탐색
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(nx < 0 || ny < 0 || nx >= n || ny >= n) // graph 벗어난 경우
                        continue;
                    if((graph[i][j] == 0) && graph[nx][ny] == 0) { // 현재가 빈칸이며 주변에 빈 칸이 있는경우
                        cnt += 1;
                    }
                }
                if(cnt != 0) { // 2번 조건을 만족하는 경우
                    // 첫번째 인덱스는 1번 조건에서 관리하는것이고 2번 조건은 이미 1번 조건을 만족하지 못한 경우들이므로 첫번째 인덱스를 0으로 설정
                    available2.add(new Node(0, cnt, i, j));
                }
            }
        }
        available = available2;
    }

    // 점수 계산 메소드
    public static void calc() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int row = 0;
                for(int k = 0; k < n * n; k ++) {
                    if(graph[i][j] == arr[k][0]) { // 현재의 행을 탐색
                        row = k;
                        break;
                    }
                }
                int cnt = 0;
                for(int k = 0; k < 4; k++) { // 4방향 탐색하며
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(nx < 0 || ny < 0 || nx >= n || ny >= n)
                        continue;
                    if((graph[nx][ny] == arr[row][1] || graph[nx][ny] == arr[row][2] // 주변에 좋아하는 친구 확인
                            || graph[nx][ny] == arr[row][3] || graph[nx][ny] == arr[row][4])) {
                        cnt += 1;
                    }
                }
                ans += score[cnt]; // score배열을 참조하여 점수 계산
            }
        }
    }

    static class Node implements Comparable<Node> {
        int cnt;
        int cnt2;
        int x;
        int y;

        public Node(int cnt, int cnt2, int x, int y) {
            this.cnt = cnt;
            this.cnt2 = cnt2;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            int r;
            r = -(this.cnt - o.cnt);
            if(r == 0) {
                r = -(this.cnt2 - o.cnt2);
                if (r == 0) {
                    r = this.x - o.x;
                    if(r == 0) {
                        r = this.y - o.y;
                        return r;
                    } else {
                        return r;
                    }
                } else {
                    return r;
                }
            } else {
                return r;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        graph = new int[n][n];
        arr = new int[n*n][5];

        for(int i = 0; i < n*n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
            available = new ArrayList<Node>();
            first(i); // 1번 조건을 체크
            if(available.size() == 0) { // 1번 조건을 만족하지 못한 경우
                second(); // 2번 조건 체크
            }
            // 1번 혹은 2번 조건을 만족하는 경우 available를 compareTo 조건에 맞춰 정렬 후 가장 처음 나온칸에 삽입
            if(available.size() != 0) {
                Collections.sort(available);
                Node node = available.get(0);
                graph[node.x][node.y] = arr[i][0];
            } else {
                // 2번 조건조차 만족하지 못하면 3번 조건을 만족하기 위해 행이 커지는 순서대로 열이 커지는 순서대로 빈칸을 체크 후
                // 해당하는 빈칸에 넣어준다. flag: 는 빈칸에 삽입하면 한번에 이중 루프 탈출하기 위함
                flag: for(int a = 0; a < n; a++) {
                    for(int b = 0; b < n; b++) {
                        if(graph[a][b] == 0) {
                            graph[a][b] = arr[i][0];
                            break flag;
                        }
                    }
                }
            }
        }
        calc(); // 점수 계산
        System.out.println(ans);
    }
}
