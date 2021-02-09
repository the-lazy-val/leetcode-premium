class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] counts = new int[nums.length];
        
        Arrays.fill(dp, 1);
        Arrays.fill(counts, 1);
        
        int max=1;
        
        for(int j=1; j<nums.length; j++){
            for(int i=0; i<j; i++){
                if(nums[j] > nums[i]){ // question is strictly increasing subsequence, 
                    // if question was non-decreasing subsequence then >= will be used
                    
                    if(dp[i]+1 > dp[j]){
                        dp[j] = dp[i] + 1;
                        counts[j]=counts[i];
                    }else if(dp[i]+1 == dp[j]){
                        counts[j]+=counts[i];
                    }
                    
                    max = Math.max(max, dp[j]);
                }
            }
        }
        
        System.out.println(Arrays.toString(dp));
        
        int count=0;
        
        for(int i=0; i<dp.length; i++){
            if(dp[i]==max){
                count+=counts[i];
            }
        }
        
        return count;
    }
}
