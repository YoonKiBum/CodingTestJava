import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] graph = new int[n + 1][10];

    for(int i = 1; i < 10; i++) {
      graph[1][i] = 1;
    }

    for(int i = 1; i < n; i++) {
      for(int j = 0; j < 10; j++) {
        if(j == 0) {
          graph[i+1][j+1] = (graph[i+1][j+1] + graph[i][j]) % 1000000000;
        }
        if(j == 9) {
          graph[i+1][j-1] = (graph[i+1][j-1] + graph[i][j]) % 1000000000;
        } else if(1 <= j && j <= 8) {
          graph[i+1][j-1] = (graph[i+1][j-1] + graph[i][j]) % 1000000000;
          graph[i+1][j+1] = (graph[i+1][j+1] + graph[i][j]) % 1000000000;
        }
      }
    }

    long ans = 0;
    for(int i = 0; i < 10; i++) {
      ans = (ans + graph[n][i]) % 1000000000;
    }

    System.out.println(ans);
  }
}
