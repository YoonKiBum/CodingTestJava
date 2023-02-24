import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] num = new int[N];
        int[] up = new int[N];
        int[] down = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++){
            int idx = N-1-i;

            up[i] = 1;
            down[idx] = 1;

            for(int j=0; j<i; j++){
                if(num[i]>num[j]){
                    up[i] = Math.max(up[i], up[j] + 1);
                }

                if(num[idx]>num[N-1-j]){
                    down[idx] = Math.max(down[idx], down[N-1-j]+1);
                }
            }
        }

        int ans = 0;
        for(int i=0; i<N; i++){
            ans = Math.max(ans, up[i]+down[i]-1);
        }

        System.out.println(ans);
    }
}
