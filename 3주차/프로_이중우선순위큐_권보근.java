import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        int prioritySize=0;
        
        for(int i=0; i<operations.length; i++){
            if(prioritySize==0){
                min.clear();
                max.clear();
            }
            
            if(operations[i].equals("D -1")){
                if(prioritySize != 0){
                    min.poll();
                    prioritySize--;
                }
            }
            else if(operations[i].equals("D 1")){
                if(prioritySize != 0){
                    max.poll();
                    prioritySize--;
                }
            }
            else{
                String[] input = operations[i].split(" ");
                max.offer(Integer.parseInt(input[1]));
                min.offer(Integer.parseInt(input[1]));
                prioritySize++;
            }
        }
        
        if(prioritySize == 0){
            answer[0] = 0;
            answer[1] = 0;
        }
        else{
            int n1 = max.poll();
            int n2 = min.poll();
            answer[0] = n1;
            answer[1] = n2;
        }
        
        
        return answer;
    }     
}
