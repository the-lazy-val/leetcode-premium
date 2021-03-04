class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int prev = 0;
        int sum = 0;
        int max = 0;
        
        for(int n : nums){
            if(n == 1){
                sum++;
            }else{
                max = Math.max(max, sum+prev);
                prev = sum+1;
                sum = 0;
            }
        }
        
        return (sum+prev > max) ? sum+prev : max;
    }
}
