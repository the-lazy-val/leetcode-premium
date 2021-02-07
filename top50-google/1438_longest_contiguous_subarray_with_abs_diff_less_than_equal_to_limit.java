class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int left=0;
        TreeSet<Integer> ts = new TreeSet<>((a,b) -> nums[a]==nums[b] ? a-b : nums[a]-nums[b]);
        ts.add(0);
        
        int max=1;
        
        for(int right=1; right<nums.length; right++){
            ts.add(right);
            
            while(nums[ts.last()] - nums[ts.first()] > limit){
                ts.remove(left);
                left++;
            }
            max = Math.max(max, right-left+1);
        }
        return max;
    }
}
