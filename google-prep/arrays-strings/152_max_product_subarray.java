/**
My solution
186/187 test case passed

on very big array, memory limit exceeds

Solved using the dp[][] matrix method, used in longest palindrome substring

*/

class Solution {
    
    public int maxProduct(int[] nums) {
        
        int max = Integer.MIN_VALUE;
        
        int len = nums.length;
        int[][] dp = new int[len][len];
        
        for(int i=0; i<len; i++){
            dp[i][i] = nums[i];
            max = Math.max(max, dp[i][i]);
        }
        
        int inc = 1;
        while(inc < len){
            for(int i=0; i<len-inc; i++){
                dp[i][i+inc] = nums[i+inc] * dp[i][i+inc-1];
                max = Math.max(max, dp[i][i+inc]);
            }
            inc++;
        }
        
        return max;
    }
}
