import com.sun.security.jgss.GSSUtil;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        BigInteger mul = BigInteger.valueOf(1);
        BigInteger div = BigInteger.valueOf(1);

        for(int i=0; i<K; i++){
            mul = mul.multiply(BigInteger.valueOf(N-i));
            div = div.multiply(BigInteger.valueOf(K-i));
        }

        System.out.println(mul.divide(div).mod(BigInteger.valueOf(10007)));
    }
}
