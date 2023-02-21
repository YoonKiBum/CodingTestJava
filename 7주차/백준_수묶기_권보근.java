import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> positive = new PriorityQueue<>((o1, o2) -> o2-o1);
        PriorityQueue<Integer> negative = new PriorityQueue<>();

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());

            if(num<=0)
                negative.offer(num);
            else
                positive.offer(num);
        }

        int ans = 0;
        if(negative.size()>=2){
            while(negative.size()>=2){
                ans += negative.poll()*negative.poll();
            }
        }

        if(negative.size()>0){
            for(Integer n : negative)
                ans += n;
        }

        if(positive.size()>=2){
            while(positive.size()>=2){
                int num1 = positive.poll();
                int num2 = positive.poll();
                
                if(num1!=1 && num2!=1)
                    ans += num1*num2;
                else 
                    ans += num1 + num2;
            }
        }

        if(positive.size()>0){
            for(Integer n : positive)
                ans += n;
        }

        System.out.println(ans);
    }
}
