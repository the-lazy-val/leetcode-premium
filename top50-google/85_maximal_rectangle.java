/**
O(N) . O(N.M) = O(N^2 . M)
Each point we have to traverse the whole height: O(N)
number of points = O(N.M)

*/

class Solution {
    public int maximalRectangle(char[][] matrix) {
        
        if(matrix.length==0) return 0;
        
        int r = matrix.length;
        int c = matrix[0].length;
        
        int maxArea = 0;
        int[][] dp = new int[r][c]; //calculate width
        
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(matrix[i][j] == '1'){
                    
                    if(j==0){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = 1 + dp[i][j-1];
                    }
                    
                    int width = dp[i][j];
                    
                    for(int k=i; k>=0; k--){ //now going up
                        width = Math.min(width, dp[k][j]);
                        maxArea = Math.max(maxArea, width * (i-k+1));
                    }
                }
            }
        }
        
        return maxArea;
    }
}
