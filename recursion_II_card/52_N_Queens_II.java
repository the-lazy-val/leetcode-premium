class Solution {
    
    int count=0;
    
    public boolean isValid(ArrayList<Integer> colPlacements){
        int currRow = colPlacements.size()-1;
        
        for(int i=0; i<currRow; i++){
            int diff = Math.abs(colPlacements.get(i) - colPlacements.get(currRow)); //columns ka distance
            
            //currRow-i => rows ka distance
            //agar jitna rows mei distance h utna hi column mei distance (dono points diagonal p h matlab)
            //diagonal p h toh invalid h position
            
            if(diff==0 || diff==currRow-i){
                return false;
            }
        }
        
        return true;
    }
    
    public void solveNQueens(int row, int n, ArrayList<Integer> colPlacements){
        if(row==n){
            count+=1;
        }else{
            for(int col=0; col<n; col++){ //choices
                
                colPlacements.add(col); //pick a choice
                
                if(isValid(colPlacements)){ //constraint
                    solveNQueens(row+1, n, colPlacements);
                }
                 
                colPlacements.remove(colPlacements.size() - 1); //backtrack
            }
        }
    }
    
    public int totalNQueens(int n) {
        
        ArrayList<Integer> colPlacements = new ArrayList();
        count=0;
        
        solveNQueens(0, n, colPlacements);
        return count;
    }
}
