import java.util.*;
import java.io.*;

public class Main {
  public static int n;
  public static PriorityQueue<Integer> pq = new PriorityQueue<>();
  public static ArrayList<Node> arr = new ArrayList<>();
  
  static class Node implements Comparable<Node> {
    int s;
    int e;
    public Node(int s, int e) {
      this.s = s;
      this.e = e;
    }
    @Override
    public int compareTo(Node o) {
      int r = this.s - o.s;
      if(r == 0) {
        return this.e - o.e;
      } else {
        return r;
      }
    }
  }
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    
    n = Integer.parseInt(br.readLine());
    for(int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      arr.add(new Node(a, b));
    }

    Collections.sort(arr);

    for(int i = 0; i < n; i++) {
      Node node = arr.get(i);
      int a = node.s;
      int b = node.e;
      
      if(pq.size() == 0) {
        pq.offer(b);
      } else {
        if (a >= pq.peek()) {
          pq.poll();
          pq.offer(b);
        } else {
          pq.offer(b);
        }
      }
    }
    System.out.println(pq.size());
  }
}
