import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String ans = "";
        boolean flag = false;

        int[] alpha = new int[26];
        for(int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'A';
            alpha[idx] += 1;
        }

        int cnt = 0;
        for(int i = 0; i < 26; i++) {
            if(alpha[i] % 2 != 0)
                cnt += 1;
        }

        if(cnt >= 2)
            System.out.println("I'm Sorry Hansoo");
        else {
            for(int i = 0; i < 26; i++) {
                if(alpha[i] % 2 != 0) {
                    ans += String.valueOf((char)(i + 'A'));
                    alpha[i] -= 1;
                    flag = true;
                }
            }
            String temp = "";
            for(int i = 0; i < 26; i++) {
                int num = alpha[i] / 2;
                for(int j = 0; j < num; j++) {
                    temp += String.valueOf((char)(i + 'A'));
                }
            }
            ans = temp + ans;
        }
        String temp = "";
        if(!flag) {
            for(int i = ans.length() - 1; i >= 0; i--) {
                temp += String.valueOf(ans.charAt(i));
            }
            ans = ans + temp;
        } else {
            for(int i = ans.length() - 2; i >= 0; i--) {
                temp += String.valueOf(ans.charAt(i));
            }
            ans = ans + temp;
        }
        System.out.println(ans);
    }
}
