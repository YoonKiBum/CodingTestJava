import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());

            int[] days = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                days[i] = Integer.parseInt(st.nextToken());
            }

            int max = 0;
            long sum = 0;
            for(int i=N-1; i>=0; i--){
                if(days[i]>max)
                    max = days[i];
                else
                    sum += (max-days[i]);
            }

            sb.append(sum).append("\n");
            
        }
        System.out.println(sb);
    }
}
