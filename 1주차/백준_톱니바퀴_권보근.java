import java.util.*;
import java.io.*;

public class Main{
    static int[][] cogwheels = new int[4][8];
    static int k;
    static boolean state[] = new boolean[3];
    static int score=0;

    public static void initState(){

        if(cogwheels[0][2] == cogwheels[1][6])
            state[0] = false;
        else
            state[0] = true;

        if(cogwheels[1][2] == cogwheels[2][6])
            state[1] = false;
        else
            state[1] = true;

        if(cogwheels[2][2] == cogwheels[3][6])
            state[2] = false;
        else
            state[2] = true;
    }

    public static void changeState(int wheel, int direction){
        int index = wheel-1;

        if(direction == 1){
            int tmp = cogwheels[index][7];

            for(int i=7; i>0; i--){
                cogwheels[index][i] = cogwheels[index][i-1];
            }
            cogwheels[index][0] = tmp;
        }
        else{
            int tmp = cogwheels[index][0];

            for(int i=0; i<7; i++){
                cogwheels[index][i] = cogwheels[index][i+1];
            }
            cogwheels[index][7] = tmp;
        }
    }

    public static boolean turnLeft(int wheel){
        if(wheel-1 > 0 && state[wheel - 2]){
            return true;
        }
        else
            return false;
    }

    public static boolean turnRight(int wheel){
        if(4-wheel > 0 && state[wheel - 1]){
            return true;
        }
        else
            return false;
    }

    public static void turn(int wheel, int direction, boolean right, boolean left){
        changeState(wheel, direction); // 회전

        // 오른쪽 톱니바퀴
        if(turnRight(wheel) && right){
            turn(wheel+1, direction*(-1), true, false);
        }

        // 왼쪽 톱니바퀴
        if(turnLeft(wheel) && left){
            turn(wheel-1, direction*(-1), false, true);
        }
    }

    public static void calc(){
        for(int i=0; i<4; i++){
            if(cogwheels[i][0] == 1){
                score = (int) (score + Math.pow(2, i));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0; i<4; i++){
            String line = br.readLine();
            for(int j=0; j<8; j++){
                cogwheels[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());

        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int wheel = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            initState();
            turn(wheel, dir, true, true);
        }

        calc();
        System.out.println(score);
    }
}