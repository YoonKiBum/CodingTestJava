import java.lang.Math;

class Solution {
    static int column[];
    static int count=0;
    
    public boolean promise(int row, int index){
        for(int i=0; i<row; i++){
            // 같은 열에 위치하는 것이 존재하는지 확인
            if(column[i] == index)
                return false;
            
            // 대각선에 위치하는지 확인
            if(Math.abs(row - i) == Math.abs(column[i] - index))
                return false;
        }
        
        return true;
    }
    
    public void dfs(int row, int n){
        //무한 루프 X - 모든 조건 만족
        if(row == n){
            count++;
            return;
        }
        //인접(행의 모든 열) 확인
        for(int i=0; i<n; i++){
            column[row] = i;    
            
            //조건 확인 - Promising
            if(promise(row, i)){
                dfs(row+1, n);
            }
        }
        
    }
    
    public int solution(int n) {     
        column = new int[n]; // 각 행에 위한 Queen의 열의 정보 저장
        
        dfs(0, n);
        
        return count;
    }
}