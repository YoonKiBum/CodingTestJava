import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n, k, l;
    public static int[][] graph;
    public static int dir = 0;
    public static int ans = 0;
    public static HashMap<Integer, Character> move = new HashMap<>();
    public static int[] dx = {0, -1, 1, 0};
    public static int[] dy = {1, 0, 0, -1};
    public static Queue<Node> q = new LinkedList<>();

    public static void changeDir(char a) {
        if(a == 'L') {
            if(dir == 0)
                dir = 1;
            else if(dir == 1)
                dir = 3;
            else if(dir == 2)
                dir = 0;
            else if(dir == 3)
                dir = 2;
        } else {
            if(dir == 0)
                dir = 2;
            else if(dir == 1)
                dir = 0;
            else if(dir == 2)
                dir = 3;
            else if(dir == 3)
                dir = 1;
        }
    }

    static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        graph = new int[n][n];
        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            graph[a][b] = 2; // 사과 표시
        }
        l = Integer.parseInt(br.readLine());
        for(int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            char b = st.nextToken().charAt(0);
            move.put(a, b);
        }

        graph[0][0] = 1; // 뱀 표시
        q.offer(new Node(0, 0));
        int x = 0;
        int y = 0;

        while(true) {
            ans += 1;
            x += dx[dir];
            y += dy[dir];
            if(x < 0 || y < 0 || x >= n || y >= n) // 밖으로나간 경우
                break;

            if(graph[x][y] == 0) { // 빈칸
                q.offer(new Node(x, y)); // 새로운 칸에 머리
                graph[x][y] = 1; // 뱀 표시

                Node node = q.poll(); // 꼬리 빼기
                graph[node.x][node.y] = 0; // 꼬리 지역 빈칸 표시
            } else if(graph[x][y] == 2) { // 사과있는 칸
                q.offer(new Node(x, y)); // 새로운 칸에 머리
                graph[x][y] = 1; // 뱀 표시
            } else if(graph[x][y] == 1){ // 뱀이 현재 머무르는 칸
                break;
            }

            if(move.containsKey(ans)) {
                changeDir(move.get(ans));
            }
        }

        System.out.println(ans);
    }
}
