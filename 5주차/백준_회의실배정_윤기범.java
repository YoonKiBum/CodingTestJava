import java.util.*;
import java.io.*;

public class Main {  
  public static ArrayList<Info> arr = new ArrayList<>();
  public static int ans = 0;
  
  static class Info implements Comparable<Info>{ 
    int start;
    int end;
    public Info(int start, int end) {
      this.start = start;
      this.end = end;
    }
    @Override
    public int compareTo(Info o) { // 끝나는 시간 기준 오름차순, 끝나는 시간이 같다면 시작시간 기준 오름차순
      int r = this.end - o.end;
      if(r == 0) {
        return this.start - o.start;
      } else {
        return r;
      }
    }
  }
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    
    int n = Integer.parseInt(br.readLine());

    for(int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      arr.add(new Info(a, b));
    }

    Collections.sort(arr);
    int s = -1;
    int e = -1;
    
    for(int i = 0; i < arr.size(); i++) {
      Info temp = arr.get(i);
      if(e <= temp.start) { // 현재 끝나는 시간보다 다음에 시작할 시간이 더 나중이라면 해당 회의 실행
        s = temp.start;
        e = temp.end; 
        ans += 1;
      }
    }

    System.out.println(ans);
  }  
}
