/**
My solution

DP approach

Runtime 35 ms
beats 16%

*/

class Solution {
    int[] dp;
    
    public int find(int[] coins, int amount){
        if(amount < 0){
            return -1;
        }else if(amount==0){
            return 0;
        }else if(dp[amount] != 0){
            return dp[amount];
        }else{
            if(amount < coins[0]){
                dp[amount] = -1;
                return -1;
            }else{
                int min = Integer.MAX_VALUE;
                for(int c : coins){
                    
                    int temp = find(coins, amount-c);
                    
                    if(temp == -1){
                        
                    }else{
                        min = Math.min(min, 1 + temp);
                    }    
                }
                if(min == Integer.MAX_VALUE){
                    dp[amount] = -1;
                    return -1;
                }
                dp[amount] = min;
                return min;
            }
            
        }
        
    }
    
    public int coinChange(int[] coins, int amount) {
        
        if(amount==0) return 0;
        
        Arrays.sort(coins);
        
        if(amount < coins[0]){
            return -1;
        }
        
        int len = 0;
        for(int c : coins){
            if(c <= amount) len++;
        }
        
        coins = Arrays.copyOfRange(coins, 0, len);
        
        dp = new int[Math.max(len, amount)+1];
        
        for(int i=1; i<coins[0]; i++){
            dp[i] = -1;
        }
        
        dp[0] = 0;
        
        for(int c : coins){
            dp[c] = 1;
        }
        
        return find(coins, amount);
    }
}
