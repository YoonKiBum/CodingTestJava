import java.util.*;
import java.io.*;

public class Main {
    static int ans = 0;
    static class Course implements Comparable<Course>{
        int s, e;

        Course(int start, int end){
            this.s = start;
            this.e = end;
        }

        @Override
        public int compareTo(Course t){
            if(this.s==t.s)
                return this.e - t.e;
            else
                return this.s - t.s;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Course> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list.add(new Course(s, e));
        }
        Collections.sort(list);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.offer(list.get(0).e);

        for(int i=1; i<N; i++){
            Course next = list.get(i);

            if(next.s<pq.peek()){
                pq.offer(next.e);
            }
            else{
                pq.poll();
                pq.offer(next.e);
            }
        }

        System.out.println(pq.size());
    }
}
