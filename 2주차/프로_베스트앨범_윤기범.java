import java.util.*;
import java.io.*;

class Solution {
    public static HashMap<String, Integer> map = new HashMap<>();
    
    static class Info implements Comparable<Info>{
        int count;
        int num;
        public Info(int count, int num) {
            this.count = count;
            this.num = num;
        }
        @Override
        public int compareTo(Info o) { // 재생횟수로 내림차순 재생횟수가 같다면 고유번호로 오름차순
            int r;
            r = -(this.count - o.count);
            if(r == 0) {
                r = this.num - o.num;
                return r;
            } else {
                return r;
            }
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i = 0; i < genres.length; i++) { // 해시를 사용해서 각 장르별 재생횟수합 
            if(map.containsKey(genres[i])) {
                map.put(genres[i], map.get(genres[i]) + plays[i]);
            } else {
                map.put(genres[i], plays[i]);
            }
        }
        
        // key 값만 가져와서 genre에 넣어주기 
        ArrayList<String> genre = new ArrayList<>();
        for(String key : map.keySet()){
            genre.add(key);
        }
        
        // key 값에 해당하는 value를 내림차순으로 정렬 
        Collections.sort(genre,(o1,o2)->map.get(o2)-map.get(o1)); 
        
        // 정렬된 genre를 조회하면서
        for(int i = 0; i < genre.size(); i++) {
            String gen = genre.get(i); // 장르 선택
            int max = 0;
            int first = -1;
            for(int j = 0; j < genres.length; j++) {
                if(gen.equals(genres[j])) { // first값 선택
                    if(max < plays[j]) {
                        max = plays[j];
                        first = j;
                    }
                }
            }
            ans.add(first);
            max = 0;
            int second = -1;
            for(int j = 0; j < genres.length; j++) {
                if(gen.equals(genres[j])) {
                    if(j != first && max < plays[j]) { // first가 아닌값 중 두번째 값 찾기
                        max = plays[j];
                        second = j;
                    }
                }
            }
            if(second != -1) { // 두번째 값이 존재하면 ans에 추가 없으면 넘기기
                ans.add(second);
            }
        }
        
        int[] answer = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }
}
