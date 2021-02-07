class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        
        Arrays.sort(nums); //2-pointer approach only works with sorted arrays
        
        for(int start=0; start<nums.length; start++){
            // this means we have alreardy processed this as start point of triplet
            if(start>0 && nums[start] == nums[start-1]){
                continue;
            }
            
            //Now do 2-sum II
            int left=start+1;
            int right=nums.length-1;
            
            while(left < right){
                int currSum = nums[start] + nums[left] + nums[right];
                if(currSum == 0){
                    //add to final result
                    res.add(Arrays.asList(nums[start], nums[left], nums[right]));
                    //next left
                    left++;
                    //if next left is same as previous left, then keep increasing
                    while(left<right && nums[left]==nums[left-1]){
                        left++;
                    }
                }else if(currSum < 0){
                    left++;
                }else{
                    right--;
                }
            }
            
        }
        
        
        return new ArrayList(res);
    }
}
