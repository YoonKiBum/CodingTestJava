import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int cnt=0;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // 잃어버린 학생 저장 (value가 1인 경우 도난, 0인 경우 받음)
        Map<Integer, Integer> lostmap = new HashMap<Integer, Integer>();
        
        for(int i=0; i<lost.length; i++){
            lostmap.put(lost[i], 1);
        }
        
        for(int i=0; i<reserve.length; i++){
            // 여벌이 있는 학생이 도난 당한 경우
            if(lostmap.containsKey(reserve[i])){
                lostmap.put(reserve[i], 0);
            }
            else{
                int before = reserve[i] - 1;
                int after = reserve[i] + 1;
                // 앞과 뒤 학생이 모두 도난 당한 경우
                if(lostmap.containsKey(before) && lostmap.containsKey(after)){
                    // 앞의 학생에게 우선적으로 빌려준다
                    if(lostmap.get(before) == 1){
                        lostmap.put(before, 0);
                    }
                    else if(lostmap.get(after) == 1){
                        lostmap.put(after, 0);
                    }
                }
                // 앞의 학생이 도난 당한 경우
                else if(lostmap.containsKey(before) && lostmap.get(before) == 1){
                     lostmap.put(before, 0);
                }
                // 뒤의 학생이 도난 당한 경우
                else if(lostmap.containsKey(after) && lostmap.get(after) == 1){
                     lostmap.put(after, 0);
                }
            }        
        }
        
        // value 값이 0인 경우 수업을 듣는 것이 가능
        for(int key : lostmap.keySet()){
            if(lostmap.get(key) == 0) cnt++;
        }
        
        answer = n-lostmap.size()+cnt;
        
        return answer;
    }
}