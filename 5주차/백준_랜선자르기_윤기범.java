import java.util.*;
import java.io.*;

public class Main {  
  public static int k, n;
  public static long[] arr;
  public static long ans = 0;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    k = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());
    arr = new long[k];
    long maxVal = 0;
    
    for(int i = 0; i < k; i++) {
      arr[i] = Integer.parseInt(br.readLine());
      if(arr[i] > maxVal) 
        maxVal = arr[i];
    }

    long start = 0;
    long end = maxVal;
    
    while(true) {
      int count = 0;
      if(start > end)
        break;
      long mid = (start + end + 1) / 2;
      for(int i = 0; i <  k; i++) {
        count += (arr[i] / mid);
      }
      if(count < n) {
        end = mid - 1;
      }
      else {
        start = mid + 1;
        ans = Math.max(ans, mid);
      }
    }

    System.out.println(ans);
  }
}
