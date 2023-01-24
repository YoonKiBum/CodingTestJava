import java.util.*;

class Task implements Comparable<Task> {
    int request;
    int time;
    
    Task(int r, int t){
        this.request = r;
        this.time = t;
    }
    
    @Override
    public int compareTo(Task t){
        if(this.time < t.time){
            return -1;
        }
        else
            return 1;
    }
}

class Solution {
    static PriorityQueue<Task> controller = new PriorityQueue<>();
    static int curIdx = 0; // controller에 들어간 작업 index
    static int cnt = 0; // controller에서 처리한 작업 count
    static int curTime = 0;
    static int total = 0;
    
    public int solution(int[][] jobs) {
        int answer = 0;
        
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        while(true){
            // 끝까지 다 돌면 break
            if(cnt == jobs.length)
                break;
            
            while(true){
                if(curIdx >= jobs.length || jobs[curIdx][0] > curTime)
                    break;
                // 이전 작업이 끝난 시점 이전에 요청이 들어온 작업 add
                if(curIdx < jobs.length && jobs[curIdx][0] <= curTime){
                    controller.offer(new Task(jobs[curIdx][0], jobs[curIdx][1]));
                    curIdx++;
                }
            }
            
            if(controller.isEmpty()){
                curTime = jobs[curIdx][0];
            }
            else{
                Task task = controller.poll();
                
                total += curTime + task.time - task.request;
                curTime += task.time;
                cnt++;
            }
        }
        
        answer = total/jobs.length;
        
        
        return answer;
    }
}