import java.util.*;
import java.io.*;

public class Main {
    public static char[][] arr = new char[4][8];
    public static int cnt, num, dir;
    public static int ans = 0;

    public static void turnCCW(int row) {
        char begin = arr[row][0];
        for(int i = 1; i < 8; i++) {
            arr[row][i - 1] = arr[row][i];
        }
        arr[row][7] = begin;
    }

    public static void turnCW(int row) {
        char last = arr[row][7];
        for(int i = 6; i >= 0; i--) {
            arr[row][i + 1] = arr[row][i];
        }
        arr[row][0] = last;
    }

    public static void action(int a, int dir) {
        char right = arr[a][2];
        char left = arr[a][6];
        int d = dir;
        if (d == 1) { // 시계방향
            turnCW(a);
        } else {
            turnCCW(a);
        }

        char tempLeft = left;
        char tempRight = right;

        for (int i = a - 1; i >= 0; i--) { // 기준 왼쪽으로
            if (tempLeft == arr[i][2]) { // 같은극이면
                break;
            } else { // 다른극이면
                tempRight = arr[i][2];
                tempLeft = arr[i][6];
                d *= -1;
                if (d == 1) {
                    turnCW(i);
                } else {
                    turnCCW(i);
                }
            }
        }
        tempLeft = left;
        tempRight = right;
        d = dir;
        for (int i = a + 1; i < 4; i++) { // 기준 아래로
            if (tempRight == arr[i][6]) { // 같은극이면
                break;
            } else { // 다른극이면
                tempRight = arr[i][2];
                tempLeft = arr[i][6];
                d *= -1;
                if (d == 1) {
                    turnCW(i);
                } else {
                    turnCCW(i);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 0; i < 4; i++) {
            char[] carr = br.readLine().toCharArray();
            for(int j = 0; j < 8; j++) {
                arr[i][j] = carr[j];
            }
        }

        cnt = Integer.parseInt(br.readLine());
        for(int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            num = Integer.parseInt(st.nextToken())-1;
            dir = Integer.parseInt(st.nextToken());
            action(num, dir);

//            for(int x = 0; x < 4; x++) {
//                for(int y = 0; y < 8; y++) {
//                    System.out.print(arr[x][y] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
        }
        ans += (arr[0][0] - '0') * 1;
        ans += (arr[1][0] - '0') * 2;
        ans += (arr[2][0] - '0') * 4;
        ans += (arr[3][0] - '0') * 8;
        System.out.println(ans);
    }
}
