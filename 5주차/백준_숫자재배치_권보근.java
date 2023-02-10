import com.sun.security.jgss.GSSUtil;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int[] A;
    static int B;
    static boolean[] visited;
    static int max = -1;

    public static void permutation(int depth, int num){
        if(depth==A.length){
            max = Math.max(max, num);
            return;
        }

        for(int i=0; i<A.length; i++){
            if(visited[i] || (depth==0 && A[i]==0) || num*10+A[i]>B)
                continue;

            visited[i] = true;
            permutation(depth+1, num*10 + A[i]);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        A = new int[a.length()];
        B = Integer.parseInt(st.nextToken());
        visited = new boolean[a.length()];

        for(int i=0; i<a.length(); i++){
            A[i] = a.charAt(i) - '0';
        }

        permutation(0, 0);
        System.out.println(max);
    }
}
