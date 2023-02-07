import java.util.*;
import java.io.*;


class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = 0;

        while(true){
            if(N<3 && N>0){
                System.out.println(-1);
                return;
            }
            else if(N==0){
                System.out.println(answer);
                return;
            }

            if(N%5==0){
                answer += N/5;
                System.out.println(answer);
                return;
            }
            else{
                N -= 3;
                answer++;
            }
        }
    }
}
