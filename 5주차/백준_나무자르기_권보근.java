import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());

        long min = 0, mid = 0, max = 0;

        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            trees[i] = Integer.parseInt(st.nextToken());
            if(max<trees[i])
                max = (long) trees[i];
        }

        while(min<=max){
            mid = (min+max)/2;

            long sum = 0;
            for(int i=0; i<trees.length; i++){
                if(trees[i]>mid)
                    sum += trees[i]-mid;
            }

            if(sum<M){
                max = mid-1;
            }
            else{
                min = mid + 1;
            }
        }

        System.out.println(max);
    }
}
