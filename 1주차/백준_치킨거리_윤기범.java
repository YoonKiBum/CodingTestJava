import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static int[][] graph;
    public static ArrayList<Node> chicken = new ArrayList<Node>();
    public static ArrayList<Node> house = new ArrayList<Node>();
    public static Node[] numbers;
    public static int ans = (int)1e9;

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
        if(cnt == m) { // 치킨집을 조합으로 m개 뽑은 경우
            int chickenDist = 0; // 치킨거리 
            for(int j = 0; j < house.size(); j++) { // 집을 정한 후 모든 치킨집과의 치킨거리를 구하기 위한 for 문
                Node node2 = house.get(j);
                int temp = (int)1e9;
                int hx = node2.x;
                int hy = node2.y;
                for(int i = 0; i < m; i++) { // 모든 조합을 통한 치킨집을 조회
                    Node node = numbers[i];
                    int cx = node.x;
                    int cy = node.y;
                    temp = Math.min(temp, Math.abs(cx-hx) + Math.abs(cy - hy)); // 한 집에서 m개의 치킨집 중 가장 작은 치킨 거리를 구함
                }
                chickenDist += temp; // 이 값들을 모두 더해서 해당하는 순번의 조합에서의 전체 치킨 거리를 구함
            }
            ans = Math.min(ans, chickenDist); // 치킨거리의 최소값을 구하기 위함
            return;
        }

        for(int i = start; i < chicken.size(); i++) { // 치킨집을 조합으로 m개 뽑지 못한 경우
            numbers[cnt] = chicken.get(i);
            comb(i + 1, cnt + 1);
        }
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
                if(graph[i][j] == 1) // 1이면 집 ArrayList에 삽입
                    house.add(new Node(i, j));
                else if(graph[i][j] == 2) // 2이면 치킨 ArrayList에 삽입
                    chicken.add(new Node(i, j));
            }
        }
        numbers = new Node[m]; // 조합을 위한 배열
        comb(0, 0); // 조합 함수 실행
        System.out.println(ans);
    }
}
