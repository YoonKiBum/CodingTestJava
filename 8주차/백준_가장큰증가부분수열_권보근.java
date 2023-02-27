import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] sum = new int[N];

        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = arr[i];

            for(int j=0; j<i; j++){
                if(arr[i]>arr[j]){
                    sum[i] = Math.max(sum[i], sum[j] + arr[i]);
                }
            }

            max = Math.max(max, sum[i]);
        }

        System.out.println(max);
    }
}   
