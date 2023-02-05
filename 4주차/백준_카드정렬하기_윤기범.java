import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      PriorityQueue<Integer> pq = new PriorityQueue<>();
      for(int i = 0; i < n; i++) {
        pq.offer(Integer.parseInt(br.readLine()));
      }

      int ans = 0;
      while(true) {
        if(pq.size() == 1)
          break;
        int a = pq.poll(); // 가장 작은 값 2개 꺼내기
        int b = pq.poll();
        ans += (a + b); // 더한값을 ans에 더하기
        pq.offer(a + b); // 더한값을 다시 우선순위 큐에 삽입
      }
    System.out.println(ans);
  }
}
