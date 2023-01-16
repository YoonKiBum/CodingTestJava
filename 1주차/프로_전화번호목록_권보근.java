import java.util.*;

class Solution {       
    public boolean solution(String[] phone_book) {
        Set<String> map = new HashSet<>();
        
        for(String str : phone_book)
            map.add(str);
        
        for(String str : phone_book){
            StringBuilder sb = new StringBuilder();
            
            for(int j=0; j<str.length()-1; j++){
                sb.append(str.charAt(j));
                
                if(map.contains(sb.toString())){
                    return false;
                }
                    
            }
        }
        return true;
    }
}