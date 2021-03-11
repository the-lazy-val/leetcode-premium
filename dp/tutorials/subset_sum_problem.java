public class Solution {
    
    Boolean[][] dp;
    
    public boolean isSum(ArrayList<Integer> A, int B, int start){
        if(B == 0) return true;
        if(start >= A.size() || B < 0) return false;
        
        if(dp[start][B] != null) return dp[start][B];
        
        for(int i=start; i<A.size(); i++){
            if(isSum(A, B-A.get(i), i+1)) {
                dp[start][B] = true;
                return true;
            }
        }
        dp[start][B] = false;
        return false;
    }
    
    public int solve(ArrayList<Integer> A, int B) {
        int size = A.size();
        dp = new Boolean[size+1][B+1];
        
        for(int i=0; i<= size; i++){
            dp[i][0] = true;
        }
        return (isSum(A, B, 0)) ? 1 : 0;
    }
}
