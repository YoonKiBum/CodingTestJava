import java.util.*;

class Truck{
    int bridgeIdx; // 다리 위의 트럭 위치
    int weight;
    
    Truck(int b, int w){
        this.bridgeIdx = b;
        this.weight = w;
    }
}

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int index = 0;
        Queue<Truck> bridge = new LinkedList<>();
        
        while(true){
            // 종료 조건
            if(bridge.size()==0 && index==truck_weights.length)
                break;
            
            // 트럭 이동
            if(bridge.size()!=0){
                Iterator<Truck> iter = bridge.iterator();
                while(iter.hasNext()){
                    Truck cur = iter.next();
                    if(cur.bridgeIdx==bridge_length)
                        iter.remove();
                    else
                        cur.bridgeIdx++;
                }
            }
            
            // 새로운 트럭
            if(index<truck_weights.length){
                if(bridge.size()<bridge_length){
                    int sum=0;
                    for(Truck truck : bridge){
                        sum += truck.weight;
                    }
                
                    if(weight-sum>=truck_weights[index]){
                        bridge.offer(new Truck(1, truck_weights[index]));
                        index++;
                    }
                }
            }
            
            answer++;
        }
        
        return answer;
    }
}