import java.util.*;
import java.io.*;

public class Main {  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    
    int n = Integer.parseInt(st.nextToken());
    int money = Integer.parseInt(st.nextToken());
    int ans = 0;
    
    Integer[] data = new Integer[n];
    for(int i = 0; i < n; i++) {
      data[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(data, Collections.reverseOrder()); // 내림차순

    for(int i = 0; i < n; i++) {
      if(money >= data[i]) {
        ans += money / data[i];
        money %= data[i];
      }
    }

    System.out.println(ans);
  }  
}
