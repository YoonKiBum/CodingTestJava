import java.util.*;
import java.io.*;

public class Main {
  public static int n, m;
  public static int[][] arr1;
  public static int[][] arr2;
  
  public static void change(int x, int y) {
    
    for(int i = x; i < x + 3; i++) {
      for(int j = y; j < y + 3; j++) {
        if(arr1[i][j] == 0)
          arr1[i][j] = 1;
        else
          arr1[i][j] = 0;
      }
    }
  }
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    
    arr1 = new int[n][m];
    arr2 = new int[n][m];

    for(int i = 0; i < n; i++) {
      String str = br.readLine();
      for(int j = 0; j < m; j++) {
        arr1[i][j] = str.charAt(j) - '0';
      }
    }

    for(int i = 0; i < n; i++) {
      String str = br.readLine();
      for(int j = 0; j < m; j++) {
        arr2[i][j] = str.charAt(j) - '0';
      }
    }    

    if(n < 3 || m < 3) {
      boolean flag = true;
      check: for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
           if(arr1[i][j] != arr2[i][j]) {
             flag = false;
             break check;
           }
        }
      }
        if(flag)
          System.out.println(0);
        else
          System.out.println(-1);
        return;
    }
    
    int cnt = 0;
    for(int i = 0; i < n-2; i++) {
      for(int j = 0; j < m-2; j++) {
        if(arr1[i][j] != arr2[i][j]) {
          change(i, j);
          cnt += 1;
        }
      }
    }

    boolean flag = true;
    check: for(int i = 0; i < n; i++) {
      for(int j = 0; j < m; j++) {
        if(arr1[i][j] != arr2[i][j]) {
          flag = false;
          break check;
        }
      }
    }

    if(flag)
      System.out.println(cnt);
    else
      System.out.println(-1);
  }
}
