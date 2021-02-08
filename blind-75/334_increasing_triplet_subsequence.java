// based off on the concept learned in #300: Longest increating subsequence
// O(N^2)

class Solution {
    public boolean increasingTriplet(int[] nums) {
        
        int dp[] = new int[nums.length];
        Arrays.fill(dp, 1);
        
        for(int j=1; j<nums.length; j++){
            for(int i=0; i<j; i++){
                if(nums[j] > nums[i]){
                    if(dp[i] + 1 > dp[j]){
                        dp[j] = dp[i]+1;
                    }
                }
                if(dp[j] >= 3) return true;
            }
        }
        
        return false;
    }
}
