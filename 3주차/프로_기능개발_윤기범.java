import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int len = progresses.length;
        ArrayList<Integer> arr = new ArrayList<>();
        
        while(true) {
            int sum = 0;
            for(int i = 0; i < arr.size(); i++) {
                sum += arr.get(i);
            }
            if(sum == len)
                break;
            for(int i = 0; i < len; i++) {
                if(progresses[i] >= 100)
                    continue;
                progresses[i] += speeds[i];
            }
    
            int cnt = 0;
            for(int i = sum; i < len; i++) {
                if (progresses[i] >= 100) 
                    cnt += 1;
                else 
                    break;
            }
            if(cnt != 0) 
                arr.add(cnt);
        }
        int[] ans = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++) {
            ans[i] = arr.get(i);
        }
        return ans;
    }
}
