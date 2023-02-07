import java.util.*;
import java.io.*;


class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = new int[50];
        char[] op = new char[50];

        String line = br.readLine();

        int index = 0;
        int start = 0;
        for(int i=0; i<nums.length; i++){
            if(index==line.length())
                break;

            if(index!=0){
                index++;
                start = index;
            }


            while (index < line.length() && line.charAt(index) != '+' && line.charAt(index) != '-') {
                index++;
            }
            nums[i] = Integer.parseInt(line.substring(start, index));
            if(index!=line.length())
                op[i] = line.charAt(index);
        }

        index = -1;
        for(int i=0; i<op.length; i++){
            if(op[i]=='-') {
                index = i;
                break;
            }
        }

        int answer = 0;
        if(index!=-1){
            for(int i=0; i<=index; i++){
                answer += nums[i];
            }

            for(int i=index+1; i<nums.length; i++){
                answer -= nums[i];
            }
        }
        else{
            for(int i=0; i<nums.length; i++){
                answer += nums[i];
            }
        }

        System.out.println(answer);
    }
}
