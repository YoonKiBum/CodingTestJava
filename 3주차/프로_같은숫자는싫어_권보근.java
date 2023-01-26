import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        int last=arr[0];
        answer.add(last);
        for(int i=1; i<arr.length; i++){
            if(arr[i] != last){
                answer.add(arr[i]);
                last = arr[i];
            }
        }
        int arr2[] = new int[answer.size()];
        for(int i=0; i<answer.size(); i++){
            arr2[i] = answer.get(i);
        }

        return arr2;
    }
}