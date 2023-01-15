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
    static int N, M;
    static ArrayList<Node> house;
    static ArrayList<Node> chicken;
    static boolean[] visit;
    static int chickenDistance = (int)1e9;

    public static void dfs(int start, int depth){
        if(depth <= M && depth > 0){
            int total=0;
            for(int i=0; i<house.size(); i++){
                int distance = (int)1e9;

                for(int j=0; j<visit.length; j++){
                    if(visit[j]){
                        int tmp = Math.abs(house.get(i).r - chicken.get(j).r) + Math.abs(house.get(i).c - chicken.get(j).c);
                        if(distance > tmp)
                            distance = tmp;
                    }
                }

                total += distance;
            }
            chickenDistance = Math.min(chickenDistance, total);
        }


        for(int i=start; i<chicken.size(); i++){
            visit[i] = true;
            dfs(i+1, depth+1);
            visit[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        house = new ArrayList<>();
        chicken = new ArrayList<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer((br.readLine()));

            for(int j=0; j<N; j++){
                int value = Integer.parseInt(st.nextToken());

                if(value == 1){
                    house.add(new Node(i+1, j+1));
                }
                else if (value == 2){
                    chicken.add(new Node(i+1, j+1));
                }
            }
        }

        visit = new boolean[chicken.size()];
        Arrays.fill(visit, false);

        dfs(0, 0);
        System.out.println(chickenDistance);
    }
}