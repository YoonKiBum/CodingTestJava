import java.util.*;
import java.io.*;


class Main {
    static int N;
    static int[][] times;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        times = new int[N][2];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1])
                    return o1[0]-o2[0];
                
                return o1[1] - o2[1];
            }
        });


        int last = 0;
        for(int i=0; i<times.length; i++){
            int start = times[i][0];

            if(start<last)
                continue;

            last = times[i][1];
            answer++;
        }


        System.out.println(answer);
    }
}
