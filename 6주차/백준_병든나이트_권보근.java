import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int ans = 0;
        if(N==1)
            ans = 0;
        else if(N==2)
            ans = Math.min((M-1)/2, 3);
        else if(N>=3){
            if(M<7){
                ans = Math.min(M-1, 3);
            }
            else{
                ans = M-3;
            }
        }

        System.out.println(ans+1);
    }
}
