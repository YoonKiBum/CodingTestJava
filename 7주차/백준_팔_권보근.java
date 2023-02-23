import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String left = st.nextToken();
        String right = st.nextToken();


        if(left.length() != right.length())
            System.out.println(0);
        else{
            int cnt = 0;
            for(int i=0; i<left.length(); i++){
                if(left.charAt(i)!=right.charAt(i))
                    break;
                else{
                    if(left.charAt(i)=='8' && right.charAt(i)=='8')
                        cnt++;
                }
            }

            System.out.println(cnt);
        }
    }
}
