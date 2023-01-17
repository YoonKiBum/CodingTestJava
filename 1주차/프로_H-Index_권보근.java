import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int h=0;
        Arrays.sort(citations);
        
        for(int i=0; i<citations.length; i++){
            int tmp = citations.length-i;
            
            if(citations[i] >= tmp)
                h = Math.max(h, tmp);
        }
        
        return h;
    }
}