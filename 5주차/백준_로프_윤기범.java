import java.util.*;
import java.io.*;

public class Main {  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    for(int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(arr); // 오름차순
    int ans = 0;
    int idx = 0;
    while(true) {
      if(n == 0)
        break;
      ans = Math.max(ans, arr[idx] * n);
      n -= 1;
      idx += 1;
    }
    
    System.out.println(ans);
  }
}
