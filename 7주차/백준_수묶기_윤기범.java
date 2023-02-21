import java.util.*;
import java.io.*;

public class Main {
  public static int n;
  public static int ans = 0;
  public static PriorityQueue<Integer> pqplus = new PriorityQueue<>();
  public static PriorityQueue<Integer> pqminus = new PriorityQueue<>();
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());

    for(int i = 0; i < n; i++) {
      int num = Integer.parseInt(br.readLine());
      if(num > 0)
        pqplus.add(num * -1); // 최소힙을 최대힙으로 사용하기 위함
      else
        pqminus.add(num);
    }

    while(!pqplus.isEmpty()) {
      if(pqplus.size() >= 2) {
        int num1 = -pqplus.poll();
        int num2 = -pqplus.poll();

        if(num1 <= 1 || num2 <= 1) {
          ans += (num1 + num2);
        } else {
          ans += (num1 * num2);
        }
      } else {
        int num1 = -pqplus.poll();
        ans += num1;
      }
    }

    while(!pqminus.isEmpty()) {
      if(pqminus.size() >= 2) {
        int num1 = pqminus.poll();
        int num2 = pqminus.poll();

        ans += (num1 * num2);
      } else {
        int num1 = pqminus.poll();
        ans += num1;
      }
    }

    System.out.println(ans);
  }
}
