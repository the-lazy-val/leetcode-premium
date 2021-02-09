//My solution (beats 100%)

class Solution {
    
    public int getCost(int[][] dp, int[][] costs, int house, int exclude){
        if(house==costs.length) return 0;
        else if(dp[house][exclude] != 0) return dp[house][exclude];
        else{
            int min = Integer.MAX_VALUE;
            for(int colour=0; colour<3; colour++){
                    if(colour==exclude) continue;
                    min = Math.min(min, costs[house][colour] + getCost(dp, costs, house+1, colour));
            }
            
            dp[house][exclude] = min;
            return min;
        }
    }
    
    public int minCost(int[][] costs) {
        int[][] dp = new int[costs.length][3];
        
        int min = Integer.MAX_VALUE;
        
        for(int i=0; i<3; i++){
            min = Math.min(min, getCost(dp, costs, 0, i));
        }
        
        return min;
    }
}
