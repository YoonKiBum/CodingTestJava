import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[][] cnt = new long[N][3];

        cnt[0][0] = cnt[0][1] = cnt[0][2] = 1L;

        for(int i=1; i<N; i++){
            cnt[i][0] = (cnt[i-1][0] + cnt[i-1][2])%9901;
            cnt[i][1] = (cnt[i-1][1] + cnt[i-1][2])%9901;
            cnt[i][2] = (cnt[i-1][0] + cnt[i-1][1] + cnt[i-1][2])%9901;
        }

        System.out.println((cnt[N-1][0] + cnt[N-1][1] + cnt[N-1][2])%9901);
    }
}
