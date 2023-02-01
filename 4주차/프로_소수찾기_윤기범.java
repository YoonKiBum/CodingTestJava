import java.util.*;
import java.io.*;

class Solution {
    public static int n;
    public static char[] carr;
    public static char[] checked;
    public static boolean[] visited;
    public static int answer = 0;
    public static HashSet<Integer> set = new HashSet<>();
    
    public static void isPrime(int num) {
        if(num <= 1) // 0 혹은 1은 무조건 소수 아님
            return;

        int len = (int)Math.sqrt(num); // 제곱근 까지만 확인하면 됨
        boolean flag = true;
        
        for(int i = 2; i <= len; i++) { // 제곱근까지 확인하며
            if(num % i == 0) { // 약수가 존재하면 루프 탈출
                flag = false;
                break;
            }
        }
        
        if(flag) {
            if(!set.contains(num)) { // 소수면 집합에 넣기
                set.add(num);   
            }
        }
    }
    
    public static void perm(int cnt, int m) {
        if(cnt == m) {
            String s = "";
            for(int i = 0; i < m; i++) { // m 개를 선택하면 문자들을 전부 붙여 문자열 생성
                s += String.valueOf(checked[i]);
            }
            isPrime(Integer.parseInt(s)); // 소수 여부 확인하는 메소드
            return;
        }
        
        for(int i = 0; i < n; i++) {
            if(visited[i] == false) {
                visited[i] = true;
                checked[cnt] = carr[i];
                perm(cnt + 1, m);
                visited[i] = false;
            }
        }
    }
    public int solution(String numbers) {
        carr = numbers.toCharArray(); // 입력받은 문자열을 처리하기 위함
        int m = carr.length;
        n = carr.length;
        checked = new char[n];
        
        for(int i = 1; i <= m; i++) { // 전체 카드 중 1개 뽑는 경우부터 전체를 뽑는 경우까지 
            visited = new boolean[n];
            perm(0, i);   
        }
        
        return set.size(); // 집합의 개수 즉 소수 개수 반환
    }
}
