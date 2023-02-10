import java.io.*;
import java.util.*;

public class Main {
    static int N, D, K, C;
    static int start = 0, end = 0;
    static int[] roll;
    static int max = 0;
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        roll = new int[N];
        for(int i=0; i<N; i++){
            roll[i] = Integer.parseInt(br.readLine());
        }

        if(end-start!=K-1){
            map.put(roll[start], 1);
            while(end-start<K-1){
                end++;
                if(map.containsKey(roll[end]))
                    map.put(roll[end], map.get(roll[end])+1);
                else
                    map.put(roll[end], 1);
            }
        }

        while(start<N-1){
            if(map.get(roll[start])>1)
                map.put(roll[start], map.get(roll[start])-1);
            else
                map.remove(roll[start]);
            start++;

            end++;
            end = end%N;
            if(map.containsKey(roll[end]))
                map.put(roll[end], map.get(roll[end])+1);
            else
                map.put(roll[end], 1);

            if(!map.containsKey(C))
                max = Math.max(max, map.size()+1);
            else
                max = Math.max(max, map.size());
        }

        System.out.println(max);
    }
}
