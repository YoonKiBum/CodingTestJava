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
        StringTokenizer st = new StringTokenizer(br.readLine());

        PriorityQueue<Node> p_w = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.w, o2.w));
        PriorityQueue<Node> p_v = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.v, o1.v));

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] bags = new int[K];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            p_w.offer(new Node(w, v));
        }

        for(int i=0; i<K; i++){
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bags);
        long ans = 0L;
        for(int i=0; i<bags.length; i++){
            while(!p_w.isEmpty()){
                Node cur = p_w.poll();

                if(cur.w > bags[i]) {
                    p_w.offer(cur);
                    break;
                }

                p_v.offer(cur);
            }

            if(!p_v.isEmpty()){
                ans += p_v.poll().v;
            }
        }
        System.out.println(ans);
    }
}
