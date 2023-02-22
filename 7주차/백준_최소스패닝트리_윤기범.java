import java.util.*;
import java.io.*;

public class Main {
  public static int v, e;
  public static int[] parent;
  public static ArrayList<Node> arr = new ArrayList<>();
  public static int ans = 0;
  
  public static int findParent(int[] parent, int x) {
    if(x != parent[x]) {
      x = findParent(parent, parent[x]);
    }
    return x;
  }

  public static void unionParent(int[] parent, int a, int b) {
    a = findParent(parent, a);
    b = findParent(parent, b);
    if(a < b)
      parent[b] = a;
    else
      parent[a] = b;
  }

  static class Node implements Comparable<Node>{
    int nodeA;
    int nodeB;
    int cost;

    public Node(int nodeA, int nodeB, int cost) {
      this.nodeA = nodeA;
      this.nodeB = nodeB;
      this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
      return this.cost - o.cost;
    }
  }
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    v = Integer.parseInt(st.nextToken());
    e = Integer.parseInt(st.nextToken());

    parent = new int[v + 1];
    for(int i = 0; i < v + 1; i++) {
      parent[i] = i;
    }

    for(int i = 0; i < e; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int nodeA = Integer.parseInt(st.nextToken());
      int nodeB = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());
      arr.add(new Node(nodeA, nodeB, cost));
    }

    Collections.sort(arr);

    for(Node node : arr) {
      int nodeA = node.nodeA;
      int nodeB = node.nodeB;
      int cost = node.cost;

      if(findParent(parent, nodeA) != findParent(parent, nodeB)) {
        unionParent(parent, nodeA, nodeB);
        ans += cost;
      }
    }

    System.out.println(ans);
  }
}
