import java.io.*;
import java.util.*;

public class Main {
    static long N;
    static int[] dice = new int[6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Long.parseLong(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<6; i++){
            dice[i] = Integer.parseInt(st.nextToken());
        }

        if(N==1){
            int max = 0;
            int sum = 0;

            for(int i=0; i<6; i++){
                max = Math.max(max, dice[i]);
                sum += dice[i];
            }

            System.out.println(sum-max);
        }
        else{
            int minAF = Math.min(dice[0], dice[5]);
            int minBE = Math.min(dice[1], dice[4]);
            int minCD = Math.min(dice[2], dice[3]);

            int minOne = Math.min(minAF, Math.min(minBE, minCD));
            int minTwo = Math.min(minAF+minBE, Math.min(minAF+minCD, minBE+minCD));
            int minThree = minAF + minBE + minCD;

            long oneSlide = 4*(N-2)*(N-1) + (N-2)*(N-2);
            long twoSlide = 4*(N-1) + 4*(N-2);
            long threeSlide = 4;

            long sum = minOne*oneSlide + minTwo*twoSlide + minThree*threeSlide;
            System.out.println(sum);
        }



    }
}
