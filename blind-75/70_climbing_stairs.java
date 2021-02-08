/**
DP

n=1 -> 1 way
n=2 -> 2 ways

n=3 -> 3 ways

n=4 -> 5 ways

so, f(n) = f(n-1) + f(n-2)

to avoid repetitions lets store results of initial steps in DP array
*/

class Solution {
    public int climbStairs(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        else {
            int[] dp = new int[n+1];
            dp[1]=1;
            dp[2]=2;
            for(int i=3; i<=n; i++){
                dp[i] = dp[i-1] + dp[i-2];
            }
            return dp[n];
        }
    }
}
