import java.util.*;
import java.io.*;

public class Main {  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int ans = 0;
    
    // 우선순위 큐에 삽입
    for(int i = 0; i < n; i++) {
      pq.offer(Integer.parseInt(br.readLine()));
    }
  
    while(true) {
      if(pq.size() == 1) // 우선순위 큐의 사이즈가 1이면 종료
        break;
      int num1 = pq.poll(); // 가장 작은 값 2개를 꺼내서 합하기
      int num2 = pq.poll();
      ans += (num1 + num2);
      pq.offer(num1 + num2);
    }

    System.out.println(ans);
  }
}
