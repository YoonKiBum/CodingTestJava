import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
  public static int n;
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<Integer> ans = new ArrayList<>();

    n = Integer.parseInt(br.readLine());

    String str = br.readLine();

    // 오른쪽
    String temp = str + "!";
    int numR = 0;
    int numB = 0;
    int val = 0;
    for(int i = 0; i < n; i++) {
      if(temp.charAt(i) == '!')
        break;
      val += 1;
      if(temp.charAt(i) == 'R' && temp.charAt(i + 1) == 'B') {
        numR += val;
        val = 0;
      } else if(temp.charAt(i) == 'B' && temp.charAt(i + 1) == 'R') {
        numB += val;
        val = 0;
      } 
    }

    // System.out.println(numR + " " + numB);
    ans.add(numR);
    ans.add(numB);
    
    // 왼쪽
    temp = "!" + str;
    numR = 0;
    numB = 0;
    val = 0;
    for(int i = n; i >= 0; i--) {
      if(temp.charAt(i) == '!')
        break;
      val += 1;
      if(temp.charAt(i) == 'R' && temp.charAt(i - 1) == 'B') {
        numR += val;
        val = 0;
      } else if(temp.charAt(i) == 'B' && temp.charAt(i - 1) == 'R') {
        numB += val;
        val = 0;
      } 
    }

    // System.out.println(numR + " " + numB);
    ans.add(numR);
    ans.add(numB);

    Collections.sort(ans);
    System.out.println(ans.get(0));
  }
}
