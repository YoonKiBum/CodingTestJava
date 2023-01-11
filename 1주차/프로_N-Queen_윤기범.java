import java.util.*;
import java.io.*;

class Solution {
    public static int x = 0;
    public static int[] arr;
    public static int ans = 0;
  
    public static void dfs(int cnt) {
      if(cnt == x) {
        ans += 1;
        return;
      }

      for(int i = 0; i < x; i++) {
        arr[cnt] = i;
        if(check(cnt))
          dfs(cnt + 1);
      }
    }

    public static boolean check(int col) {
      for(int i = 0; i < col; i++) {
        if(arr[i] == arr[col])
          return false;
        else if(Math.abs(col - i) == Math.abs(arr[col] - arr[i]))
          return false;
      }
      return true;
    }
  
    public int solution(int n) {
      arr = new int[n];
      x = n;

      dfs(0);
      return ans;
    }
}
