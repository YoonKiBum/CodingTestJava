import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] d = new int[100001];
    
    d[1] = 1;
    int idx = 1;
    
    for (int i = 1; i <= n; i++) {
      d[i] = i;
      for (int j = 1; j * j <= i; j++) {
        if (d[i] > d[i - j * j] + 1) {
          d[i] = d[i - j * j] + 1;
        }
      }
    }
    System.out.println(d[n]);
  }
}
