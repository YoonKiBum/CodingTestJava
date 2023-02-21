import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] rgb = new int[N][3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        rgb[0][0] = r; rgb[0][1] = g; rgb[0][2] = b;

        for(int i=1; i<N; i++){
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            rgb[i][0] = r + Math.min(rgb[i-1][1], rgb[i-1][2]);
            rgb[i][1] = g + Math.min(rgb[i-1][0], rgb[i-1][2]);;
            rgb[i][2] = b + Math.min(rgb[i-1][0], rgb[i-1][1]);;
        }

        System.out.println(Math.min(rgb[N-1][0], Math.min(rgb[N-1][1], rgb[N-1][2])));
    }
}
