import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Integer[] straw = new Integer[N];
        for(int i=0; i<N; i++){
            straw[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(straw, Collections.reverseOrder());

        int longest = straw[0];
        for(int i=1; i<N-1; i++){
            int second = straw[i];
            int third = straw[i+1];

            if(longest<second+third){
                System.out.println(longest+second+third);
                return;
            }
            else
                longest = second;
        }

        System.out.println(-1);
    }
}
