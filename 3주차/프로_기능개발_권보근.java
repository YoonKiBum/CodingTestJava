import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        ArrayList<Integer> alist = new ArrayList<>();
        int index=0;
        
        while(true){
            if(index == progresses.length)
                break;
            
            if(progresses[index] >= 100){
                int count=0;
                
                for(int i=index; i<progresses.length; i++){
                    if(progresses[i] >= 100){
                        count++;
                        if(i==progresses.length-1){
                            index = progresses.length;
                            
                        }
                    }
                    else{
                        index = i;
                        break;
                    }
                }
                alist.add(count);
            }
            
            for(int i=index; i<progresses.length; i++){
                progresses[i] += speeds[i];
            }
        }
        answer = new int[alist.size()];
        for(int i=0; i<alist.size(); i++){
            answer[i] = alist.get(i);
        }
        return answer;
    }
}