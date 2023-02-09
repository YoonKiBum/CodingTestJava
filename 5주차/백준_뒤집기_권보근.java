import java.util.*;
import java.io.*;


class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        int oneCnt = 0;
        int zeroCnt = 0;

        char last = '2';
        for(int i=0; i<line.length(); i++){
            if(line.charAt(i) == last)
                continue;

            if(line.charAt(i) == '1'){
                oneCnt++;
                last = '1';
            }
            else{
                zeroCnt++;
                last = '0';
            }
        }

        System.out.println(Math.min(oneCnt, zeroCnt));
    }
}
