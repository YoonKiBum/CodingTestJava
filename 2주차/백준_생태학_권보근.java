import java.util.*;
import java.io.*;

public class Main {
    static Map<String, Double> map = new HashMap<>();
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double total = 0.0;
        String line = "";

        while (true) {
            line = br.readLine();
            if(line == null)
                break;
            if (map.containsKey(line)) {
                map.put(line, map.get(line) + 1.0);
            } else {
                map.put(line, 1.0);
                list.add(line);
            }
            total++;
        }
        Collections.sort(list);

        for(String tree : list) {
            System.out.println(tree + " " + String.format("%.4f", (map.get(tree)/total)*100));
        }
    }
}