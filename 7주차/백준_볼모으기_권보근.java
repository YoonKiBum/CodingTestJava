import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String line = br.readLine();
        ArrayList<Integer> colors = new ArrayList<>();
        int cnt = 0;
        char last = line.charAt(0);
        for(int i=0; i<N; i++){
            if(line.charAt(i)==last){
                cnt++;
                continue;
            }

            colors.add(cnt);
            last = line.charAt(i);
            cnt = 1;
        }
        colors.add(cnt);

        int ans = 0;

        if(colors.size()==1){
            System.out.println(0);
        }
        else if(colors.size()%2==0){
            int first_color = 0;
            int last_color = 0;
            for(int i=1; i<colors.size()-1; i++){
                if(i%2==0){
                    first_color += colors.get(i);
                }
                else{
                    last_color += colors.get(i);
                }
            }

            ans = Math.min(first_color, last_color);
            System.out.println(ans);
        }
        else{
            int first_color = 0;
            int second_color = 0;

            for(int i=0; i<colors.size(); i++){
                if(i%2==0){
                    first_color += colors.get(i);
                }
                else{
                    second_color += colors.get(i);
                }
            }
            first_color -= Math.max(colors.get(0), colors.get(colors.size()-1));

            ans = Math.min(first_color, second_color);
            System.out.println(ans);
        }
    }
}
