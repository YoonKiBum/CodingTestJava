import java.util.*;
import java.io.*;

public class Main {  
  public static String a, b;
  public static String[] arr;
  public static boolean[] visited;
  public static String[] numbers;
  public static ArrayList<Integer> array = new ArrayList<>();
  
  public static void perm(int cnt) {
    if(cnt == a.length()) {
      String temp = "";
      for(int i = 0; i < numbers.length; i++) {
        temp += numbers[i];
      }
      if(temp.charAt(0) != '0' && Integer.parseInt(temp) < Integer.parseInt(b) && Integer.parseInt(temp) != Integer.parseInt(a)) {
        array.add(Integer.parseInt(temp));
      }
      return;
    }

    for(int i = 0; i < a.length(); i++) {
      if(!visited[i]) {
        visited[i] = true;
        numbers[cnt] = arr[i];
        perm(cnt + 1);
        visited[i] = false;
      }
    }
  }
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    a = st.nextToken();
    b = st.nextToken();

    arr = new String[a.length()];
    visited = new boolean[a.length()];
    numbers = new String[a.length()];
    
    for(int i = 0; i < a.length(); i++) {
      arr[i] = String.valueOf(a.charAt(i));
    }

    perm(0);

    if(array.size() == 0)
      System.out.println(-1);
    else {
      Collections.sort(array);
      Collections.reverse(array); 
      System.out.println(array.get(0));
    }
  }
}
