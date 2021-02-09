class Solution {
    
    public int longestCommonSubsequence(String text1, String text2) {
        int r=text1.length();
        int c=text2.length();
        
        int[][] dp = new int[r+1][c+1];
        
        int max=0;
        
        for(int i=1; i<r+1; i++){
            for(int j=1; j<c+1; j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        
        return max;
    }
}
