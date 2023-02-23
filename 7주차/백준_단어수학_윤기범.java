import java.util.*;
import java.io.*;

public class Main {
  public static int ans = 0;
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[26];
    
    for(int i = 0; i < n; i++) {
      String str = br.readLine();
      for(int j = 0; j < str.length(); j++) {
      int num = (int)Math.pow(10, str.length()-j-1);
        arr[str.charAt(j) - 'A'] += num;
      }
    }

    Arrays.sort(arr);
    int val = 9;
    
    for(int i = arr.length - 1; i >= 0; i--) {
      if(arr[i] != 0) {
        ans += arr[i] * val;
        val-=1;
      }
    }

    System.out.println(ans);
  }
}

