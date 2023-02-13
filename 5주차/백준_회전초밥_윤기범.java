import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n*2];
        int[] num = new int[d + 1];

        for(int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());
            arr[i] = temp;
            arr[i + n] = temp;
        }

        int start = 0;
        int idx = 0;
        int cnt = 0;
        int ans = 0;
        for(int i = 0; i < k; i++) {
            num[arr[idx]] += 1;
            idx += 1;
        }
        num[c] += 1; // 쿠폰 추가

        for(int i = 1; i < d + 1; i++) {
            if(num[i] != 0)
                cnt += 1;
        }
        ans = Math.max(ans, cnt);
        cnt = 0;

        for(int i = idx; i < n + k; i++) {
            num[arr[start]] -= 1;
            start += 1;
            num[arr[i]] += 1;
            num[c] -= 1; // 그 전에 넣은 쿠폰 제거
            num[c] += 1; // 새로 쿠폰 추가
            for(int j = 1; j < d + 1; j++) {
                if(num[j] != 0)
                    cnt += 1;
            }
            ans = Math.max(ans, cnt);
            cnt = 0;
        }

        System.out.println(ans);
    }
}
