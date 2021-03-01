class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int len = nums.length;
        
        int output = 1;
        
        int[] dp = new int[len]; //max length of LIS ending at index i
        
        Arrays.fill(dp, 1);//since initially LIS is each index itself
        
        for(int j=1; j<len; j++){
            //now compare all previous subsequence if it can be extended
            for(int i=0; i<j; i++){
                if(nums[j] > nums[i] && dp[i]+1 > dp[j]){
                    dp[j] = dp[i]+1;
                    
                    output = Math.max(output, dp[j]);
                }
            }
        }
        
        return output;
    }
}
