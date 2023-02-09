import javax.sound.sampled.Line;
import java.util.*;
import java.io.*;


class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        if(N==1){
            System.out.println(0);
            return;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<N; i++){
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int ans = 0;
        while(!pq.isEmpty()){
            int sum = pq.poll() + pq.poll();

            ans += sum;
            if(!pq.isEmpty())
                pq.offer(sum);
        }

        System.out.println(ans);
    }
}
