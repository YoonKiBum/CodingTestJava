import java.util.*;
import java.io.*;

public class Solution {
    public static Stack<Integer> stack = new Stack<>();
    
    public int[] solution(int []arr) {
        for(int i = 0; i < arr.length; i++) {
            if(stack.size() == 0) {
                stack.push(arr[i]);
            } else {
                if(stack.peek() != arr[i])
                    stack.push(arr[i]);
            }
        }
        int[] array = new int[stack.size()];
        int len = stack.size();
        for(int i = 0; i < len; i++) {
            array[i] = stack.pop();
        }
        int[] ans = new int[len];
        for(int i = 0; i < len; i++) {
            ans[i] = array[len-i-1];
        }
        return ans;
    }
}
