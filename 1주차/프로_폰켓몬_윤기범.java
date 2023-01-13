class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int cnt = 0;
        int[] arr = new int[200001];
        for(int i = 0; i < nums.length; i++) {
            arr[nums[i]]+=1;
        }
        for(int i = 0; i < 200001; i++) {
            if(arr[i] != 0)
                cnt += 1;
        }
        if(cnt > (nums.length/2))
            answer = nums.length / 2;
        else
            answer = cnt;
        return answer;
    }
}
