import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int T = Integer.parseInt(br.readLine());
    
    for(int t = 0; t < T; t++) {
      int n = Integer.parseInt(br.readLine());
      ArrayList<Integer> arr = new ArrayList<>();
      ArrayList<Long> sum = new ArrayList<>();
      
      st = new StringTokenizer(br.readLine(), " ");
      for(int i = 0; i < n; i++) {
        arr.add(Integer.parseInt(st.nextToken()));
      }
      Collections.reverse(arr); // 뒤집기

      long temp = 0;
      long max = arr.get(0);
      for(int i = 1; i < n; i++) {
        if(max >= arr.get(i)) {
          sum.add(max - arr.get(i));
        } else {
          max = arr.get(i);
        }
      }

      long val = 0;
      for(long a : sum) {
        val += a;
      }
      System.out.println(val);
    }
  }
}
