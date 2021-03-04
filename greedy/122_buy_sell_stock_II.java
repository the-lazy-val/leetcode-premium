class Solution {
    public int maxProfit(int[] prices) {
        int i=0;
        int j=1;
        
        int maxProfit = 0;
        
        while(j < prices.length){
            if(prices[j] > prices[i]){
                maxProfit += prices[j] - prices[i];
            }
            i++;
            j++;
        }
        
        return maxProfit;
    }
}
