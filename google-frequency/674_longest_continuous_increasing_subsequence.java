class Solution {
    public int findLengthOfLCIS(int[] nums) {
        
        if(nums.length==0) return 0;
        
        int max=1;
        int count=1;
        int i=1;
        
        while(i<nums.length){
            if(nums[i] > nums[i-1]){
                count++;
                max=Math.max(max, count);
            }else{
                count=1;
            }
            i++;
        }
        
        return max;
    }
}
