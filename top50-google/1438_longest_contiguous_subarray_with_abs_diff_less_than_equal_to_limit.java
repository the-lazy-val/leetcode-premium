class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int left=0;
        //We are using a TreeSet because for any range that we consider, 
        //the difference b/w min & max element needs to be <= limit
        TreeSet<Integer> ts = new TreeSet<>((a,b) -> nums[a]==nums[b] ? a-b : nums[a]-nums[b]);
        
        ts.add(left); //adding first element
        
        int max=1;

        for(int right=1; right<nums.length; right++){
            
            ts.add(right); //adding the next index
            
            //Now check, if adding this element, still maintains the diff b/w min & max element to be <= limit
            //Since TreeSet maintains order, we can simply use:
            //first() -> to get min
            //last() -> to  get max
            
            while(nums[ts.last()] - nums[ts.first()] > limit){
                ts.remove(left);  //contract from left until diff b/w min & max <= limit
                left++;
            }
            
            max = Math.max(max, right-left+1);
        }
        
        return max;
    }
}
