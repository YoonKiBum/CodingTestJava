import java.util.*;
import java.io.*;

class Main{
    static int R, C, K;
    static int[][] A = new int[100][100];
    static int rowCnt=3; //행의 개수
    static int colCnt=3; //열의 개수

    public static int[][] getSorted(Map<Integer, Integer> map){
        int[][] arr = new int[map.size()][2];
        int index=0;
        for(Integer i : map.keySet()){
            arr[index][0] = i;
            arr[index][1] = map.get(i);
            index++;
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1])
                    return o1[0] - o2[0];
                else
                    return o1[1] - o2[1];
            }
        });

        return arr;
    }

    public static void rowCal(){
        Map<Integer, Integer> map;
        int[] eachRow = new int[rowCnt];

        int max=0;
        for(int i=0; i<rowCnt; i++){
            map = new HashMap<>();
            int index=0;

            while(index<colCnt){
                if(A[i][index]!=0){
                    if(map.containsKey(A[i][index]))
                        map.put(A[i][index], map.get(A[i][index])+1);
                    else
                        map.put(A[i][index], 1);
                }

                index++;
            }

            int[][] arr = getSorted(map);

            for(int j=0; j<arr.length; j++){
                if(j==50)
                    break;

                A[i][j*2] = arr[j][0];
                A[i][j*2+1] = arr[j][1];
            }
            eachRow[i] = arr.length*2;
            max = Math.max(max, arr.length*2);
        }

        for(int i=0; i<rowCnt; i++){
            int index = eachRow[i];
            while (index<max) {
                A[i][index] = 0;
                index++;
            }
        }
        colCnt = max;
    }

    public static void colCal(){
        Map<Integer, Integer> map;
        int[] eachCol = new int[colCnt];

        int max=0;
        for(int i=0; i<colCnt; i++){
            map = new HashMap<>();
            int index=0;

            while(index<rowCnt){
                if(A[index][i]!=0){
                    if(map.containsKey(A[index][i]))
                        map.put(A[index][i], map.get(A[index][i])+1);
                    else
                        map.put(A[index][i], 1);
                }

                index++;
            }

            int[][] arr = getSorted(map);

            for(int j=0; j<arr.length; j++){
                if(j==50)
                    break;

                A[j*2][i] = arr[j][0];
                A[j*2+1][i] = arr[j][1];
            }

            eachCol[i] = arr.length*2;
            max = Math.max(max, arr.length*2);
        }

        for(int i=0; i<colCnt; i++){
            int index = eachCol[i];
            while (index<max) {
                A[index][i] = 0;
                index++;
            }
        }
        rowCnt = max;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i=0; i<3; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<3; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans=0;
        while(A[R-1][C-1] != K && ans<=100){
            if(rowCnt >= colCnt)
                rowCal();
            else
                colCal();

            ans++;
        }

        if(ans==101)
            System.out.println(-1);
        else
            System.out.println(ans);
    }
}