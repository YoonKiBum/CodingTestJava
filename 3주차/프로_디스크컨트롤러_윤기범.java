import java.util.*;
import java.io.*;

class Solution {
    public static PriorityQueue<Jobs> pq = new PriorityQueue<>();

    static class Jobs implements Comparable<Jobs> {
        int a;
        int b;
        public Jobs(int a, int b) {
            this.a = a;
            this.b = b;
        }
        @Override
        public int compareTo(Jobs o) {
            return this.b - o.b;
        }
    }

    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]); // jobs 배열 오름차순

        int idx = 0;
        int point = 0;
        int cnt = 0;

        while(true) {
            if(cnt == jobs.length) // 탈출조건
                break;
            while(idx < jobs.length && point >= jobs[idx][0]) { // 종료시간 이전에 들어온 것들 처리
                pq.offer(new Jobs(jobs[idx][0], jobs[idx][1]));
                idx += 1;
            }

            if(pq.size() == 0) { // 하드디스크가 작업을 수행하지 않을때
                point = jobs[idx][0]; // 가장 먼저 들어온것 처리
            }
            else {
                Jobs job = pq.poll();
                answer += (point + job.b - job.a);
                point += job.b;
                cnt += 1;
            }
        }
        return answer / cnt;
    }
}
