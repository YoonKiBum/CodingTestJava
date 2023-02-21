import java.util.*;
import java.io.*;

public class Main {
  public static int n;
  public static int[] arr;
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    arr = new int[n];

    st = new StringTokenizer(br.readLine(), " ");
    for(int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    } 

    int idx = 0;
    Arrays.sort(arr);
    int point = 0;
    if(n % 2 == 0) {
      point = n / 2 - 1;
    } else {
      point = n / 2;
    }
    System.out.println(arr[point]);
  }
}
