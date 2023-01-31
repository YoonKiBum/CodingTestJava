import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static int r, c, k;
    public static int[][] graph;
    public static int ans = 0;

    static class Info implements Comparable<Info> {
        int cnt;
        int num;
        public Info(int cnt, int num) {
            this.cnt = cnt;
            this.num = num;
        }

        @Override
        public int compareTo(Info o) {
            int r = this.cnt - o.cnt;
            if(r == 0) {
                return this.num - o.num;
            } else{
                return r;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        k = Integer.parseInt(st.nextToken());
        graph = new int[3][3];

        for(int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 3; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true) {
            if (ans > 100)
                break;
            int numR = graph.length;
            int numC = graph[0].length;
            if(numR >= r + 1 && numC >= c + 1) {
                if(graph[r][c] == k) {
                    break;
                }
            }
            ans += 1;
            if(numR >= numC) { // R연산
                ArrayList<ArrayList<Info>> arrList = new ArrayList<ArrayList<Info>>();
                for(int j = 0; j < numR; j++) { // 초기화
                    arrList.add(new ArrayList<>());
                }
                for(int i = 0; i < numR; i++) {
                    int[] arr = new int[101];
                    for(int j = 0; j < graph[i].length; j++) {
                        if(graph[i][j] >= 1) { // 0은 고려하지 않음
                            arr[graph[i][j]] += 1;
                        }
                    }
                    int temp = 0; // 최대값 구하기 위한 임시 변수
                    for(int j = 1; j < 101; j++) {
                        if(arr[j] != 0) {
                            arrList.get(i).add(new Info(arr[j], j));
                        }
                    }
                }
                int maxVal = 0; // 최댓값
                // 정렬
                for(int i = 0; i < numR; i++) {
                    maxVal = Math.max(maxVal, arrList.get(i).size());
                }
                maxVal *= 2;
                if(maxVal > 100) // 행 또는 열의 크기가 100 넘어가면 처리해주기
                    maxVal = 100;
                graph = new int[numR][maxVal];
                for(int i = 0; i < numR; i++) {
                    Collections.sort(arrList.get(i));
                }
                for(int i = 0; i < numR; i++) {
                    int k = 0;
                    for(int j = 0; j < arrList.get(i).size(); j ++) {
                        Info tempInfo = arrList.get(i).get(j);
                        graph[i][k] = tempInfo.num;
                        graph[i][k + 1] = tempInfo.cnt;
                        k += 2;
                    }
                }
            } else { // C연산
                ArrayList<ArrayList<Info>> arrList = new ArrayList<ArrayList<Info>>();
                for(int j = 0; j < numC; j++) { // 초기화
                    arrList.add(new ArrayList<>());
                }
                for(int i = 0; i < numC; i++) {
                    int[] arr = new int[101];
                    for(int j = 0; j < numR; j++) {
                        if(graph[j][i] >= 1) { // 0은 고려하지 않음
                            arr[graph[j][i]] += 1;
                        }
                    }
                    int temp = 0; // 최대값 구하기 위한 임시 변수
                    for(int j = 1; j < 101; j++) {
                        if(arr[j] != 0) {
                            arrList.get(i).add(new Info(arr[j], j));
                        }
                    }
                }
                int maxVal = 0; // 최댓값
                // 정렬
                for(int i = 0; i < numC; i++) {
                    maxVal = Math.max(maxVal, arrList.get(i).size());
                }
                maxVal *= 2;
                if(maxVal > 100) // 행 또는 열의 크기가 100 넘어가면 처리해주기
                    maxVal = 100;
                graph = new int[maxVal][numC];
                for(int i = 0; i < numC; i++) {
                    Collections.sort(arrList.get(i));
                }
                for(int i = 0; i < numC; i++) {
                    int k = 0;
                    for(int j = 0; j < arrList.get(i).size(); j ++) {
                        Info tempInfo = arrList.get(i).get(j);
                        graph[k][i] = tempInfo.num;
                        graph[k+1][i] = tempInfo.cnt;
                        k += 2;
                    }
                }
            }
        }
        if (ans > 100)
            System.out.println(-1);
        else
            System.out.println(ans);
    }
}
