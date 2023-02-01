import java.util.*;
import java.io.*;

class Solution {
    // 정렬 위한 클래스
    static class Info implements Comparable<Info>{
        int person;
        int number;
        
        public Info(int person, int number) {
            this.person = person;
            this.number = number;
        }
        
        @Override
        public int compareTo(Info o) {
            int r = -(this.number - o.number); // 맞춘 문제 순으로 내림차순
            if(r == 0) {
                return this.person - o.person; // 맞춘 문제가 같다면 사람번호로 오름차순
            }
            return r;
        }
    }
    
    public int[] solution(int[] answers) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] arr3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int cnt1 = 0, cnt2 = 0, cnt3 = 0;
        Info[] tempArr = new Info[3];
        
        // 1번이 맞춘 문제 구하기
        for(int i = 0; i < answers.length; i++) {
            int temp = i;
            if (temp > arr1.length-1) {
                temp %= 5;
            }
            if(answers[i] == arr1[temp])
                cnt1 += 1;
        }
        
        // 2번이 맞춘 문제 구하기
        for(int i = 0; i < answers.length; i++) {
            int temp = i;
            if (temp > arr2.length-1) {
                temp %= 8;
            }
            if(answers[i] == arr2[temp])
                cnt2 += 1;
        }
        
        // 3번이 맞춘 문제 구하기
        for(int i = 0; i < answers.length; i++) {
            int temp = i;
            if (temp > arr3.length-1) {
                temp %= 10;
            }
            if(answers[i] == arr3[temp])
                cnt3 += 1;
        }

        tempArr[0] = new Info(1, cnt1);
        tempArr[1] = new Info(2, cnt2);
        tempArr[2] = new Info(3, cnt3);
        
        Arrays.sort(tempArr); // 정렬
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        Info info = tempArr[0];
        arr.add(info.person);
        
        for(int i = 1; i < 3; i++) { // 정렬한 첫번쨰 원소와 비교하며
            Info temp = tempArr[i];
            if(info.number == temp.number) // 첫번쨰 원소와 그 다음 원소가 같다면 삽입
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
