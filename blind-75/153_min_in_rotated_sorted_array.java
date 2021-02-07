//Binary Search

class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        
        int start=0;
        int end=nums.length-1;
        
        while(start<=end){
            int mid = (start+end)/2;
            min = Math.min(min, Math.min(nums[start], Math.min(nums[mid], nums[end])));
            
            if(nums[end]<nums[mid]){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        
        return min;
    }
}
