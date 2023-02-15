import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] origin = new int[N][M];
        int[][] change = new int[N][M];

        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<M; j++){
                origin[i][j] = line.charAt(j)-'0';
            }
        }

        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<M; j++){
                change[i][j] = line.charAt(j)-'0';
            }
        }

        int cnt = 0;
        for(int i=0; i<N-2; i++){
            for(int j=0; j<M-2; j++){
                if(origin[i][j]!=change[i][j]){
                    for(int k=i; k<i+3; k++){
                        for(int l=j; l<j+3; l++){
                            origin[k][l] = 1 - origin[k][l];
                        }
                    }
                    cnt++;
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(origin[i][j]!=change[i][j]) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(cnt);
    }
}
