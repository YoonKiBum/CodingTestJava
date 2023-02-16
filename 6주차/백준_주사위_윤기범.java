import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    long n = Long.parseLong(br.readLine());
    long[] arr = new long[6];
    st = new StringTokenizer(br.readLine(), " ");
    for(int i = 0; i < 6; i++) {
      arr[i] = Long.parseLong(st.nextToken());
    }

    long[] triMax = {
      arr[0] + arr[1] + arr[2], arr[0] + arr[2] + arr[4],
      arr[1] + arr[2] + arr[5], arr[2] + arr[4] + arr[5],
      arr[0] + arr[4] + arr[3], arr[0] + arr[1] + arr[3],
      arr[4] + arr[3] + arr[5], arr[1] + arr[3] + arr[5]
    };
    Arrays.sort(triMax);
    long tMax = triMax[0];
    // System.out.println(Arrays.toString(triMax));
    
    long[] doMax = {
      arr[0] + arr[1], arr[0] + arr[2], arr[0] + arr[3],
      arr[0] + arr[4], arr[1] + arr[2], arr[1] + arr[3],
      arr[1] + arr[5], arr[2] + arr[5], arr[2] + arr[4],
      arr[3] + arr[5], arr[3] + arr[4], arr[4] + arr[5]
    };
    Arrays.sort(doMax);
    long dMax = doMax[0];
    // System.out.println(Arrays.toString(doMax));
    
    Arrays.sort(arr);
    long sMax = arr[0];
    // System.out.println(Arrays.toString(arr));
    
    long num1 = tMax * 4;
    long num2 = dMax * (n-2) * 8;
    long num3 = sMax * (n-2) * (n-2) * 5;
    long num4 = dMax * 4;
    long num5 = sMax * (n-2) * 4;

    if(n >= 2)
      System.out.println(num1 + num2 + num3 + num4 + num5);
    else
      System.out.println(arr[0] + arr[1] + arr[2] + arr[3] + arr[4]);
  }
}
