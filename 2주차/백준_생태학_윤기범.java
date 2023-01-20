import java.util.*;
import java.io.*;

public class Main {
    public static HashMap<String, Double> map = new HashMap<>();
    public static double num = 0;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()) {
            String str = sc.nextLine();
            num += 1;
            if(map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1.0);
            }
        }

        ArrayList<String> keyList = new ArrayList<>(map.keySet());
        keyList.sort((s1, s2) -> s1.compareTo(s2));
        for(String s : keyList) {
            System.out.println(s + " " + String.format("%.4f", (map.get(s) * 100 /num)));
        }
    }
}

