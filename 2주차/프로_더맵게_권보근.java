import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(Integer i : scoville)
            pq.offer(i);
        
        while(!pq.isEmpty()){
            Integer first = pq.poll();
            
            if(first >= K){
                break;
            }
            else{
                Integer second = pq.poll();
            
                if(second == null)
                    return -1;
                else{
                    int mix = first + (second*2);
                    pq.offer(mix);
                    answer++;
                }
            }
            
        }
        
        return answer;
    }
}