import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if(N<=K){
            System.out.println(0);
            return;
        }

        for(int i=0; i<K-1; i++){
            int exp = 0;

            while(Math.pow(2, exp)<=N)
                exp++;

            N -= Math.pow(2, exp-1);

            if(N==0) {
                System.out.println(0);
                return;
            }
        }

        int exp = 0;
        while(Math.pow(2, exp)<N)
            exp++;

        System.out.println((int) Math.pow(2, exp) - N);
    }
}
