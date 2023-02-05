import java.util.*;
import java.io.*;

public class Main {
    static class Info implements Comparable<Info> {
        int a;
        int b;
        public Info(int a, int b) {
            this.a = a;
            this.b = b;
        }
        @Override
        public int compareTo(Info o) {
            return this.a - o.a;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            Info[] arr = new Info[n]; // 등수정보를 담을 배열
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[i] = new Info(a, b);
            }
            
            Arrays.sort(arr); // 1차 점수를 기준으로 오름차순
            
            int min = (int)1e9;
            int cnt = 0;
            for(int i = 0; i < n; i++) { // 1차 점수를 기준으로 오름차순한 배열을 조회 2차 등수가 더 낮으면 무조건 앞사람보다 둘다 낮음
                Info temp = arr[i];
                if(temp.b < min) {
                    min = temp.b;
                } else {
                    cnt += 1;
                }
            }
            System.out.println(n-cnt); // 전체 - 걸러낸 사람 수
        }
    }
}
