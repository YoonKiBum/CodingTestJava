import javax.sound.sampled.Line;
import java.util.*;
import java.io.*;


class Main {
    static class Node{
        int w, v;

        Node(int weight, int value){
            this.w = weight;
            this.v = value;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            int[] scores = new int[N];
            int cnt = 1;

            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());

                int idx = Integer.parseInt(st.nextToken());
                scores[idx-1] = Integer.parseInt(st.nextToken());
            }

            int score = scores[0];

            for(int j=1; j<scores.length; j++){
                if(scores[j]<score){
                    score = scores[j];
                    cnt++;
                }
            }

            sb.append(cnt);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
