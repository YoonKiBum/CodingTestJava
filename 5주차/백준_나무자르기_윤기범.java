import java.util.*;
import java.io.*;

public class Main {  
  public static int n, m;
  public static int[] arr;
  public static long maxValue = 0;
  public static long ans = 0;
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    arr = new int[n];

    st = new StringTokenizer(br.readLine(), " ");
    for(int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      if(maxValue < arr[i])
        maxValue = arr[i];
    }

    long start = 0;
    long end = maxValue + 1;
    while(true) {
      if(start > end)
        break;
      long temp = 0;
      long mid = (start + end) / 2;
      for(int i = 0; i < n; i++) {
        if(arr[i] > mid)
          temp += (arr[i] - mid);
      }
      if(temp >= m) {
        start = mid + 1;
        ans = Math.max(ans, mid);
      } else {
        end = mid - 1;
      }
    }

    System.out.println(ans);
  }
}
