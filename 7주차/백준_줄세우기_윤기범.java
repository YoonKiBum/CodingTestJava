import java.util.*;
import java.io.*;

public class Main {
  public static int n, m;
  public static int[] indegree;
  public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
  public static ArrayList<Integer> ans = new ArrayList<>();
  
  public static void topologySort() {
    Queue<Integer> q = new LinkedList<>();
    for(int i = 1; i < n + 1; i++) {
      if(indegree[i] == 0) {
        q.offer(i);
      }
    }

    while(!q.isEmpty()) {
      int v = q.poll();
      ans.add(v);
      for(int i = 0; i < graph.get(v).size(); i++) {
        int y = graph.get(v).get(i);
        indegree[y] -= 1;
        if(indegree[y] == 0) {
          q.offer(y);
        }
      }
    }

    for(int x : ans) {
      System.out.print(x + " ");
    }
  }
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    for(int i = 0; i < n + 1; i++) {
      graph.add(new ArrayList<>());
    } 
    
    indegree = new int[n + 1];
    for(int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      indegree[b] += 1;
      graph.get(a).add(b);
    }
  
    topologySort();
  }
}
