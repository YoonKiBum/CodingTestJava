import java.util.*;
import java.io.*;

public class Main {  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    boolean flag = false;
    int ans = 0;
    
    String str = br.readLine() + "!";
    String temp = "";
    for(int i = 0; i < str.length(); i++) {
      if('0' <= str.charAt(i) && str.charAt(i) <= '9') { // 숫자
        temp += String.valueOf(str.charAt(i));
      }
      else { // 문자
        if(flag == false && str.charAt(i) == '-') {
          flag = true;
          ans += Integer.parseInt(temp);
          temp = "";
        } else if(flag == true) {
          ans -= Integer.parseInt(temp);
          temp = "";
        } else {
          ans += Integer.parseInt(temp);
          temp = "";
        }
      }
    }

    System.out.println(ans);
  }  
}
