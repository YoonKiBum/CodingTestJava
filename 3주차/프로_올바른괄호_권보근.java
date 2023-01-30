class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        if(s.startsWith(")") || s.length()%2 != 0)
            return false;

        
        int open=0;
        for(int i=0; i<s.length(); i++){
            if(s.substring(i, i+1).equals("("))
                open+=1;
            else{
                if(open==0)
                    return false;
                else
                    open-=1;
            }
        }
        if(open==0)
            answer = true;
        else
            answer = false;

        return answer;
    }
}