import java.util.*;
import java.io.*; 

class Solution {
    public int solution(int[] citations) {
        Integer[] arr = new Integer[citations.length];
        for(int i = 0; i < citations.length; i++) {
            arr[i] = citations[i];
        }
        Arrays.sort(arr, Collections.reverseOrder());
        int h = arr[0];
        while(true) {
            int cnt = 0;
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] >= h) 
                    cnt += 1;
            }
            if(cnt >= h)
                break;
            else
                h -= 1;
        }
        return h;
    }
}

