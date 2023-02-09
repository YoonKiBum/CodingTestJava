import java.util.*;
import java.io.*;

public class Main {  
 public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String str = br.readLine();
    str += "!"; // 연산을 위해 뒤에 아무거나 붙이기
    int numOfOne = 0, numOfZero = 0;
   
    for(int i = 0; i < str.length() -1; i++) {
      if(str.charAt(i) == '0' && str.charAt(i + 1) !='0')
        numOfZero += 1;
      else if(str.charAt(i) == '1' && str.charAt(i + 1) != '1')
        numOfOne += 1;
    }

    System.out.println(Math.min(numOfZero, numOfOne));
  }
}
