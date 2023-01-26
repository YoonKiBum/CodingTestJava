import java.util.*;
import java.io.*;


class Node{
    int r, c;

    Node(int row, int column){
        this.r = row;
        this.c = column;
    }
}

public class Main{
    static int N;
    static int curveCount=0;
    static ArrayList<Node>[] curveList;
    static ArrayList<Integer>[] dirList;
    static boolean map[][] = new boolean[101][101];
    static int squareCnt=0;

    public static void makeSquare(){
        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                if(map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1])
                    squareCnt++;
            }
        }
    }

    public static void curve(int r, int c, int dir, int generation){
        curveList[curveCount].add(new Node(r, c));
        map[r][c] = true;

        if(dir==0){
            curveList[curveCount].add(new Node(r, c+1));
            map[r][c+1] = true;
        }
        else if(dir==1){
            curveList[curveCount].add(new Node(r-1, c));
            map[r-1][c] = true;
        }
        else if(dir==2){
            curveList[curveCount].add(new Node(r, c-1));
            map[r][c-1] = true;
        }
        else{
            curveList[curveCount].add(new Node(r+1, c));
            map[r+1][c] = true;
        }
        dirList[curveCount].add(dir);

        for(int i=0; i<generation; i++){
            int idx = curveList[curveCount].size()-1;
            int size = curveList[curveCount].size()-1;

            for(int j=0; j<size; j++){
                Node last = curveList[curveCount].get(curveList[curveCount].size()-1); // 매 단계의 마지막 점
                int curDir = dirList[curveCount].get(idx-1);

                addCurve(last.r, last.c, curDir);

                idx--;
            }
        }
    }

    public static void addCurve(int r, int c, int dir){
        if(dir==0){
            curveList[curveCount].add(new Node(r-1, c));
            map[r-1][c] = true;
            dirList[curveCount].add(1);
        }
        else if(dir==1){
            curveList[curveCount].add(new Node(r, c-1));
            map[r][c-1] = true;
            dirList[curveCount].add(2);
        }
        else if(dir==2){
            curveList[curveCount].add(new Node(r+1, c));
            map[r+1][c] = true;
            dirList[curveCount].add(3);
        }
        else{
            curveList[curveCount].add(new Node(r, c+1));
            map[r][c+1] = true;
            dirList[curveCount].add(0);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        curveList = new ArrayList[N];
        dirList = new ArrayList[N];

        for(int i=0; i<N; i++){
            curveList[i] = new ArrayList<>();
            dirList[i] = new ArrayList<>();
        }

        for(int i=0; i<101; i++){
            Arrays.fill(map[i], false);
        }

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            int generation = Integer.parseInt(st.nextToken());

            curve(r, c, dir, generation);
            curveCount++;
        }
        makeSquare();
        System.out.println(squareCnt);
    }
}