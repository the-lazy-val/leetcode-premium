class Solution {
    
    int[][] dp;
    
    public int getValue(int row, int col){
        
        if(dp[row][col] != 0) return dp[row][col];
        
        if(col==0 || col==row) {
            dp[row][col] = 1;
            return 1;
        }
        
        int value = getValue(row-1, col-1) + getValue(row-1, col);
        
        dp[row][col] = value;
        
        return value;
    }
    
    public List<Integer> getRow(int rowIndex) {
        
        dp = new int[rowIndex+1][rowIndex+1];
        
        dp[0][0] = 1;
        
        LinkedList<Integer> res = new LinkedList();
        
        for(int i=0; i<=rowIndex; i++){
            res.add(getValue(rowIndex, i));
        }
        
        return res;
    }
}
