import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] road = new int[n-1];
        int[] cost = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n - 1; i++) {
            road[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        long tempCost = 1000000001; // 초기값 (최대값보다 1큰 값)
        long tempRoad = 0;
        long ans = 0;
        for(int i = 0; i < n-1; i++) {
            if(cost[i] >= tempCost) { // 현재 cost보다 새 주유소의 cost가 크면 넘기기
                tempRoad += road[i];
            } else { // 현재 cost보다 새 주유소의 cost가 작으면 해당 cost 채택 
                if(tempCost != 1000000001) { 
                    ans += (tempCost * tempRoad);
                    tempRoad = 0;
                }
                tempCost = cost[i]; 
                tempRoad += road[i];
            }
        }
        ans += (tempCost * tempRoad);
        System.out.println(ans);
    }
}
