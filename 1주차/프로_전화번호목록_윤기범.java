import java.util.*;
import java.io.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>(); // Hash 사용을 위한 set
        for(int i = 0; i < phone_book.length; i++) { // set에 추가
            set.add(phone_book[i]);
        }

        for(int i = 0; i < phone_book.length; i++) { // 전체 배열을 조회하면서
            String temp = "";
            for(int j = 0; j < phone_book[i].length()-1; j++) { // 해당 인덱스의 문자열 자체를 제외한 문자열 (ex 123-> 12)
                temp += String.valueOf(phone_book[i].charAt(j));
                if(set.contains(temp)) // 이 포함되면 false반환
                    return false;
            }
        }
        return true;
    }
}

