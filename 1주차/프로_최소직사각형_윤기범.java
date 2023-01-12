import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] sizes) {
        int row = sizes.length;
        int col = sizes[0].length;
        
        Integer[][] arr = new Integer[row][col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                arr[i][j] = sizes[i][j];
            }
        }
        
        for(int i = 0; i < row; i++) {
            Arrays.sort(arr[i], Collections.reverseOrder());
        }
        
        int a = 0;
        int b = 0;
        
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                a = Math.max(a, arr[i][0]);
                b = Math.max(b, arr[i][1]);
            }
        }
        
        return a * b;
    }
}

