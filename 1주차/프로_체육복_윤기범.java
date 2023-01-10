import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {

        HashSet<Integer> lostSet = new HashSet<>(); // lost배열을 집합화
        HashSet<Integer> reserveSet = new HashSet<>(); // reserve배열을 집합화
        HashSet<Integer> intersection = new HashSet<>(); // 교집합을 위한 배열

        for(int i = 0; i < lost.length; i++) {
            lostSet.add(lost[i]);
        }

        for(int i = 0; i < reserve.length; i++) {
            reserveSet.add(reserve[i]);
            intersection.add(reserve[i]);
        }

        intersection.retainAll(lostSet); // 교집합
        // 교집합이 존재하면 lostSet, reserveSet에서 교집합 제거
        // 존재하지 않으면 넘김
        if(intersection.size() != 0) { 
            lostSet.removeAll(intersection);
            reserveSet.removeAll(intersection);
        }

        int[] temp = new int[lostSet.size()];
        int idx = 0;
        for(Integer i : lostSet) {
            temp[idx++] = i;
        }
 
        // 루프를 확인하면서 왼쪽이나 오른쪽이 존재하면 reserveSet, lostSet에서 제거
        for(int i = 0; i < temp.length; i++) {
            if (reserveSet.contains(temp[i] - 1)) {
                lostSet.remove(temp[i]);
                reserveSet.remove(temp[i]-1);
            }
            else if(reserveSet.contains(temp[i] + 1)) {
                lostSet.remove(temp[i]);
                reserveSet.remove(temp[i]+1);
            }
        }
        // 결과값 return
        return n - lostSet.size();
    }
}
