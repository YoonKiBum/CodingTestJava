import java.util.*;
class Node implements Comparable<Node> {
    String genre;
    int play;
    int num;
    
    Node(String genre, int play, int num){
        this.genre = genre;
        this.play = play;
        this.num = num;
    }
    
    @Override
    public int compareTo(Node o){
        if(Solution.map.get(this.genre) > Solution.map.get(o.genre))
            return -1;
        else if(Solution.map.get(this.genre) < Solution.map.get(o.genre))
            return 1;
        else{
            if(this.play > o.play)
                return -1;
            else if(this.play < o.play)
                return 1;
            else{
                if(this.num > o.play)
                    return 1;
                else if(this.play < o.play)
                    return -1;
                else 
                    return 1;
            }
        }
    }
}

class Solution {
    static Map<String, Integer> map = new HashMap<>();
    static ArrayList<Node> alist = new ArrayList<>();
    
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        for(int i=0; i<genres.length; i++){
            if(map.containsKey(genres[i])){
                map.put(genres[i], map.get(genres[i]) + plays[i]);
            }   
            else{
                map.put(genres[i], plays[i]);
            }
            
            alist.add(new Node(genres[i], plays[i], i));
        }
        
        Collections.sort(alist);
        
        String beforeG="";
        int count=0;
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i=0; i<alist.size(); i++){
            String g = alist.get(i).genre;
            
            if(beforeG.equals(g)){
                count++;
                
                if(count <=2){
                    ans.add(alist.get(i).num);
                }
            }
            else{
                count=1;
                
                ans.add(alist.get(i).num);
            }
            
            beforeG = g;
        }
        
        answer = new int[ans.size()];
        for(int i=0; i<ans.size(); i++){
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
}