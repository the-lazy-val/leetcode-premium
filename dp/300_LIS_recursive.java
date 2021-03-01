class Solution {
    
    int longestLis = 1;
    
    public int getLIS(int[] nums, int currIndex, int maxTillNow){
        
        int max = maxTillNow;
        
        for(int i=currIndex+1; i<nums.length; i++){
            if(currIndex==-1){
                
                max = getLIS(nums, i, 1);
                
            }else if(nums[i] > nums[currIndex]){
                
                max = Math.max(max, getLIS(nums, i, 1 + maxTillNow));
                
            }
        }
        
        longestLis = Math.max(longestLis, max);
        
        return max;
    }
    
    public int lengthOfLIS(int[] nums) {
        getLIS(nums, -1, 0);
        return longestLis;
    }
}
