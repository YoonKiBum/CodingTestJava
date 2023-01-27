import java.io.*;
import java.util.*;

class Solution {
    public static int cnt = 0;
    
    boolean solution(String s) {
        int len = s.length();
        char[] carr = s.toCharArray();
        
        for(int i = 0; i < carr.length; i++) {
            // System.out.println(carr[i]);
            if(String.valueOf(carr[i]).equals("("))
                cnt += 1;
            else
                cnt -= 1;
            if(cnt < 0)
                break;
        }
        if(cnt == 0)
            return true;
        else
            return false;
    }
}
