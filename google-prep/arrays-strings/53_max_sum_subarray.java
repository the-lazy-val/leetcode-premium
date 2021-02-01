/**
O(N) solution
*/

class Solution {
    int max = Integer.MIN_VALUE;
    
    public int maxSubArray(int[] nums) {
        int sum=0;
        for(int n : nums){
            sum += n;
            if(n > sum){
                sum=n;
            }
            max = Math.max(max, sum);
        }
        
        return max;
    }
}
