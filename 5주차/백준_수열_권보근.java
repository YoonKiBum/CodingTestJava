import com.sun.security.jgss.GSSUtil;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] tem = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            tem[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0, max = 0;

        max += tem[start];
        while(end-start<K-1){
            end++;
            max += tem[end];
        }

        int sum = max;
        while(end<N-1){
            sum -= tem[start];
            start++;
            end++;
            sum += tem[end];

            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
