import java.util.*;
import java.io.*;

public class Main {
  public static int n, k;
  public static int[][] graph;
  public static int[] w;
  public static int[] v;
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    w = new int[n + 1];
    v = new int[n + 1];
    
    for(int i = 1; i < n + 1; i++) {
      st = new StringTokenizer(br.readLine(), " "); 
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      w[i] = a;
      v[i] = b;
    }
    
    graph = new int[n + 1][k + 1];

    for(int i = 1; i < n + 1; i++) {
      for(int j = 1; j < k + 1; j++) {
        graph[i][j] = graph[i-1][j];
        if(j >= w[i]) { // 현재 무게만큼을 들 수 있는 경우
          graph[i][j] = Math.max(graph[i][j], v[i] + graph[i-1][j-w[i]]); // 현재 배낭값과 조합한 배낭값의 최댓값 구함
        }
      }
    }

    System.out.println(graph[n][k]);
  }
}
