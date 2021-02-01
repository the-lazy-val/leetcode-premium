/**
My solution: O(N)
*/

class Solution {
    int max = 0;
    public int maxProfit(int[] prices) {
        int profit=0;
        int start = prices[0];
        for(int n : prices){
            profit = n-start;
            if(n < start){
                start = n;
                max = Math.max(max, profit);
                profit=0;
            }
            max = Math.max(max, profit);
        }
        
        return max;
    }
}
