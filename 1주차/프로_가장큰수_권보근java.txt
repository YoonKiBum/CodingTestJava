import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] str = new String[numbers.length];
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<numbers.length; i++){
            str[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(str, new Comparator<String>() {
            /* compare의 return 값이 양수면 str2가 먼저, 음수면 str1이 먼저 나간다
               compareTo는 자신이 더 작으면 음수
            */
            @Override
            public int compare(String str1, String str2){
                return (str2 + str1).compareTo(str1+str2);
            }
        });
        
        if(str[0].equals("0"))
            return "0";
        
        for(int i=0; i<numbers.length; i++){
            sb.append(str[i]);
        }
        return sb.toString();
    }
}