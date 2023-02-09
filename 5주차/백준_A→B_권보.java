import javax.sound.sampled.Line;
import java.util.*;
import java.io.*;


class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int ans = 1;
        while(true){
            if(A==B){
                System.out.println(ans);
                return;
            }
            /**
             * 종료 조건 순서 중요 ex) A, B = 3이면, 같다는 조건에 의해서 나가야 하지만,
             * -1이 출력되는 조건 뒤에 존재하면 -1이 출력됨
             */
            if(B<A || (B%2!=0 && B%10!=1)) {
                System.out.println(-1);
                return;
            }


            if(B%2==0){
                B = B/2;
            }
            else{
                B = B/10;
            }
            ans++;


        }
    }
}
