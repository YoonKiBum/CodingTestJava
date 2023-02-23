import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Integer[] alpha = new Integer[26];
        Arrays.fill(alpha, 0);

        for(int i=0; i<N; i++){
            String word = br.readLine();

            for(int j=0; j<word.length(); j++){
                alpha[word.charAt(j)-'A'] += (int) Math.pow(10, word.length()-j-1);
            }
        }
        Arrays.sort(alpha, Collections.reverseOrder());

        int num = 9;
        int ans = 0;
        for(int i=0; i<26; i++){
            if(alpha[i]==0)
                break;

            ans += alpha[i]*num;
            num--;
        }

        System.out.println(ans);
    }
}
