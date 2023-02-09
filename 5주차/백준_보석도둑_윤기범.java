import java.util.*;
import java.io.*;

public class Main {  
  public static ArrayList<Info> jewel = new ArrayList<>();
  public static ArrayList<Integer> bag = new ArrayList<>();
  public static long ans = 0;
  
  static class Info implements Comparable<Info>{
    int w;
    int v;
    public Info(int w, int v) {
      this.w = w;
      this.v = v;
    }
    @Override
    public int compareTo(Info o) {
      return this.w - o.w;
    }
  }

  static class Num implements Comparable<Num> {
    int n;
    public Num(int n) {
      this.n = n;
    }
    
    @Override
    public int compareTo(Num o) {
      return o.n - this.n;
    }
  }
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    
    for(int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      jewel.add(new Info(a, b));
    }

    for(int i = 0; i < k; i++) {
      bag.add(Integer.parseInt(br.readLine()));
    }
    // 오름차순 정렬
    Collections.sort(jewel);
    Collections.sort(bag);
    
    long sum = 0;
    int idx = 0;
    PriorityQueue<Num> pq = new PriorityQueue<>();

    for(int i=0; i<k; i++) {
      for(int j=idx; j<n; j++) {
        if(jewel.get(j).w <= bag.get(i)) { // 현재 가방의 무게 이하인 보석을 넣기
          idx++;
          pq.add(new Num(jewel.get(j).v));
        } else { // 탈출
          break;
        }
      }
      if(pq.isEmpty()) // 아무것도 담지 못했다면 다음 가방 기준으로 조회
        continue;
      sum+=pq.poll().n; // 가치가 가장 큰 보석 꺼내서 더하기
    }
    System.out.println(sum);
  }
}
