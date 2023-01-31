import java.util.*;
import java.io.*;

class Solution {
    public static Queue<Info> q = new LinkedList<>();
    
    static class Info {
        int weight;
        int cnt;
        public Info(int weight, int cnt) {
            this.weight = weight;
            this.cnt = cnt;
        }
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int idx = 0;
        int count = 0;
        
        while(true) {
            if(count == truck_weights.length)
                break;
            answer += 1;
            int sum = 0;
            
            for(int i = 0; i < q.size(); i++) {
                Info info = q.poll();
                info.cnt += 1;
                q.offer(new Info(info.weight, info.cnt));
            }
            int len = q.size();
            for(int i = len - 1; i >= 0; i--) {
                if(q.peek().cnt == bridge_length) {
                    q.poll();
                    count += 1;
                }
            }
            for(int i = 0; i < q.size(); i++) {
                Info info = q.poll();
                sum += info.weight;
                q.offer(new Info(info.weight, info.cnt));
            }
            if(idx < truck_weights.length) {
                if(weight >= sum + truck_weights[idx]) {
                    q.offer(new Info(truck_weights[idx], 0));
                    idx += 1;
                }   
            }
        }
        return answer;
    }
}
