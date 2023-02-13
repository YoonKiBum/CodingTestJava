import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] lines = new int[K];
        long min = 1, mid = 0, max = 0;
        for(int i=0; i<K; i++){
            lines[i] = Integer.parseInt(br.readLine());
            if(max<lines[i])
                max = lines[i];
        }

        while(min<=max){
            mid = (min+max)/2;

            long cnt = 0;
            for(int i=0; i<lines.length; i++){
                cnt += lines[i]/mid;
            }

            if(cnt<N){
                max = mid-1;
            }
            else{
                min = mid+1;
            }
        }

        System.out.println(max);
    }
}
