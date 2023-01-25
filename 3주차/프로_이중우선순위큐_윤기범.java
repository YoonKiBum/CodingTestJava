import java.util.*;
import java.io.*;

class Solution {
    public static PriorityQueue<Integer> minPq = new PriorityQueue<>();
    public static PriorityQueue<Integer> maxPq = new PriorityQueue<>();
    
    public int[] solution(String[] operations) {
        StringTokenizer st;
    
        for(int i = 0; i < operations.length; i++) {
            st = new StringTokenizer(operations[i], " ");
            String cmd = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            if(cmd.equals("I")) { // 삽입인 경우
                minPq.offer(num);
                maxPq.offer(num*-1);
            } else { // 삭제인 경우
                if(minPq.size() == 0) { // 비어있다면 넘기기
                    continue;
                }
                if(num == 1) { // 최대값을 삭제하는 경우는 maxPq에서 뽑기
                    int temp = maxPq.poll();
                    minPq.remove(temp * -1);
                } else { // 최소값을 삭제하는 경우는 minPq에서 뽑기
                    int temp = minPq.poll();
                    maxPq.remove(temp * -1);
                }
            }
        }
       
        if(minPq.size() == 0) {
            int[] answer = {0, 0};
            return answer;
        } else {
            int[] answer = {maxPq.poll() * -1, minPq.poll()};
            return answer;
        }
    }
}
