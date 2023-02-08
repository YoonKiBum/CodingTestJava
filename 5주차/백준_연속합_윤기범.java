import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    int max = -987654321;
    
    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 1; i < n; i++) {
      arr[i] = Math.max(arr[i], arr[i] + arr[i - 1]);
    }

    for(int num : arr) {
      if(max < num)
        max = num;
    }

    System.out.println(max);
  }
}
