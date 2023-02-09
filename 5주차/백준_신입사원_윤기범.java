import java.util.*;
import java.io.*;

public class Main {  
  static class Info implements Comparable<Info> {
    int a;
    int b;
    public Info(int a, int b) {
      this.a = a;
      this.b = b;
    }
    @Override
    public int compareTo(Info o) { // 1차 점수 기준으로 오름차순
      return this.a - o.a;
    }
  }
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());
    for(int t = 0; t < T; t++) {
      int n = Integer.parseInt(br.readLine());
      Info[] score = new Info[n];
      for(int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        score[i] = new Info(a, b);
      }

      Arrays.sort(score);
      int num = 0;
      int temp = score[0].b;
      for(int i = 1; i < n; i++) {
        if(score[i].b < temp) {
          temp = score[i].b;
        } else {
          num += 1;
        }
      }

      System.out.println(n - num);
    }
  }
}
