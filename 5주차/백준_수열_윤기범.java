import java.util.*;
import java.io.*;

public class Main {  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int[] arr = new int[n];
    st = new StringTokenizer(br.readLine(), " ");
    for(int i = 0; i < n; i++) { 
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int max = -987654321; // 최소값

    int temp = 0;
    for(int i = 0; i < k; i++) { // 미리 k개만큼의 합을 구하기
      temp += arr[i];
    }
    max = Math.max(max, temp);

    for(int i = k; i < n; i++) { // 그 이후로 오른쪽으로 슬라이딩 하며 뒤쪽에 하나 추가 앞에 하나 감소
      temp += arr[i];
      temp -= arr[i-k];
      max = Math.max(max, temp);
    }

    System.out.println(max);
  }
}
