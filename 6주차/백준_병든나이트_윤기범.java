import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int ans = 0;
    
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken()); 

    if(n >= 3 && m >= 7) { // 4가지 움직일수 있는 최소 경우
      ans = 5;
      if(m - 7 > 0) {
        ans += (m - 7); 
      }
      System.out.println(ans);
    } else {
      if(n >= 3) { // 세로로 한칸씩 놓을 수 있는 경우
        ans = m;
      } else { // 세로로 한칸씩 놓을 수 없는 경우
        if(n == 1) {
          ans = 1;
        }
        else if(n == 2) {
         if(m%2==0)
          ans = m / 2;
          else
          ans = (m + 1) / 2; 
        }
      }
      if(ans > 4)
        ans = 4;
      System.out.println(ans);
    }
  }
}
