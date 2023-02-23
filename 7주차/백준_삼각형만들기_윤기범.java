import java.util.*;
import java.io.*;

public class Main {
    public static int ans = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int first = n-3;
        int second = n-2;
        int third = n-1;

        while(true) {
            if(first < 0 || second >= third)
                break;
            if(arr[first] + arr[second] > arr[third]) {
                ans = arr[first] + arr[second] + arr[third];
                break;
            } else {
                first -= 1;
                second -= 1;
                third -= 1;
            }
        }

        System.out.print(ans);
    }
}
