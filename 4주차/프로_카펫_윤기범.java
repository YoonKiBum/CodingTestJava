class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int maxR = (brown - 2) / 2; // 최댓값 (가로로 제일 긴 도형)
        int minR = (brown + 4) / 4; // 최솟값 (정사각형)
        for(int i = minR; i <= maxR; i++) {
            int col = (brown - (i * 2)) / 2;
            if((i-2) * col == yellow) {
                answer[0] = i;
                answer[1] = col + 2;
            }
        }
        return answer;
    }
}
