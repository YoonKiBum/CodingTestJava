import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        BigInteger[] arr = new BigInteger[n + 1];
        arr[0] = BigInteger.valueOf(1);
        arr[1] = BigInteger.valueOf(1);

        for(int i = 2; i < n + 1; i++) {
            arr[i] = arr[i-1].multiply(BigInteger.valueOf(i));
        }

        System.out.println(arr[n].divide(arr[n-k].multiply(arr[k])).mod(BigInteger.valueOf(10007)));
    }
}
