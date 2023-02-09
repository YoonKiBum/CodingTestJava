import java.util.*;
import java.io.*;


class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] lope = new int[N];

        for(int i=0; i<N; i++){
            lope[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(lope);

        int max = 0;
        for(int i=0; i<N; i++){
            int cur = lope[i]*(N-i);

            max = Math.max(max, cur);
        }

        System.out.println(max);
    }
}
