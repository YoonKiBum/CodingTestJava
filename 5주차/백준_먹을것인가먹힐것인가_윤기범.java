import java.util.*;
import java.io.*;

public class Main {  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int T = Integer.parseInt(br.readLine());
    for(int t = 0; t < T; t++) {
      st = new StringTokenizer(br.readLine(), " ");
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());

      Integer[] A = new Integer[n];
      st = new StringTokenizer(br.readLine(), " ");
      for(int i = 0; i < n; i++) {
        A[i] = Integer.parseInt(st.nextToken());
      }

      Integer[] B = new Integer[m];
      st = new StringTokenizer(br.readLine(), " ");
      for(int i = 0; i < m; i++) {
        B[i] = Integer.parseInt(st.nextToken());
      }

      Arrays.sort(A, Collections.reverseOrder()); // 내림차순
      Arrays.sort(B, Collections.reverseOrder()); // 내림차순

      int num = 0;
      int idx = 0; // A의 인덱스
      int idx2 = 0;// B의 인덱스
      
      while(true) {
        if(idx == n || idx2 == m) // A, B 둘 중 하나의 인덱스라도 끝에 닿으면 break
          break;
        if(A[idx] > B[idx2]) { // A의 인덱스가 B의 인덱스보다 크다면
          idx++; // A의 인덱스 증가
          num += (m - idx2); // m-idx2 개수만큼 증가
        } else {
          idx2++; // B의 인덱스가 더 크면 idx2 증가
        }
      }
      
      System.out.println(num);
    }
  }
}
