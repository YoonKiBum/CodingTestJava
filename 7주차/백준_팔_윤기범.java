import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    String a = st.nextToken();
    String b = st.nextToken();

    int numA = 0;
    int numB = 0;
    for(int i = 0; i < a.length(); i++) {
      if(a.charAt(i) == '8') {
        numA += 1;
      } 
    }
    for(int i = 0; i < b.length(); i++) {
      if(b.charAt(i) == '8') {
        numB += 1;
      } 
    }

    if(numA == 0 || numB == 0) {
      System.out.println(0);
    } else {
      int ans = 0;
      ArrayList<Integer> arr = new ArrayList<>();
      for(int i = 0; i < b.length(); i++) {
        if(b.charAt(i) == '8')
          arr.add(i);
      }
      int start = 0;
      boolean check = false;
      int tempNumber = b.length() - a.length();
      for(int i = 0; i < tempNumber; i++) {
        a = "0" + a;
      }
      for(int i = 0; i < arr.size(); i++) {
        if(!check){
        loop: for(int j = start; j <= arr.get(i); j++) {
          if(a.charAt(j) != b.charAt(j)) {
            check = true;
            break loop;
          }
        } 
        }
        start = arr.get(i);
        if(!check) {
          ans += 1;
        }
      }
      System.out.println(ans);
    }
  }
}

