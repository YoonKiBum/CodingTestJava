import java.util.*;
import java.io.*;

public class Main {
    public static ArrayList<Node> arr = new ArrayList<>();

    static class Node implements Comparable<Node>{
        int from;
        int to;

        public Node(int from, int to) {
            this.from = from;
            this.to = to;
        }
        @Override
        public int compareTo(Node o) {
            int r = this.to - o.to;
            if(r == 0) {
                return this.from - o.from;
            } else {
                return r;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.add(new Node(a, b));
        }

        Collections.sort(arr);

        // 가장 긴 증가하는 부분 수열
        int[] dp = new int[n];
        for(int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for(int i = 0; i < arr.size(); i++) {
            Node node = arr.get(i);
//            int check = node.from;
            for(int j = i + 1; j < arr.size(); j++) {
                if (node.from < arr.get(j).from) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }

        Arrays.sort(dp);
        int ans = dp[n-1];
        System.out.println(n - ans);
    }
}
