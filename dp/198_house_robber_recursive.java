class Solution {
    
    public int getMax(int[] nums, int currIndex){
        if(currIndex >= nums.length) return 0;
        
        return Math.max(nums[currIndex]+ getMax(nums, currIndex+2), getMax(nums, currIndex+1));
    }
    
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        return getMax(nums, 0);
    }
}
