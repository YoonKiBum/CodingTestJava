import java.util.*;
import java.io.*;

public class Main {
  public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
  public static int n;
  public static int[] parent;
  public static boolean[] visited;
  
  public static void bfs(int start) {
    Queue<Integer> q = new LinkedList<>();
    q.offer(start);
    visited[start] = true;

    while(!q.isEmpty()) {
      int v = q.poll();
      for(int i = 0; i < graph.get(v).size(); i++) {
        int y = graph.get(v).get(i);
        if(!visited[y]) {
          q.offer(y);
          visited[y] = true;
          parent[y] = v;
        }
      }
    }
  }
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());

    parent = new int[n + 1];
    visited = new boolean[n + 1];
    for(int i = 0; i < n + 1; i++) {
      graph.add(new ArrayList<>());
    }
    
    for(int i = 0; i < n - 1; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      graph.get(a).add(b);
      graph.get(b).add(a);
    }

    bfs(1);
    
    for(int i = 2; i < n + 1; i++) {
      System.out.println(parent[i]);
    }
  }
}
