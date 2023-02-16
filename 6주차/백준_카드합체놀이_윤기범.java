import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    PriorityQueue<Long> pq = new PriorityQueue<>();
    
    st = new StringTokenizer(br.readLine(), " ");
    for(int i = 0; i < n; i++) {
      pq.offer(Long.parseLong(st.nextToken()));
    }

    
    for(int i = 0; i < m; i++) {
      long a = pq.poll();
      long b = pq.poll();
      pq.offer(a + b);
      pq.offer(a + b);
    }

    int len = pq.size();
    long sum = 0;
    for(int i = 0; i < len; i++) {
      sum += pq.poll();
    }
    System.out.println(sum);
  }
}
