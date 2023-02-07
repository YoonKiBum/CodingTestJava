import java.util.*;
import java.io.*;


class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];

        for(int i=0; i<N; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }


        int answer = 0;
        int index = N-1;
        while(K>0){
            if(coins[index]>K) {
                index--;
                continue;
            }

            int cnt = K/coins[index];
            answer += cnt;
            K -= cnt*coins[index];

        }

        System.out.println(answer);
    }
}
