import java.util.*;
import java.io.*;

public class Main {  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    int[] temp = new int[n];
    int ans = 0;
    
    st = new StringTokenizer(br.readLine(), " ");
    for(int i = 0; i < n; i++) {
     arr[i] = Integer.parseInt(st.nextToken()); 
    }  

    Arrays.sort(arr); // 오름차순

    int tempVal = 0;
    for(int i = 0; i < n; i++) {
      tempVal += arr[i];
      temp[i] = tempVal;
    }

    for(int num : temp) {
      ans += num;
    }
    System.out.println(ans);
  }  
}
