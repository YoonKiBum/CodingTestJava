import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer=1;
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<clothes.length; i++){
            String str1 = clothes[i][0];
            String str2 = clothes[i][1];
            
            if(map.containsKey(str2))
                map.put(str2, map.get(str2) + 1);
            else
                map.put(str2, 2);
        }
        
        for(String Key : map.keySet()){
            answer = answer * map.get(Key);
        }
        
        return answer-1;
    }
}