import java.util.*;
import java.io.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> set = new HashMap<>();
        String answer = "";

        for(int i = 0; i < completion.length; i++) {
            if(set.containsKey(completion[i]))
                set.put(completion[i], set.get(completion[i]) + 1);
            else
                set.put(completion[i], 1);
        }

        for(int i = 0; i < participant.length; i++) {
            if(set.containsKey(participant[i]) && set.get(participant[i]) > 0) {
                set.put(participant[i], set.get(participant[i]) - 1);
            }
            else
                answer = participant[i];
        }
        return answer;
    }
}
