class Solution {
    
    public List<String> transformPositionsToString(ArrayList<Integer> colPlacements, int n){
        List<String> res = new ArrayList();
        
        char[] ar = new char[n];
        Arrays.fill(ar, '.');
        
        for(int cp : colPlacements){
            StringBuilder sb = new StringBuilder(new String(ar));
            sb.setCharAt(cp, 'Q');
            res.add(sb.toString());
        }
        
        return res;
    }
    
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
    
    public void solveNQueens(int row, int n, ArrayList<Integer> colPlacements, List<List<String>> res){
        if(row==n){
            res.add(transformPositionsToString(colPlacements, n));
        }else{
            for(int col=0; col<n; col++){ //choices
                
                colPlacements.add(col); //pick a choice
                
                if(isValid(colPlacements)){ //constraint
                    solveNQueens(row+1, n, colPlacements, res);
                }
                 
                colPlacements.remove(colPlacements.size() - 1); //backtrack
            }
        }
    }
    
    public List<List<String>> solveNQueens(int n) {
        ArrayList<Integer> colPlacements = new ArrayList();
        List<List<String>> res = new ArrayList();
        
        solveNQueens(0, n, colPlacements, res);
        return res;
    }
}
