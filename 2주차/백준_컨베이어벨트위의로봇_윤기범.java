import java.util.*;
import java.io.*;

public class Main {
  public static int n, k;
  public static Info[] arr;

  public static void rotate() {
    // 회전
    Info temp = arr[2*n-1];
    for(int i = 2*n-1; i > 0; i--) {
      arr[i] = arr[i-1];
    }
    arr[0] = temp;

    // 내리는 칸에 로봇이 존재하면 내리기
    if(arr[n-1].robot == 1) {
      arr[n-1].robot = 0;
    }
  }

  public static void moveRobot() {
    for(int i = n-1; i > 0; i--) {
       // 내리는 칸 직전 칸부터 조회하며 로봇이 존재하고 현재 칸에 내구도가 1이상이고 현재칸에 로봇이 없다면
      if(arr[i-1].robot == 1 && arr[i].robot == 0 && arr[i].num >= 1) {
        arr[i-1].robot = 0; // 직전칸 로봇 내리고
        arr[i].robot = 1; // 현재킨 로봇 올리고
        arr[i].num -= 1; // 현재칸 내구도 내리기
      }
    } 
    // 내리는 칸에 로봇이 존재하면 내리기
    if(arr[n-1].robot == 1) {
      arr[n-1].robot = 0;
    }
  }

  public static void loadRobot() {
    if(arr[0].num >= 1) { // 올리는 칸 내구도가 1이상이라면
      arr[0].robot = 1; // 로봇 올리기
      arr[0].num -= 1; // 내구도 1 감소
    }
  }

  public static boolean check() {
    int count = 0;
    for(int i = 0; i < 2*n; i++) {
      if(arr[i].num == 0)
        count += 1;
    }
    if(count >= k)
      return true;
    return false;
  }
  
  static class Info {
    int num;
    int robot;
    public Info(int num, int robot) {
      this.num = num;
      this.robot = robot;
    }

    @Override
    public String toString() {
     return num + " " + robot;
    }
  }
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    arr = new Info[2 * n];
    st = new StringTokenizer(br.readLine(), " ");
    for(int i = 0; i < 2 * n; i++) {
      arr[i] = new Info(Integer.parseInt(st.nextToken()), 0);
    }

    int cnt = 0;
    while(true) {
      cnt += 1;
      rotate();
      moveRobot();
      loadRobot();
      if(check())
        break;
    }

    System.out.println(cnt);
  }
}
