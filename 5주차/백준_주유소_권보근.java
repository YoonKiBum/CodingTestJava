import java.util.*;
import java.io.*;


class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long ans = 0L;
        int N = Integer.parseInt(br.readLine());

        int[] distance = new int[N-1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N-1; i++){
            distance[i] = Integer.parseInt(st.nextToken());
        }

        long cur = (long) 1e9;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N-1; i++){
            cur = Math.min(cur, Integer.parseInt(st.nextToken()));
            ans += cur * (long) distance[i];
        }

        System.out.println(ans);
    }
}
