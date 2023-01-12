class Solution {    
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxw=0;
        int maxh=0;
        
        for(int i=0; i<sizes.length; i++){
            int w = sizes[i][0];
            int h = sizes[i][1];
            
            if(w<h){
                int tmp;
                tmp = w;
                w = h;
                h = tmp;
            }
            
            if(w>maxw)
                maxw = w;
            if(h>maxh)
                maxh = h;
        }
        
        
        return maxw*maxh;
    }
}