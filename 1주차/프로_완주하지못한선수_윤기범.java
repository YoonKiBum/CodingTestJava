import java.util.*;
import java.io.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // 시간복잡도를 위해 HashMap 사용
        HashMap<String, Integer> set = new HashMap<>();
        String answer = "";

        // 완주자 배열을 체크하면서
        for(int i = 0; i < completion.length; i++) {
            if(set.containsKey(completion[i])) // 동명이인인 경우
                set.put(completion[i], set.get(completion[i]) + 1);
            else // 처음 들어온 사람의 경우
                set.put(completion[i], 1);
        }

        // 참가자 배열을 체크하면서
        for(int i = 0; i < participant.length; i++) {
            // 완주자가 존재하면서 숫자가 1 이상인 경우 즉 동명이인까지 체크
            if(set.containsKey(participant[i]) && set.get(participant[i]) > 0) {
                set.put(participant[i], set.get(participant[i]) - 1);
            }
            // 그 외의 경우는 완주 못한 사람
            else
                answer = participant[i];
        }
        return answer;
    }
}
