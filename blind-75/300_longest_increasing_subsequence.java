class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        
        Arrays.fill(dp, 1);
        int max=1;
        
        for(int j=1; j<nums.length; j++){
            for(int i=0; i<j; i++){
                if(nums[j] > nums[i]){ // question is strictly increasing subsequence, question was non-decreasing then >=
                    if(dp[i]+1 > dp[j]){
                        dp[j] = dp[i] + 1;
                    }
                    max = Math.max(max, dp[j]);
                }
            }
        }
        
        return max;
    }
}
