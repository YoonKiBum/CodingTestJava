import java.util.*;
import java.io.*;

class Solution {
    public static PriorityQueue<Order> pq = new PriorityQueue<>();
    public static Queue<Info> q = new LinkedList<>();
    public static int ans = 0;

    static class Order implements Comparable<Order>{
        int order;
        public Order(int order) {
            this.order = order;
        }
        @Override
        public int compareTo(Order o) {
            return -(this.order - o.order);
        }
    }
    
    static class Info {
        int value; // 우선순위
        int order; // 순서
        public Info(int value, int order) {
            this.value = value;
            this.order = order;
        }
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;
        for(int i = 0; i < priorities.length; i++) {
            pq.offer(new Order(priorities[i])); // (우선순위, 순서)
            q.offer(new Info(priorities[i], i));
        }

        while(true) {
            Order val = pq.poll();
            Info temp = q.poll();
            if(val.order == temp.value) { // 우선순위와 최대가 같으면
                ans += 1;
                if(temp.order == location) // 구하길 원하는 인덱스라면
                    return ans;
            } else { // 그 외는 다시 pq, q에 삽입
                pq.offer(val);
                q.offer(temp);
            }
        }
    }
}
