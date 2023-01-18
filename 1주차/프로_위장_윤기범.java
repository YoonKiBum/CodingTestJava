import java.util.*;
import java.io.*;

class Solution {
    public static HashMap<String, Integer> map = new HashMap<>();
    public static int ans = 1;
    public static int totalCnt, n;
    
    public static void comb(int start, int cnt) {
        if(cnt == 1) {
            totalCnt += 1;
            return;
        }
        for(int i = start; i < n; i++) {
            comb(i + 1, cnt + 1);
        }
    }
    
    public int solution(String[][] clothes) {
        for(int i = 0; i < clothes.length; i++) {
            String a = clothes[i][0];
            String b = clothes[i][1];
    
            // 해시에 집어넣기
            if(map.containsKey(b)) { 
                map.put(b, map.get(b) + 1);
            } else {
                map.put(b, 1);
            }
        }
        
        // 조회하면서 
        for (String key : map.keySet()){
            totalCnt = 0;
            n = map.get(key);
            comb(0, 0);
            ans = ans * (totalCnt + 1);
		}
        return ans - 1; // 모든 종류 다 안입는 경우
    }
}
