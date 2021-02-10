class Solution {
    
    public int countPaths(int[][] dp, int x, int y, int r, int c){
        if(x>=r || x<0 || y>=c || y<0) return 0;
        if(dp[x][y]!=0) return dp[x][y];
        else{
            int pathsFromTop = countPaths(dp, x-1, y, r, c);
            int pathsFromLeft = countPaths(dp, x, y-1, r, c);
            
            dp[x][y] = pathsFromTop+pathsFromLeft;
            
            return pathsFromTop+pathsFromLeft;
        }
    }
    
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        dp[0][0]=1;
        
        return countPaths(dp, m-1, n-1, m, n);
    }
}
