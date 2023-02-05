import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[][] graph = new int[n][m];
    for(int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for(int j = 0; j < m; j++) {
        graph[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for(int i = 0; i < n; i++) {
      for(int j = 0; j < m; j++) {
        if(i == 0) { // 첫헹
          if(j - 1 >= 0) // 첫행의 두번째 열부터
            graph[i][j] += graph[i][j-1];
        } else { // 첫행 X
          if(j == 0) // 첫열
             graph[i][j] += graph[i-1][j];
          else {
            int max = 0;
            max = Math.max(graph[i][j-1], graph[i-1][j-1]);
            max = Math.max(max, graph[i-1][j]);
            graph[i][j] += max;
          }
        }
      }
    }

    System.out.println(graph[n-1][m-1]);
  }
}
