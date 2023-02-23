import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    
    int n = Integer.parseInt(br.readLine());
    int INF = (int)1e9;
    
    int[][] graph = new int[n + 1][n + 1];

    for(int i = 1; i < n + 1; i++) {
      for(int j = 1; j < n + 1; j++) {
        graph[i][j] = INF;
      }
    }

    for(int i = 1; i < n + 1; i++) {
      for(int j = 1; j < n + 1; j++) {
        if(i == j) {
          graph[i][j] = 0;
        }
      }
    }

    for(int i = 1; i < n + 1; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for(int j = 1; j < n + 1; j++) {
        graph[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    
    for(int k = 1; k < n + 1; k ++) {
      for(int a = 1; a < n + 1; a++) {
        for(int b = 1; b < n + 1; b++) {
          if(graph[a][k] == 1 && graph[k][b] == 1)
            graph[a][b] = 1;
        }
      }
    }

    for(int i = 1; i < n + 1; i++) {
      for(int j = 1; j < n + 1; j++) {
        sb.append(graph[i][j]).append(" ");
      }
      sb.append("\n");
    }
    System.out.print(sb);
  }
}

