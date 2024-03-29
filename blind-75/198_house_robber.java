class Solution {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0], nums[1]);
        
        int[] dp = new int[nums.length];
        
        dp[0] = nums[0];
        int max = nums[0];
        
        for(int i=1; i<nums.length; i++){
            if(i-2>=0){
                dp[i] = Math.max(dp[i-1], nums[i]+dp[i-2]);
            }else{
                dp[i] = Math.max(dp[i-1], nums[i]);
            }
            
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
}
