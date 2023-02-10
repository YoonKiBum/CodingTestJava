import java.util.*;
import java.io.*;

public class Main {  
  public static int n, m;
  public static long[] arr;
  public static long maxValue = 0;
  public static long ans = 987654321;
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    arr = new long[m];

    for(int i = 0; i < m; i++) {
      arr[i] = Integer.parseInt(br.readLine());
      if(maxValue < arr[i])
        maxValue = arr[i];
    }

    long start = 1;
    long end = maxValue;
    
    while(true) {
      if(start > end)
        break;
      long temp = 0;
      long mid = (start + end) / 2;
      for(int i = 0; i < m; i++) {
        temp += (arr[i] / mid);
        if(arr[i] % mid > 0) // 나머지가 존재하면 사람 한명 더 줄 수 있음
          temp += 1;
      }
      if(temp <= n) { // 다 나눠주지 않아도 되므로
        end = mid - 1;
        ans = Math.min(ans, mid);
      } else { // 사람 
        start = mid + 1;
      }
    }

    System.out.println(ans);
  }
}
