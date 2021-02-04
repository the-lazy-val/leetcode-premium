/**
My solution: 9ms
O(N*M + M*N!)
*/

class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        for(int i=0; i<m; i++){
            for(int j=1; j<n; j++){
                if(matrix[i][j] == 1) matrix[i][j] += matrix[i][j-1];
            }
        }
        
        int total=0;
        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                int v = matrix[i][j];
                if(v==1){
                    total++;
                }else if(v!=0){
                    int count = 1;
                    int k=i-1;
                    if(k>=0){
                        int temp = matrix[k][j];
                    
                        while(v>count && k>=0 && temp > count){
                            v = Math.min(temp, v);
                            count++;
                            k--;
                            if(k>=0) temp = matrix[k][j]; else temp=-1;
                        }
                        total+=Math.min(count, v);
                    }else{
                        total++;
                    }
                }
            }
        }
        
        return total;
    }
}

/**
Better DP solution
*/

// You can also avoid additional for loops using dp[n + 1][m + 1] size, here is my example:

class Solution {
    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        int[][] dp = new int[n + 1][m + 1];
        
        int res = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                
                if (matrix[i - 1][j - 1] == 1) {
                    
                    dp[i][j] = 1 + Math.min( Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]);
                    
                    res += dp[i][j];
                }
                
            }
        }
        return res;
    }
}
