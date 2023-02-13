import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long min = 1, mid = 0, max = 0;

        int[] jew = new int[M];
        for(int i=0; i<M; i++){
            jew[i] = Integer.parseInt(br.readLine());
            if(max<jew[i])
                max = jew[i];
        }

        long ans = Long.MAX_VALUE;
        while(min<=max){
            mid = (min+max)/2;

            int sum = 0;
            for(Integer j : jew){
                sum += j/mid;
                if(j%mid!=0)
                    sum++;
            }

            if(sum<=N){
                max = mid - 1;
                ans = Math.min(ans, mid);
            }
            else{
                min = mid + 1;
            }
        }
        System.out.println(ans);
    }
}
