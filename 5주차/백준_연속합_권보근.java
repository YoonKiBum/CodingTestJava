import java.util.*;
import java.io.*; 


class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int last_val = 0, max = -1001;
        for(int i=0; i<N; i++){
            int cur = Integer.parseInt(st.nextToken());

            last_val = Math.max(last_val + cur, cur);
            max = Math.max(max, last_val);
        }
        System.out.println(max);
    }
}
