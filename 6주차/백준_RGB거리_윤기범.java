import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[n][3];
    for(int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for(int j = 0; j < 3; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    
    for(int i = 1; i < n; i++) {
      for(int j = 0; j < 3; j++) {
        if(j == 0) { // 같은 열 즉 같은 색은 제외하기 위함
          arr[i][j] += Math.min(arr[i-1][1], arr[i-1][2]);
        } else if(j == 1) {
          arr[i][j] += Math.min(arr[i-1][0], arr[i-1][2]);
        } else {
          arr[i][j] += Math.min(arr[i-1][0], arr[i-1][1]);
        }
      }
    }

    int min = 987654321;
    for(int num : arr[n-1]) { // 최소값 찾기
      min = Math.min(min, num);
    }

    System.out.println(min);
  }
}
