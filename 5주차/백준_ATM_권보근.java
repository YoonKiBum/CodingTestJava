import java.util.*;
import java.io.*;


class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] times = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            times[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times);

        int answer = 0;
        int last = 0;
        for(int i=0; i<N; i++){
            last += times[i];
            answer += last;
        }

        System.out.println(answer);
    }
}
