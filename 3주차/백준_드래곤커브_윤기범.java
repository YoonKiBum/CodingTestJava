import java.util.*;
import java.io.*;


public class Main {
    public static int n;
    public static int[][] graph = new int[101][101];
    public static int x, y, d, g;
    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {1, 0, -1, 0};
    public static HashSet<Node> set = new HashSet<>();
    public static int ans = 0;

    static class Node { 
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        // 집합 구현을 위한 오버라이딩
        @Override
        public boolean equals(Object o) {
            if (this.x == ((Node)o).x && this.y == ((Node)o).y)
                return true;
            else
                return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    // 방향 전환 함수
    public static int changeDir(int d) {
        return d = (d + 1) % 4;
    }
    public static void curve() {
        set.add(new Node(x, y)); // 초기값 세탕
        int a = x; int b = y;
        a += dx[d]; b += dy[d];
        set.add(new Node(a, b));
        
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        ArrayList<Integer> arr3 = new ArrayList<>();
        arr.add(d);

        for(int i = 0; i < g; i++) {
            int len = arr.size();
            for(int t = 0; t < len; t++) {
                d = changeDir(arr.get(t)); // 방향 정보가 담김
                a += dx[d];
                b += dy[d];
                set.add(new Node(a, b)); // 바뀐 방향정보로 이동한 좌표 집합에 삽입
                arr2.add(d);
            }
            // 새로 변경된 좌표들 arr3에 삽입
            len = arr2.size();
            for(int t = len -1; t >= 0; t--) {
                arr3.add(arr2.get(t));
            }
            // 기존 좌표들 arr3에 삽입
            len = arr.size();
            for(int t = 0; t < len; t++) {
                arr3.add(arr.get(t));
            }
            // arr3를 전부 arr에 넣어줌
            arr.clear();
            len = arr3.size();
            for(int t = 0; t < len; t++) {
                arr.add(arr3.get(t));
            }
            arr2.clear();
            arr3.clear();
        }
    }

    // 체크하며 4개의 점이 집합에 포함되어있는지 확인
    public static void check() {
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                if (set.contains(new Node(i, j)) && set.contains(new Node(i, j + 1))
                        && set.contains(new Node(i + 1, j)) && set.contains(new Node(i + 1, j + 1)))
                    ans += 1;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());

            curve(); // 드래곤 커브 실행
        }
        check(); // 4개의 점이 포함되는지 확인하는 함수
        System.out.println(ans);
    }
}
