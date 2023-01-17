import java.util.*;
import java.io.*;

class Node {
    int r, c;

    Node(int row, int column){
        this.r = row;
        this.c = column;
    }
}

public class Main{
    static int N, K, L;
    static int[][] graph;
    static Deque<Node> snake =  new ArrayDeque<>();
    static String dir = "Right"; // 현재 머리 방향
    static int time = 0;
    static Map<Integer, String> timeChange = new HashMap<>(); // 시간 방향 전환 저장

    public static boolean check(int r, int c){
        // 1. 벽과 부딪하는지 확인
        if(r<0 || r>=N || c<0 || c>=N)
            return false;
        // 2. Deque iterator로 돌면서 몸통과 부딪히는지 확인
        Iterator<Node> iter = snake.iterator();
        while(iter.hasNext()){
            Node node = iter.next();
            int bodyr = node.r;
            int bodyc = node.c;

            if(r == bodyr && c == bodyc)
                return false;
        }

        return true;
    }

    public static void changeDirection(String change){
        if(dir.equals("Right")){
            if(change.equals("D"))
                dir = "Down";
            else
                dir = "Up";
        }
        else if(dir.equals("Left")){
            if(change.equals("D"))
                dir = "Up";
            else
                dir = "Down";
        }
        else if(dir.equals("Up")){
            if(change.equals("D"))
                dir = "Right";
            else
                dir = "Left";
        }
        else{
            if(change.equals("D"))
                dir = "Left";
            else
                dir = "Right";
        }
    }
    public static void move(int r, int c){
        if(!check(r, c))
            return;

        // 사과 먹는 경우
        if(graph[r][c] == 1){
            snake.offerFirst(new Node(r, c));
            graph[r][c] = 0;
        }
        else{
            if(snake.size() > 1){
                snake.offerFirst(new Node(r, c));
                snake.pollLast();
            }
            else if(snake.size() == 1){
                snake.offerFirst(new Node(r, c));
                snake.pollLast();
            }
            else{
                snake.offerFirst(new Node(r, c));
            }
        }

        // 방향 변경이 있는지 확인
        if(timeChange.containsKey(time)){
            changeDirection(timeChange.get(time));
        }

        if(dir.equals("Right")){
            time++;

            move(r, c+1);
        }
        else if(dir.equals("Left")){
            time++;

            move(r, c-1);
        }
        else if(dir.equals(("Up"))){
            time++;

            move(r-1, c);
        }
        else{
            time++;

            move(r+1, c);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        graph = new int[N][N];
        for(int i=0; i<N; i++){
            Arrays.fill(graph[i], 0);
        }

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[r-1][c-1] = 1;
        }

        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());

        for(int i=0; i<L; i++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            String d = st.nextToken();

            timeChange.put(t, d);
        }

        move(0, 0);
        System.out.println(time);
    }
}