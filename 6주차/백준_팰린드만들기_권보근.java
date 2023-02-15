import java.io.*;
import java.util.*;

public class Main {
    static int len;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String name = br.readLine();

        int[] cnt = new int[26];
        for(int i=0; i<name.length(); i++){
            cnt[name.charAt(i)-'A']++;
        }

        len = name.length();
        int odd = 0;
        int mid = 0;
        for(int i=0; i<26; i++){
            if(cnt[i]%2!=0) {
                odd++;
                mid = i;
            }
        }

        if(len%2!=0 && odd!=1){
            System.out.println("I'm Sorry Hansoo");
        }
        else if(len%2==0 && odd!=0){
            System.out.println("I'm Sorry Hansoo");
        }
        else{
            StringBuilder a = new StringBuilder();
            for(int i=0; i<cnt.length; i++){
                for(int j=0; j<cnt[i]/2; j++){
                    a.append((char)(i+'A'));
                }
            }
            StringBuilder b = new StringBuilder(a.reverse());
            a.reverse();
            if(odd!=0)
                a.append((char)(mid+'A'));
            a.append(b);
            System.out.println(a);
        }
    }
}
