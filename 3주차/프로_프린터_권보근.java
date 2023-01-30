import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Integer> printer = new LinkedList<>();
        PriorityQueue<Integer> priority = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<priorities.length; i++){
            printer.offer(priorities[i]);
            priority.offer(priorities[i]);
        }
        int first = priority.poll();
        while(true){
            int current = printer.poll();

            if(current >= first && location==0){
                answer++;
                break;
            }
            else if(current >= first && location!=0){
                first = priority.poll();
                location--;
                answer++;
            }
            else{
                printer.offer(current);
                if(location == 0){
                    location = printer.size()-1;
                }
                else
                    location--;
            }
        }
                
        return answer;
    }
}