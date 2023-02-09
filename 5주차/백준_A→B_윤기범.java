import java.util.*;
import java.io.*;

public class Main {  
  public static int a, b;
  
  public static int bfs(long n) {
    int ans = 1;
    Queue<Long> q = new LinkedList<>();
    q.offer(n);

    while(!q.isEmpty()) {
      int len = q.size();
      for(int t = 0; t < len; t++) {
        long v = q.poll();
        for(int i = 0; i < 2; i++) {
          if(2 * v <= b && i == 0) { // 2 곱하는 경우
            if(2*v == b) {
              return ans + 1;
            }
            q.offer(2*v);
          } else if(10*v + 1 <= b && i == 1) { // 뒤에 1을 붙이는 경우
            if(10*v + 1 == b) {
              return ans + 1;
            }
            q.offer(10*v+1);
          }
        }    
      }
      ans += 1;
    }
    return -1;
  }
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    a = Integer.parseInt(st.nextToken());
    b = Integer.parseInt(st.nextToken());
    System.out.println(bfs(a));
    
  }
}
