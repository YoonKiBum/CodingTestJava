import java.util.*;
import java.io.*;

class Solution {
    public static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static int first = 0, second = 0, value = 0, check = 0;
    
    public int solution(int[] scoville, int K) {
        int answer = 0;
        for(int i = 0; i < scoville.length; i++) { // 우선순위 큐에 삽입
            pq.offer(scoville[i]);
        }
        
        while(true) {
            check = pq.poll(); // 우선순위 큐의 최소값을 꺼내서 K이상인지 확인
            if(check >= K) // 이상이면 answer 반환
                return answer;
            else // 그렇지 않으면 다시 삽입 후 로직 실행
                pq.offer(check);
            
            if(pq.size() <= 0)
                return -1;
            answer += 1;
            if(pq.size() == 1) { // pq의 크기가 1이면 하나만 꺼내서 확인
                check = pq.poll();
                if(check >= K)
                    return answer;
                else // 불가능하다면 더이상 로직 실행 불가능이므로 -1 반환
                    return -1;
            }
            first = pq.poll(); // 첫번째로 작은값
            second = pq.poll(); // 두번째로 작은값
            value = first + (second * 2); // 연산
            pq.offer(value);
        }
    }
}
