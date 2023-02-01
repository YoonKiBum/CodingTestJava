import java.util.*;
import java.io.*;

class Solution {
    static class Info implements Comparable<Info>{
        int person;
        int number;
        
        public Info(int person, int number) {
            this.person = person;
            this.number = number;
        }
        
        @Override
        public int compareTo(Info o) {
            int r = -(this.number - o.number);
            if(r == 0) {
                return this.person - o.person;
            }
            return r;
        }
    }
    
    public static int count(int[] answers, int [] array) {
        int cnt = 0;
        
        for(int i = 0; i < answers.length; i++) {
            int temp = i;
            if (temp > array.length-1) {
                temp %= array.length;
            }
            if(answers[i] == array[temp])
                cnt += 1;
        }
        return cnt;
    }
    
    public int[] solution(int[] answers) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] arr3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int cnt1 = 0, cnt2 = 0, cnt3 = 0;
        
        Info[] tempArr = new Info[3];

        tempArr[0] = new Info(1, count(answers, arr1));
        tempArr[1] = new Info(2, count(answers, arr2));
        tempArr[2] = new Info(3, count(answers, arr3));
        
        Arrays.sort(tempArr);
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        Info info = tempArr[0];
        arr.add(info.person);
        
        for(int i = 1; i < 3; i++) {
            Info temp = tempArr[i];
            if(info.number == temp.number)
                arr.add(temp.person);
            else
                break;
        }
        
        int[] answer = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }

        return answer;
    }
}
