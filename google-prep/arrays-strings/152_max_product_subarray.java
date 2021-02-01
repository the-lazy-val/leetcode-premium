/**
My solution
186/187 test case passed

Time: O(N), but space is O(N^2) because of matrix

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


/**
LC solution

Time: O(N)
Space: O(1)
*/

class Solution {
    
    public int maxProduct(int[] nums) {
        int len = nums.length;
        if(len==0) return 0;
        
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
            
        int max = maxSoFar;
        
        for(int i=1; i<nums.length; i++){
            int curr = nums[i];
            
            int tempMax = Math.max(curr, Math.max(maxSoFar*curr, minSoFar*curr));
            minSoFar = Math.min(curr, Math.min(maxSoFar*curr, minSoFar*curr));
            
            maxSoFar = tempMax;
            
            max = Math.max(max, maxSoFar);
        }
        
        return max;
    }
}
