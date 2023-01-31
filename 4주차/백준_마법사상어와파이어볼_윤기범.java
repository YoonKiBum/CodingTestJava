import java.util.*;
import java.io.*;

public class Main {
    public static int N, M, K;
    public static ArrayList<Info>[][] graph;
    public static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static class Info {
        int m; int s;
        int d;

        public Info(int m, int s, int d) {
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    // 파이어볼 이동
    public static void move() {
        ArrayList<Info>[][] tempGraph = new ArrayList[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                tempGraph[i][j] = new ArrayList<>();
            }
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                int len = graph[i][j].size();
                for(int k = len-1; k >= 0; k--) {
                    Info info = graph[i][j].get(k);
                    graph[i][j].remove(k);
                    int nx = i + dx[info.d] * info.s;
                    int ny = j + dy[info.d] * info.s;
                    // 1과 N을 연결하기 위함
                    nx = nx % N;
                    ny = ny % N;
                    if(nx < 0) {
                        nx += N;
                    }
                    if(ny < 0) {
                        ny += N;
                    }
                    tempGraph[nx][ny].add(new Info(info.m, info.s, info.d));
                }
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                int len = tempGraph[i][j].size();
                for(int k = len-1; k >= 0; k--) {
                    Info info = tempGraph[i][j].get(k);
                    graph[i][j].add(new Info(info.m, info.s, info.d));
                }
            }
        }
    }

    // 파이어볼 분리
    public static void split() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                int len = graph[i][j].size(); // 해당 좌표의 파이어볼 개수 파악
                if(len >= 2) { // 2개 이상이라면
                    int m = 0;
                    int s = 0;
                    ArrayList<Integer> arr = new ArrayList<>();
                    boolean flag = false;

                    for(int k = len - 1; k >= 0; k--) {
                        Info info = graph[i][j].get(k);
                        graph[i][j].remove(k);
                        m += info.m; // 전체 질량 합
                        s += info.s; // 전체 속도 합
                        arr.add(info.d); // 방향들을 전부 arr에 넣기
                    }

                    m = m / 5;
                    s = s / len;
                    if (m <= 0) {
                        continue;
                    } else {
                        // 방향들이 전부 짝수인지 혹은 홀수인지 확인
                        for(int k = 0; k < arr.size() - 1; k++) {
                            if(arr.get(k) % 2 == 0 && arr.get(k + 1) % 2 == 1) {// 앞 짝 뒤 홀
                                flag = true;
                                break;
                            }
                            if(arr.get(k) % 2 == 1 && arr.get(k + 1) % 2 == 0) { // 앞 홀 뒤 짝
                                flag = true;
                                break;
                            }
                        }
                        if (!flag) { // 모두 짝수이거나 홀수인경우
                            for(int k = 0; k <= 6; k += 2) {
                                graph[i][j].add(new Info(m, s, k));
                            }
                        } else { // 하나라도 아닌경우
                            for(int k = 1; k <= 7; k += 2) {
                                graph[i][j].add(new Info(m, s, k));
                            }
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                graph[i][j] = new ArrayList<>();
            }
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) -1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            graph[r][c].add(new Info(m, s, d));
        }

        for(int i = 0; i < K; i++) {
            move();
            split();
        }
        int ans = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                int len = graph[i][j].size();
                for(int k = len - 1; k >= 0; k--) {
                    ans += graph[i][j].get(k).m;
                }
            }
        }
        System.out.println(ans);
    }
}
