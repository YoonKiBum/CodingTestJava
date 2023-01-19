import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static int K;
    static int[] conveyer;
    static boolean[] robot;
    static int step=0;

    public static boolean check(){
        int count=0;

        for(int i=0; i<2*N; i++){
            if(conveyer[i] == 0)
                count++;

            if(count >= K)
                return false;
        }

        return true;
    }

    public static boolean move(){
        int tmp=conveyer[2*N-1];

        for(int i=2*N-1; i>0; i--){
            conveyer[i] = conveyer[i-1];
            robot[i] = robot[i-1];
        }
        conveyer[0] = tmp;
        robot[0] = false;
        robot[N-1] = false;

        for(int i=N-2; i>0; i--){
            if(robot[i]){
                if(!robot[i+1] && conveyer[i+1]>0){
                    robot[i+1] = robot[i];
                    robot[i] = false;
                    conveyer[i+1] -= 1;
                }
            }
        }
        robot[N-1] = false;

        if(conveyer[0] != 0){
            conveyer[0] -= 1;
            robot[0] = true;
        }

        step++;

        return check();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        conveyer = new int[2*N];
        robot = new boolean[2*N];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<2*N; i++){
            conveyer[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(robot, false);

        while(true){
            boolean flag = move();
            if(!flag)
                break;
        }

        System.out.println(step);
    }
}