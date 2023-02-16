import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] cnt = new int[N+1];

        for(int i=1; i*i<=N;i++){
            cnt[i*i] = 1;
        }

        for(int i=2; i<=N; i++){
            if(cnt[i]==0){
                cnt[i] = i;
                for(int j=1; j*j<=i;j++){
                    cnt[i] = Math.min(cnt[i], cnt[i-j*j]+1);
                }
            }
        }

        System.out.println(cnt[N]);
    }
}
