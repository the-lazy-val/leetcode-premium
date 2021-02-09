//My solution.. with one correction from Leetcode discuss

class Solution {
    
    /**
    Note: Before we were getting TLE because...
    
    https://leetcode.com/problems/combination-sum-iv/discuss/85136/I-got-a-TLE-for-my-answer-could-any-one-help-me-Thank-you-very-much!/476329
    
    .... because there are some recursive path in the tree which never leads to any solution in that case u would have set dp[target] = 0 which is correct, but u are recalculating the same path again because u are checking dp[target] != 0 which is wrong it can be 0.
So instead initialize the dp with -1 and check if dp[target] != -1.
Also i think u have to add the condition check for target > 0.
Hope this helps.
    */
    
    
    public int findCombinations(int[] dp, int[] nums, int target){
        if(target==0) return 1;
        // if(target<=0) return 0;
        // if(dp[target]==-1){
        //     return 0;
        // }
        else if(dp[target]!=-1){
            return dp[target];
        }else{
            int count=0;
            for(int i : nums){
                if(i>target) continue;
                count+=findCombinations(dp, nums, target-i);
            }
            dp[target]=count;
            return count;
        }
    }
    
    public int combinationSum4(int[] nums, int target) {
        if(nums.length==0) return 0;
        Arrays.sort(nums);
        
        if(target < nums[0]) return 0;
        
        int len = nums.length;
        
        int consider = Math.max(len, target)+1;
        
        int[] dp = new int[consider];
        
//         dp[0]=0;
        
//         for(int i=1; i<nums[0]; i++){
//             dp[i]=-1;
//         }
        
        Arrays.fill(dp, -1);
        
        return findCombinations(dp, nums, target);
    }
}
